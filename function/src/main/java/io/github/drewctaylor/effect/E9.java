package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E9<P1, P2, P3, P4, P5, P6, P7, P8, P9>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7,
            final P8 p8,
            final P9 p9);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9> E9<P1, P2, P3, P4, P5, P6, P7, P8, P9> e9(
            final E9<P1, P2, P3, P4, P5, P6, P7, P8, P9> e9)
    {
        requireNonNull(e9, "e9");
        return e9;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9> E9<P1, P2, P3, P4, P5, P6, P7, P8, P9> constant()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9) ->
        {
        };
    }

    default E8<P2, P3, P4, P5, P6, P7, P8, P9> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
}
