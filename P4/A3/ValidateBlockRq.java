public class ValidateBlockRq implements IMessage{
    Block bloque;

    public ValidateBlockRq(Block bloque){
        this.bloque = bloque;
    }

    @Override
    public String getMessage(){
        return "Transaction ";
    }
}
