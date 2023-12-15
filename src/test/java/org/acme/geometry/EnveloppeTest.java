package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeTest {

    private static final double EPSILON = 1e-15;

    @Test
    public void testEnvelopeBuilder() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        builder.insert(new Coordinate(0.0, 1.0));
        builder.insert(new Coordinate(2.0, 0.0));
        builder.insert(new Coordinate(1.0, 3.0));
        Enveloppe result = builder.build();

        Assert.assertEquals(0.0, result.getXmin(), EPSILON);
        Assert.assertEquals(0.0, result.getYmin(), EPSILON);
        Assert.assertEquals(2.0, result.getXmax(), EPSILON);
        Assert.assertEquals(3.0, result.getYmax(), EPSILON);
    }

    @Test
    public void testEmptyEnvelope() {
        Enveloppe emptyEnvelope = new Enveloppe();
        Assert.assertTrue(emptyEnvelope.isEmpty());
    }

    @Test
    public void testToString() {
        Enveloppe enveloppe = new Enveloppe(new Coordinate(1.0, 2.0), new Coordinate(3.0, 4.0));
        Assert.assertEquals("1.0,2.0,3.0,4.0", enveloppe.toString());
    }
}
