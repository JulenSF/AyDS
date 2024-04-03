import java.util.*;

public class MiningNode extends Node{
    private int coins;
    private IConnectable parent;
    private List<Block> bloquesValidados;

    public MiningNode(Wallet wallet, int coins){
        super(wallet);
        this.coins = coins;
    }

    public String fullname(){
        if(0 <= this.id && this.id <=9) return "MiningNode#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "MiningNode#0" + this.id;
        return "MiningNode#" + this.id;
    }

    public IConnectable getParent(){
        return this.parent;
    }

    public void setParent(Subnet parent){
        this.parent = parent;
    }
}