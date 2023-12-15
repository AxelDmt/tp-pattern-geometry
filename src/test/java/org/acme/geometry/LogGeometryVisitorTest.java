package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.List;
import java.util.Arrays;

public class LogGeometryVisitorTest {

    @Test
    public void testVisitEmptyPoint() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Point emptyPoint = new Point();
        emptyPoint.accept(visitor);

        String result = os.toString();
        Assert.assertEquals("Je suis un point vide.\n", result);
    }

    @Test
    public void testVisitPoint() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Point point = new Point(new Coordinate(2.0, 3.0));
        point.accept(visitor);

        String result = os.toString();
        Assert.assertEquals("Je suis un point avec x = 2.0 et y = 3.0.\n", result);
    }

    @Test
    public void testVisitEmptyLineString() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        LineString emptyLineString = new LineString();
        emptyLineString.accept(visitor);

        String result = os.toString();
        Assert.assertEquals("Je suis une polyligne vide.\n", result);
    }

    @Test
    public void testVisitLineString() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        List<Point> points = Arrays.asList(
                new Point(new Coordinate(1.0, 2.0)),
                new Point(new Coordinate(3.0, 4.0))
        );
        LineString lineString = new LineString(points);
        lineString.accept(visitor);

        String result = os.toString();
        Assert.assertEquals("Je suis une polyligne définie par 2 point(s).\n", result);
    }
}
