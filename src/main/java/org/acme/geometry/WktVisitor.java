package org.acme.geometry;

public class WktVisitor implements GeometryVisitor<Void>{
    
    private StringBuilder buffer;

    public WktVisitor(){
        this.buffer = new StringBuilder();
    }

    public String getResult(){
        return buffer.toString();
    };  

    public Void visit(Point point) {
        if (point.isEmpty()) {
            buffer.append("POINT EMPTY");
        } else {
            buffer.append("POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
        }

        return null;
    }

    public Void visit(LineString lineString) {
        if (lineString.isEmpty()) {
            buffer.append("LINESTRING EMPTY");
        } else {
            buffer.append("LINESTRING(");
            for (int i = 0; i < lineString.getNumPoints(); i++) {
                Point point = lineString.getPointN(i);
                Coordinate coordinate = point.getCoordinate();
                buffer.append(coordinate.getX()+ " " + coordinate.getY());
                if (i < lineString.getNumPoints() - 1) {
                    buffer.append(",");
                }
            }
            buffer.append(")");
        }

        return null;
    }

    @Override
    public Void visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()){
            buffer.append("GEOMETRYCOLLECTION EMPTY");
        }else{
            buffer.append("GEOMETRYCOLLECTION(");
            for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
                if (i!=0){
                    buffer.append(",");
                }
                geometryCollection.getGeometryN(i).accept(this);
            }
            buffer.append(")");
        }

        return null;
    }
}
