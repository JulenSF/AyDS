import java.util.*;

public class Node{
    protected int id;
    private static int id_count = 0;
    private Wallet wallet;

    public Node(Wallet wallet){
        this.wallet = wallet;
        
        this.id = id_count;
        id_count ++;
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