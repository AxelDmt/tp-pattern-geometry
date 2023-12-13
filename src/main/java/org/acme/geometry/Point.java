package org.acme.geometry;

public class Point extends Geometry{

    private Coordinate coordinate;

    public Point(){

    }

    public Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }
}
