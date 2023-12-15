package org.acme.geometry;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Arrays;

public class WktVisitorTest {

    private static final double EPSILON = 1e-15;

    @Test
    public void testVisitPoint() {
        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);

        assertEquals("POINT(3.0 4.0)", visitor.getResult());
    }

    @Test
    public void testVisitEmptyPoint() {
        Geometry emptyPoint = new Point();
        WktVisitor visitor = new WktVisitor();
        emptyPoint.accept(visitor);

        assertEquals("POINT EMPTY", visitor.getResult());
    }

    @Test
    public void testVisitLineString() {
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(0.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                new Point(new Coordinate(5.0, 5.0))
        );
        Geometry lineString = new LineString(points);
        WktVisitor visitor = new WktVisitor();
        lineString.accept(visitor);

        assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", visitor.getResult());
    }

    @Test
    public void testVisitEmptyLineString() {
        Geometry emptyLineString = new LineString();
        WktVisitor visitor = new WktVisitor();
        emptyLineString.accept(visitor);

        assertEquals("LINESTRING EMPTY", visitor.getResult());
    }
}
