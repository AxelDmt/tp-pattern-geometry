package org.acme.geometry;
import java.util.List;

public class LineString {
    
    private List<Point> points;

    public LineString(){

    }

    public LineString(List<Point> points){
        this.points = points;
    }

    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }
}