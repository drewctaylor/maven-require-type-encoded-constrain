package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
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
            final P10 p10,
            final P11 p11,
            final P12 p12,
            final P13 p13,
            final P14 p14);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> E14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> e14(
            final E14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> e14)
    {
        requireNonNull(e14, "e14");
        return e14;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> E14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> constant()
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
                p10,
                p11,
                p12,
                p13,
                p14) ->
        {
        };
    }

    default E13<P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> argument(
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
                p10,
                p11,
                p12,
                p13,
                p14) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }
}
