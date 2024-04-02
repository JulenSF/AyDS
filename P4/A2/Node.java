import java.util.*;

public class Node{
    protected int id;
    private static int id_count = 0;
    private Wallet wallet;
    private List<Transaction> transacciones;

    public Node(Wallet wallet){
        this.id = id_count;
        id_count ++;

        this.transacciones = new ArrayList<>();
        this.wallet = wallet;
    }

    public void añadirTransaccion(Transaction transaccion){
        this.transacciones.add(transaccion);
    }

    public String fullname(){
        return "Node#00" + this.id;
    }

    public String toString(){
        String str = "u: " + this.wallet.getName() + ", PK:" 
                           + this.wallet.getKey() + ", balance: " 
                           + this.wallet.getBalance() +  " | @" 
                           + this.fullname();
        return str;
    }
}