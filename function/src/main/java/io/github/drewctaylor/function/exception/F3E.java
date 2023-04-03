package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F3E<P1, P2, P3, R1, E extends Exception>
{
    R1 f(
            final P1 p1,
            final P2 p2,
            final P3 p3)
            throws E;

    static <P1, P2, P3, R1, E extends Exception> F3E<P1, P2, P3, R1, E> f3e(
            final F3E<P1, P2, P3, R1, E> f3e)
    {
        requireNonNull(f3e, "f3e");
        return f3e;
    }

    static <P1, P2, P3, R1, E extends Exception> F3E<P1, P2, P3, R1, E> constant(
            final R1 r1)
    {
        return (
                p1,
                p2,
                p3) -> r1;
    }

    default F2E<P2, P3, R1, E> partial(
            final P1 p1)
    {
        return (
                p2,
                p3) -> f(p1, p2, p3);
    }

    static <P1, P2, P3, R1, E extends Exception> F3E<P1, P2, P3, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3) ->
        {
            throw e;
        };
    }

    static <P1, P2, P3, E extends Exception> F3E<P1, P2, P3, P1, E> identity()
    {
        return (
                p1,
                p2,
                p3) -> p1;
    }

    default F3E<P1, P2, P3, R1, E> reverse()
    {
        return (
                p1,
                p2,
                p3) -> f(p1, p2, p3);
    }
}
