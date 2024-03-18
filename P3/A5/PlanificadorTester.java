import java.util.*;

/**
 * Clase que sirve testear PlanificadorMenu.
 * 
 * Autor: Profesores AyDS
 */
public class PlanificadorTester extends PlatosTester {
    public static void main (String[] args) {
        PlanificadorTester tester = new PlanificadorTester();
        List<Plato> platos = new ArrayList<>(tester.crearPlatos().values());
        
        // busqueda 1
        PlanificadorMenu planificador = new PlanificadorMenu(platos)
                                        .conMaximo(ElementoNutricional.GRASA_SATURADA, 20.0)
                                        .conMaximo(ElementoNutricional.AZUCARES, 15.0)
                                        .sinAlergenos(Alergeno.GLUTEN, Alergeno.HUEVO);
        Menu menu = planificador.planificar(800, 2500);
        System.out.println("* " + menu);
        // busqueda 2
        planificador = new PlanificadorMenu(platos)
                        .conMaximo(ElementoNutricional.GRASA_SATURADA, 20.0)
                        .conMaximo(ElementoNutricional.AZUCARES, 15.0)
                        .sinAlergenos(Alergeno.FRUTOS_SECOS);
        menu = planificador.planificar(800, 2500);
        System.out.println("* " + menu);
    }
}