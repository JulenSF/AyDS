import java.util.*;

public class MiningNode extends Node{
    private int coins;
    private IConnectable parent;
    private List<Block> bloquesValidados;

/* Constructor */
    public MiningNode(Wallet wallet, int coins){
        super(wallet);
        this.coins = coins;
    }

/* Métodos */
    public String fullname(){
        if(0 <= this.id && this.id <=9) return "MiningNode#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "MiningNode#0" + this.id;
        return "MiningNode#" + this.id;
    }

    public void setMiningMethod(IMiningMethod miningMethod){}
    public void setValidationMethod(IValidateMethod validateMethod){}

/* Implementaciones */
    public IConnectable getParent(){
        return this.parent;
    }

    @Override
    public void broadcast(IMessage msg){
        msg.process(this);
    }

    public void setParent(Subnet parent){
        this.parent = parent;
    }
}