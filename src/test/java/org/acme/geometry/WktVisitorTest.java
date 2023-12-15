package org.acme.geometry;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WktVisitorTest {

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

    @Test
    public void testWktVisitorWithGeometryCollection() {
        Geometry point = new Point(new Coordinate(3.0, 4.0));      
        List<Point> points = Arrays.asList(
                new Point(new Coordinate(0.0, 0.0)),
                new Point(new Coordinate(1.0, 1.0)),
                new Point(new Coordinate(5.0, 5.0))
        );
        Geometry lineString = new LineString(points);  
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(point);
        geometries.add(lineString);
        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        // Utiliser le visiteur WKT pour obtenir la représentation WKT
        WktVisitor wktVisitor = new WktVisitor();
        geometryCollection.accept(wktVisitor);
        String wktResult = wktVisitor.getResult();

        // Vérifier le résultat attendu
        String expectedWkt = "GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0))";
        assertEquals(expectedWkt, wktResult);
    }    

    @Test
    public void testVisitEmptyGeometryCollection() {
        GeometryCollection geometryCollection = new GeometryCollection();
        WktVisitor visitor = new WktVisitor();
        geometryCollection.accept(visitor);

        assertEquals("GEOMETRYCOLLECTION EMPTY", visitor.getResult());
    }
}
