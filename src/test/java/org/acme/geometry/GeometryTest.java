package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;


public class GeometryTest {

    private static final double EPSILON = 1e-15;

    @Test
    public void testPointGetEnvelope() {
        Geometry point = new Point(new Coordinate(3.0, 4.0));
        Enveloppe enveloppe = point.getEnvelope();

        Assert.assertEquals(3.0, enveloppe.getXmin(), EPSILON);
        Assert.assertEquals(4.0, enveloppe.getYmin(), EPSILON);
        Assert.assertEquals(3.0, enveloppe.getXmax(), EPSILON);
        Assert.assertEquals(4.0, enveloppe.getYmax(), EPSILON);
    }

    @Test
    public void testLineStringGetEnvelope() {
        List<Point> points = Arrays.asList(new Point(new Coordinate(1.0, 2.0)), new Point(new Coordinate(3.0, 4.0)));
        Geometry lineString = new LineString(points);
        Enveloppe envelope = lineString.getEnvelope();

        Assert.assertEquals(1.0, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.0, envelope.getYmin(), EPSILON);
        Assert.assertEquals(3.0, envelope.getXmax(), EPSILON);
        Assert.assertEquals(4.0, envelope.getYmax(), EPSILON);
    }
}
