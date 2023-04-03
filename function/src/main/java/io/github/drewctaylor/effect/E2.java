package io.github.drewctaylor.effect;

import java.util.function.BiConsumer;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E2<P1, P2> extends BiConsumer<P1, P2>
{
    void f(
            final P1 p1,
            final P2 p2);

    static <P1, P2> E2<P1, P2> e2(
            final E2<P1, P2> e2)
    {
        requireNonNull(e2, "e2");
        return e2;
    }

    static <P1, P2> E2<P1, P2> nothing()
    {
        return (
                p1,
                p2) ->
        {
        };
    }

    @Override
    default void accept(
            final P1 p1,
            final P2 p2)
    {
        f(p1, p2);
    }

    default E1<P2> partial(
            final P1 p1)
    {
        return (
                p2) -> f(p1, p2);
    }

    default E2<P1, P2> reverse()
    {
        return (
                p1,
                p2) -> f(p1, p2);
    }
}
