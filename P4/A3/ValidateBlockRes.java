public class ValidateBlockRes implements IMessage{
    Block bloque;

    public ValidateBlockRes(Block bloque){
        this.bloque = bloque;
    }

    @Override
    public String getMessage(){
        return "Transaction ";
    }
}
