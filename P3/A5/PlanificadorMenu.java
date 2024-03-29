import java.util.*;

/**
 * Clase que sirve para generar un menu a partir de una lista de platos y de condiciones.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public class PlanificadorMenu{
    public List<Alergeno> alergenosExcluidos;
    public Map<ElementoNutricional, Double> maximos = new LinkedHashMap<>();
    public List<Plato> platos;

    public PlanificadorMenu(List<Plato> platos){
        this.platos = platos;
    }

    public PlanificadorMenu conMaximo(ElementoNutricional en, double max){
        this.maximos.put(en, max);
        return this;
	}

    public PlanificadorMenu sinAlergenos(Alergeno... alergenos){
        this.alergenosExcluidos = Arrays.asList(alergenos);
        return this;
	}

    public Menu planificar(double minCal, double maxCal){
        if(minCal<0 || maxCal<minCal) return null;

        List<Plato> platosList = new ArrayList<>();
        
        double totalCalorias = 0;
        double totalHidratosCarbono = 0;
        double totalGrasaTotal = 0;
        double totalGrasaSaturada = 0;
        double totalProteinas = 0;
        double totalAzucares = 0;
        double totalFibra = 0;
        double totalSodio = 0;

        int flag;

        for(Plato plato: this.platos){
            flag = 0;
            if((totalCalorias+plato.getTotalCalorías()) <= maxCal){

                for(Map.Entry<ElementoNutricional, Double> maximoReg : this.maximos.entrySet()){
                    if(maximoReg.getKey() == ElementoNutricional.HIDRATOS_CARBONO){
                        if(totalHidratosCarbono + plato.getTotalHidratosCarbono() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.GRASA_TOTAL){
                        if(totalGrasaTotal + plato.getTotalGrasasTotales() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.GRASA_SATURADA){
                        if(totalGrasaSaturada + plato.getTotalGrasasSaturadas() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.PROTEINAS){
                        if(totalProteinas + plato.getTotalProteinas() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.AZUCARES){
                        if(totalAzucares + plato.getTotalAzucares() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.FIBRA){
                        if(totalFibra + plato.getTotalFibra() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                    else if(maximoReg.getKey() == ElementoNutricional.SODIO){
                        if(totalSodio + plato.getTotalSodio() > maximoReg.getValue()){
                            flag = 1;
                            break;
                        }
                    }
                }

                for(Alergeno alergeno: this.alergenosExcluidos){
                    if(plato.getAlergenos().contains(alergeno)){
                        flag = 1;
                        break;
                    }
                }

                if(flag == 0){
                    platosList.add(plato);
                    totalCalorias += plato.getTotalCalorías();
                    totalHidratosCarbono += plato.getTotalHidratosCarbono();
                    totalGrasaTotal += plato.getTotalGrasasTotales();
                    totalGrasaSaturada += plato.getTotalGrasasSaturadas();
                    totalProteinas += plato.getTotalProteinas();
                    totalAzucares += plato.getTotalAzucares();
                    totalFibra += plato.getTotalFibra();
                    totalSodio += plato.getTotalSodio();
                }

            }
        }
        
        if(platosList.isEmpty()) return null;
        Plato[] platosArray = platosList.toArray(new Plato[0]);
        Menu menu = new Menu(platosArray);
        if(menu.getTotalCalorías() < minCal) return null;
        return menu;
    }
}