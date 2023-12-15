package org.acme.geometry;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class LengthVisitorTest {

    private static final double EPSILON = 1e-15;

    @Test
    public void testLengthVisitorWithPoint() {
        Point point = new Point(new Coordinate(3.0, 4.0));
        LenghtVisitor lengthVisitor = new LenghtVisitor();
        Double result = point.accept(lengthVisitor);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testLengthVisitorWithLineString() {
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(2.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                 new Point(new Coordinate(2.0, 1.0)));
        LineString lineString = new LineString(points);
        LenghtVisitor lengthVisitor = new LenghtVisitor();
        Double result = lineString.accept(lengthVisitor);
        assertEquals( 2.4142135623730951 , result, EPSILON);
    }

    @Test
    public void testLengthVisitorWithGeometryCollection() {
        Point point = new Point(new Coordinate(3.0, 4.0));
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(1.0, 1.0)),
                 new Point(new Coordinate(2.0, 1.0)));
        List<Point> points2 = Arrays.asList(
                new Point(new Coordinate(2.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)));
        LineString lineString = new LineString(points);
         LineString lineString2 = new LineString(points2);
        GeometryCollection geometryCollection = new GeometryCollection(Arrays.asList(point, lineString, lineString2));

        LenghtVisitor lengthVisitor = new LenghtVisitor();
        Double result = geometryCollection.accept(lengthVisitor);
        assertEquals(2.4142135623730951 , result, EPSILON);
    }

}
