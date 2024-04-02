import java.util.*;

public class Subnet{
    private int id;
    private static int id_count = 0;
    private List<MiningNode> miningNodes;

    public Subnet(MiningNode... miningNodes){
        this.id = id_count;
        id_count ++;

        this.miningNodes = Arrays.asList(miningNodes);
    }

    public String toString(){
        int n_elements = 0;
        n_elements = this.miningNodes.size();

        String str = "Node network of: " + n_elements + " nodes";
        if(n_elements == 0) return str;
        
        str += ": [";
        for(Node node: this.miningNodes){
            str += node.toString() + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
}