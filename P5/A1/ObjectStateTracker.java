package objetos;
import java.util.*;

public class ObjectStateTracker<K, V> {
    private List<K> keys;

    ObjectStateTracker(List<K> claves){
        this.keys = new ArrayList<>();
        this.keys.addAll(claves);
    }

    public void updateStates(){}

    public void addObjects(K ... values){}

    public ObjectStateTracker<K,V> withState(V value, ){
        return this;
    }

    @Override
    public String toString(){
        return "";
    }
}