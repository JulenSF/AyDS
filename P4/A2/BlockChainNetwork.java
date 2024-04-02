import java.util.*;

public class BlockChainNetwork{
    private String name;
    private List<Node> nodosSimples;
    private List<MiningNode> nodosMineros;
    private List<Subnet> subredes;

    public BlockChainNetwork(String name){
        this.name = name;
        this.nodosSimples = new ArrayList<>();
        this.nodosMineros = new ArrayList<>();
        this.subredes = new ArrayList<>();
    }

    public BlockChainNetwork connect(Node node){
        if(node instanceof MiningNode) this.nodosMineros.add((MiningNode) node);
        else this.nodosSimples.add(node);

        String str = this.name + " - new peer connected: " + node.toString();
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
}