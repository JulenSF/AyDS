public class ManejadorFicheros{
    private Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
    private Map<String, Plato> platos = new LinkedHashMap<>();
    private List<Menu> menus = new ArrayList<>();

    public void guardarFichero(String fichero, List<Menu> menus){}

    public void leerFichero(String fichero){
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] elementos = linea.split(";");
            String objectName; = elementos[0];

            if(objectName.equals(TipoDato.INGREDIENTE_PESO.toString()))
                leerIngrediente(Arrays.copyOfRange(elementos, 1, elementos.length), InfoNutricionalPeso);
            else if (objectName.equals(TipoDato.INGREDIENTE_UNIDAD.toString()))
                leerIngrediente(Arrays.copyOfRange(elementos, 1, elementos.length), InfoNutricionalUnidad);
            else if (objectName.equals(TipoDato.PLATO.toString()))
                leerPlato(Arrays.copyOfRange(elementos, 1, elementos.length));
            else if (objectName.equals(TipoDato.MENU.toString()))
                leerMenu(Arrays.copyOfRange(elementos, 1, elementos.length));
        }
    }

    private void leerIngrediente(String ingredienteString, InfoNutricional info){
        List<Alergeno> alergenos = new ArrayList<>();
        InfoNutricional info = new info.InfoNutricional(Double.parseDouble(ingredienteString[2]), Double.parseDouble(ingredienteString[3]), 
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
            this.ingredientes.put(ingredienteString[0], new Ingrediente(ingredienteString[0], TipoIngrediente.toEnum(ingredienteString[1]), info).tieneAlergenos(alergenos));
        }
        this.ingredientes.put(ingredienteString[0], new Ingrediente(ingredienteString[0], TipoIngrediente.toEnum(ingredienteString[1]), info));
    }

    /*private void leerIngredienteUnidad(String ingredienteString){
        List<Alergeno> alergenos = new ArrayList<>();
        InfoNutricionalUnidad info = new InfoNutricionalUnidad(Double.parseDouble(ingredienteString[2]), Double.parseDouble(ingredienteString[3]), 
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
    }*/

    private void leerPlato(String platoString){
        Plato p = new Plato(platoString[0]);
        int i = 1;

        while(i < platoString.length){
            String[] plato_ingrediente = platoString[i].split(" ");
            if(plato_ingrediente[0].equals("INGREDIENTE")){
                String[] ingrediente = plato_ingrediente[1].split(":");
                if (p.addIngrediente(ing.get(ingrediente[0]), Double.parseDouble(ingrediente[1]))) System.out.println("ingrediente repetido");
            }
            else if(plato_ingrediente[0].equals("PLATO")){
                p.addPlato(p.get(plato_ingrediente[1]));
            }
            i++;
        }

        this.platos.put(platoString[0], p);
    }

    private void leerMenu(String menuString){
        List<Platos> platos;
        int i = 0;

        while(i < menuString.length){
            platos.add(this.platos.get(menuString[i]));
            i++;
        }

        this.menus.add(platos);
    }

    public List<Menu> getMenus(){
        return this.menus;
    }
}