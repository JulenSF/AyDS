public class MiningNode extends Node{
    private int coins;

    public MiningNode(Wallet wallet, int coins){
        super(wallet);
        this.coins = coins;
    }

    public Transaction createTransaction(String PublicKey, int coins) throws TransactionException{
        if(coins<=0) throw new TransactionException(this.wallet.getKey(), PublicKey, coins, "Negative transfer attempt");
        Transaction t = new Transaction(this.wallet, wallet, coins);
        this.transacciones.add(t);
        return t;
    }

    public String fullname(){
        if(0 <= this.id && this.id <=9) return "MiningNode#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "MiningNode#0" + this.id;
        return "MiningNode#" + this.id;
    }
}