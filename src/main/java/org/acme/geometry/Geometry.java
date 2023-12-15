package org.acme.geometry;

// Interface Geometry
public interface Geometry {

    String getType();

    void translate(double x, double y);

    boolean isEmpty();

    Geometry clone();

    Enveloppe getEnvelope();

    <T> T accept(GeometryVisitor<T> visitor);

    String asText();

    void addListener(GeometryListener listener);
}
