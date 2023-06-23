package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
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
            final P9 p9,
            final P10 p10);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> E10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> e10(
            final E10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> e10)
    {
        requireNonNull(e10, "e10");
        return e10;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> E10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> constant()
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
                p9,
                p10) ->
        {
        };
    }

    default E9<P2, P3, P4, P5, P6, P7, P8, P9, P10> argument(
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
                p9,
                p10) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }
}
