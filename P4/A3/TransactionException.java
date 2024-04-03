public class TransactionException extends Exception {
    String emisorKey;
    String receptorKey;
    int balance;
    String message;

    public TransactionException(String emisorKey, String receptorKey, int balance, String message) {
        this.emisorKey = emisorKey;
        this.receptorKey = receptorKey;
        this.balance = balance;
        this.message = message;
    }

    @Override
    public String toString(){
        return "\u001B[31m" + this.message + ": source: " + this.emisorKey + ", receiver:" + this.receptorKey + ", amount: " + this.balance + "\u001B[0m";
    }
}