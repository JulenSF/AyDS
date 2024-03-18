import java.util.*;

/**
 * Clase que representa un menu.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public class Menu {
    private static int menu_count = 1;
    private int id;
    private List<Plato> platos;

    public Menu(Plato... platos){
        this.id = menu_count;
        this.menu_count ++;
        this.platos = Arrays.asList(platos);
    }

    public List<Plato> getPlatos(){
        return this.platos;
    }

    @Override
    public String toString() {
        Set<Alergeno> alergenos = this.getAlergenos();
        String str = "Menu " + this.id + " [";

        if (platos != null && !platos.isEmpty()) {
            for (Plato plato : platos) {
                str += plato.getName() + ", ";
            }
            str = str.substring(0, str.length() - 2); // Eliminamos la coma y el espacio extra al final del String
        }
        str += "]:" + " INFORMACION NUTRICIONAL DEL MENU"
        + " -> Valor energetico: " + String.format("%.2f", this.getTotalCalorías()).replace(',', '.') 
        + " kcal, Hidratos de carbono: " + String.format("%.2f", this.getTotalHidratosCarbono()).replace(',', '.')
        + " g, Grasas: " + String.format("%.2f", this.getTotalGrasasTotales()).replace(',', '.')
        + " g, Saturadas: " + String.format("%.2f", this.getTotalGrasasSaturadas()).replace(',', '.')
        + " g, Proteinas: " + String.format("%.2f", this.getTotalProteinas()).replace(',', '.')
        + " g, Azucares: " + String.format("%.2f", this.getTotalAzucares()).replace(',', '.')
        + " g, Fibra: " + String.format("%.2f", this.getTotalFibra()).replace(',', '.')
        + " g, Sodio: " + String.format("%.2f", this.getTotalSodio()).replace(',', '.') + " mg.";

        if (alergenos != null && !alergenos.isEmpty()) {
            str += " CONTIENE ";
            for (Alergeno alergeno : alergenos) {
                str += alergeno.toString() + ", ";
            }
            str = str.substring(0, str.length() - 2); // Eliminamos la coma y el espacio extra al final del String
        }

        return str;
    }

    public double getTotalCalorías(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalCalorías();
        }
        return total;
    }
    private double getTotalHidratosCarbono(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalHidratosCarbono();
        }
        return total;
    }
    private double getTotalGrasasTotales(){
        double total = 0;        
        for(Plato plato : platos){
            total += plato.getTotalGrasasTotales();
        }
        return total;
    }
    private double getTotalGrasasSaturadas(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalGrasasSaturadas();
        }
        return total;
    }
    private double getTotalProteinas(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalProteinas();
        }
        return total;
    }
    private double getTotalAzucares(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalAzucares();
        }
        return total;
    }
    private double getTotalFibra(){
        double total = 0;
        for(Plato plato : platos){
            total += plato.getTotalFibra();
        }
        return total;
    }
    private double getTotalSodio(){
        double total = 0;
        for(Plato plato : this.platos){
            total += plato.getTotalSodio();
        }
        return total;
    }
    
    private Set<Alergeno> getAlergenos(){
        SortedSet<Alergeno> alergenos = new TreeSet<>();
        for(Plato plato : platos){
            if(plato.getAlergenos() != null)
                alergenos.addAll(plato.getAlergenos());
        }
        return alergenos;
    }
}