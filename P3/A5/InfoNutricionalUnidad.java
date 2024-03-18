/**
 * Clase que extiende a InfoNutricional.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public class InfoNutricionalUnidad extends InfoNutricional {
    public InfoNutricionalUnidad(double calorías, double hidratosCarbono, double grasasTotales, double grasasSaturadas, double proteínas, double azúcares, double fibra, double sodio) {
        super(calorías, hidratosCarbono, grasasTotales, grasasSaturadas, proteínas, azúcares, fibra, sodio);
        this.name = "UNIDAD";
    }
}