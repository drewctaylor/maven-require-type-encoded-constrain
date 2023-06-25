package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F4E<P1, P2, P3, P4, R1, E extends Exception>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4)
            throws E;

    static <P1, P2, P3, P4, R1, E extends Exception> F4E<P1, P2, P3, P4, R1, E> f4e(
            final F4E<P1, P2, P3, P4, R1, E> f4e)
    {
        requireNonNull(f4e, "f4e");
        return f4e;
    }

    static <P1, P2, P3, P4, R1, E extends Exception> F4E<P1, P2, P3, P4, R1, E> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3,
                p4) -> r1;
    }

    default F3E<P2, P3, P4, R1, E> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }

    static <P1, P2, P3, P4, R1, E extends Exception> F4E<P1, P2, P3, P4, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4) ->
        {
            throw e;
        };
    }

    static <P1, P2, P3, P4, E extends Exception> F4E<P1, P2, P3, P4, P1, E> identity()
    {
        return (
                p1,
                p2,
                p3,
                p4) -> p1;
    }
}
