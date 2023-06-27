package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E1<P1>
{
    void f(
            final P1 p1);

    static <P1> E1<P1> e1(
            final E1<P1> e1)
    {
        requireNonNull(e1, "e1");
        return e1;
    }

    static <P1> E1<P1> constant()
    {
        return (
                p1) ->
        {
        };
    }

    default E0 argument(
            final P1 p1)
    {
        return () -> f(p1);
    }
}
