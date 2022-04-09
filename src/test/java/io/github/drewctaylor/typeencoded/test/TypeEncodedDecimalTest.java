package io.github.drewctaylor.typeencoded.test;

import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.Negative;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.TypeEncodedDecimalConcrete;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._0$;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._1$;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__1$;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__2$;
import io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__3$;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.logging.Logger;

import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._2;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._3;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._4;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._5;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._6;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._7;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._8;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder._9;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__0;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__1;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__2;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__3;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__4;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__5;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__6;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__7;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__8;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.__9;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.decimal;
import static io.github.drewctaylor.typeencoded.TypeEncodedDecimalBuilder.negative;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class TypeEncodedDecimalTest
{
    @Test
    void test()
    {
        assertEquals(BigDecimal.valueOf(0L), decimal(_0()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(1L), decimal(_1()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(2L), decimal(_2()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(3L), decimal(_3()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(4L), decimal(_4()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(5L), decimal(_5()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(6L), decimal(_6()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(7L), decimal(_7()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(8L), decimal(_8()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(9L), decimal(_9()).toBigDecimal());

        assertEquals(BigDecimal.valueOf(12L), decimal(_1(_2())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(23L), decimal(_2(_3())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(34L), decimal(_3(_4())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(45L), decimal(_4(_5())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(56L), decimal(_5(_6())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(67L), decimal(_6(_7())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(78L), decimal(_7(_8())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(89L), decimal(_8(_9())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(90L), decimal(_9(_0())).toBigDecimal());

        assertEquals(BigDecimal.valueOf(123L), decimal(_1(_2(_3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(234L), decimal(_2(_3(_4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(345L), decimal(_3(_4(_5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(456L), decimal(_4(_5(_6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(567L), decimal(_5(_6(_7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(678L), decimal(_6(_7(_8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(789L), decimal(_7(_8(_9()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(890L), decimal(_8(_9(_0()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(901L), decimal(_9(_0(_1()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-1L), decimal(negative(_1())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-2L), decimal(negative(_2())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-3L), decimal(negative(_3())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-4L), decimal(negative(_4())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-5L), decimal(negative(_5())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-6L), decimal(negative(_6())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-7L), decimal(negative(_7())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-8L), decimal(negative(_8())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-9L), decimal(negative(_9())).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-12L), decimal(negative(_1(_2()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-23L), decimal(negative(_2(_3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-34L), decimal(negative(_3(_4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-45L), decimal(negative(_4(_5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-56L), decimal(negative(_5(_6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-67L), decimal(negative(_6(_7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-78L), decimal(negative(_7(_8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-89L), decimal(negative(_8(_9()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-90L), decimal(negative(_9(_0()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-123L), decimal(negative(_1(_2(_3())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-234L), decimal(negative(_2(_3(_4())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-345L), decimal(negative(_3(_4(_5())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-456L), decimal(negative(_4(_5(_6())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-567L), decimal(negative(_5(_6(_7())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-678L), decimal(negative(_6(_7(_8())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-789L), decimal(negative(_7(_8(_9())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-890L), decimal(negative(_8(_9(_0())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-901L), decimal(negative(_9(_0(_1())))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(0.1d), decimal(__1()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.2d), decimal(__2()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.3d), decimal(__3()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.4d), decimal(__4()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.5d), decimal(__5()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.6d), decimal(__6()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.7d), decimal(__7()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.8d), decimal(__8()).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.9d), decimal(__9()).toBigDecimal());

        assertEquals(BigDecimal.valueOf(0.01d), decimal(__0(__1())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.12d), decimal(__1(__2())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.23d), decimal(__2(__3())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.34d), decimal(__3(__4())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.45d), decimal(__4(__5())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.56d), decimal(__5(__6())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.67d), decimal(__6(__7())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.78d), decimal(__7(__8())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.89d), decimal(__8(__9())).toBigDecimal());

        assertEquals(BigDecimal.valueOf(0.012d), decimal(__0(__1(__2()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.123d), decimal(__1(__2(__3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.234d), decimal(__2(__3(__4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.345d), decimal(__3(__4(__5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.456d), decimal(__4(__5(__6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.567d), decimal(__5(__6(__7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.678d), decimal(__6(__7(__8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.789d), decimal(__7(__8(__9()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(0.901d), decimal(__9(__0(__1()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-0.1), decimal(negative(__1())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.2), decimal(negative(__2())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.3), decimal(negative(__3())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.4), decimal(negative(__4())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.5), decimal(negative(__5())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.6), decimal(negative(__6())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.7), decimal(negative(__7())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.8), decimal(negative(__8())).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.9), decimal(negative(__9())).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-0.01), decimal(negative(__0(__1()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.12), decimal(negative(__1(__2()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.23), decimal(negative(__2(__3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.34), decimal(negative(__3(__4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.45), decimal(negative(__4(__5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.56), decimal(negative(__5(__6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.67), decimal(negative(__6(__7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.78), decimal(negative(__7(__8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.89), decimal(negative(__8(__9()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-0.012), decimal(negative(__0(__1(__2())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.123), decimal(negative(__1(__2(__3())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.234), decimal(negative(__2(__3(__4())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.345), decimal(negative(__3(__4(__5())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.456), decimal(negative(__4(__5(__6())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.567), decimal(negative(__5(__6(__7())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.678), decimal(negative(__6(__7(__8())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.789), decimal(negative(__7(__8(__9())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-0.901), decimal(negative(__9(__0(__1())))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(1.23d), decimal(_1(__2(__3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(2.34d), decimal(_2(__3(__4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(3.45d), decimal(_3(__4(__5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(4.56d), decimal(_4(__5(__6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(5.67d), decimal(_5(__6(__7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(6.78d), decimal(_6(__7(__8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(7.89d), decimal(_7(__8(__9()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(9.01d), decimal(_9(__0(__1()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(12.3d), decimal(_1(_2(__3()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(23.4d), decimal(_2(_3(__4()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(34.5d), decimal(_3(_4(__5()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(45.6d), decimal(_4(_5(__6()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(56.7d), decimal(_5(_6(__7()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(67.8d), decimal(_6(_7(__8()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(78.9d), decimal(_7(_8(__9()))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(90.1d), decimal(_9(_0(__1()))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-1.23), decimal(negative(_1(__2(__3())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-2.34), decimal(negative(_2(__3(__4())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-3.45), decimal(negative(_3(__4(__5())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-4.56), decimal(negative(_4(__5(__6())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-5.67), decimal(negative(_5(__6(__7())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-6.78), decimal(negative(_6(__7(__8())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-7.89), decimal(negative(_7(__8(__9())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-9.01), decimal(negative(_9(__0(__1())))).toBigDecimal());

        assertEquals(BigDecimal.valueOf(-12.3), decimal(negative(_1(_2(__3())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-23.4), decimal(negative(_2(_3(__4())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-34.5), decimal(negative(_3(_4(__5())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-45.6), decimal(negative(_4(_5(__6())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-56.7), decimal(negative(_5(_6(__7())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-67.8), decimal(negative(_6(_7(__8())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-78.9), decimal(negative(_7(_8(__9())))).toBigDecimal());
        assertEquals(BigDecimal.valueOf(-90.1), decimal(negative(_9(_0(__1())))).toBigDecimal());

    }

    void testCompile()
    {
        final TypeEncodedDecimalConcrete<_1$> decimal1 = decimal(_1());
        final TypeEncodedDecimalConcrete<_1<_0$>> decimal10 = decimal(_1(_0()));
        final TypeEncodedDecimalConcrete<_1<_0<_0$>>> decimal100 = decimal(_1(_0(_0())));
        final TypeEncodedDecimalConcrete<Negative<_1$>> decimalN1 = decimal(negative(_1()));
        final TypeEncodedDecimalConcrete<Negative<_1<_0$>>> decimalN10 = decimal(negative(_1(_0())));
        final TypeEncodedDecimalConcrete<Negative<_1<_0<_0$>>>> decimalN100 = decimal(negative(_1(_0(_0()))));

        final _1$ d1 = _1();
        final _1<_0$> d10 = _1(_0());
        final _1<_0<_0$>> d100 = _1(_0(_0()));
        final Negative<_1$> dn1 = negative(_1());
        final Negative<_1<_0$>> dn10 = negative(_1(_0()));
        final Negative<_1<_0<_0$>>> dn100 = negative(_1(_0(_0())));

        require1(decimal1);
        require10(decimal10);
        require100(decimal100);
        requireNegative1(decimalN1);
        requireNegative10(decimalN10);
        requireNegative100(decimalN100);

        // commented statements should not compile

        // require1(decimal10);
        // require1(decimal100);
        // require1(decimalN1);
        // require1(decimalN10);
        // require1(decimalN100);

        // require1(d1);
        // require1(d10);
        // require1(d100);
        // require1(dn1);
        // require1(dn10);
        // require1(dn100);

        // require10(decimal1);
        // require10(decimal100);
        // require10(decimalN1);
        // require10(decimalN10);
        // require10(decimalN100);

        // require10(d1);
        // require10(d10);
        // require10(d100);
        // require10(dn1);
        // require10(dn10);
        // require10(dn100);

        // require100(decimal1);
        // require100(decimal10);
        // require100(decimalN1);
        // require100(decimalN10);
        // require100(decimalN100);

        // require100(d1);
        // require100(d10);
        // require100(d100);
        // require100(dn1);
        // require100(dn10);
        // require100(dn100);

        // requireNegative1(decimal1);
        // requireNegative1(decimal10);
        // requireNegative1(decimal100);
        // requireNegative1(decimalN10);
        // requireNegative1(decimalN100);

        // requireNegative1(d1);
        // requireNegative1(d10);
        // requireNegative1(d100);
        // requireNegative1(dn1);
        // requireNegative1(dn10);
        // requireNegative1(dn100);

        // requireNegative10(decimal1);
        // requireNegative10(decimal10);
        // requireNegative10(decimal100);
        // requireNegative10(decimalN1);
        // requireNegative10(decimalN100);

        // requireNegative10(d1);
        // requireNegative10(d10);
        // requireNegative10(d100);
        // requireNegative10(dn1);
        // requireNegative10(dn10);
        // requireNegative10(dn100);

        // requireNegative100(decimal1);
        // requireNegative100(decimal10);
        // requireNegative100(decimal100);
        // requireNegative100(decimalN1);
        // requireNegative100(decimalN10);

        // requireNegative100(d1);
        // requireNegative100(d10);
        // requireNegative100(d100);
        // requireNegative100(dn1);
        // requireNegative100(dn10);
        // requireNegative100(dn100);

        final TypeEncodedDecimalConcrete<_1<__2<__3$>>> decimal1o23 = decimal(_1(__2(__3())));
        final TypeEncodedDecimalConcrete<_1<_2<__3$>>> decimal12o3 = decimal(_1(_2(__3())));

        final TypeEncodedDecimalConcrete<Negative<_1<__2<__3$>>>> decimalN1o23 = decimal(negative(_1(__2(__3()))));
        final TypeEncodedDecimalConcrete<Negative<_1<_2<__3$>>>> decimalN12o3 = decimal(negative(_1(_2(__3()))));

        final _1<__2<__3$>> d1o23 = _1(__2(__3()));
        final _1<_2<__3$>> d12o3 = _1(_2(__3()));

        final Negative<_1<__2<__3$>>> dn1o23 = negative(_1(__2(__3())));
        final Negative<_1<_2<__3$>>> dn12o3 = negative(_1(_2(__3())));

        require1_23(decimal1o23);
        require12_3(decimal12o3);
        requireNegative1_23(decimalN1o23);
        requireNegative12_3(decimalN12o3);

        // require12_3(decimal1o23);
        // requireNegative1_23(decimal1o23);
        // requireNegative12_3(decimal1o23);

        // require1_23(decimal12o3);
        // requireNegative1_23(decimal12o3);
        // requireNegative12_3(decimal12o3);

        // require1_23(decimalN1o23);
        // require12_3(decimalN1o23);
        // requireNegative12_3(decimalN1o23);

        // require1_23(decimalN12o3);
        // require12_3(decimalN12o3);
        // requireNegative1_23(decimalN12o3);

        // require1_23(d1o23);
        // require12_3(d1o23);
        // requireNegative1_23(d1o23);
        // requireNegative12_3(d1o23);

        // require1_23(d12o3);
        // require12_3(d12o3);
        // requireNegative1_23(d12o3);
        // requireNegative12_3(d12o3);

        // require1_23(dn1o23);
        // require12_3(dn1o23);
        // requireNegative1_23(dn1o23);
        // requireNegative12_3(dn1o23);

        // require1_23(dn12o3);
        // require12_3(dn12o3);
        // requireNegative1_23(dn12o3);
        // requireNegative12_3(dn12o3);
    }

    private void require1(
            final TypeEncodedDecimalConcrete<_1$> d1)
    {
    }

    private void require10(
            final TypeEncodedDecimalConcrete<_1<_0$>> d10)
    {
    }

    private void require100(
            final TypeEncodedDecimalConcrete<_1<_0<_0$>>> d100)
    {
    }

    private void requireNegative1(
            final TypeEncodedDecimalConcrete<Negative<_1$>> dn1)
    {
    }

    private void requireNegative10(
            final TypeEncodedDecimalConcrete<Negative<_1<_0$>>> dn10)
    {
    }

    private void requireNegative100(
            final TypeEncodedDecimalConcrete<Negative<_1<_0<_0$>>>> dn100)
    {
    }

    private void require1_23(
            final TypeEncodedDecimalConcrete<_1<__2<__3$>>> dn1o23)
    {
    }

    private void require12_3(
            final TypeEncodedDecimalConcrete<_1<_2<__3$>>> dn12o3)
    {
    }

    private void requireNegative1_23(
            final TypeEncodedDecimalConcrete<Negative<_1<__2<__3$>>>> dn1o23)
    {
    }

    private void requireNegative12_3(
            final TypeEncodedDecimalConcrete<Negative<_1<_2<__3$>>>> dn12o3)
    {
    }

    @Test
    void testExample()
    {
        // construct a type for the decimal 1.1
        // noinspection RedundantExplicitVariableType
        final TypeEncodedDecimalConcrete<_1<__1$>> oneOne = decimal(_1(__1()));

        // construct a type for the decimal -2.2
        // noinspection RedundantExplicitVariableType
        final TypeEncodedDecimalConcrete<Negative<_2<__2$>>> negativeTwoTwo = decimal(negative(_2(__2())));

        // define a function that accepts decimal 1.1
        final Function<TypeEncodedDecimalConcrete<_1<__1$>>, BigDecimal> functionOneOne = parameter ->
        {
            return parameter.toBigDecimal();
        };

        // define a function that accepts decimal -2.2
        final Function<TypeEncodedDecimalConcrete<Negative<_2<__2$>>>, BigDecimal> functionNegativeTwoTwo = parameter ->
        {
            return parameter.toBigDecimal();
        };

        // Logger.getAnonymousLogger().info(format("%s", functionOneOne.apply(negativeTwoTwo))); // <-- compiler error
        Logger.getAnonymousLogger().info(format("%s", functionOneOne.apply(oneOne)));
        // logs "1.1"

        // Logger.getAnonymousLogger().info(format("%s", functionNegativeTwoTwo.apply(oneOne))); // <-- compiler error
        Logger.getAnonymousLogger().info(format("%s", functionNegativeTwoTwo.apply(negativeTwoTwo)));
        // logs "-2.2"
    }
}
