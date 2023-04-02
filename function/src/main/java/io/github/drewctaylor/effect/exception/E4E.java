package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E4E<P1, P2, P3, P4, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4)
            throws E;

    static <P1, P2, P3, P4, E extends Exception> E4E<P1, P2, P3, P4, E> e4e(
            final E4E<P1, P2, P3, P4, E> e4e)
    {
        requireNonNull(e4e, "e4e");
        return e4e;
    }

    static <P1, P2, P3, P4, E extends Exception> E4E<P1, P2, P3, P4, E> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4) ->
        {
        };
    }

    default E3E<P2, P3, P4, E> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4) -> f(p1, p2, p3, p4);
    }

    static <P1, P2, P3, P4, E extends Exception> E4E<P1, P2, P3, P4, E> exception(
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
}
