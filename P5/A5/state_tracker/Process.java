package state_tracker;
import java.util.*;

public class Process<V>{
    private Map<String, Map.Entry<Integer,Integer>> stateEndsTMap;
    private Map<String, Map<String, Integer>> tostateMap;

    public Process(V[] estados){
        stateEndsTMap = new LinkedHashMap<>();
        tostateMap = new LinkedHashMap<>();
        for(V estado : estados){
            Map.Entry<Integer, Integer> registro = new AbstractMap.SimpleEntry<>(0, 0);
            stateEndsTMap.put(estado.toString(), registro);
            tostateMap.put(estado.toString(), new LinkedHashMap<>());
        }
    }

    public void add(String trajectoryString){
        trajectoryString = trajectoryString.substring(1, trajectoryString.length() - 1); // quitas corchete
        String[] elementosCorchete = trajectoryString.split(", ");

        for(String elementoCorchete: elementosCorchete){
            String[] elementosParentesis = elementoCorchete.substring(1, elementoCorchete.length() - 1).split(" ");

            if(elementosParentesis[0].equals("in:")){
                Map.Entry<Integer, Integer> endsEntry = stateEndsTMap.get(elementosParentesis[1]);
                stateEndsTMap.put(elementosParentesis[1], new AbstractMap.SimpleEntry<>(endsEntry.getKey() + 1, endsEntry.getValue()));
            }
            else if(elementosParentesis[0].equals("from:")){
                if(!tostateMap.get(elementosParentesis[1]).containsKey(elementosParentesis[3])){
                    Map<String, Integer> estadoVeces = tostateMap.get(elementosParentesis[1]);
                    estadoVeces.put(elementosParentesis[3], 0);
                    tostateMap.put(elementosParentesis[1], estadoVeces);
                }
                Map<String, Integer> estadoVeces = tostateMap.get(elementosParentesis[1]);
                estadoVeces.put(elementosParentesis[3], estadoVeces.get(elementosParentesis[3]) + 1);
                
                if(elementoCorchete.equals(elementosCorchete[elementosCorchete.length-1])){
                    Map.Entry<Integer, Integer> endsEntry = stateEndsTMap.get(elementosParentesis[3]);
                    stateEndsTMap.put(elementosParentesis[3], new AbstractMap.SimpleEntry<>(endsEntry.getKey(), endsEntry.getValue() + 1));
                }
            }
        }
    }

    @Override
    public String toString(){
        String str = "";

        for(Map.Entry<String, Map.Entry<Integer,Integer>> estadoEnds: stateEndsTMap.entrySet()){
            str += estadoEnds.getKey() + " (initial " + estadoEnds.getValue().getKey() + " times, final " + estadoEnds.getValue().getValue() 
                + " times):\n";
            for(Map.Entry<String, Integer> toState: tostateMap.get(estadoEnds.getKey()).entrySet()){
                str += "  to state " + toState.getKey() + ": " + toState.getValue() + " times\n";
            }
        }

        return str;
    }
}
