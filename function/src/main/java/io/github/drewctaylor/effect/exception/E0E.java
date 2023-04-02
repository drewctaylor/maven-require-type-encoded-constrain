package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E0E<E extends Exception>
{
    void f()
            throws E;

    static <E extends Exception> E0E<E> e0e(
            final E0E<E> e0e)
    {
        requireNonNull(e0e, "e0e");
        return e0e;
    }

    static <E extends Exception> E0E<E> nothing()
    {
        return () ->
        {
        };
    }

    static <E extends Exception> E0E<E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return () ->
        {
            throw e;
        };
    }
}
