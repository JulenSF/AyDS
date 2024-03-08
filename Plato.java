import java.util.*;

public class Plato {
    protected String nombre;
    private Map<Ingrediente, Integer> ingredientes = new LinkedHashMap<>();
    private Set<Plato> platos = new HashSet<>();

    public Plato(String nombre){
        this.nombre = nombre;
    }

    public boolean addIngrediente(Ingrediente ingrediente, int cantidad){
        if (!ingredientes.containsKey(ingrediente)){
            this.ingredientes.put(ingrediente, cantidad);
            return true;
        }
        return false;
    }

    public boolean addPlato(Plato plato){
        if (platos.contains(plato)) {
            return false;
        } else {
            platos.add(plato);
            return true;
        }
    }

    @Override
    public String toString() {
        String str = "[Plato] " + this.nombre + ": INFORMACION NUTRICIONAL DEL PLATO"
        + " -> Valor energetico: " + String.format("%.2f", this.getTotalCalorías()).replace(',', '.') 
        + " kcal, Hidratos de carbono: " + String.format("%.2f", this.getTotalHidratosCarbono()).replace(',', '.')
        + " g, Grasas: " + String.format("%.2f", this.getTotalGrasasTotales()).replace(',', '.')
        + " g, Saturadas: " + String.format("%.2f", this.getTotalGrasasSaturadas()).replace(',', '.')
        + " g, Proteinas: " + String.format("%.2f", this.getTotalProteinas()).replace(',', '.')
        + " g, Azucares: " + String.format("%.2f", this.getTotalAzucares()).replace(',', '.')
        + " g, Fibra: " + String.format("%.2f", this.getTotalFibra()).replace(',', '.')
        + " g, Sodio: " + String.format("%.2f", this.getTotalSodio()).replace(',', '.') + " mg.";
        return str;
    }

    private double ingredienteGetCalorías(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getCalorías()*cantidad/100;
        }
        return ingrediente.infoNutricional.getCalorías()*cantidad;
    }
    private double ingredienteGetHidratosCarbono(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getHidratosCarbono()*cantidad/100;
        }
        return ingrediente.infoNutricional.getHidratosCarbono()*cantidad;
    }
    private double ingredienteGetGrasasTotales(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getGrasasTotales()*cantidad/100;
        }
        return ingrediente.infoNutricional.getGrasasTotales()*cantidad;
    }
    private double ingredienteGetGrasasSaturadas(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getGrasasSaturadas()*cantidad/100;
        }
        return ingrediente.infoNutricional.getGrasasSaturadas()*cantidad;
    }
    private double ingredienteGetProteinas(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getProteínas()*cantidad/100;
        }
        return ingrediente.infoNutricional.getProteínas()*cantidad;
    }
    private double ingredienteGetAzucares(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getAzúcares()*cantidad/100;
        }
        return ingrediente.infoNutricional.getAzúcares()*cantidad;
    }
    private double ingredienteGetFibra(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getFibra()*cantidad/100;
        }
        return ingrediente.infoNutricional.getFibra()*cantidad;
    }
    private double ingredienteGetSodio(Ingrediente ingrediente, int cantidad){
        if (ingrediente.infoNutricional.getName().equals("100 g")){
            return ingrediente.infoNutricional.getSodio()*cantidad/100;
        }
        return ingrediente.infoNutricional.getSodio()*cantidad;
    }
    
    private double getTotalCalorías(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetCalorías(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalCalorías();
        }

        return total;
    }
    private double getTotalHidratosCarbono(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetHidratosCarbono(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalHidratosCarbono();
        }

        return total;
    }
    private double getTotalGrasasTotales(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetGrasasTotales(ing, cant);
        }
        
        for(Plato plato : platos){
            total += plato.getTotalGrasasTotales();
        }

        return total;
    }
    private double getTotalGrasasSaturadas(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetGrasasSaturadas(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalGrasasSaturadas();
        }

        return total;
    }
    private double getTotalProteinas(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetProteinas(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalProteinas();
        }

        return total;
    }
    private double getTotalAzucares(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetAzucares(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalAzucares();
        }

        return total;
    }
    private double getTotalFibra(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetFibra(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalFibra();
        }

        return total;
    }
    private double getTotalSodio(){
        double total = 0;
        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            Ingrediente ing = ingrediente.getKey();
            int cant = ingrediente.getValue();
            total += ingredienteGetSodio(ing, cant);
        }
        for(Plato plato : platos){
            total += plato.getTotalSodio();
        }

        return total;
    }

}