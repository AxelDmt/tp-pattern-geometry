package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

// Classe LineString implémentant l'interface Geometry
public class LineString extends AbstractGeometry{

    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<>();
    }

    public LineString(List<Point> points) {
        this.points = (points != null) ? points : new ArrayList<>();
    }

    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        if (n >= 0 && n < points.size()) {
            return points.get(n);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for getPointN");
        }
    }

    @Override
    public void translate(double x, double y) {
        for (Point point : points) {
            point.translate(x, y);
        }
    }

    @Override
    public boolean isEmpty() {
        return points.isEmpty();
    }

    @Override
    public String getType() {
        return "LineString";
    }

    @Override
    public LineString clone() {
        List<Point> clonedPoints = new ArrayList<>();
        for (Point point : this.points) {
            clonedPoints.add(point.clone());
        }
        return new LineString(clonedPoints);
    }

    @Override
    public Enveloppe getEnvelope() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        for (Point point : points) {
            builder.insert(point.getCoordinate());
        }
        return builder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}
