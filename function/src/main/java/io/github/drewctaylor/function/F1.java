package io.github.drewctaylor.function;

import java.util.function.Function;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F1<P1, R1> extends Function<P1, R1>
{
    R1 f(
            final P1 p1);

    static <P1, R1> F1<P1, R1> f1(
            final F1<P1, R1> f1)
    {
        requireNonNull(f1, "f1");
        return f1;
    }

    static <P1, R1> F1<P1, R1> constant(
            final R1 r1)
    {
        return (
                p1) -> r1;
    }

    @Override
    default R1 apply(
            final P1 p1)
    {
        return f(p1);
    }

    default F0<R1> partial(
            final P1 p1)
    {
        return () -> f(p1);
    }

    static <P1> F1<P1, P1> identity()
    {
        return (
                p1) -> p1;
    }

    default F1<P1, R1> reverse()
    {
        return (
                p1) -> f(p1);
    }
}
