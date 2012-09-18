ippiparray
==========

`ippiparray` is a widget which displays your device's current IP address (on the off-chance that it is even remotely working --- but not working remotely). It does not have a launcher aspect, it is only a widget. There are no dependencies for `ippiparray`. `ippiparray` is in whatever the development stage before extreme beta is ... I can't stress that enough. At this early stage, it does not detect the initial IP address on installation --- it only detects subsequent changes.


Installation
------------

### Configuration

Installing `ippiparray` requires the Android SDK with the `android` executable on the `path`. Inside your `ippiparray` checkout directory, type: 

    android update project --path . 

This will generate the `local.properties` and `proguard` configuration required. The `android update project` command also provides you with other project configuration options, such as the target Android OS. For a full list of configuration options, consult the [Android Developer Documentation](http://developer.android.com/tools/projects/projects-cmdline.html#UpdatingAProject). 

### Target Android OS

`ippiparray` has been written to operate on any 2.2 OS of Android (Froyo). However, it is possible to build `ippiparray` for a different target OS. As mentioned above, using `android update project` is the approach to specify the target OS. In order to see a list of OS that your Android tools currently support, type: 

    android list targets

The output of this will provide each supported OS with an `id`. This `id` should be specified as the value for the `--target` parameter in the `android update project` command. E.g.

    android update project --path . --target android-8


### Installation

Installation and deployment to your system (connected device or running emulator) is achieved through the `ant` build tools. Specifically: 

    ant debug install

After installing the application, you will need to add the widget to one of your screens. This will be device-dependent (probably).
