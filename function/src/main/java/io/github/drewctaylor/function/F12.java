package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1>
{
    R1 f(
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
            final P12 p12);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> f12(
            final F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> f12)
    {
        requireNonNull(f12, "f12");
        return f12;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> constant(
            final R1 r1)
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
                p12) -> r1;
    }

    default F11<P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> partial(
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
                p12) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P1> identity()
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
                p12) -> p1;
    }

    default F12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R1> reverse()
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
                p12) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }
}
