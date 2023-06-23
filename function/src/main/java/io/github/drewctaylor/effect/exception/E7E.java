package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E7E<P1, P2, P3, P4, P5, P6, P7, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7)
            throws E;

    static <P1, P2, P3, P4, P5, P6, P7, E extends Exception> E7E<P1, P2, P3, P4, P5, P6, P7, E> e7e(
            final E7E<P1, P2, P3, P4, P5, P6, P7, E> e7e)
    {
        requireNonNull(e7e, "e7e");
        return e7e;
    }

    static <P1, P2, P3, P4, P5, P6, P7, E extends Exception> E7E<P1, P2, P3, P4, P5, P6, P7, E> constant()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) ->
        {
        };
    }

    default E6E<P2, P3, P4, P5, P6, P7, E> argument(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) -> f(p1, p2, p3, p4, p5, p6, p7);
    }

    static <P1, P2, P3, P4, P5, P6, P7, E extends Exception> E7E<P1, P2, P3, P4, P5, P6, P7, E> exception(
            final E e)
    {
        requireNonNull(e, "e");
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7) ->
        {
            throw e;
        };
    }
}
