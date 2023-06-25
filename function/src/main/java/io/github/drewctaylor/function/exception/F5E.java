package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F5E<P1, P2, P3, P4, P5, R1, E extends Exception>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5)
            throws E;

    static <P1, P2, P3, P4, P5, R1, E extends Exception> F5E<P1, P2, P3, P4, P5, R1, E> f5e(
            final F5E<P1, P2, P3, P4, P5, R1, E> f5e)
    {
        requireNonNull(f5e, "f5e");
        return f5e;
    }

    static <P1, P2, P3, P4, P5, R1, E extends Exception> F5E<P1, P2, P3, P4, P5, R1, E> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) -> r1;
    }

    default F4E<P2, P3, P4, P5, R1, E> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5) -> f(p1, p2, p3, p4, p5);
    }

    static <P1, P2, P3, P4, P5, R1, E extends Exception> F5E<P1, P2, P3, P4, P5, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4,
                p5) ->
        {
            throw e;
        };
    }

    static <P1, P2, P3, P4, P5, E extends Exception> F5E<P1, P2, P3, P4, P5, P1, E> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) -> p1;
    }
}
