public class ValidateBlockRes implements IMessage{
    Block bloque;
    boolean res;
    Object srcKey;

    public ValidateBlockRes(Block bloque, boolean res, int srcKey){
        this.bloque = bloque;
        this.res = res;
        this.srcKey = srcKey;
    }
    public ValidateBlockRes(Block bloque, boolean res, String srcKey){
        this.bloque = bloque;
        this.res = res;
        this.srcKey = srcKey;
    }

    @Override
    public void process(Node n){
        System.out.println("[" + n.fullname() + "] Received Task: " + this.getMessage());
    }
    
    @Override
    public String getMessage(){
        if(srcKey instanceof Integer){
            if(0 <= (int)srcKey && (int)srcKey <=9) return "ValidateBlockRes: <b:" + bloque.getId() + ", res:" + this.res + ", src:00" + this.srcKey + ">";
            else if(10 <= (int)srcKey && (int)srcKey <=99) return "ValidateBlockRes: <b:" + bloque.getId() + ", res:" + this.res + ", src:0" + this.srcKey + ">";
            else return "ValidateBlockRes: <b:" + bloque.getId() + ", res:" + this.res + ", src:" + this.srcKey + ">";
        }
        else return "ValidateBlockRes: <b:" + bloque.getId() + ", res:" + this.res + ", src:" + this.srcKey + ">";
    }

    public String getMessageBroadcast(){
        return "ValidateBlockRq: <b:" + bloque.getId() + ", src:broadcast>";
    }

    public Block getBlock(){
        return this.bloque;
    }
}
