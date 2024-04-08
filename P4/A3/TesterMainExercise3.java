public class TesterMainExercise3 extends TesterMainExercise2{
    public void createTransactions(){
        this.miningNode.setMiningMethod(new SimpleMining());
        this.miningNode.setValidationMethod(new SimpleValidate());
        this.miningNode2.setMiningMethod(new SimpleMining());
        this.miningNode2.setValidationMethod(new SimpleValidate());

        try{
            network.broadcast(new TransactionNotification(node.createTransaction(wallet2.getPublicKey(), 5)));
        } catch(TransactionException e){
            System.err.println(e);
        }
        
    }

    public static void main(String[] args){
        TesterMainExercise3 tme = new TesterMainExercise3();
        tme.buildNetwork();
        tme.createTransactions();
        System.out.println("End of party!");
    }
}