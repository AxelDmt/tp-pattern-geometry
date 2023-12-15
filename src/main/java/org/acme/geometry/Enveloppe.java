package org.acme.geometry;

// Classe Envelope représentant une emprise rectangulaire
public class Enveloppe {

    private Coordinate bottomLeft;
    private Coordinate topRight;

    public Enveloppe(){
        bottomLeft = new Coordinate();
        topRight = new Coordinate();
    }
   
    public Enveloppe(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean isEmpty(){
        return bottomLeft.isEmpty();
    }

    public double getYmin(){
        return bottomLeft.getY();
    }

    public double getXmin(){
        return bottomLeft.getX();
    }

    public double getXmax(){
        return topRight.getX();
    }

    public double getYmax(){
        return topRight.getY();
    }

    @Override
    public String toString() {
        return getXmin() + "," + getYmin() + "," + getXmax() + "," + getYmax();
    }    
}
