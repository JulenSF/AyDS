import java.util.*;

public class MenusTester extends PlatosTester {
    public static void main(String[] args) {
        MenusTester tester = new MenusTester();
        for (Menu menu: tester.crearMenus()){
            System.out.println("* " + menu);
        }
    }

    public List<Menu> crearMenus(){
        Map<String, Plato> platos = this.crearPlatos();
        Menu m1 = new Menu(platos.get("Macarrones"), platos.get("Tortilla"));
        Menu m2 = new Menu(platos.get("Macarrones"), platos.get("Tortilla guisada"));
        Menu m3 = new Menu(platos.get("Macarrones"));

        /*List.of fue introducido en Java 9*/
        /*return List.of(m1,m2,m3);*/

        /*Alternativa para Java 8:*/
        return Collections.unmodifiableList(Arrays.asList(m1, m2, m3));
    }
}