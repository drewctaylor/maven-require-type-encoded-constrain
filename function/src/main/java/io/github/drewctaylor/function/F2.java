package io.github.drewctaylor.function;

import java.util.function.BiFunction;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F2<P1, P2, R1> extends BiFunction<P1, P2, R1>
{
    R1 f(
            final P1 p1,
            final P2 p2);

    static <P1, P2, R1> F2<P1, P2, R1> f2(
            final F2<P1, P2, R1> f2)
    {
        requireNonNull(f2, "f2");
        return f2;
    }

    static <P1, P2, R1> F2<P1, P2, R1> constant(
            final R1 r1)
    {
        return (
                p1,
                p2) -> r1;
    }

    @Override
    default R1 apply(
            final P1 p1,
            final P2 p2)
    {
        return f(p1, p2);
    }

    default F1<P2, R1> partial(
            final P1 p1)
    {
        return (
                p2) -> f(p1, p2);
    }

    static <P1, P2> F2<P1, P2, P1> identity()
    {
        return (
                p1,
                p2) -> p1;
    }

    default F2<P1, P2, R1> reverse()
    {
        return (
                p1,
                p2) -> f(p1, p2);
    }
}
