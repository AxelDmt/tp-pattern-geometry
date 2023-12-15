package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{
    
    public String asText(){
        WktVisitor visitor = new WktVisitor();
        accept(visitor);
        return visitor.getResult();
    }

    @Override 
    public abstract AbstractGeometry clone();  

    @Override
    public Enveloppe getEnvelope() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        accept(builder);
        return builder.build();
    }
}

