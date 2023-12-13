package org.acme.geometry;

public class Geometry {
   
    // Méthode pour obtenir le type de la classe en CamelCase
    public String getType() {
        String className = this.getClass().getSimpleName();
        return toCamelCase(className);
    }

    // Méthode utilitaire pour convertir une chaîne en CamelCase
    private String toCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
