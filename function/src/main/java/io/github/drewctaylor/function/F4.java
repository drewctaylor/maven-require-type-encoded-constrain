package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F4<P1, P2, P3, P4, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4);

    static <P1, P2, P3, P4, R1> F4<P1, P2, P3, P4, R1> f4(
            final F4<P1, P2, P3, P4, R1> f4)
    {
        requireNonNull(f4, "f4");
        return f4;
    }

    static <P1, P2, P3, P4, R1> F4<P1, P2, P3, P4, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4) -> r1;
    }

    default F3<P2, P3, P4, R1> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }

    static <P1, P2, P3, P4> F4<P1, P2, P3, P4, P1> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4) -> p1;
    }

    default F4<P1, P2, P3, P4, R1> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }
}
