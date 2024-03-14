public enum TipoIngrediente {
    CARNE("Carne"), PESCADO("Pescado"), FRUTA_VERDURA("Frutas y verduras"), LEGUMBRE("Legumbre"), CEREAL("Cereal"), HUEVO("Huevo"), LACTEO("Lacteo");

    private String nombre;

    private TipoIngrediente(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public static TipoIngrediente toEnum(String nombre){
        if(nombre.equals("CARNE"))
            return TipoIngrediente.CARNE;
        else if (nombre.equals("PESCADO"))
            return TipoIngrediente.PESCADO;
        else if (nombre.equals("FRUTA_VERDURA"))
            return TipoIngrediente.FRUTA_VERDURA;
        else if (nombre.equals("LEGUMBRE"))
            return TipoIngrediente.LEGUMBRE;
        else if (nombre.equals("CEREAL"))
            return TipoIngrediente.CEREAL;
        else if (nombre.equals("HUEVO"))
            return TipoIngrediente.HUEVO;
        return TipoIngrediente.LACTEO;
    }
}