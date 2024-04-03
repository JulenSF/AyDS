public class TransactionNotification implements IMessage{
    Transaction transaccion;

    public TransactionNotification(Transaction transaction){
        this.transaccion = transaction;
    }

    @Override
    public String getMessage(){
        return "Transaction " + this.transaccion.getId() 
                + "| from: " + this.transaccion.getEmisorKey() 
                + ", to: " + this.transaccion.getReceptorKey() 
                + ", quantity: " + this.transaccion.getValorTransaccion();
    }
}
