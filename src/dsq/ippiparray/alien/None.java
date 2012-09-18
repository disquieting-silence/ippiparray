package dsq.ippiparray.alien;

public class None<A> implements Option<A> {
    @Override
    public A get() {
        throw new RuntimeException("Option not set");
    }

    @Override
    public boolean isDefined() {
        return false;
    }
}
