public enum ElementoNutricional {
    HIDRATOS_CARBONO("HIDRATOS_CARBONO"), GRASA_TOTAL("GRASA_TOTAL"), GRASA_SATURADA("GRASA_SATURADA"), PROTEINAS("PROTEINAS"), AZUCARES("AZUCARES"), FIBRA("FIBRA"), SODIO("SODIO");

    private String nombre;

    private Alergeno(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
