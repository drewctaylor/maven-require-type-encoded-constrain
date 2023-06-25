package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F1E<P1, R1, E extends Exception>
{
    R1 f(
            final P1 p1)
            throws E;

    static <P1, R1, E extends Exception> F1E<P1, R1, E> f1e(
            final F1E<P1, R1, E> f1e)
    {
        requireNonNull(f1e, "f1e");
        return f1e;
    }

    static <P1, R1, E extends Exception> F1E<P1, R1, E> constant(
            final R1 r1)
    {
        return (
                p1) -> r1;
    }

    default F0E<R1, E> argument(
            final P1 p1)
    {
        return () -> f(p1);
    }

    static <P1, R1, E extends Exception> F1E<P1, R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1) ->
        {
            throw e;
        };
    }

    static <P1, E extends Exception> F1E<P1, P1, E> identity()
    {
        return (
                p1) -> p1;
    }
}
