import java.util.*;

/**
 * Clase que sirve para testear ManejadorFicheros.
 * 
 * Autor: Profesores AyDS
 */
public class FicherosTester extends MenusTester{
    public static void main(String[] args) {
        FicherosTester tester = new FicherosTester();
        List<Menu> menus = tester.crearMenus();
        ManejadorFicheros.guardarFichero("comida.txt", menus);
        ManejadorFicheros.leerFichero("comida.txt");
        for (Menu menu: ManejadorFicheros.getMenus()){
            System.out.println("* "+ menu);
        }
    }
}