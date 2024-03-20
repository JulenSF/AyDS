public class Subnet{
    private List<MiningNode> miningNodes;

    public Subnet(MiningNode... miningNodes){
        this.miningNodes = Arrays.asList(miningNodes);
    }
}