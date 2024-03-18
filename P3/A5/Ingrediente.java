import java.util.List;
import java.util.Arrays;

/**
 * Clase que representea Ingrediente.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public class Ingrediente{
    protected String            nombre;
    protected Object            tipoIngrediente; // Puede ser un String o un enumerado
    protected InfoNutricional   infoNutricional;
    private List<Alergeno>      alergenos;

    public Ingrediente(String nombre, TipoIngrediente tipoIngrediente, InfoNutricional infoNutricional) {
        this.nombre = nombre;
        this.tipoIngrediente = tipoIngrediente;
        this.infoNutricional = infoNutricional;
	}
    
    public Ingrediente(String nombre, String tipoIngrediente, InfoNutricional infoNutricional) {
        this.nombre = nombre;
        this.tipoIngrediente = tipoIngrediente;
        this.infoNutricional = infoNutricional;
	}

    public List<Alergeno> getAlergenos() {
        return this.alergenos;
	}

    public Object getTipoIngrediente() {
        return this.tipoIngrediente;
	}

    public InfoNutricional getInfoNutricional() {
        return this.infoNutricional;
    }

    public String getName() {
        return this.nombre;
    }

    public Ingrediente tieneAlergenos(Alergeno... alergenos) {
        this.alergenos = Arrays.asList(alergenos);
        return this;
	}

    @Override
    public String toString() {
        String tipoString = null;

        if (tipoIngrediente instanceof String) {
            tipoString = (String) tipoIngrediente;
        } else if (tipoIngrediente instanceof TipoIngrediente) {
            tipoString = ((TipoIngrediente) tipoIngrediente).toString();
        }

        String str = "[" + tipoString + "] " + this.nombre + ": INFORMACION NUTRICIONAL POR " + this.infoNutricional.getName() 
        + " -> Valor energetico: " + String.format("%.2f", this.infoNutricional.getCalorías()).replace(',', '.') 
        + " kcal, Hidratos de carbono: " + String.format("%.2f", this.infoNutricional.getHidratosCarbono()).replace(',', '.')
        + " g, Grasas: " + String.format("%.2f", this.infoNutricional.getGrasasTotales()).replace(',', '.')
        + " g, Saturadas: " + String.format("%.2f", this.infoNutricional.getGrasasSaturadas()).replace(',', '.')
        + " g, Proteinas: " + String.format("%.2f", this.infoNutricional.getProteínas()).replace(',', '.')
        + " g, Azucares: " + String.format("%.2f", this.infoNutricional.getAzúcares()).replace(',', '.')
        + " g, Fibra: " + String.format("%.2f", this.infoNutricional.getFibra()).replace(',', '.')
        + " g, Sodio: " + String.format("%.2f", this.infoNutricional.getSodio()).replace(',', '.') + " mg.";
        if (alergenos != null && !alergenos.isEmpty()) {
            str += " CONTIENE ";
            for (Alergeno alergeno : alergenos) {
                str += alergeno.toString() + ", ";
            }
            str = str.substring(0, str.length() - 2); // Eliminamos la coma y el espacio extra al final del String
        }
        return str;
    }
}