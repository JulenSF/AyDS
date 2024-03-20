public class BlockChainNetwork{
    private String name;

    public BlockChainNetwork(String name){
        this.name = name;
    }

    public BlockChainNetwork connect(Node node){}
    public BlockChainNetwork connect(Subnet subnet){}
    public BlockChainNetwork connect(MiningNode miningNode){}
}