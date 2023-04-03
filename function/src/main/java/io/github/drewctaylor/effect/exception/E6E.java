package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E6E<P1, P2, P3, P4, P5, P6, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6)
            throws E;

    static <P1, P2, P3, P4, P5, P6, E extends Exception> E6E<P1, P2, P3, P4, P5, P6, E> e6e(
            final E6E<P1, P2, P3, P4, P5, P6, E> e6e)
    {
        requireNonNull(e6e, "e6e");
        return e6e;
    }

    static <P1, P2, P3, P4, P5, P6, E extends Exception> E6E<P1, P2, P3, P4, P5, P6, E> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) ->
        {
        };
    }

    default E5E<P2, P3, P4, P5, P6, E> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }

    static <P1, P2, P3, P4, P5, P6, E extends Exception> E6E<P1, P2, P3, P4, P5, P6, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) ->
        {
            throw e;
        };
    }

    default E6E<P1, P2, P3, P4, P5, P6, E> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6) -> f(p1, p2, p3, p4, p5, p6);
    }
}
