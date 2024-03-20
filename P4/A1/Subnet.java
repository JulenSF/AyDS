public class Subnet{
    private int id;
    private static id_count = 0;
    protected List<MiningNode> miningNodes;

    public Subnet(MiningNode... miningNodes){
        this.miningNodes = Arrays.asList(miningNodes);

        this.id = id_count;
        id_count++;
    }
}