package dsq.ippiparray.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.RemoteViews;
import dsq.ippiparray.R;
import dsq.ippiparray.alien.None;
import dsq.ippiparray.alien.Option;
import dsq.ippiparray.alien.Some;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IppipArrayWidgetProvider extends AppWidgetProvider {
    
    private Option<InetAddress> find() {
        try {
            final Enumeration<NetworkInterface> xs = NetworkInterface.getNetworkInterfaces();
            while (xs.hasMoreElements()) {
                final NetworkInterface x = xs.nextElement();
                final Enumeration<InetAddress> addresses = x.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    final InetAddress a = addresses.nextElement();
                    if (!a.isLoopbackAddress()) return new Some<InetAddress>(a);
                }
            }
            return new None<InetAddress>();
        } catch (Exception exc) {
            return new None<InetAddress>();
        }
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            final AppWidgetManager manager = AppWidgetManager.getInstance(context);
            final int[] ids = manager.getAppWidgetIds(new ComponentName(context.getPackageName(), getClass().getName()));
            final RemoteViews views = makeViews(context);
            manager.updateAppWidget(ids, views);
        }
    }

    private RemoteViews makeViews(final Context context) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        final Option<InetAddress> current = find();
        if (current.isDefined()) {
            final InetAddress address = current.get();
            final String ip = address.getHostAddress();
            views.setViewVisibility(R.id.widget_container, View.VISIBLE);
            views.setTextViewText(R.id.widget_text, ip);
        } else {
            views.setViewVisibility(R.id.widget_container, View.GONE);
        }
        return views;
    }
}