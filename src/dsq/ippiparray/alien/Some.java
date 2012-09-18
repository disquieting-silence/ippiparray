package dsq.ippiparray.alien;

public class Some<A> implements Option<A> {
    
    private final A value;

    public Some(final A value) {
        this.value = value;
    }

    @Override
    public A get() {
        return value;
    }

    @Override
    public boolean isDefined() {
        return true;
    }
}
