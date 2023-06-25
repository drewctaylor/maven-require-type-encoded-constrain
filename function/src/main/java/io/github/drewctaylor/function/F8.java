package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F8<P1, P2, P3, P4, P5, P6, P7, P8, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7,
            final P8 p8);

    static <P1, P2, P3, P4, P5, P6, P7, P8, R1> F8<P1, P2, P3, P4, P5, P6, P7, P8, R1> f8(
            final F8<P1, P2, P3, P4, P5, P6, P7, P8, R1> f8)
    {
        requireNonNull(f8, "f8");
        return f8;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, R1> F8<P1, P2, P3, P4, P5, P6, P7, P8, R1> constant(
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
                p8) -> r1;
    }

    default F7<P2, P3, P4, P5, P6, P7, P8, R1> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8) -> f(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8> F8<P1, P2, P3, P4, P5, P6, P7, P8, P1> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8) -> p1;
    }
}
