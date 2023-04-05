package io.github.drewctaylor.effect.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E extends Exception>
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
            final P9 p9,
            final P10 p10,
            final P11 p11,
            final P12 p12)
            throws E;

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E extends Exception> E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> e12e(
            final E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> e12e)
    {
        requireNonNull(e12e, "e12e");
        return e12e;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E extends Exception> E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> nothing()
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
                p9,
                p10,
                p11,
                p12) ->
        {
        };
    }

    default E11E<P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> partial(
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
                p9,
                p10,
                p11,
                p12) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E extends Exception> E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> exception(
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
                p9,
                p10,
                p11,
                p12) ->
        {
            throw e;
        };
    }

    default E12E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, E> reverse()
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
                p9,
                p10,
                p11,
                p12) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }
}