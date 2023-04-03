package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E4<P1, P2, P3, P4>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4);

    static <P1, P2, P3, P4> E4<P1, P2, P3, P4> e4(
            final E4<P1, P2, P3, P4> e4)
    {
        requireNonNull(e4, "e4");
        return e4;
    }

    static <P1, P2, P3, P4> E4<P1, P2, P3, P4> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4) ->
        {
        };
    }

    default E3<P2, P3, P4> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }

    default E4<P1, P2, P3, P4> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }
}
