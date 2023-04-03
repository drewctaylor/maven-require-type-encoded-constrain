package io.github.drewctaylor.function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F3<P1, P2, P3, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3);

    static <P1, P2, P3, R1> F3<P1, P2, P3, R1> f3(
            final F3<P1, P2, P3, R1> f3)
    {
        requireNonNull(f3, "f3");
        return f3;
    }

    static <P1, P2, P3, R1> F3<P1, P2, P3, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3) -> r1;
    }

    default F2<P2, P3, R1> partial(
            final P1 p1)
    {
        return (
                p2,
                p3) -> f(p1, p2, p3);
    }

    static <P1, P2, P3> F3<P1, P2, P3, P1> identity()
    {
        return (
                p1,
                p2,
                p3) -> p1;
    }

    default F3<P1, P2, P3, R1> reverse()
    {
        return (
                p1,
                p2,
                p3) -> f(p1, p2, p3);
    }
}
