public class Wallet{
    private String userName;
    private String key;
    private int balance;

    public Wallet(String userName, String key, int balance){
        this.userName = userName;
        this.key = key;
        this.balance = balance;
    }

    public String getName(){
        return this.userName;
    }

    public int getBalance(){
        return this.balance;
    }

    public String getPublicKey(){
        return this.key;
    }
}