public class BlockChainNetwork{
    private String name;
    private List<Node> nodos;
    private List<MiningNode> nodosMineros; /* Añadir los tres al diagrama */
    private List<Node> nodos;

    public BlockChainNetwork(String name){
        this.name = name;
    }

    public BlockChainNetwork connect(Node node){
        String str = this.name + " - new peer connected: " + node.toString();
        System.out.println(str);
        return this;
    }
    public BlockChainNetwork connect(Subnet subnet){
        String str = this.name + " - new peer connected: Node network of " /* + Contar elementos de la red */ + " nodes: ["
        for(Node node: subnet.miningNodes){
            str += node.toString() + + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        System.out.println(str);
        return this;
    }

    @Override
    public String toString(){
        int n_elements = 0;
        n_elements = /* Metodo tamaño de lista para cada lista */
        String str = this.name + " consists of " /* + Contar elementos de la red */ +  "elements";
        if (){

        }
        
    }
}