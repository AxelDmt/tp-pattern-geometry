package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry,GeometryListener{
    
    private Geometry original;
    private Enveloppe cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry originalGeometry) {
        this.original = originalGeometry;
        this.cachedEnvelope = null;
        original.addListener(this);
    }

    @Override
    public String getType() {
        return original.getType();
    }

    @Override
    public void translate(double x, double y) {
        original.translate(x, y);
    }

    @Override
    public boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public GeometryWithCachedEnvelope clone() {
        return new GeometryWithCachedEnvelope(original.clone());
    }

    @Override
    public Enveloppe getEnvelope() {
        if (cachedEnvelope == null) {
            cachedEnvelope = original.getEnvelope();
        }
        return cachedEnvelope;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        original.accept(visitor);
    }

    @Override
    public String asText() {
        return original.asText();
    }

    @Override
    public void onChange(Geometry geometry) {
        cachedEnvelope = null;
    }

    @Override
    public void addListener(GeometryListener listener){
        this.original.addListener(listener);
    };
}
