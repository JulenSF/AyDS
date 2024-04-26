package objetos;
import java.util.*;
import java.util.function.Predicate;

public class ObjectStateTracker<K, V>{
    private Map<V, Predicate<K>> stateConditionsMap;            // Mapa estado-condicion
    private Map<V, List<K>> stateObjectlistMap;                 // Mapa estado-objetos

    public ObjectStateTracker(V[] estados){
        stateConditionsMap = new LinkedHashMap<>();
        stateObjectlistMap = new LinkedHashMap<>();
        for(V estado : estados){
            stateObjectlistMap.put(estado, new ArrayList<>());
        }
    }

    public void addObjects(K... objects){
        for(K object: objects){
            for(Map.Entry<V, Predicate<K>> estadoCondicion: stateConditionsMap.entrySet()){
                if(estadoCondicion.getValue().test(object)){
                    List<K> objetos = stateObjectlistMap.get(estadoCondicion.getKey());
                    objetos.add(object);
                    stateObjectlistMap.put(estadoCondicion.getKey(), objetos);
                    break;
                }
            }
        }
    }

    public ObjectStateTracker<K, V> withState(V state, Predicate<K> condition)/*throws IllegalStateException*/{
        stateConditionsMap.put(state, condition);
        return this;
    }

    public void elseState(V defaultState)/*throws IllegalStateException*/{
        this.withState(defaultState, r -> true);
    }

    public void updateStates(){
        List<K> objetos = new ArrayList<>();
        for(V estado: stateObjectlistMap.keySet()){
            List<K> objects = stateObjectlistMap.get(estado);
            objetos.addAll(objects);
            stateObjectlistMap.put(estado, new ArrayList<>());
        }

        this.addObjects((K[]) objetos.toArray(new Object[0]));
    }

    @Override
    public String toString(){
        String str = "{";
        for(Map.Entry<V, List<K>> estadoObjetos: stateObjectlistMap.entrySet()){
            str += estadoObjetos.getKey() + "=[";
            List<K> objetos = estadoObjetos.getValue();
            if(!objetos.isEmpty()){
                for(K objeto: estadoObjetos.getValue()) str += objeto + ", ";
                str = str.substring(0, str.length() - 2);
            }
            str += "], ";
        }
        if(!stateObjectlistMap.keySet().isEmpty()) str = str.substring(0, str.length() - 2);
        str += "}";

        return str;
    }
}