package io.github.drewctaylor.typeencoded.test;

import io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.S;
import io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.TypeEncodedPeanoConcrete;
import io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.Z;
import org.junit.jupiter.api.Test;

import static io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.peano;
import static io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.s;
import static io.github.drewctaylor.typeencoded.TypeEncodedPeanoBuilder.z;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class TypeEncodedPeanoTest
{
    @Test
    void testZ()
    {
        assertEquals(0, peano(z()).toInt());
    }

    @Test
    void testS()
    {
        assertEquals(1, peano(s(z())).toInt());
        assertEquals(2, peano(s(s(z()))).toInt());
    }

    void testCompile()
    {
        final TypeEncodedPeanoConcrete<Z> peanoZ = peano(z());
        final TypeEncodedPeanoConcrete<S<Z>> peanoSZ = peano(s(z()));
        final TypeEncodedPeanoConcrete<S<S<Z>>> peanoSSZ = peano(s(s(z())));

        final Z z = z();
        final S<Z> sz = s(z());
        final S<S<Z>> ssz = s(s(z()));

        requireZ(peanoZ);
        requireSZ(peanoSZ);
        requireSSZ(peanoSSZ);

        // commented statements should not compile

        // requireSZ(peanoZ);
        // requireSSZ(peanoZ);

        // requireZ(peanoSZ);
        // requireSSZ(peanoSZ);

        // requireZ(peanoSSZ);
        // requireSZ(peanoSSZ);

        // requireZ(z);
        // requireZ(sz);
        // requireZ(ssz);

        // requireSZ(z);
        // requireSZ(sz);
        // requireSZ(ssz);

        // requireSSZ(z);
        // requireSSZ(sz);
        // requireSSZ(ssz);
    }

    private void requireZ(
            final TypeEncodedPeanoConcrete<Z> z)
    {
    }

    private void requireSZ(
            final TypeEncodedPeanoConcrete<S<Z>> sz)
    {
    }

    private void requireSSZ(
            final TypeEncodedPeanoConcrete<S<S<Z>>> ssz)
    {
    }
}
