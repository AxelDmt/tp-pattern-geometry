package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AsTextTest {

    @Test
    public void testasTextPoint() {
        Point point = new Point(new Coordinate(3.0, 4.0));
        assertEquals("POINT(3.0 4.0)",point.asText());
    }

    @Test
    public void testasTextEmptyPoint() {
        Geometry emptyPoint = new Point();
        assertEquals("POINT EMPTY", emptyPoint.asText());
    }

    @Test
    public void testasTextLineString() {
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(0.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                new Point(new Coordinate(5.0, 5.0))
        );
        Geometry lineString = new LineString(points);
        assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", lineString.asText());
    }

    @Test
    public void testasTextEmptyLineString() {
        Geometry emptyLineString = new LineString();
        assertEquals("LINESTRING EMPTY", emptyLineString.asText());
    }
}
