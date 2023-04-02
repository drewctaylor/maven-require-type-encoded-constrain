package io.github.drewctaylor.function.exception;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E extends Exception>
{
    R1 f(
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
            final P11 p11)
            throws E;

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E extends Exception> F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E> f11e(
            final F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E> f11e)
    {
        requireNonNull(f11e, "f11e");
        return f11e;
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E extends Exception> F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E> constant(
            final R1 r1)
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
                p11) -> r1;
    }

    default F10E<P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E> parameter(
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
                p11) -> f(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E extends Exception> F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R1, E> exception(
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
                p11) ->
        {
            throw e;
        };
    }

    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, E extends Exception> F11E<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P1, E> identity()
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
                p11) -> p1;
    }
}
