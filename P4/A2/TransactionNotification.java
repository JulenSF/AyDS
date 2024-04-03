public class TransactionNotification {
    private String notification;

    public TransactionNotification(Transaction transaction){
        this.notification = "Transaction " + transaction.getId() 
                            + "| from: " + transaction.getEmisorKey() + ", to: " + transaction.getReceptorKey() 
                            + ", quantity: " + transaction.getValorTransaccion();
    }

    public String toString(){
        return this.notification;
    }
}
