public class Transaction{
    private int id;
    private static int id_count = 0;
    private String emisorKey;
    private String receptorKey;
    private int valorTransaccion;

    public Transaction(Wallet wallet1, Wallet wallet2, int coins){
        this.id = id_count;
        id_count ++;

        this.emisorKey = wallet1.getPublicKey();
        this.receptorKey = wallet2.getPublicKey();
        this.valorTransaccion = coins;
    }

    public int getId(){
        return this.id;
    }

    public String getEmisorKey(){
        return this.emisorKey;
    }

    public String getReceptorKey(){
        return this.receptorKey;
    }

    public int getValorTransaccion(){
        return this.valorTransaccion;
    }
}