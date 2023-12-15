package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.junit.Test;

public class LineStringTest {

    @Test
    public void testLineStringNumPoints() {
        List<Point> points = Arrays.asList(new Point(), new Point(), new Point());
        LineString lineString = new LineString(points);
        assertEquals(3, lineString.getNumPoints());
    }

    @Test
    public void testLineStringGetPointN() {
        List<Point> points = Arrays.asList(new Point(), new Point(), new Point());
        LineString lineString = new LineString(points);
        assertEquals(points.get(1), lineString.getPointN(1));
    }     
}
