package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F0E<R1, E extends Exception>
{
    R1 f()
            throws E;

    static <R1, E extends Exception> F0E<R1, E> f0e(
            final F0E<R1, E> f0e)
    {
        requireNonNull(f0e, "f0e");
        return f0e;
    }

    static <R1, E extends Exception> F0E<R1, E> constant(
            final R1 r1)
    {
        return () -> r1;
    }

    static <R1, E extends Exception> F0E<R1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return () ->
        {
            throw e;
        };
    }
}
