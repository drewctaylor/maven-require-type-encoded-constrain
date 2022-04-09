package io.github.drewctaylor.typeencoded.test;

import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.Negative;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedIntegerConcrete;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1$;
import org.junit.jupiter.api.Test;

import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._2;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._3;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._4;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._5;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._6;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._7;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._8;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._9;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.negative;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class TypeEncodedIntegerTest
{
    @Test
    void test()
    {
        assertEquals(0, integer(_0()).toInt());
        assertEquals(1, integer(_1()).toInt());
        assertEquals(2, integer(_2()).toInt());
        assertEquals(3, integer(_3()).toInt());
        assertEquals(4, integer(_4()).toInt());
        assertEquals(5, integer(_5()).toInt());
        assertEquals(6, integer(_6()).toInt());
        assertEquals(7, integer(_7()).toInt());
        assertEquals(8, integer(_8()).toInt());
        assertEquals(9, integer(_9()).toInt());

        assertEquals(12, integer(_1(_2())).toInt());
        assertEquals(23, integer(_2(_3())).toInt());
        assertEquals(34, integer(_3(_4())).toInt());
        assertEquals(45, integer(_4(_5())).toInt());
        assertEquals(56, integer(_5(_6())).toInt());
        assertEquals(67, integer(_6(_7())).toInt());
        assertEquals(78, integer(_7(_8())).toInt());
        assertEquals(89, integer(_8(_9())).toInt());
        assertEquals(90, integer(_9(_0())).toInt());

        assertEquals(123, integer(_1(_2(_3()))).toInt());
        assertEquals(234, integer(_2(_3(_4()))).toInt());
        assertEquals(345, integer(_3(_4(_5()))).toInt());
        assertEquals(456, integer(_4(_5(_6()))).toInt());
        assertEquals(567, integer(_5(_6(_7()))).toInt());
        assertEquals(678, integer(_6(_7(_8()))).toInt());
        assertEquals(789, integer(_7(_8(_9()))).toInt());
        assertEquals(890, integer(_8(_9(_0()))).toInt());
        assertEquals(901, integer(_9(_0(_1()))).toInt());

        assertEquals(-1, integer(negative(_1())).toInt());
        assertEquals(-2, integer(negative(_2())).toInt());
        assertEquals(-3, integer(negative(_3())).toInt());
        assertEquals(-4, integer(negative(_4())).toInt());
        assertEquals(-5, integer(negative(_5())).toInt());
        assertEquals(-6, integer(negative(_6())).toInt());
        assertEquals(-7, integer(negative(_7())).toInt());
        assertEquals(-8, integer(negative(_8())).toInt());
        assertEquals(-9, integer(negative(_9())).toInt());

        assertEquals(-12, integer(negative(_1(_2()))).toInt());
        assertEquals(-23, integer(negative(_2(_3()))).toInt());
        assertEquals(-34, integer(negative(_3(_4()))).toInt());
        assertEquals(-45, integer(negative(_4(_5()))).toInt());
        assertEquals(-56, integer(negative(_5(_6()))).toInt());
        assertEquals(-67, integer(negative(_6(_7()))).toInt());
        assertEquals(-78, integer(negative(_7(_8()))).toInt());
        assertEquals(-89, integer(negative(_8(_9()))).toInt());
        assertEquals(-90, integer(negative(_9(_0()))).toInt());

        assertEquals(-123, integer(negative(_1(_2(_3())))).toInt());
        assertEquals(-234, integer(negative(_2(_3(_4())))).toInt());
        assertEquals(-345, integer(negative(_3(_4(_5())))).toInt());
        assertEquals(-456, integer(negative(_4(_5(_6())))).toInt());
        assertEquals(-567, integer(negative(_5(_6(_7())))).toInt());
        assertEquals(-678, integer(negative(_6(_7(_8())))).toInt());
        assertEquals(-789, integer(negative(_7(_8(_9())))).toInt());
        assertEquals(-890, integer(negative(_8(_9(_0())))).toInt());
        assertEquals(-901, integer(negative(_9(_0(_1())))).toInt());
    }

    void testCompile()
    {
        final TypeEncodedIntegerConcrete<_1$> integer1 = integer(_1());
        final TypeEncodedIntegerConcrete<_1<_0$>> integer10 = integer(_1(_0()));
        final TypeEncodedIntegerConcrete<_1<_0<_0$>>> integer100 = integer(_1(_0(_0())));
        final TypeEncodedIntegerConcrete<Negative<_1$>> integerN1 = integer(negative(_1()));
        final TypeEncodedIntegerConcrete<Negative<_1<_0$>>> integerN10 = integer(negative(_1(_0())));
        final TypeEncodedIntegerConcrete<Negative<_1<_0<_0$>>>> integerN100 = integer(negative(_1(_0(_0()))));

        final _1$ i1 = _1();
        final _1<_0$> i10 = _1(_0());
        final _1<_0<_0$>> i100 = _1(_0(_0()));
        final Negative<_1$> in1 = negative(_1());
        final Negative<_1<_0$>> in10 = negative(_1(_0()));
        final Negative<_1<_0<_0$>>> in100 = negative(_1(_0(_0())));

        require1(integer1);
        require10(integer10);
        require100(integer100);
        requireNegative1(integerN1);
        requireNegative10(integerN10);
        requireNegative100(integerN100);

        // commented statements should not compile

        // require1(integer10);
        // require1(integer100);
        // require1(integerN1);
        // require1(integerN10);
        // require1(integerN100);

        // require1(i1);
        // require1(i10);
        // require1(i100);
        // require1(in1);
        // require1(in10);
        // require1(in100);

        // require10(integer1);
        // require10(integer100);
        // require10(integerN1);
        // require10(integerN10);
        // require10(integerN100);

        // require10(i1);
        // require10(i10);
        // require10(i100);
        // require10(in1);
        // require10(in10);
        // require10(in100);

        // require100(integer1);
        // require100(integer10);
        // require100(integerN1);
        // require100(integerN10);
        // require100(integerN100);

        // require100(i1);
        // require100(i10);
        // require100(i100);
        // require100(in1);
        // require100(in10);
        // require100(in100);

        // requireNegative1(integer1);
        // requireNegative1(integer10);
        // requireNegative1(integer100);
        // requireNegative1(integerN10);
        // requireNegative1(integerN100);

        // requireNegative1(i1);
        // requireNegative1(i10);
        // requireNegative1(i100);
        // requireNegative1(in1);
        // requireNegative1(in10);
        // requireNegative1(in100);

        // requireNegative10(integer1);
        // requireNegative10(integer10);
        // requireNegative10(integer100);
        // requireNegative10(integerN1);
        // requireNegative10(integerN100);

        // requireNegative10(i1);
        // requireNegative10(i10);
        // requireNegative10(i100);
        // requireNegative10(in1);
        // requireNegative10(in10);
        // requireNegative10(in100);

        // requireNegative100(integer1);
        // requireNegative100(integer10);
        // requireNegative100(integer100);
        // requireNegative100(integerN1);
        // requireNegative100(integerN10);

        // requireNegative100(i1);
        // requireNegative100(i10);
        // requireNegative100(i100);
        // requireNegative100(in1);
        // requireNegative100(in10);
        // requireNegative100(in100);
    }

    private void require1(
            final TypeEncodedIntegerConcrete<_1$> i1)
    {
    }

    private void require10(
            final TypeEncodedIntegerConcrete<_1<_0$>> i10)
    {
    }

    private void require100(
            final TypeEncodedIntegerConcrete<_1<_0<_0$>>> i100)
    {
    }

    private void requireNegative1(
            final TypeEncodedIntegerConcrete<Negative<_1$>> in1)
    {
    }

    private void requireNegative10(
            final TypeEncodedIntegerConcrete<Negative<_1<_0$>>> in10)
    {
    }

    private void requireNegative100(
            final TypeEncodedIntegerConcrete<Negative<_1<_0<_0$>>>> in100)
    {
    }
}
