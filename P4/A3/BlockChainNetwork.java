import java.util.*;

public class BlockChainNetwork implements IConnectable{
    private String name;
    private List<ObjectWithId> elementos;

/* Contructor */
    public BlockChainNetwork(String name){
        this.name = name;
        this.elementos = new ArrayList<>();
    }

/* Métodos */
    public BlockChainNetwork connect(Node node) throws ConnectionException{
        if(this.elementos.contains(node)) throw new ConnectionException(node.name() + " is already connected to the network");
        this.elementos.add(node);

        String str = this.name + " - new peer connected: " + node.toString();
        System.out.println(str);
        return this;
    }

    public BlockChainNetwork connect(MiningNode miningNode) throws DuplicateConnectionException{
        for(Subnet subnet: this.getSubredes()){
            if(subnet.getMiningNodes().contains(miningNode)) throw new DuplicateConnectionException(miningNode.name() + " is connected to a different network");
        }
        this.elementos.add(miningNode);

        String str = this.name + " - new peer connected: " + miningNode.toString();
        System.out.println(str);
        return this;
    }

    public BlockChainNetwork connect(Subnet subnet){
        this.elementos.add(subnet);
        
        String str = this.name + " - new peer connected: " + subnet.toString();
        System.out.println(str);
        return this;
    }

    @Override
    public String toString(){
        int n_elements = 0;
        n_elements = this.elementos.size();
        String str = this.name + " consists of " + n_elements +  " elements";
        if(n_elements == 0) return str;
        
        str += ":\n";
        for(ObjectWithId elemento: this.elementos){
            str += "* " + elemento.toString() + "\n";
        }
        return str;
    }

    private List<Subnet> getSubredes(){
        List<Subnet> subredes = new ArrayList<>();
        for(ObjectWithId elemento: this.elementos){
            if(elemento instanceof Subnet) subredes.add((Subnet)elemento);
        }
        return subredes;
    }

    private List<MiningNode> getNodosMineros(){
        List<MiningNode> nodosMineros = new ArrayList<>();
        for(ObjectWithId elemento: this.elementos){
            if(elemento instanceof MiningNode) nodosMineros.add((MiningNode)elemento);
        }
        return nodosMineros;
    }


/* Implementaciones */
    public void broadcast(IMessage msg){
        for(Subnet subnetP: this.getSubredes()){
            System.out.println("[" + subnetP.fullname() + "] " + msg.getMessage());
        }
        System.out.println("Broadcasting to " + this.getNodosMineros().size() + " nodes:");
        for(ObjectWithId elemento: this.elementos){
            if(elemento instanceof Subnet) ((Subnet) elemento).broadcast(msg);
            else if(elemento instanceof MiningNode) ((MiningNode) elemento).broadcast(msg);
            else ((Node) elemento).broadcast(msg);
        }
    }

    public IConnectable getParent(){
        return null;
    }
}