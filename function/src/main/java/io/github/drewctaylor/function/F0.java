package io.github.drewctaylor.function;

import java.util.function.Supplier;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface F0<R1> extends Supplier<R1>
{
    R1 f();

    static <R1> F0<R1> f0(
            final F0<R1> f0)
    {
        requireNonNull(f0, "f0");
        return f0;
    }

    static <R1> F0<R1> constant(
            final R1 r1)
    {
        return () -> r1;
    }

    @Override
    default R1 get()
    {
        return f();
    }
}
