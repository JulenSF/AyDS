import java.util.*;
import java.io.*;

public class ManejadorFicheros{
    private static Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
    private static Map<String, Plato> platos = new LinkedHashMap<>();
    private static List<Menu> menus = new ArrayList<>();

    public static void guardarFichero(String fichero, List<Menu> menus){}

    public static void leerFichero(String fichero){

        try{
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(";");
                String objectName = elementos[0];

                if (objectName.equals(TipoDato.INGREDIENTE_PESO.toString()))
                    leerIngredientePeso(linea);

                else if (objectName.equals(TipoDato.INGREDIENTE_UNIDAD.toString()))
                    leerIngredienteUnidad(linea);

                else if (objectName.equals(TipoDato.PLATO.toString()))
                    leerPlato(linea);

                else if (objectName.equals(TipoDato.MENU.toString()))
                    leerMenu(linea);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no pudo ser encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
    }

    private static void leerIngredienteUnidad(String linea){
        String[] ingredienteString = linea.split(";");
        List<Alergeno> alergenos = new ArrayList<>();

        InfoNutricionalUnidad info = new InfoNutricionalUnidad(Double.parseDouble(ingredienteString[3]), Double.parseDouble(ingredienteString[4]), 
                                                               Double.parseDouble(ingredienteString[5]), Double.parseDouble(ingredienteString[6]), 
                                                               Double.parseDouble(ingredienteString[7]), Double.parseDouble(ingredienteString[8]), 
                                                               Double.parseDouble(ingredienteString[9]), Double.parseDouble(ingredienteString[10]));
        if(ingredienteString[11].equals("S")){
            alergenos.add(Alergeno.GLUTEN);
        }
        if(ingredienteString[12].equals("S")){
            alergenos.add(Alergeno.LACTOSA);
        }
        if(ingredienteString[13].equals("S")){
            alergenos.add(Alergeno.FRUTOSECO);
        }
        if(ingredienteString[14].equals("S")){
            alergenos.add(Alergeno.HUEVO);
        }

        if(!alergenos.isEmpty() && alergenos != null){
            Alergeno[] alergenosArray = alergenos.toArray(new Alergeno[0]);
            ingredientes.put(ingredienteString[1], new Ingrediente(ingredienteString[1], TipoIngrediente.toEnum(ingredienteString[2]), info).tieneAlergenos(alergenosArray));
        }
        ingredientes.put(ingredienteString[1], new Ingrediente(ingredienteString[1], TipoIngrediente.toEnum(ingredienteString[2]), info));
    }

    private static void leerIngredientePeso(String linea){
        String[] ingredienteString = linea.split(";");
        List<Alergeno> alergenos = new ArrayList<>();
        
        InfoNutricionalPeso info = new InfoNutricionalPeso(Double.parseDouble(ingredienteString[3]), Double.parseDouble(ingredienteString[4]), 
                                                           Double.parseDouble(ingredienteString[5]), Double.parseDouble(ingredienteString[6]), 
                                                           Double.parseDouble(ingredienteString[7]), Double.parseDouble(ingredienteString[8]), 
                                                           Double.parseDouble(ingredienteString[9]), Double.parseDouble(ingredienteString[10]));
        if(ingredienteString[11].equals("S")){
            alergenos.add(Alergeno.GLUTEN);
        }
        if(ingredienteString[12].equals("S")){
            alergenos.add(Alergeno.LACTOSA);
        }
        if(ingredienteString[13].equals("S")){
            alergenos.add(Alergeno.FRUTOSECO);
        }
        if(ingredienteString[14].equals("S")){
            alergenos.add(Alergeno.HUEVO);
        }

        if(!alergenos.isEmpty() && alergenos != null){
            Alergeno[] alergenosArray = alergenos.toArray(new Alergeno[0]);
            ingredientes.put(ingredienteString[1], new Ingrediente(ingredienteString[1], TipoIngrediente.toEnum(ingredienteString[2]), info).tieneAlergenos(alergenosArray));
        }
        ingredientes.put(ingredienteString[1], new Ingrediente(ingredienteString[1], TipoIngrediente.toEnum(ingredienteString[2]), info));
    }

    private static void leerPlato(String linea){
        String[] platoString = linea.split(";");
        Plato p = new Plato(platoString[1]);
        int i = 2;

        while(i < platoString.length){
            String[] plato_ingrediente = platoString[i].split(" ");
            if(plato_ingrediente[0].equals("INGREDIENTE")){
                String[] ingrediente = plato_ingrediente[1].split(":");
                if (p.addIngrediente(ingredientes.get(ingrediente[0]), Integer.parseInt(ingrediente[1]))) System.out.println("ingrediente repetido");
            }
            else if(plato_ingrediente[0].equals("PLATO")){
                p.addPlato(platos.get(plato_ingrediente[1]));
            }
            i++;
        }

        platos.put(platoString[1], p);
    }

    private static void leerMenu(String linea){
        String[] menuString = linea.split(";");
        List<Plato> platosList = new ArrayList<>();
        int i = 1;
        
        while(i < menuString.length){
            platosList.add(platos.get(menuString[i]));
            i++;
        }

        Plato[] platosArray = platosList.toArray(new Plato[0]);
        menus.add(new Menu(platosArray));
    }

    public static List<Menu> getMenus(){
        return menus;
    }
}