package io.github.drewctaylor.typeencoded;

import java.math.BigDecimal;

/**
 * A builder for a type-encoded decimal.
 *
 * // @formatter:off
 * <ul>
 * <li>type-encoded-decimal                      =        _0$</li>
 * <li>type-encoded-decimal                      =/       _1$</li>
 * <li>type-encoded-decimal                      =/       _2$</li>
 * <li>type-encoded-decimal                      =/       _3$</li>
 * <li>type-encoded-decimal                      =/       _4$</li>
 * <li>type-encoded-decimal                      =/       _5$</li>
 * <li>type-encoded-decimal                      =/       _6$</li>
 * <li>type-encoded-decimal                      =/       _7$</li>
 * <li>type-encoded-decimal                      =/       _8$</li>
 * <li>type-encoded-decimal                      =/       _9$</li>
 * <li>type-encoded-decimal                      =/      __1$</li>
 * <li>type-encoded-decimal                      =/      __2$</li>
 * <li>type-encoded-decimal                      =/      __3$</li>
 * <li>type-encoded-decimal                      =/      __4$</li>
 * <li>type-encoded-decimal                      =/      __5$</li>
 * <li>type-encoded-decimal                      =/      __6$</li>
 * <li>type-encoded-decimal                      =/      __7$</li>
 * <li>type-encoded-decimal                      =/      __8$</li>
 * <li>type-encoded-decimal                      =/      __9$</li>
 * <li>type-encoded-decimal                      =/       _1  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _2  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _3  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _4  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _5  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _6  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _7  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _8  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/       _9  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal                      =/      __0  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __1  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __2  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __3  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __4  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __5  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __6  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __7  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __8  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/      __9  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal                      =/ Negative  type-encoded-decimal-digit-whole-non-zero</li>
 * <li>type-encoded-decimal-digit-whole          =        _0$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _1$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _2$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _3$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _4$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _5$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _6$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _7$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _8$</li>
 * <li>type-encoded-decimal-digit-whole          =/       _9$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __1$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __2$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __3$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __4$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __5$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __6$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __7$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __8$</li>
 * <li>type-encoded-decimal-digit-whole          =/      __9$</li>
 * <li>type-encoded-decimal-digit-whole          =        _0  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _1  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _2  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _3  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _4  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _5  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _6  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _7  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _8  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =/       _9  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole          =       __0  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __1  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __2  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __3  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __4  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __5  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __6  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __7  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __8  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole          =/      __9  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =        _1$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _2$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _3$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _4$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _5$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _6$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _7$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _8$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _9$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __1$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __2$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __3$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __4$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __5$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __6$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __7$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __8$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __9$</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _1  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _2  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _3  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _4  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _5  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _6  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _7  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _8  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/       _9  type-encoded-decimal-digit-whole</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __0  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __1  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __2  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __3  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __4  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __5  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __6  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __7  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __8  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-whole-non-zero =/      __9  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __1$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __2$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __3$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __4$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __5$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __6$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __7$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __8$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __9$</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __0  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __1  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __2  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __3  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __4  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __5  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __6  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __7  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __8  type-encoded-decimal-digit-fraction</li>
 * <li>type-encoded-decimal-digit-fraction       =/      __9  type-encoded-decimal-digit-fraction</li>
 * </ul>
 * // @formatter:on
 *
 * @see <a href="https://wiki.haskell.org/The_Monad.Reader/Issue5/Number_Param_Types">Number-parameterized types</a>
 */
public final class TypeEncodedDecimalBuilder
{
    private TypeEncodedDecimalBuilder()
    {
    }

    private abstract static class TypeEncodedDecimalDigitWholeNonTerminal<T0 extends TypeEncodedDecimalDigitWhole<T0>, T1 extends TypeEncodedDecimal<T1>> extends TypeEncodedDecimal<T1>
    {
        private final T0 next;
        private final BigDecimal bd;

        private TypeEncodedDecimalDigitWholeNonTerminal(
                final T0 next,
                final BigDecimal bd)
        {
            this.next = next;
            this.bd = bd;
        }

        @Override
        public final BigDecimal toBigDecimal()
        {
            return toBigDecimal(BigDecimal.ZERO);
        }

        public final BigDecimal toBigDecimal(
                final BigDecimal bd)
        {
            return next.toBigDecimal(bd.movePointRight(1).add(this.bd));
        }
    }

    private abstract static class TypeEncodedDecimalDigitFractionNonTerminal<T0 extends TypeEncodedDecimalDigitFraction<T0>, T1 extends TypeEncodedDecimal<T1>> extends TypeEncodedDecimal<T1>
    {
        private final T0 next;
        private final BigDecimal bd;

        private TypeEncodedDecimalDigitFractionNonTerminal(
                final T0 next,
                final BigDecimal bd)
        {
            this.next = next;
            this.bd = bd;
        }

        @Override
        public final BigDecimal toBigDecimal()
        {
            return bd.movePointLeft(1).add(next.toBigDecimal().movePointLeft(1));
        }

        public final BigDecimal toBigDecimal(
                final BigDecimal bd)
        {
            return bd.add(toBigDecimal());
        }
    }

    private abstract static class TypeEncodedDecimalDigitWholeTerminal<T1 extends TypeEncodedDecimal<T1>> extends TypeEncodedDecimal<T1>
    {
        private final BigDecimal bd;

        private TypeEncodedDecimalDigitWholeTerminal(
                final BigDecimal bd)
        {
            this.bd = bd;
        }

        @Override
        public final BigDecimal toBigDecimal()
        {
            return bd;
        }

        public final BigDecimal toBigDecimal(
                final BigDecimal bd)
        {
            return bd.movePointRight(1).add(this.bd);
        }
    }

    private abstract static class TypeEncodedDecimalDigitFractionTerminal<T1 extends TypeEncodedDecimal<T1>> extends TypeEncodedDecimal<T1>
    {
        private final BigDecimal bd;

        private TypeEncodedDecimalDigitFractionTerminal(
                final BigDecimal bd)
        {
            this.bd = bd;
        }

        @Override
        public final BigDecimal toBigDecimal()
        {
            return bd.movePointLeft(1);
        }

        public final BigDecimal toBigDecimal(
                final BigDecimal bd)
        {
            return bd.add(toBigDecimal());
        }
    }

    // @formatter:off
    public  abstract static class     TypeEncodedDecimal                 <T0 extends TypeEncodedDecimal                 <T0>> { private TypeEncodedDecimal() {} public abstract BigDecimal toBigDecimal(); }
    private                 interface TypeEncodedDecimalDigitWholeNonZero<T0 extends TypeEncodedDecimalDigitWholeNonZero<T0>> {                                                         BigDecimal toBigDecimal(); }
    private                 interface TypeEncodedDecimalDigitWhole       <T0 extends TypeEncodedDecimalDigitWhole       <T0>> {                                                         BigDecimal toBigDecimal(); BigDecimal toBigDecimal(final BigDecimal bd); }
    private                 interface TypeEncodedDecimalDigitFraction    <T0 extends TypeEncodedDecimalDigitFraction    <T0>> {                                                         BigDecimal toBigDecimal(); }

    /** A type-encoded decimal.                     */ public static final class TypeEncodedDecimalConcrete<T0 extends TypeEncodedDecimal                 <T0>> extends TypeEncodedDecimal                                <T0>                                                                                                                                           { private final T0 next; private TypeEncodedDecimalConcrete(final T0 next) { this.next = next; } @Override public BigDecimal toBigDecimal() { return next.toBigDecimal(); } }
    /** A type-encoded negative sign.               */ public static final class                   Negative<T0 extends TypeEncodedDecimalDigitWholeNonZero<T0>> extends TypeEncodedDecimal                       <Negative<T0>>                                                                                                                                          { private final T0 next; private           Negative(final T0 next)         { this.next = next; } @Override public BigDecimal toBigDecimal() { return next.toBigDecimal().negate(); } }
    /** A type-encoded, whole number 0.             */ public static final class                         _0<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _0<T0>> implements TypeEncodedDecimalDigitWhole< _0<T0>>                                                                                         {                        private                _0 (final T0 next)         { super(next, new BigDecimal(0)); } }
    /** A type-encoded, whole number 1.             */ public static final class                         _1<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _1<T0>> implements TypeEncodedDecimalDigitWhole< _1<T0>>, TypeEncodedDecimalDigitWholeNonZero< _1<T0>>                                           {                        private                _1 (final T0 next)         { super(next, new BigDecimal(1)); } }
    /** A type-encoded, whole number 2.             */ public static final class                         _2<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _2<T0>> implements TypeEncodedDecimalDigitWhole< _2<T0>>, TypeEncodedDecimalDigitWholeNonZero< _2<T0>>                                           {                        private                _2 (final T0 next)         { super(next, new BigDecimal(2)); } }
    /** A type-encoded, whole number 3.             */ public static final class                         _3<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _3<T0>> implements TypeEncodedDecimalDigitWhole< _3<T0>>, TypeEncodedDecimalDigitWholeNonZero< _3<T0>>                                           {                        private                _3 (final T0 next)         { super(next, new BigDecimal(3)); } }
    /** A type-encoded, whole number 4.             */ public static final class                         _4<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _4<T0>> implements TypeEncodedDecimalDigitWhole< _4<T0>>, TypeEncodedDecimalDigitWholeNonZero< _4<T0>>                                           {                        private                _4 (final T0 next)         { super(next, new BigDecimal(4)); } }
    /** A type-encoded, whole number 5.             */ public static final class                         _5<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _5<T0>> implements TypeEncodedDecimalDigitWhole< _5<T0>>, TypeEncodedDecimalDigitWholeNonZero< _5<T0>>                                           {                        private                _5 (final T0 next)         { super(next, new BigDecimal(5)); } }
    /** A type-encoded, whole number 6.             */ public static final class                         _6<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _6<T0>> implements TypeEncodedDecimalDigitWhole< _6<T0>>, TypeEncodedDecimalDigitWholeNonZero< _6<T0>>                                           {                        private                _6 (final T0 next)         { super(next, new BigDecimal(6)); } }
    /** A type-encoded, whole number 7.             */ public static final class                         _7<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _7<T0>> implements TypeEncodedDecimalDigitWhole< _7<T0>>, TypeEncodedDecimalDigitWholeNonZero< _7<T0>>                                           {                        private                _7 (final T0 next)         { super(next, new BigDecimal(7)); } }
    /** A type-encoded, whole number 8.             */ public static final class                         _8<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _8<T0>> implements TypeEncodedDecimalDigitWhole< _8<T0>>, TypeEncodedDecimalDigitWholeNonZero< _8<T0>>                                           {                        private                _8 (final T0 next)         { super(next, new BigDecimal(8)); } }
    /** A type-encoded, whole number 9.             */ public static final class                         _9<T0 extends TypeEncodedDecimalDigitWhole       <T0>> extends TypeEncodedDecimalDigitWholeNonTerminal   <T0,  _9<T0>> implements TypeEncodedDecimalDigitWhole< _9<T0>>, TypeEncodedDecimalDigitWholeNonZero< _9<T0>>                                           {                        private                _9 (final T0 next)         { super(next, new BigDecimal(9)); } }
    /** A type-encoded, fractional number 0.        */ public static final class                        __0<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __0<T0>> implements TypeEncodedDecimalDigitWhole<__0<T0>>, TypeEncodedDecimalDigitWholeNonZero<__0<T0>>, TypeEncodedDecimalDigitFraction<__0<T0>> {                        private               __0 (final T0 next)         { super(next, new BigDecimal(0)); } }
    /** A type-encoded, fractional number 1.        */ public static final class                        __1<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __1<T0>> implements TypeEncodedDecimalDigitWhole<__1<T0>>, TypeEncodedDecimalDigitWholeNonZero<__1<T0>>, TypeEncodedDecimalDigitFraction<__1<T0>> {                        private               __1 (final T0 next)         { super(next, new BigDecimal(1)); } }
    /** A type-encoded, fractional number 2.        */ public static final class                        __2<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __2<T0>> implements TypeEncodedDecimalDigitWhole<__2<T0>>, TypeEncodedDecimalDigitWholeNonZero<__2<T0>>, TypeEncodedDecimalDigitFraction<__2<T0>> {                        private               __2 (final T0 next)         { super(next, new BigDecimal(2)); } }
    /** A type-encoded, fractional number 3.        */ public static final class                        __3<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __3<T0>> implements TypeEncodedDecimalDigitWhole<__3<T0>>, TypeEncodedDecimalDigitWholeNonZero<__3<T0>>, TypeEncodedDecimalDigitFraction<__3<T0>> {                        private               __3 (final T0 next)         { super(next, new BigDecimal(3)); } }
    /** A type-encoded, fractional number 4.        */ public static final class                        __4<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __4<T0>> implements TypeEncodedDecimalDigitWhole<__4<T0>>, TypeEncodedDecimalDigitWholeNonZero<__4<T0>>, TypeEncodedDecimalDigitFraction<__4<T0>> {                        private               __4 (final T0 next)         { super(next, new BigDecimal(4)); } }
    /** A type-encoded, fractional number 5.        */ public static final class                        __5<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __5<T0>> implements TypeEncodedDecimalDigitWhole<__5<T0>>, TypeEncodedDecimalDigitWholeNonZero<__5<T0>>, TypeEncodedDecimalDigitFraction<__5<T0>> {                        private               __5 (final T0 next)         { super(next, new BigDecimal(5)); } }
    /** A type-encoded, fractional number 6.        */ public static final class                        __6<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __6<T0>> implements TypeEncodedDecimalDigitWhole<__6<T0>>, TypeEncodedDecimalDigitWholeNonZero<__6<T0>>, TypeEncodedDecimalDigitFraction<__6<T0>> {                        private               __6 (final T0 next)         { super(next, new BigDecimal(6)); } }
    /** A type-encoded, fractional number 7.        */ public static final class                        __7<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __7<T0>> implements TypeEncodedDecimalDigitWhole<__7<T0>>, TypeEncodedDecimalDigitWholeNonZero<__7<T0>>, TypeEncodedDecimalDigitFraction<__7<T0>> {                        private               __7 (final T0 next)         { super(next, new BigDecimal(7)); } }
    /** A type-encoded, fractional number 8.        */ public static final class                        __8<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __8<T0>> implements TypeEncodedDecimalDigitWhole<__8<T0>>, TypeEncodedDecimalDigitWholeNonZero<__8<T0>>, TypeEncodedDecimalDigitFraction<__8<T0>> {                        private               __8 (final T0 next)         { super(next, new BigDecimal(8)); } }
    /** A type-encoded, fractional number 9.        */ public static final class                        __9<T0 extends TypeEncodedDecimalDigitFraction    <T0>> extends TypeEncodedDecimalDigitFractionNonTerminal<T0, __9<T0>> implements TypeEncodedDecimalDigitWhole<__9<T0>>, TypeEncodedDecimalDigitWholeNonZero<__9<T0>>, TypeEncodedDecimalDigitFraction<__9<T0>> {                        private               __9 (final T0 next)         { super(next, new BigDecimal(9)); } }
    /** A type-encoded, final, whole number 0.      */ public static final class                         _0$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _0$> implements TypeEncodedDecimalDigitWhole< _0$>                                                                                            {                        private                _0$()                      { super(new BigDecimal(0)); } }
    /** A type-encoded, final, whole number 1.      */ public static final class                         _1$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _1$> implements TypeEncodedDecimalDigitWhole< _1$>,    TypeEncodedDecimalDigitWholeNonZero< _1$>                                              {                        private                _1$()                      { super(new BigDecimal(1)); } }
    /** A type-encoded, final, whole number 2.      */ public static final class                         _2$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _2$> implements TypeEncodedDecimalDigitWhole< _2$>,    TypeEncodedDecimalDigitWholeNonZero< _2$>                                              {                        private                _2$()                      { super(new BigDecimal(2)); } }
    /** A type-encoded, final, whole number 3.      */ public static final class                         _3$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _3$> implements TypeEncodedDecimalDigitWhole< _3$>,    TypeEncodedDecimalDigitWholeNonZero< _3$>                                              {                        private                _3$()                      { super(new BigDecimal(3)); } }
    /** A type-encoded, final, whole number 4.      */ public static final class                         _4$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _4$> implements TypeEncodedDecimalDigitWhole< _4$>,    TypeEncodedDecimalDigitWholeNonZero< _4$>                                              {                        private                _4$()                      { super(new BigDecimal(4)); } }
    /** A type-encoded, final, whole number 5.      */ public static final class                         _5$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _5$> implements TypeEncodedDecimalDigitWhole< _5$>,    TypeEncodedDecimalDigitWholeNonZero< _5$>                                              {                        private                _5$()                      { super(new BigDecimal(5)); } }
    /** A type-encoded, final, whole number 6.      */ public static final class                         _6$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _6$> implements TypeEncodedDecimalDigitWhole< _6$>,    TypeEncodedDecimalDigitWholeNonZero< _6$>                                              {                        private                _6$()                      { super(new BigDecimal(6)); } }
    /** A type-encoded, final, whole number 7.      */ public static final class                         _7$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _7$> implements TypeEncodedDecimalDigitWhole< _7$>,    TypeEncodedDecimalDigitWholeNonZero< _7$>                                              {                        private                _7$()                      { super(new BigDecimal(7)); } }
    /** A type-encoded, final, whole number 8.      */ public static final class                         _8$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _8$> implements TypeEncodedDecimalDigitWhole< _8$>,    TypeEncodedDecimalDigitWholeNonZero< _8$>                                              {                        private                _8$()                      { super(new BigDecimal(8)); } }
    /** A type-encoded, final, whole number 9.      */ public static final class                         _9$                                                    extends TypeEncodedDecimalDigitWholeTerminal             < _9$> implements TypeEncodedDecimalDigitWhole< _9$>,    TypeEncodedDecimalDigitWholeNonZero< _9$>                                              {                        private                _9$()                      { super(new BigDecimal(9)); } }
    /** A type-encoded, final, fractional number 1. */ public static final class                        __1$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__1$> implements TypeEncodedDecimalDigitWhole<__1$>,    TypeEncodedDecimalDigitWholeNonZero<__1$>,    TypeEncodedDecimalDigitFraction<__1$>    {                        private               __1$()                      { super(new BigDecimal(1)); } }
    /** A type-encoded, final, fractional number 2. */ public static final class                        __2$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__2$> implements TypeEncodedDecimalDigitWhole<__2$>,    TypeEncodedDecimalDigitWholeNonZero<__2$>,    TypeEncodedDecimalDigitFraction<__2$>    {                        private               __2$()                      { super(new BigDecimal(2)); } }
    /** A type-encoded, final, fractional number 3. */ public static final class                        __3$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__3$> implements TypeEncodedDecimalDigitWhole<__3$>,    TypeEncodedDecimalDigitWholeNonZero<__3$>,    TypeEncodedDecimalDigitFraction<__3$>    {                        private               __3$()                      { super(new BigDecimal(3)); } }
    /** A type-encoded, final, fractional number 4. */ public static final class                        __4$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__4$> implements TypeEncodedDecimalDigitWhole<__4$>,    TypeEncodedDecimalDigitWholeNonZero<__4$>,    TypeEncodedDecimalDigitFraction<__4$>    {                        private               __4$()                      { super(new BigDecimal(4)); } }
    /** A type-encoded, final, fractional number 5. */ public static final class                        __5$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__5$> implements TypeEncodedDecimalDigitWhole<__5$>,    TypeEncodedDecimalDigitWholeNonZero<__5$>,    TypeEncodedDecimalDigitFraction<__5$>    {                        private               __5$()                      { super(new BigDecimal(5)); } }
    /** A type-encoded, final, fractional number 6. */ public static final class                        __6$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__6$> implements TypeEncodedDecimalDigitWhole<__6$>,    TypeEncodedDecimalDigitWholeNonZero<__6$>,    TypeEncodedDecimalDigitFraction<__6$>    {                        private               __6$()                      { super(new BigDecimal(6)); } }
    /** A type-encoded, final, fractional number 7. */ public static final class                        __7$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__7$> implements TypeEncodedDecimalDigitWhole<__7$>,    TypeEncodedDecimalDigitWholeNonZero<__7$>,    TypeEncodedDecimalDigitFraction<__7$>    {                        private               __7$()                      { super(new BigDecimal(7)); } }
    /** A type-encoded, final, fractional number 8. */ public static final class                        __8$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__8$> implements TypeEncodedDecimalDigitWhole<__8$>,    TypeEncodedDecimalDigitWholeNonZero<__8$>,    TypeEncodedDecimalDigitFraction<__8$>    {                        private               __8$()                      { super(new BigDecimal(8)); } }
    /** A type-encoded, final, fractional number 9. */ public static final class                        __9$                                                    extends TypeEncodedDecimalDigitFractionTerminal          <__9$> implements TypeEncodedDecimalDigitWhole<__9$>,    TypeEncodedDecimalDigitWholeNonZero<__9$>,    TypeEncodedDecimalDigitFraction<__9$>    {                        private               __9$()                      { super(new BigDecimal(9)); } }

    /** Return a type-encoded decimal.                     */ public static <T0 extends TypeEncodedDecimal                 <T0>> TypeEncodedDecimalConcrete<T0>  decimal(final T0 next) { return new TypeEncodedDecimalConcrete<>(next); }
    /** Return a type-encoded negative sign.               */ public static <T0 extends TypeEncodedDecimalDigitWholeNonZero<T0>>                   Negative<T0> negative(final T0 next) { return new                   Negative<>(next); }
    /** Return a type-encoded, whole number 0.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _0<T0>       _0(final T0 next) { return new                         _0<>(next); }
    /** Return a type-encoded, whole number 1.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _1<T0>       _1(final T0 next) { return new                         _1<>(next); }
    /** Return a type-encoded, whole number 2.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _2<T0>       _2(final T0 next) { return new                         _2<>(next); }
    /** Return a type-encoded, whole number 3.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _3<T0>       _3(final T0 next) { return new                         _3<>(next); }
    /** Return a type-encoded, whole number 4.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _4<T0>       _4(final T0 next) { return new                         _4<>(next); }
    /** Return a type-encoded, whole number 5.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _5<T0>       _5(final T0 next) { return new                         _5<>(next); }
    /** Return a type-encoded, whole number 6.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _6<T0>       _6(final T0 next) { return new                         _6<>(next); }
    /** Return a type-encoded, whole number 7.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _7<T0>       _7(final T0 next) { return new                         _7<>(next); }
    /** Return a type-encoded, whole number 8.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _8<T0>       _8(final T0 next) { return new                         _8<>(next); }
    /** Return a type-encoded, whole number 9.             */ public static <T0 extends TypeEncodedDecimalDigitWhole       <T0>>                         _9<T0>       _9(final T0 next) { return new                         _9<>(next); }
    /** Return a type-encoded, fractional number 0.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __0<T0>      __0(final T0 next) { return new                        __0<>(next); }
    /** Return a type-encoded, fractional number 1.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __1<T0>      __1(final T0 next) { return new                        __1<>(next); }
    /** Return a type-encoded, fractional number 2.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __2<T0>      __2(final T0 next) { return new                        __2<>(next); }
    /** Return a type-encoded, fractional number 3.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __3<T0>      __3(final T0 next) { return new                        __3<>(next); }
    /** Return a type-encoded, fractional number 4.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __4<T0>      __4(final T0 next) { return new                        __4<>(next); }
    /** Return a type-encoded, fractional number 5.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __5<T0>      __5(final T0 next) { return new                        __5<>(next); }
    /** Return a type-encoded, fractional number 6.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __6<T0>      __6(final T0 next) { return new                        __6<>(next); }
    /** Return a type-encoded, fractional number 7.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __7<T0>      __7(final T0 next) { return new                        __7<>(next); }
    /** Return a type-encoded, fractional number 8.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __8<T0>      __8(final T0 next) { return new                        __8<>(next); }
    /** Return a type-encoded, fractional number 9.        */ public static <T0 extends TypeEncodedDecimalDigitFraction    <T0>>                        __9<T0>      __9(final T0 next) { return new                        __9<>(next); }
    /** Return a type-encoded, final, whole number 0.      */ public static                                                                              _0$          _0()              { return new                         _0$(); }
    /** Return a type-encoded, final, whole number 1.      */ public static                                                                              _1$          _1()              { return new                         _1$(); }
    /** Return a type-encoded, final, whole number 2.      */ public static                                                                              _2$          _2()              { return new                         _2$(); }
    /** Return a type-encoded, final, whole number 3.      */ public static                                                                              _3$          _3()              { return new                         _3$(); }
    /** Return a type-encoded, final, whole number 4.      */ public static                                                                              _4$          _4()              { return new                         _4$(); }
    /** Return a type-encoded, final, whole number 5.      */ public static                                                                              _5$          _5()              { return new                         _5$(); }
    /** Return a type-encoded, final, whole number 6.      */ public static                                                                              _6$          _6()              { return new                         _6$(); }
    /** Return a type-encoded, final, whole number 7.      */ public static                                                                              _7$          _7()              { return new                         _7$(); }
    /** Return a type-encoded, final, whole number 8.      */ public static                                                                              _8$          _8()              { return new                         _8$(); }
    /** Return a type-encoded, final, whole number 9.      */ public static                                                                              _9$          _9()              { return new                         _9$(); }
    /** Return a type-encoded, final, fractional number 1. */ public static                                                                             __1$         __1()              { return new                        __1$(); }
    /** Return a type-encoded, final, fractional number 2. */ public static                                                                             __2$         __2()              { return new                        __2$(); }
    /** Return a type-encoded, final, fractional number 3. */ public static                                                                             __3$         __3()              { return new                        __3$(); }
    /** Return a type-encoded, final, fractional number 4. */ public static                                                                             __4$         __4()              { return new                        __4$(); }
    /** Return a type-encoded, final, fractional number 5. */ public static                                                                             __5$         __5()              { return new                        __5$(); }
    /** Return a type-encoded, final, fractional number 6. */ public static                                                                             __6$         __6()              { return new                        __6$(); }
    /** Return a type-encoded, final, fractional number 7. */ public static                                                                             __7$         __7()              { return new                        __7$(); }
    /** Return a type-encoded, final, fractional number 8. */ public static                                                                             __8$         __8()              { return new                        __8$(); }
    /** Return a type-encoded, final, fractional number 9. */ public static                                                                             __9$         __9()              { return new                        __9$(); }
    // @formatter:on
}
