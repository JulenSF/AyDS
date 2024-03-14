public abstract class InfoNutricional {
    protected String name;
    protected double calorías;
    protected double hidratosCarbono;
    protected double grasasTotales;
    protected double grasasSaturadas;
    protected double proteínas;
    protected double azúcares;
    protected double fibra;
    protected double sodio;

	public InfoNutricional(double calorías, double hidratosCarbono, double grasasTotales, double grasasSaturadas, double proteínas, double azúcares, double fibra, double sodio) {
        this.calorías = calorías;
        this.hidratosCarbono = hidratosCarbono;
        this.grasasTotales = grasasTotales;
        this.grasasSaturadas = grasasSaturadas;
        this.proteínas = proteínas;
        this.azúcares = azúcares;
        this.fibra = fibra;
        this.sodio = sodio;
	}

    public String getName(){
        return this.name;
    }

    public double getCalorías(){
        return this.calorías;
    }

    public double getHidratosCarbono(){
        return this.hidratosCarbono;
    }

    public double getGrasasTotales(){
        return this.grasasTotales;
    }

    public double getGrasasSaturadas(){
        return this.grasasSaturadas;
    }

    public double getProteínas(){
        return this.proteínas;
    }

    public double getAzúcares(){
        return this.azúcares;
    }

    public double getFibra(){
        return this.fibra;
    }

    public double getSodio(){
        return this.sodio;
    }
}
