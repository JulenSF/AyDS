import java.util.*;

public class BlockChainNetwork implements IConnectable{
    private String name;
    private List<Node> nodosSimples;
    private List<MiningNode> nodosMineros;
    private List<Subnet> subredes;

/* Contructor */
    public BlockChainNetwork(String name){
        this.name = name;
        this.nodosSimples = new ArrayList<>();
        this.nodosMineros = new ArrayList<>();
        this.subredes = new ArrayList<>();
    }

/* Métodos */
    public BlockChainNetwork connect(Node node) throws ConnectionException{
        if(this.nodosSimples.contains(node)) throw new ConnectionException(node.name() + " is already connected to the network");
        this.nodosSimples.add(node);

        String str = this.name + " - new peer connected: " + node.toString();
        System.out.println(str);
        return this;
    }

    public BlockChainNetwork connect(MiningNode miningNode) throws DuplicateConnectionException{
        for(Subnet subnet: this.subredes){
            if(subnet.getMiningNodes().contains(miningNode)) throw new DuplicateConnectionException(miningNode.name() + " is connected to a different network");
        }
        this.nodosMineros.add(miningNode);

        String str = this.name + " - new peer connected: " + miningNode.toString();
        System.out.println(str);
        return this;
    }

    public BlockChainNetwork connect(Subnet subnet){
        this.subredes.add(subnet);
        
        String str = this.name + " - new peer connected: " + subnet.toString();
        System.out.println(str);
        return this;
    }

    @Override
    public String toString(){
        int n_elements = 0;
        n_elements = this.nodosSimples.size() + this.nodosMineros.size() + this.subredes.size();
        String str = this.name + " consists of " + n_elements +  " elements";
        if(n_elements == 0) return str;
        
        str += ":\n";
        for(Node nodo: this.nodosSimples){
            str += "* " + nodo.toString() + "\n";
        }
        for(Subnet subred: this.subredes){
            str += "* " + subred.toString() + "\n";
        }
        for(Node nodo: this.nodosMineros){
            str += "* " + nodo.toString() + "\n";
        }
        return str;
    }

/* Implementaciones */
    public void broadcast(IMessage msg){
        System.out.println("Broadcasting to " + this.nodosMineros.size() + " nodes:");
        for(Subnet subred: this.subredes){
            subred.broadcast(msg);
        }
        for(MiningNode miningNode: this.nodosMineros){
            miningNode.broadcast(msg);
        }
    }

    public IConnectable getParent(){
        return null;
    }
}