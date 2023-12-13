package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import org.Geometry;
import org.junit.Test;

public class GeometryTest {

    @Test
    public void testGeometryType() {
        Geometry geometry = new Geometry();
        assertEquals("Geometry", geometry.getType());
    }
    
}
