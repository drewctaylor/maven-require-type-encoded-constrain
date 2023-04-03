package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E5E<P1, P2, P3, P4, P5, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5)
            throws E;

    static <P1, P2, P3, P4, P5, E extends Exception> E5E<P1, P2, P3, P4, P5, E> e5e(
            final E5E<P1, P2, P3, P4, P5, E> e5e)
    {
        requireNonNull(e5e, "e5e");
        return e5e;
    }

    static <P1, P2, P3, P4, P5, E extends Exception> E5E<P1, P2, P3, P4, P5, E> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) ->
        {
        };
    }

    default E4E<P2, P3, P4, P5, E> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5) -> f(p1, p2, p3, p4, p5);
    }

    static <P1, P2, P3, P4, P5, E extends Exception> E5E<P1, P2, P3, P4, P5, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4,
                p5) ->
        {
            throw e;
        };
    }

    default E5E<P1, P2, P3, P4, P5, E> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5) -> f(p1, p2, p3, p4, p5);
    }
}
