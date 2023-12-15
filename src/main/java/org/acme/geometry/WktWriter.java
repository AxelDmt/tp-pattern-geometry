package org.acme.geometry;

public class WktWriter {
    
    public String write(Geometry geometry){
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            if (point.isEmpty()) {
                return "POINT EMPTY";
            } else {
                Coordinate coordinate = point.getCoordinate();
                return "POINT("+coordinate.getX()+" "+coordinate.getY()+")";
            }
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            if (lineString.isEmpty()) {
            return "LINESTRING EMPTY";
            
           } else {
            StringBuilder sb = new StringBuilder("LINESTRING(");
            for (int i = 0; i < lineString.getNumPoints(); i++) {
                Point point = lineString.getPointN(i);
                Coordinate coordinate = point.getCoordinate();
                sb.append(coordinate.getX()+ " " + coordinate.getY());
                if (i < lineString.getNumPoints() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        }else{
            throw new RuntimeException("geometry type not supported");
            }
        }
    }
