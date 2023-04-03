package io.github.drewctaylor.effect;

import static io.github.drewctaylor.require.Require.requireNonNull;

@FunctionalInterface
public interface E3<P1, P2, P3>
{
    void f(
            final P1 p1,
            final P2 p2,
            final P3 p3);

    static <P1, P2, P3> E3<P1, P2, P3> e3(
            final E3<P1, P2, P3> e3)
    {
        requireNonNull(e3, "e3");
        return e3;
    }

    static <P1, P2, P3> E3<P1, P2, P3> nothing()
    {
        return (
                p1,
                p2,
                p3) ->
        {
        };
    }

    default E2<P2, P3> partial(
            final P1 p1)
    {
        return (
                p2,
                p3) -> f(p1, p2, p3);
    }

    default E3<P1, P2, P3> reverse()
    {
        return (
                p1,
                p2,
                p3) -> f(p1, p2, p3);
    }
}
