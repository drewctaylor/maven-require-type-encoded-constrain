package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1>
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
            final P10 p10);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> F10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> f10(
            final F10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> f10)
    {
        requireNonNull(f10, "f10");
        return f10;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> F10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> constant(
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
                p10) -> r1;
    }

    default F9<P2, P3, P4, P5, P6, P7, P8, P9, P10, R1> parameter(
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

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> F10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P1> identity()
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
                p10) -> p1;
    }
}
