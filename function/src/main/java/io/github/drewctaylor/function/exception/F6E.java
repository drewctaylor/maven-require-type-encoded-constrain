package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F6E<P1, P2, P3, P4, P5, P6, R1, E extends Exception>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6)
            throws E;

    static <P1, P2, P3, P4, P5, P6, R1, E extends Exception> F6E<P1, P2, P3, P4, P5, P6, R1, E> f6e(
            final F6E<P1, P2, P3, P4, P5, P6, R1, E> f6e)
    {
        requireNonNull(f6e, "f6e");
        return f6e;
    }

    static <P1, P2, P3, P4, P5, P6, R1, E extends Exception> F6E<P1, P2, P3, P4, P5, P6, R1, E> constant(
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

    default F5E<P2, P3, P4, P5, P6, R1, E> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }

    static <P1, P2, P3, P4, P5, P6, R1, E extends Exception> F6E<P1, P2, P3, P4, P5, P6, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) ->
        {
            throw e;
        };
    }

    static <P1, P2, P3, P4, P5, P6, E extends Exception> F6E<P1, P2, P3, P4, P5, P6, P1, E> identity()
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
