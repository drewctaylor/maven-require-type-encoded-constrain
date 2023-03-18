package io.github.drewctaylor.typeencoded;

/**
 * A builder for a type-encoded integer.
 *
 * // @formatter:off
 * <ul>
 * <li>type-encoded-integer                =        _0$</li>
 * <li>type-encoded-integer                =/       _1$</li>
 * <li>type-encoded-integer                =/       _2$</li>
 * <li>type-encoded-integer                =/       _3$</li>
 * <li>type-encoded-integer                =/       _4$</li>
 * <li>type-encoded-integer                =/       _5$</li>
 * <li>type-encoded-integer                =/       _6$</li>
 * <li>type-encoded-integer                =/       _7$</li>
 * <li>type-encoded-integer                =/       _8$</li>
 * <li>type-encoded-integer                =/       _9$</li>
 * <li>type-encoded-integer                =        _1  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _2  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _3  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _4  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _5  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _6  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _7  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _8  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/       _9  type-encoded-integer-digit</li>
 * <li>type-encoded-integer                =/ Negative  type-encoded-integer-non-zero-digit</li>
 * <li>type-encoded-integer-non-zero-digit =        _1$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _2$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _3$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _4$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _5$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _6$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _7$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _8$</li>
 * <li>type-encoded-integer-non-zero-digit =/       _9$</li>
 * <li>type-encoded-integer-non-zero-digit =        _1  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _2  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _3  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _4  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _5  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _6  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _7  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _8  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-non-zero-digit =/       _9  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =        _0$</li>
 * <li>type-encoded-integer-digit          =/       _1$</li>
 * <li>type-encoded-integer-digit          =/       _2$</li>
 * <li>type-encoded-integer-digit          =/       _3$</li>
 * <li>type-encoded-integer-digit          =/       _4$</li>
 * <li>type-encoded-integer-digit          =/       _5$</li>
 * <li>type-encoded-integer-digit          =/       _6$</li>
 * <li>type-encoded-integer-digit          =/       _7$</li>
 * <li>type-encoded-integer-digit          =/       _8$</li>
 * <li>type-encoded-integer-digit          =/       _9$</li>
 * <li>type-encoded-integer-digit          =        _0  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _1  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _2  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _3  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _4  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _5  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _6  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _7  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _8  type-encoded-integer-digit</li>
 * <li>type-encoded-integer-digit          =/       _9  type-encoded-integer-digit</li>
 * </ul>
 * // @formatter:on
 *
 * @see <a href="https://wiki.haskell.org/The_Monad.Reader/Issue5/Number_Param_Types">Number-parameterized types</a>
 */
public final class TypeEncodedIntegerBuilder
{
    private TypeEncodedIntegerBuilder()
    {
    }

    private abstract static class TypeEncodedIntegerDigitNonTerminal<T0 extends TypeEncodedIntegerDigit<T0>, T1 extends TypeEncodedInteger<T1>> extends TypeEncodedInteger<T1>
    {
        private final T0 next;
        private final int i;

        private TypeEncodedIntegerDigitNonTerminal(
                final T0 next,
                final int i)
        {
            this.next = next;
            this.i = i;
        }

        @Override
        public final int toInt()
        {
            return toInt(0);
        }

        public final int toInt(
                final int i)
        {
            return next.toInt(i * 10 + this.i);
        }
    }

    private abstract static class TypeEncodedIntegerDigitTerminal<T1 extends TypeEncodedInteger<T1>> extends TypeEncodedInteger<T1>
    {
        private final int i;

        private TypeEncodedIntegerDigitTerminal(
                final int i)
        {
            this.i = i;
        }

        @Override
        public final int toInt()
        {
            return i;
        }

        public final int toInt(
                final int i)
        {
            return i * 10 + this.i;
        }
    }

    // @formatter:off
    public  abstract static class     TypeEncodedInteger            <T0 extends TypeEncodedInteger            <T0>> { private TypeEncodedInteger() {} public abstract int toInt(); }
    private                 interface TypeEncodedIntegerDigitNonZero<T0 extends TypeEncodedIntegerDigitNonZero<T0>> {                                                         int toInt(); }
    private                 interface TypeEncodedIntegerDigit       <T0 extends TypeEncodedIntegerDigit       <T0>> {                                                         int toInt(final int i); }

    /** A type-encoded integer.       */ public static final class TypeEncodedIntegerConcrete<T0 extends TypeEncodedInteger            <T0>> extends TypeEncodedInteger                        <T0>                                                                                     { private final T0 next; private TypeEncodedIntegerConcrete (final T0 next) { this.next = next; } @Override public int toInt() { return next.toInt(); } }
    /** A type-encoded negative sign. */ public static final class Negative                  <T0 extends TypeEncodedIntegerDigitNonZero<T0>> extends TypeEncodedInteger               <Negative<T0>>                                                                                    { private final T0 next; private                   Negative (final T0 next) { this.next = next; } @Override public int toInt() { return next.toInt() * -1; } }
    /** A type-encoded 0.             */ public static final class _0                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _0<T0>> implements TypeEncodedIntegerDigit<_0<T0>>                                         {                        private                         _0 (final T0 next) { super(next, 0); } }
    /** A type-encoded 1.             */ public static final class _1                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _1<T0>> implements TypeEncodedIntegerDigit<_1<T0>>, TypeEncodedIntegerDigitNonZero<_1<T0>> {                        private                         _1 (final T0 next) { super(next, 1); } }
    /** A type-encoded 2.             */ public static final class _2                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _2<T0>> implements TypeEncodedIntegerDigit<_2<T0>>, TypeEncodedIntegerDigitNonZero<_2<T0>> {                        private                         _2 (final T0 next) { super(next, 2); } }
    /** A type-encoded 3.             */ public static final class _3                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _3<T0>> implements TypeEncodedIntegerDigit<_3<T0>>, TypeEncodedIntegerDigitNonZero<_3<T0>> {                        private                         _3 (final T0 next) { super(next, 3); } }
    /** A type-encoded 4.             */ public static final class _4                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _4<T0>> implements TypeEncodedIntegerDigit<_4<T0>>, TypeEncodedIntegerDigitNonZero<_4<T0>> {                        private                         _4 (final T0 next) { super(next, 4); } }
    /** A type-encoded 5.             */ public static final class _5                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _5<T0>> implements TypeEncodedIntegerDigit<_5<T0>>, TypeEncodedIntegerDigitNonZero<_5<T0>> {                        private                         _5 (final T0 next) { super(next, 5); } }
    /** A type-encoded 6.             */ public static final class _6                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _6<T0>> implements TypeEncodedIntegerDigit<_6<T0>>, TypeEncodedIntegerDigitNonZero<_6<T0>> {                        private                         _6 (final T0 next) { super(next, 6); } }
    /** A type-encoded 7.             */ public static final class _7                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _7<T0>> implements TypeEncodedIntegerDigit<_7<T0>>, TypeEncodedIntegerDigitNonZero<_7<T0>> {                        private                         _7 (final T0 next) { super(next, 7); } }
    /** A type-encoded 8.             */ public static final class _8                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _8<T0>> implements TypeEncodedIntegerDigit<_8<T0>>, TypeEncodedIntegerDigitNonZero<_8<T0>> {                        private                         _8 (final T0 next) { super(next, 8); } }
    /** A type-encoded 9.             */ public static final class _9                        <T0 extends TypeEncodedIntegerDigit       <T0>> extends TypeEncodedIntegerDigitNonTerminal <T0, _9<T0>> implements TypeEncodedIntegerDigit<_9<T0>>, TypeEncodedIntegerDigitNonZero<_9<T0>> {                        private                         _9 (final T0 next) { super(next, 9); } }
    /** A type-encoded final 0.       */ public static final class _0$                                                                       extends TypeEncodedIntegerDigitTerminal           <_0$> implements TypeEncodedIntegerDigit<_0$>                                            {                        private                         _0$()              { super(0); } }
    /** A type-encoded final 1.       */ public static final class _1$                                                                       extends TypeEncodedIntegerDigitTerminal           <_1$> implements TypeEncodedIntegerDigit<_1$>,    TypeEncodedIntegerDigitNonZero<_1$>    {                        private                         _1$()              { super(1); } }
    /** A type-encoded final 2.       */ public static final class _2$                                                                       extends TypeEncodedIntegerDigitTerminal           <_2$> implements TypeEncodedIntegerDigit<_2$>,    TypeEncodedIntegerDigitNonZero<_2$>    {                        private                         _2$()              { super(2); } }
    /** A type-encoded final 3.       */ public static final class _3$                                                                       extends TypeEncodedIntegerDigitTerminal           <_3$> implements TypeEncodedIntegerDigit<_3$>,    TypeEncodedIntegerDigitNonZero<_3$>    {                        private                         _3$()              { super(3); } }
    /** A type-encoded final 4.       */ public static final class _4$                                                                       extends TypeEncodedIntegerDigitTerminal           <_4$> implements TypeEncodedIntegerDigit<_4$>,    TypeEncodedIntegerDigitNonZero<_4$>    {                        private                         _4$()              { super(4); } }
    /** A type-encoded final 5.       */ public static final class _5$                                                                       extends TypeEncodedIntegerDigitTerminal           <_5$> implements TypeEncodedIntegerDigit<_5$>,    TypeEncodedIntegerDigitNonZero<_5$>    {                        private                         _5$()              { super(5); } }
    /** A type-encoded final 6.       */ public static final class _6$                                                                       extends TypeEncodedIntegerDigitTerminal           <_6$> implements TypeEncodedIntegerDigit<_6$>,    TypeEncodedIntegerDigitNonZero<_6$>    {                        private                         _6$()              { super(6); } }
    /** A type-encoded final 7.       */ public static final class _7$                                                                       extends TypeEncodedIntegerDigitTerminal           <_7$> implements TypeEncodedIntegerDigit<_7$>,    TypeEncodedIntegerDigitNonZero<_7$>    {                        private                         _7$()              { super(7); } }
    /** A type-encoded final 8.       */ public static final class _8$                                                                       extends TypeEncodedIntegerDigitTerminal           <_8$> implements TypeEncodedIntegerDigit<_8$>,    TypeEncodedIntegerDigitNonZero<_8$>    {                        private                         _8$()              { super(8); } }
    /** A type-encoded final 9.       */ public static final class _9$                                                                       extends TypeEncodedIntegerDigitTerminal           <_9$> implements TypeEncodedIntegerDigit<_9$>,    TypeEncodedIntegerDigitNonZero<_9$>    {                        private                         _9$()              { super(9); } }

    /** Return a type-encoded integer.       */ public static <T0 extends TypeEncodedInteger    <T0>> TypeEncodedIntegerConcrete<T0>  integer(final T0 next) { return new TypeEncodedIntegerConcrete<>(next); }
    /** Return a type-encoded negative sign. */ public static <T0 extends TypeEncodedIntegerDigitNonZero<T0>>           Negative<T0> negative(final T0 next) { return new           Negative<>(next); }
    /** Return a type-encoded 0.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _0<T0>       _0(final T0 next) { return new                 _0<>(next); }
    /** Return a type-encoded 1.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _1<T0>       _1(final T0 next) { return new                 _1<>(next); }
    /** Return a type-encoded 2.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _2<T0>       _2(final T0 next) { return new                 _2<>(next); }
    /** Return a type-encoded 3.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _3<T0>       _3(final T0 next) { return new                 _3<>(next); }
    /** Return a type-encoded 4.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _4<T0>       _4(final T0 next) { return new                 _4<>(next); }
    /** Return a type-encoded 5.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _5<T0>       _5(final T0 next) { return new                 _5<>(next); }
    /** Return a type-encoded 6.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _6<T0>       _6(final T0 next) { return new                 _6<>(next); }
    /** Return a type-encoded 7.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _7<T0>       _7(final T0 next) { return new                 _7<>(next); }
    /** Return a type-encoded 8.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _8<T0>       _8(final T0 next) { return new                 _8<>(next); }
    /** Return a type-encoded 9.             */ public static <T0 extends TypeEncodedIntegerDigit       <T0>>                 _9<T0>       _9(final T0 next) { return new                 _9<>(next); }
    /** Return a type-encoded final 0.       */ public static                                                                 _0$          _0()              { return new                 _0$(); }
    /** Return a type-encoded final 1.       */ public static                                                                 _1$          _1()              { return new                 _1$(); }
    /** Return a type-encoded final 2.       */ public static                                                                 _2$          _2()              { return new                 _2$(); }
    /** Return a type-encoded final 3.       */ public static                                                                 _3$          _3()              { return new                 _3$(); }
    /** Return a type-encoded final 4.       */ public static                                                                 _4$          _4()              { return new                 _4$(); }
    /** Return a type-encoded final 5.       */ public static                                                                 _5$          _5()              { return new                 _5$(); }
    /** Return a type-encoded final 6.       */ public static                                                                 _6$          _6()              { return new                 _6$(); }
    /** Return a type-encoded final 7.       */ public static                                                                 _7$          _7()              { return new                 _7$(); }
    /** Return a type-encoded final 8.       */ public static                                                                 _8$          _8()              { return new                 _8$(); }
    /** Return a type-encoded final 9.       */ public static                                                                 _9$          _9()              { return new                 _9$(); }
    // @formatter:on
}
