package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E8E<P1, P2, P3, P4, P5, P6, P7, P8, E extends Exception>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3,
            final P4 p4,
            final P5 p5,
            final P6 p6,
            final P7 p7,
            final P8 p8)
            throws E;

    static <P1, P2, P3, P4, P5, P6, P7, P8, E extends Exception> E8E<P1, P2, P3, P4, P5, P6, P7, P8, E> e8e(
            final E8E<P1, P2, P3, P4, P5, P6, P7, P8, E> e8e)
    {
        requireNonNull(e8e, "e8e");
        return e8e;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, E extends Exception> E8E<P1, P2, P3, P4, P5, P6, P7, P8, E> nothing()
    {
        return (
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8) ->
        {
        };
    }

    default E7E<P2, P3, P4, P5, P6, P7, P8, E> parameter(
            final P1 p1)
    {
        return (
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8) -> f(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, E extends Exception> E8E<P1, P2, P3, P4, P5, P6, P7, P8, E> exception(
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
                p8) ->
        {
            throw e;
        };
    }
}
