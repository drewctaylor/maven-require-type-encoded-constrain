package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F2E<P1, P2, R1, E extends Exception>
{
    R1 f(
            final P1 p1,
            final P2 p2)
            throws E;

    static <P1, P2, R1, E extends Exception> F2E<P1, P2, R1, E> f2e(
            final F2E<P1, P2, R1, E> f2e)
    {
        requireNonNull(f2e, "f2e");
        return f2e;
    }

    static <P1, P2, R1, E extends Exception> F2E<P1, P2, R1, E> constant(
            final R1 r1)
    {
        return (
                p1,
                p2) -> r1;
    }

    default F1E<P2, R1, E> argument(
            final P1 p1)
    {
        return (
                p2) -> f(p1, p2);
    }

    static <P1, P2, R1, E extends Exception> F2E<P1, P2, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2) ->
        {
            throw e;
        };
    }

    static <P1, P2, E extends Exception> F2E<P1, P2, P1, E> identity()
    {
        return (
                p1,
                p2) -> p1;
    }
}
