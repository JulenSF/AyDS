import java.util.*;

public class PlanificadorMenu{
    public List<Alergeno> alergenosExcluidos;
    public Map<ElementoNutricional, Double> maximos;

    public PlanificadorMenu(List<Plato>){

    }
    public PlanificadorMenu conMaximo(ElementoNutricional en, double max) {
        this.maximos[en] = max;
        return this;
	}

    public PlanificadorMenu sinAlergenos(Alergeno... alergenos) {
        this.alergenosExcluidos = Arrays.asList(alergenos);
        return this;
	}
}