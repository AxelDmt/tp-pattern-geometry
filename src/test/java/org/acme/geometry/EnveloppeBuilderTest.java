package org.acme.geometry;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;

public class EnveloppeBuilderTest {

    private static final double EPSILON = 1e-15;

    @Test
    public void testGetEnvelopeWithPoint() {
        // Créer une géométrie Point
        AbstractGeometry point = new Point(new Coordinate(3.0, 4.0));

        // Obtenir l'enveloppe
        Enveloppe envelope = point.getEnvelope();

        // Vérifier les valeurs attendues de l'enveloppe
        assertEquals(3.0, envelope.getXmin(), EPSILON);
        assertEquals(3.0, envelope.getXmax(), EPSILON);
        assertEquals(4.0, envelope.getYmin(), EPSILON);
        assertEquals(4.0, envelope.getYmax(), EPSILON);
        assertTrue(!envelope.isEmpty()); 
    }

    @Test
    public void testGetEnvelopeWithLineString() {
        // Créer une géométrie LineString
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(0.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                new Point(new Coordinate(5.0, 5.0))
        );
        AbstractGeometry lineString = new LineString(points);

        // Obtenir l'enveloppe
        Enveloppe envelope = lineString.getEnvelope();

        // Vérifier les valeurs attendues de l'enveloppe
        assertEquals(0.0, envelope.getXmin(), EPSILON);
        assertEquals(5.0, envelope.getXmax(), EPSILON);
        assertEquals(0.0, envelope.getYmin(), EPSILON);
        assertEquals(5.0, envelope.getYmax(), EPSILON);
        assertTrue(!envelope.isEmpty()); 
    }

}