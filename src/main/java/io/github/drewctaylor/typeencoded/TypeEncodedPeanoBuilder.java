package io.github.drewctaylor.typeencoded;

/**
 * A builder for type-encoded Peano number.
 *
 * // @formatter:off
 * <ul>
 * <li>type-encoded-peano =  Z</li>
 * <li>type-encoded-peano =/ S type-encoded-peano</li>
 * </ul>
 * // @formatter:on
 *
 * @see <a href="https://wiki.haskell.org/The_Monad.Reader/Issue5/Number_Param_Types">Number-parameterized types</a>
 */
public final class TypeEncodedPeanoBuilder
{
    private TypeEncodedPeanoBuilder()
    {
    }

    public abstract static class TypeEncodedPeano<T0 extends TypeEncodedPeano<T0>>
    {
        private TypeEncodedPeano()
        {
        }

        /**
         * Return the int representation.
         *
         * @return the int representation
         */
        public abstract int toInt();
    }

    /**
     * A type-encoded Peano number.
     *
     * @param <T0> the type of the first element of the type-encoded Peano number.
     */
    public static final class TypeEncodedPeanoConcrete<T0 extends TypeEncodedPeano<T0>> extends TypeEncodedPeano<T0>
    {
        private final T0 peano;

        private TypeEncodedPeanoConcrete(
                final T0 peano)
        {
            this.peano = peano;
        }

        @Override
        public int toInt()
        {
            return peano.toInt();
        }
    }

    /**
     * Return a type-encoded peano number.
     *
     * @param  peano the rest of the peano number
     * @param  <T0>  the type of the rest of the peano number
     * @return       a type-encoded peano number
     */
    public static <T0 extends TypeEncodedPeano<T0>> TypeEncodedPeanoConcrete<T0> peano(
            final T0 peano)
    {
        return new TypeEncodedPeanoConcrete<>(peano);
    }

    /**
     * A zero.
     */
    public static final class Z extends TypeEncodedPeano<Z>
    {
        private static final Z z = new Z();

        private Z()
        {
        }

        @Override
        public int toInt()
        {
            return 0;
        }
    }

    /**
     * Return a type-encoded zero.
     *
     * @return a type-encoded zero
     */
    public static Z z()
    {
        return Z.z;
    }

    /**
     * A successor of a Peano number.
     *
     * @param <T0> the type of the rest of the Peano number
     */
    public static final class S<T0 extends TypeEncodedPeano<T0>> extends TypeEncodedPeano<S<T0>>
    {
        private final T0 predecessor;

        private S(
                final T0 predecessor)
        {
            this.predecessor = predecessor;
        }

        @Override
        public int toInt()
        {
            return 1 + predecessor.toInt();
        }
    }

    /**
     * Return a type-encoded successor of a Peano number given the type of the rest of the Peano number.
     *
     * @param  number the rest of the peano number
     * @param  <T0>   the type of the rest of the Peano number
     * @return        a type-encoded successor of a Peano number
     */
    public static <T0 extends TypeEncodedPeano<T0>> S<T0> s(
            final T0 number)
    {
        return new S<>(number);
    }
}
