package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R1>
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
            final P9 p9);

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> f9(
            final F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> f9)
    {
        requireNonNull(f9, "f9");
        return f9;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> constant(
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
                p9) -> r1;
    }

    default F8<P2, P3, P4, P5, P6, P7, P8, P9, R1> partial(
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

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9> F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, P1> identity()
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
                p9) -> p1;
    }

    default F9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R1> reverse()
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
                p9) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
}
