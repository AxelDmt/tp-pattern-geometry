package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry{

    private List<GeometryListener> listeners = new ArrayList<>();
    
    public String asText(){
        WktVisitor visitor = new WktVisitor();
        accept(visitor);
        return visitor.getResult();
    }

    public void addListener(GeometryListener listener) {
        listeners.add(listener);
    }

    protected void triggerChange() {
        for (GeometryListener listener : listeners) {
            listener.onChange(this);
        }
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


