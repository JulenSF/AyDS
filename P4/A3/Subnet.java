import java.util.*;

public class Subnet extends ObjectWithId implements IMessage, IConnectable{
    private List<MiningNode> miningNodes;
    private IConnectable parent;

/* Constructor */
    public Subnet(MiningNode... miningNodes){
        super();
        this.miningNodes = Arrays.asList(miningNodes);
        for(MiningNode nodoMinero: this.miningNodes){
            nodoMinero.setParent(this);
        }
        this.parent = null;
    }

/* Métodos */
    public List<MiningNode> getMiningNodes(){
        return this.miningNodes;
    }

    public String fullname(){
        if(0 <= this.id && this.id <=9) return "Subnet#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "Subnet#0" + this.id;
        return "Subnet#" + this.id;
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

/* Implementaciones */
    public String getMessage(){
        String str = "";
        for(MiningNode nodoMinero: this.miningNodes){
            str += nodoMinero.getMessage();
        }
        return str;
    }
    
    public void broadcast(IMessage msg){
        for(MiningNode nodoMinero: this.miningNodes){
            nodoMinero.broadcast(msg);
        }
    }

    public IConnectable getParent(){
        return this.parent;
    }

    /* Se usará en BlockChainNetwork:36 */
    public void setParent(IConnectable parent){
        this.parent = parent;
    }
}