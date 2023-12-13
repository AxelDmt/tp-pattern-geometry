package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

public class LineString extends Geometry{
    
    private List<Point> points;

    // Constructeur par défaut initialisant une géométrie vide
    public LineString() {
        this.points = new ArrayList<>();
    }

    // Constructeur avec une liste de points spécifiée
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
}
