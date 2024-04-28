package state_tracker;
import java.util.*;
import java.util.function.Predicate;
import java.time.LocalDateTime;

public class ObjectStateTracker<K, V> implements Iterable<K>{
    private Map<V, Predicate<K>> stateConditionsMap;                                // Mapa (estado-condicion)
    private Map<V, List<K>> stateObjectlistMap;                                     // Mapa (estado-objetos)
    private Map<K, List<Map.Entry<LocalDateTime, V>>> objectTrajectoryMap;          // Mapa (objeto-Lista((tiempo-estado))

    public ObjectStateTracker(V[] estados){
        stateConditionsMap = new LinkedHashMap<>();
        stateObjectlistMap = new LinkedHashMap<>();
        objectTrajectoryMap = new LinkedHashMap<>();
        for(V estado : estados){
            stateObjectlistMap.put(estado, new ArrayList<>());
        }
    }

    public void addObjects(K... objects){
        List<K> objectsList = Arrays.asList(objects);
        for(K object: objects){
            for(Map.Entry<V, List<K>> estadoObjeto: stateObjectlistMap.entrySet()){
                if(estadoObjeto.getValue().contains(object)){
                    objectsList.remove(object);
                    break;
                }
            }
        }

        for(K object: objectsList){
            for(Map.Entry<V, Predicate<K>> estadoCondicion: stateConditionsMap.entrySet()){
                if(estadoCondicion.getValue().test(object)){
                    List<K> objetos = stateObjectlistMap.get(estadoCondicion.getKey());
                    objetos.add(object);
                    stateObjectlistMap.put(estadoCondicion.getKey(), objetos);

                    Map.Entry<LocalDateTime, V> registro = new AbstractMap.SimpleEntry<>(LocalDateTime.now(), estadoCondicion.getKey());
                    if(!objectTrajectoryMap.containsKey(object)){
                        List<Map.Entry<LocalDateTime, V>> listaRegistros = new LinkedList<>();
                        listaRegistros.add(registro);
                        objectTrajectoryMap.put(object, listaRegistros);
                    }
                    else{
                        List<Map.Entry<LocalDateTime, V>> listaRegistros = objectTrajectoryMap.get(object);
                        Map.Entry<LocalDateTime, V> registroPrevio = listaRegistros.get(listaRegistros.size()-1);
                        if(!registroPrevio.getValue().equals(estadoCondicion.getKey())){
                            listaRegistros.add(registro);
                            objectTrajectoryMap.put(object, listaRegistros);
                        }
                    }
                    break;
                }
            }
        }
    }

    public ObjectStateTracker<K, V> withState(V state, Predicate<K> condition)throws IllegalStateException{
        try{
        	stateConditionsMap.put(state, condition);
        	 return this;
        }catch(IllegalStateException e) {
        	return null;
        }
       
    }

    public void elseState(V defaultState)throws IllegalStateException{
        try{
        	this.withState(defaultState, r -> true);
        }catch(IllegalStateException e) {
        	return;
        }
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

    public String trajectory(K object){
        String str = "[";
        boolean first = true;
        V prevState = null;

        for(Map.Entry<LocalDateTime, V> timeState: objectTrajectoryMap.get(object)){
            if(first){
                str += "(in: " + timeState.getValue() + " at: " + timeState.getKey() + ")";
                first = false;
            }
            else{
                str += "(from: " + prevState + " to " + timeState.getValue() + " at: " + timeState.getKey() + ")";
            }
            prevState = timeState.getValue();
            str += ", ";
        }
        if(objectTrajectoryMap.get(object) != null && !objectTrajectoryMap.get(object).isEmpty()) str = str.substring(0, str.length() - 2);

        str += "]";
        return str;
    }

    @Override
    public Iterator<K> iterator(){
        return objectTrajectoryMap.keySet().iterator();
    }

}