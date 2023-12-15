package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class WktWriterTest {

    @Test
    public void testWritePoint() {
        Geometry point = new Point(new Coordinate(3.0, 4.0));
        WktWriter writer = new WktWriter();
        String result = writer.write(point);

        Assert.assertEquals("POINT(3.0 4.0)", result);
    }

    @Test
    public void testWriteEmptyPoint() {
        Geometry emptyPoint = new Point();
        WktWriter writer = new WktWriter();
        String result = writer.write(emptyPoint);

        Assert.assertEquals("POINT EMPTY", result);
    }

    @Test
    public void testWriteLineString() {
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(0.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                new Point(new Coordinate(5.0, 5.0))
        );
        Geometry lineString = new LineString(points);
        WktWriter writer = new WktWriter();
        String result = writer.write(lineString);

        Assert.assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", result);
    }

    @Test
    public void testWriteEmptyLineString() {
        Geometry emptyLineString = new LineString();
        WktWriter writer = new WktWriter();
        String result = writer.write(emptyLineString);

        Assert.assertEquals("LINESTRING EMPTY", result);
    }
}
