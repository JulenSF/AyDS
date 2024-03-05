public enum TipoIngrediente {
    CARNE("Carne"), PESCADO("Pescado"), FRUTA_VERDURA("Frutas y verduras"), LEGUMBRE("Legumbre"), CEREAL("Cereal"), HUEVO("Huevo"), LACTEO("Lacteo");

    private String nombre;

    private TipoIngrediente(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}