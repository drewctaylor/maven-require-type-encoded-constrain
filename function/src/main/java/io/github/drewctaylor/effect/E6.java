package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E6<P1, P2, P3, P4, P5, P6>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6);

    static <P1, P2, P3, P4, P5, P6> E6<P1, P2, P3, P4, P5, P6> e6(
            final E6<P1, P2, P3, P4, P5, P6> e6)
    {
        requireNonNull(e6, "e6");
        return e6;
    }

    static <P1, P2, P3, P4, P5, P6> E6<P1, P2, P3, P4, P5, P6> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) ->
        {
        };
    }

    default E5<P2, P3, P4, P5, P6> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }

    default E6<P1, P2, P3, P4, P5, P6> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }
}