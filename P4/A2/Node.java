import java.util.*;

public class Node implements IMessage/*, IConnectable*/{
    protected int id;
    private static int id_count = 0;
    protected Wallet wallet;
    protected List<Transaction> transacciones;

    public Node(Wallet wallet){
        this.id = id_count;
        id_count ++;

        this.transacciones = new ArrayList<>();
        this.wallet = wallet;
    }

    public int getId(){
        return this.id;
    }

    public Transaction createTransaction(Wallet wallet, int coins) throws TransactionException{
        if(coins<=0) throw new TransactionException(this.wallet.getKey(), wallet.getKey(), coins, "Negative transfer attempt");
        Transaction t = new Transaction(this.wallet, wallet, coins);
        this.transacciones.add(t);
        process(this);
        return t;
    }

    public String getMessage(){
        return new TransactionNotification(this.transacciones.get(transacciones.size() - 1)).toString();
    }

    public String name(){
        if(0 <= this.id && this.id <=9) return "Node 00" + this.id;
        else if(10 <= this.id && this.id <=99) return "Node 0" + this.id;
        return "Node " + this.id;
    }

    public String fullname(){
        if(0 <= this.id && this.id <=9) return "Node#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "Node#0" + this.id;
        return "Node#" + this.id;
    }

    public String toString(){
        String str = "u: " + this.wallet.getName() + ", PK:" 
                           + this.wallet.getKey() + ", balance: " 
                           + this.wallet.getBalance() +  " | @" 
                           + this.fullname();
        return str;
    }
}