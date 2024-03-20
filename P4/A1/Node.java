public class Node{
    private int id;
    private static int id_count = 000;
    protected Wallet wallet;
    private List<Transaction> transactions;

    public Node(Wallet wallet){
        this.wallet = wallet;
        
        this.id = id_count;
        id_count ++;

        this.transactions = new ArrayList<>();
    }

    public String fullName(){
        return "Node#" + this.id;
    }

    public String toString(){
        String str = "u: " + node.wallet.getName() + ", PK:" 
                           + node.wallet.getKey() + ', balance: ' 
                           + node.wallet.getBalance() +  " | @"
                           + node.fullName();
    }

}