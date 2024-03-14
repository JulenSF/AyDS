public enum Alergeno {
    GLUTEN("gluten"), LACTOSA("lactosa"), HUEVO("huevo"), FRUTOSECO("frutos secos");

    private String nombre;

    private Alergeno(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
