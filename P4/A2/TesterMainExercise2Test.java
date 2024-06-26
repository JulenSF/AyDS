import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TesterMainExercise2Test extends TesterMainExercise1Test{
    @BeforeEach
    public void buildFaultyNetwork() { 
        super.buildNetwork(); 
        try { 
            this.network.connect(this.node); // cannot connect: node already in the network 
        } catch (ConnectionException e) { 
            System.err.println(e); 
        }
        
        try { 
            this.network.connect(this.miningNode2); // cannot connect: miningNode in a subnet 
        } catch (DuplicateConnectionException e) { 
            System.err.println(e); 
        }
    }
    @BeforeEach
    public void createTransactions(){
        try{
            Transaction tr1 = node.createTransaction(wallet2, 10);
            network.broadcast(new TransactionNotification(tr1));
            Transaction tr2 = miningNode.createTransaction(wallet1.getPublicKey(), -1);     // negative fails
            network.broadcast(new TransactionNotification(tr2));
        } catch(TransactionException e){
            System.err.println(e);
        }
    }
    @Test
    public static void main(String[] args){
        TesterMainExercise2 tme = new TesterMainExercise2();
        tme.buildFaultyNetwork();
        tme.createTransactions();
    }
}