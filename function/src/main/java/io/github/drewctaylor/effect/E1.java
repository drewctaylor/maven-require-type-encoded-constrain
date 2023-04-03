package io.github.drewctaylor.effect;

import java.util.function.Consumer;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E1<P1> extends Consumer<P1>
{
    void f(
            final P1 p1);

    static <P1> E1<P1> e1(
            final E1<P1> e1)
    {
        requireNonNull(e1, "e1");
        return e1;
    }

    static <P1> E1<P1> nothing()
    {
        return (
                p1) ->
        {
        };
    }

    @Override
    default void accept(
            final P1 p1)
    {
        f(p1);
    }

    default E0 partial(
            final P1 p1)
    {
        return () -> f(p1);
    }

    default E1<P1> reverse()
    {
        return (
                p1) -> f(p1);
    }
}
