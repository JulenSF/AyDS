public class ManejadorFicheros{
    private List<Ingrediente> ingredientes;
    private List<Plato> platos;
    private List<Menu> menus;

    public void guardarFichero(String fichero, List<Menu> menus){}
    public void leerFichero(String fichero){
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;

        while ((linea = br.readLine()) != null) {
            String objectName;
            String[] elementos = linea.split(";");
            objectName = elementos[0];
            if(objectName.equals(TipoDato.INGREDIENTE_PESO))
                leerIngredientePeso(elementos[1]);
            else if (objectName.equals(TipoDato.INGREDIENTE_UNIDAD))
                leerIngredienteUnidad(elementos[1]);
            else if (objectName.equals(TipoDato.PLATO))
                leerPlato(elementos[1]);
            else if (objectName.equals(TipoDato.MENU))
                leerMenu(elementos[1]);
        }
    }

    private void leerIngredientePeso(String ingredienteString){
        List<Alergeno> alergenos = new ArrayList<>();
        InfoNutricionalPeso info = new InfoNutricionalPeso(Double.parseDouble(ingredienteString[2]), Double.parseDouble(ingredienteString[3]), 
                                                            Double.parseDouble(ingredienteString[4]), Double.parseDouble(ingredienteString[5]), 
                                                            Double.parseDouble(ingredienteString[6]), Double.parseDouble(ingredienteString[7]), 
                                                            Double.parseDouble(ingredienteString[8]), Double.parseDouble(ingredienteString[9]));
        if(ingredienteString[10] == 'S'){
            alergenos.add(Alergeno.GLUTEN);
        }
        if(ingredienteString[11] == 'S'){
            alergenos.add(Alergeno.LACTOSA);
        }
        if(ingredienteString[12] == 'S'){
            alergenos.add(Alergeno.FRUTOSECO);
        }
        if(ingredienteString[13] == 'S'){
            alergenos.add(Alergeno.HUEVO);
        }

        if(!alergenos.isEmpty() && alergenos != null){
            this.ingrediente.add(new Ingrediente(ingredienteString[0], TipoIngrediente.toEnum(ingredienteString[1]), info).tieneAlergenos(alergenos));
        }
        this.ingrediente.add(new Ingrediente(ingredienteString[0], TipoIngrediente.toEnum(ingredienteString[1]), info));
    }
    private void leerIngredienteUnidad(String ingredienteString){}
    private void leerPlato(String platoString){}
    private void leerMenu(String menuString){}

    public List<Menu> getMenus(){
        return this.menus;
    }
}