public class ValidateBlockRq implements IMessage{
    protected Block bloque;
    private int srcKey;

    public ValidateBlockRq(Block bloque, int srcKey){
        this.bloque = bloque;
        this.srcKey = srcKey;
    }

    @Override
    public void process(Node n){
        System.out.println("[" + n.fullname() + "] Received Task: " + this.getMessage());
    }

    @Override
    public String getMessage(){
        if(0 <= this.srcKey && this.srcKey <=9) return "ValidateBlockRq: <b:" + bloque.getId() + ", src:00" + this.srcKey + ">";
        else if(10 <= this.srcKey && this.srcKey <=99) return "ValidateBlockRq: <b:" + bloque.getId() + ", src:0" + this.srcKey + ">";
        else return "ValidateBlockRq: <b:" + bloque.getId() + ", src:" + this.srcKey + ">";
    }

    public int getSrcKey(){
        return this.srcKey;
    }

    public Block getBlock(){
        return this.bloque;
    }
}
