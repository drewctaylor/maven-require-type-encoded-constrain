package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F7<P1, P2, P3, P4, P5, P6, P7, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7);

    static <P1, P2, P3, P4, P5, P6, P7, R1> F7<P1, P2, P3, P4, P5, P6, P7, R1> f7(
            final F7<P1, P2, P3, P4, P5, P6, P7, R1> f7)
    {
        requireNonNull(f7, "f7");
        return f7;
    }

    static <P1, P2, P3, P4, P5, P6, P7, R1> F7<P1, P2, P3, P4, P5, P6, P7, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) -> r1;
    }

    default F6<P2, P3, P4, P5, P6, P7, R1> argument(
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

    static <P1, P2, P3, P4, P5, P6, P7> F7<P1, P2, P3, P4, P5, P6, P7, P1> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) -> p1;
    }
}
