package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CoordinateTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testCoordinateXY() {
        Coordinate c = new Coordinate(3.0, 4.0);
        assertEquals(3.0, c.getX(), EPSILON);
        assertEquals(4.0, c.getY(), EPSILON);
        assertFalse(c.isEmpty());
        assertEquals("[3.0,4.0]", c.toString());
		System.out.println(c.getY());
    }

}