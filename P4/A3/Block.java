import java.util.*;

public class Block {
    protected String id;
    private int version;
    private int nonce;
    private int timestamp;
    private int difficulty;
    private Transaction transaccionOrigen;
    private boolean validado;
    private String hash;
    private Block previous;
    
/* Constructor */
    public Block(String MinerKey, Transaction transaccion, Block previousConfirmedBlock){
        this.id = MinerKey;
        this.version = BlockConfig.VERSION;
        this.nonce = (int)(Math.floor(Math.random()*(1001)));
        this.timestamp = (int)(new Date().getTime()/1000);
        this.difficulty = BlockConfig.DIFFICULTY;
        this.transaccionOrigen = transaccion;
        this.validado = false;
        // El hash no debe calcularse en la clase block
        this.previous = previousConfirmedBlock;
    }

/* Getters */
    public String getId(){
        return this.id;
    }

    public int getVersion(){
        return this.version;
    }

    public int getNonce(){
        return this.nonce;
    }

    public int getTimeStamp(){
        return this.timestamp;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public String getHash(){
        return this.hash;
    }

    public Block getPrevious(){
        return this.previous;
    }

/* Setters */
    public void setHash(String hash){
        this.hash = hash;
    }

    public void setValido(boolean valido){
        this.validado = valido;
    }

}
