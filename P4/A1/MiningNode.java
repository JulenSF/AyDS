public class MiningNode extends Node{
    private int coins;

    public MiningNode(Wallet wallet, int coins){
        this.wallet = wallet;
        this.coins = coins;

        this.id = id_count;
        id_count ++;
    }

    public String fullName(){
        return "MiningNode#00" + this.id; 
    }
}