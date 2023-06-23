package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E0
{
    void f();

    static E0 e0(
            final E0 e0)
    {
        requireNonNull(e0, "e0");
        return e0;
    }

    static E0 constant()
    {
        return () ->
        {
        };
    }
}
