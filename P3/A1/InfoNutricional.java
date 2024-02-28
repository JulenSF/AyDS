public abstract class InfoNutricional {
    protected float calorías, hidratosCarbono, grasasTotales, grasasSaturadas, proteínas, azúcares, fibra, sodio;
    private List<Alergeno> alergenos;

	public InfoNutricional(float calorías, float hidratosCarbono, float grasasTotales, float grasasSaturadas, float proteínas, float azúcares, float fibra, float sodio) {
		this.calorías = calorías;
        this.hidratosCarbono = hidratosCarbono;
        this.grasasTotales = grasasTotales;
        this.grasasSaturadas = grasasSaturadas;
        this.proteínas = proteínas;
        this.azúcares = azúcares;
        this.fibra = fibra;
        this.sodio = sodio;
	}

    /*@Override
    public String toString() {
        String str = "[]";
        for (String palabra : this.palabras.keySet())
            str += "- " + palabra + " (" + this.palabras.get(palabra) + " caracteres).\n";
        return str;
    }*/
	
	public void tieneAlergenos(List<Alergeno> alergenos) {
        this.alergenos = alergenos;
	}
}
