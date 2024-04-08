import java.util.*;

public class Node extends ObjectWithId implements IMessage, IConnectable{
    protected Wallet wallet;
    protected List<Transaction> transaccionesNoConfirmadas;
    protected List<Transaction> transacciones;

/* Constructor */
    public Node(Wallet wallet){
        super();

        this.transaccionesNoConfirmadas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.wallet = wallet;
    }

/* Métodos */
    public Transaction createTransaction(Wallet wallet, int coins) throws TransactionException{
        if(coins<=0) throw new TransactionException(this.wallet.getPublicKey(), wallet.getPublicKey(), coins, "Negative transfer attempt");
        Transaction t = new Transaction(this.wallet, wallet, coins);
        this.transaccionesNoConfirmadas.add(t);
        
        process(this);

        return t;
    }

    public Transaction createTransaction(String PublicKey, int coins) throws TransactionException{
        if(coins<=0) throw new TransactionException(this.wallet.getPublicKey(), PublicKey, coins, "Negative transfer attempt");
        Transaction t = new Transaction(this.wallet, PublicKey, coins);
        this.transaccionesNoConfirmadas.add(t);

        process(this);

        return t;
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
                   + this.wallet.getPublicKey() + ", balance: " 
                   + this.wallet.getBalance() +  " | @" 
                   + this.fullname();
        return str;
    }

    public String toString2(){
        String str = "u: " + this.wallet.getName() + ", PK:" 
                   + this.wallet.getPublicKey() + ", balance: " 
                   + this.wallet.getBalance();
        return str;
    }

/* Implementaciones */
    public String getMessage(){
        if(this.transaccionesNoConfirmadas.isEmpty()) return "";
        else return new TransactionNotification(this.transaccionesNoConfirmadas.get(transaccionesNoConfirmadas.size() - 1)).getMessage();
    }

    public String getMessageConfirmado(){
        if(this.transacciones.isEmpty()) return "";
        else return new TransactionNotification(this.transacciones.get(transacciones.size() - 1)).getMessage();
    }

    public void broadcast(IMessage msg){
        if((msg instanceof TransactionNotification)) return;
        if(msg instanceof ValidateBlockRq){
            msg.process(this);
            return;
        }
        msg.process(this);
        System.out.println("[" + this.fullname() + "] Committing transaction : Tx-" + ((ValidateBlockRes) msg).getBlock().getTransaction().getId() + " in " + this.fullname());
        this.transacciones.add(((ValidateBlockRes) msg).getBlock().getTransaction());
        System.out.println("[" + this.fullname() + "] -> Tx details:" + this.getMessageConfirmado());
        if(((ValidateBlockRes) msg).getBlock().getTransaction().getEmisorKey().equals(this.wallet.getPublicKey())){
            this.wallet.modBalance(-((ValidateBlockRes) msg).getBlock().getTransaction().getValorTransaccion());
            System.out.println("[" + this.fullname() + "] Applied Transaction: " + this.getMessageConfirmado());
            System.out.println("[" + this.fullname() + "] New wallet value: " + this.toString2());
            this.transacciones.add(((ValidateBlockRes) msg).getBlock().getTransaction());
        }
        else if(((ValidateBlockRes) msg).getBlock().getTransaction().getReceptorKey().equals(this.wallet.getPublicKey())){
            this.wallet.modBalance(((ValidateBlockRes) msg).getBlock().getTransaction().getValorTransaccion());
            System.out.println("[" + this.fullname() + "] Applied Transaction: " + this.getMessageConfirmado());
            System.out.println("[" + this.fullname() + "] New wallet value: " + this.toString2());
            this.transacciones.add(((ValidateBlockRes) msg).getBlock().getTransaction());
        }
    }

    public IConnectable getParent(){
        return null;
    }
}