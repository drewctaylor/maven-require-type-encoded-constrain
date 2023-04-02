package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F6<P1, P2, P3, P4, P5, P6, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6);

    static <P1, P2, P3, P4, P5, P6, R1> F6<P1, P2, P3, P4, P5, P6, R1> f6(
            final F6<P1, P2, P3, P4, P5, P6, R1> f6)
    {
        requireNonNull(f6, "f6");
        return f6;
    }

    static <P1, P2, P3, P4, P5, P6, R1> F6<P1, P2, P3, P4, P5, P6, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) -> r1;
    }

    default F5<P2, P3, P4, P5, P6, R1> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }

    static <P1, P2, P3, P4, P5, P6> F6<P1, P2, P3, P4, P5, P6, P1> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) -> p1;
    }
}
