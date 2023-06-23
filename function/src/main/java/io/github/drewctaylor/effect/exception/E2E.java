package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E2E<P1, P2, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2)
            throws E;

    static <P1, P2, E extends Exception> E2E<P1, P2, E> e2e(
            final E2E<P1, P2, E> e2e)
    {
        requireNonNull(e2e, "e2e");
        return e2e;
    }

    static <P1, P2, E extends Exception> E2E<P1, P2, E> constant()
    {
        return (
                p1,
                p2) ->
        {
        };
    }

    default E1E<P2, E> argument(
            final P1 p1)
    {
        return (
                p2) -> f(p1, p2);
    }

    static <P1, P2, E extends Exception> E2E<P1, P2, E> exception(
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
}
