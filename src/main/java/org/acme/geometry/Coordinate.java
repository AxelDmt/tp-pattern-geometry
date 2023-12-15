package org.acme.geometry;

public class Coordinate  {
    private final double x;
    private final double y;

    // Constructeur par défaut initialisant une coordonnée vide
    public Coordinate() {
        this(Double.NaN, Double.NaN);
    }

    // Constructeur avec valeurs spécifiées
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Méthode pour tester si une coordonnée est vide
    public boolean isEmpty() {
        return Double.isNaN(x) && Double.isNaN(y);
    }

    // Méthode pour obtenir la valeur de x
    public double getX() {
        return x;
    }

    // Méthode pour obtenir la valeur de y
    public double getY() {
        return y;
    }
    
    // Méthode pour représenter la coordonnée sous forme de chaîne au format JSON
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
