package dsq.ippiparray.alien;

// FIX 18/09/12 Very, very basic. No functional support.
public interface Option<A> {
    A get();
    boolean isDefined();
}
