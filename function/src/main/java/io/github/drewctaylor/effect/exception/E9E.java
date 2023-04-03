package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7,
            final P8 p8,
            final P9 p9)
            throws E;

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, E extends Exception> E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E> e9e(
            final E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E> e9e)
    {
        requireNonNull(e9e, "e9e");
        return e9e;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, E extends Exception> E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9) ->
        {
        };
    }

    default E8E<P2, P3, P4, P5, P6, P7, P8, P9, E> partial(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, E extends Exception> E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E> exception(
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
                p7,
                p8,
                p9) ->
        {
            throw e;
        };
    }

    default E9E<P1, P2, P3, P4, P5, P6, P7, P8, P9, E> reverse()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
}
