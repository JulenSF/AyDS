public class MiningNode extends Node{
    private int coins;

    public MiningNode(Wallet wallet, int coins){
        super(wallet);
        this.coins = coins;
    }

    public String fullname(){
        return "MiningNode#00" + this.id; 
    }
}