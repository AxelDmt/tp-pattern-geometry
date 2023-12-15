package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {
    
    @Test
    public void testPointType() {
        Point point = new Point(new Coordinate(3.0, 4.0));
        assertEquals("Point", point.getType());
    }    
}
