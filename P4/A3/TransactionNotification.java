public class TransactionNotification implements IMessage{
    Transaction transaction;

    public TransactionNotification(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public String getMessage(){
        return "Transaction " + this.transaction.getId() 
                + "| from: " + this.transaction.getEmisorKey() 
                + ", to: " + this.transaction.getReceptorKey() 
                + ", quantity: " + this.transaction.getValorTransaccion();
    }

    public Transaction getTransaction(){
        return this.transaction;
    }
}
