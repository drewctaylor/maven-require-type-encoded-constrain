package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E7<P1, P2, P3, P4, P5, P6, P7>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7);

    static <P1, P2, P3, P4, P5, P6, P7> E7<P1, P2, P3, P4, P5, P6, P7> e7(
            final E7<P1, P2, P3, P4, P5, P6, P7> e7)
    {
        requireNonNull(e7, "e7");
        return e7;
    }

    static <P1, P2, P3, P4, P5, P6, P7> E7<P1, P2, P3, P4, P5, P6, P7> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) ->
        {
        };
    }

    default E6<P2, P3, P4, P5, P6, P7> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) -> f(p1, p2, p3, p4, p5, p6, p7);
    }
}
