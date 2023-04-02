package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F5<P1, P2, P3, P4, P5, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5);

    static <P1, P2, P3, P4, P5, R1> F5<P1, P2, P3, P4, P5, R1> f5(
            final F5<P1, P2, P3, P4, P5, R1> f5)
    {
        requireNonNull(f5, "f5");
        return f5;
    }

    static <P1, P2, P3, P4, P5, R1> F5<P1, P2, P3, P4, P5, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) -> r1;
    }

    default F4<P2, P3, P4, P5, R1> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5) -> f(p1, p2, p3, p4, p5);
    }

    static <P1, P2, P3, P4, P5> F5<P1, P2, P3, P4, P5, P1> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) -> p1;
    }
}
