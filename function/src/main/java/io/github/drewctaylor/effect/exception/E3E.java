package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E3E<P1, P2, P3, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3)
            throws E;

    static <P1, P2, P3, E extends Exception> E3E<P1, P2, P3, E> e3e(
            final E3E<P1, P2, P3, E> e3e)
    {
        requireNonNull(e3e, "e3e");
        return e3e;
    }

    static <P1, P2, P3, E extends Exception> E3E<P1, P2, P3, E> nothing()
    {
        return (
                p1,
                p2,
                p3) ->
        {
        };
    }

    default E2E<P2, P3, E> partial(
            final P1 p1)
    {
        return (
                p2,
                p3) -> f(p1, p2, p3);
    }

    static <P1, P2, P3, E extends Exception> E3E<P1, P2, P3, E> exception(
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

    default E3E<P1, P2, P3, E> reverse()
    {
        return (
                p1,
                p2,
                p3) -> f(p1, p2, p3);
    }
}
