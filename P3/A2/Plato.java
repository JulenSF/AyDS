public class Plato {
    protected String nombre;
    private Map<Ingrediente, int> ingredientes = new LinkedHashMap<>();
    private Set<Plato> platos = new HashSet<>();

    public Plato(String nombre){
        this.nombre = nombre;
    }

    public addIngrediente(Ingrediente ingrediente, int cantidad){
        if (!ingredientes.containsKey(ingrediente))
            this.ingredientes.put(ingrediente, cantidad);
    }

    public addPlato(Plato plato){
        if (platos.contains(plato)) {
            System.out.println("El objeto ya está en el conjunto");
        } else {
            platos.add(plato);
            System.out.println("El objeto fue añadido al conjunto");
        }
    }

    @Override
    public String toString() {
        String str = "[Plato] " + this.nombre + ": INFORMACION NUTRICIONAL DEL PLATO"
        + " -> Valor energetico: " + String.format("%.2f", this.infoNutricional.getCalorías()).replace(',', '.') 
        + " kcal, Hidratos de carbono: " + String.format("%.2f", this.infoNutricional.getHidratosCarbono()).replace(',', '.')
        + " g, Grasas: " + String.format("%.2f", this.infoNutricional.getGrasasTotales()).replace(',', '.')
        + " g, Saturadas: " + String.format("%.2f", this.infoNutricional.getGrasasSaturadas()).replace(',', '.')
        + " g, Proteinas: " + String.format("%.2f", this.infoNutricional.getProteínas()).replace(',', '.')
        + " g, Azucares: " + String.format("%.2f", this.infoNutricional.getAzúcares()).replace(',', '.')
        + " g, Fibra: " + String.format("%.2f", this.infoNutricional.getFibra()).replace(',', '.')
        + " g, Sodio: " + String.format("%.2f", this.infoNutricional.getSodio()).replace(',', '.') + " mg.";
        return str;
    }

    private double ingredienteGetCalorías(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetHidratosCarbono(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetGrasasTotales(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetGrasasSaturadas(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetProteinas(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetAzucares(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetFibra(Ingrediente ingrediente, int cantidad){}
    private double ingredienteGetSodio(Ingrediente ingrediente, int cantidad){}
    
    private double PlatoGetTotalCalorías(Plato plato){}
    private double PlatoGetTotalHidratosCarbono(Plato plato){}
    private double PlatoGetTotalGrasasTotales(Plato plato){}
    private double PlatoGetTotalGrasasSaturadas(Plato plato){}
    private double PlatoGetTotalProteinas(Plato plato){}
    private double PlatoGetTotalAzucares(Plato plato){}
    private double PlatoGetTotalFibra(Plato plato){}
    private double PlatoGetTotalSodio(Plato plato){}
}