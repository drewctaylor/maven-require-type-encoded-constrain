package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E5<P1, P2, P3, P4, P5>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5);

    static <P1, P2, P3, P4, P5> E5<P1, P2, P3, P4, P5> e5(
            final E5<P1, P2, P3, P4, P5> e5)
    {
        requireNonNull(e5, "e5");
        return e5;
    }

    static <P1, P2, P3, P4, P5> E5<P1, P2, P3, P4, P5> constant()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) ->
        {
        };
    }

    default E4<P2, P3, P4, P5> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5) -> f(p1, p2, p3, p4, p5);
    }
}
