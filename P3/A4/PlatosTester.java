import java.util.*;

public class PlatosTester extends IngredientesTester {
    public static void main(String[] args) {
        PlatosTester tester = new PlatosTester();
        for (Plato plato: tester.crearPlatos().values())
            System.out.println("* " + plato);
    }

    public Map<String, Plato> crearPlatos(){
        Map<String, Ingrediente> ing = this.crearIngredientes();
        Plato p1, p2, p3;

        p1 = new Plato("Macarrones");
        if (p1.addIngrediente(ing.get("Pasta"), 90)) System.out.println("ingrediente repetido");
        if (p1.addIngrediente(ing.get("Pasta"), 90)) System.out.println("ingrediente repetido");
        if (p1.addIngrediente(ing.get("Tomate"), 4)) System.out.println("ingrediente repetido");
        if (p1.addIngrediente(ing.get("Tomate"), 4)) System.out.println("ingrediente repetido");

        p1.addIngrediente(ing.get("Aceite"), 10);
        p1.addIngrediente(ing.get("Chorizo"), 30);

        p2 = new Plato("Tortilla");
        p2.addIngrediente(ing.get("Huevo"), 2);
        p2.addIngrediente(ing.get("Patata"), 150);
        p2.addIngrediente(ing.get("Aceite"), 10);

        p3 = new Plato("Tortilla guisada");
        p3.addPlato(p2);
        p3.addIngrediente(ing.get("Caldo"), 80);
        
        /*Map.of fue introducido en Java 9*/
        /*return Map.of("Macarrones", p1, "Tortilla", p2, "Tortilla guisada", p3);*/

        /*Alternativa para Java 8:*/
        /*Map<String, Plato> platos = new HashMap<>();
        platos.put("Macarrones", p1);
        platos.put("Tortilla", p2);
        platos.put("Tortilla guisada", p3);
        return platos;*/

        /* Otra alternativa para Java 8: */
        return Array.asMap("Macarrones", p1, "Tortilla", p2, "Tortilla guisada", p3);
    }
}