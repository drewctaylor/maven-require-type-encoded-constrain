package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E1E<P1, E extends Exception>
{
    void f(
            final P1 p1)
            throws E;

    static <P1, E extends Exception> E1E<P1, E> e1e(
            final E1E<P1, E> e1e)
    {
        requireNonNull(e1e, "e1e");
        return e1e;
    }

    static <P1, E extends Exception> E1E<P1, E> nothing()
    {
        return (
                p1) ->
        {
        };
    }

    default E0E<E> parameter(
            final P1 p1)
    {
        return () -> f(p1);
    }

    static <P1, E extends Exception> E1E<P1, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1) ->
        {
            throw e;
        };
    }
}
