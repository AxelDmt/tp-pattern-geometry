package org.acme.geometry;

import java.util.*;

public class GeometryCollection extends AbstractGeometry {

    private List<Geometry> geometries;

    public GeometryCollection(){
        this.geometries = new ArrayList<>();
    }

    public GeometryCollection(List<Geometry> geometries){
        this.geometries = (geometries != null) ? geometries : new ArrayList<>();
    }

    public int getNumGeometries(){
        return geometries.size();
    }

    public Geometry getGeometryN(int n){
        if (n >= 0 && n < getNumGeometries()) {
            return geometries.get(n);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for getPointN");
        }
    }

    @Override
    public String getType() {
        return "GeometryCollection";
    }

    @Override
    public void translate(double x, double y) {
        for (Geometry geometry : geometries) {
            geometry.translate(x, y);
        }
    }

    @Override
    public boolean isEmpty() {
        return geometries.isEmpty();
    }

    @Override
    public <T> T accept(GeometryVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AbstractGeometry clone() {
        List<Geometry> clonedGeometries= new ArrayList<>();
        for (Geometry geometry: this.geometries) {
            clonedGeometries.add(geometry.clone());
        }
        return new GeometryCollection(clonedGeometries);
    }
}

