package org.acme.geometry;

// Interface Geometry
public interface Geometry {

    String getType();

    void translate(double x, double y);

    boolean isEmpty();
}
