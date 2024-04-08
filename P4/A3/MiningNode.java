import java.util.*;

public class MiningNode extends Node{
    private int coins;
    private IConnectable parent;
    private IMiningMethod miningMethod;
    private IValidateMethod validateMethod;
    private List<Block> bloquesValidados;

/* Constructor */
    public MiningNode(Wallet wallet, int coins){
        super(wallet);
        this.coins = coins;
        this.miningMethod = null;
        this.validateMethod = null;
        this.bloquesValidados = new ArrayList<>();

        this.parent = null;
    }

/* Métodos */
    public String fullname(){
        if(0 <= this.id && this.id <=9) return "MiningNode#00" + this.id;
        else if(10 <= this.id && this.id <=99) return "MiningNode#0" + this.id;
        return "MiningNode#" + this.id;
    }

    public void setMiningMethod(IMiningMethod miningMethod){
        this.miningMethod = miningMethod;
    }
    
    public void setValidationMethod(IValidateMethod validateMethod){
        this.validateMethod = validateMethod;
    }

/* Implementaciones */
    public IConnectable getParent(){
        return this.parent;
    }

    @Override
    public void broadcast(IMessage msg){
        if(msg instanceof TransactionNotification){
            msg.process(this);
            if(!this.transacciones.contains(((TransactionNotification) msg).getTransaction())){
                Block bloque;
                if(this.bloquesValidados.isEmpty()) bloque = this.miningMethod.mineBlock(((TransactionNotification) msg).getTransaction(), null, this.wallet.getPublicKey());
                else bloque = this.miningMethod.mineBlock(((TransactionNotification) msg).getTransaction(), this.bloquesValidados.get(this.bloquesValidados.size() - 1), this.wallet.getPublicKey());
                System.out.println("[" + this.fullname() + "] Mined block: id:" + bloque.getId() + ", v:" + bloque.getVersion() + ", nonce:" + bloque.getNonce() 
                        + ", ts:" + bloque.getTimeStamp() + ", diff:" + bloque.getDifficulty() + ", hash:" + bloque.getHash() + ", minerK:" + bloque.getMinerKey());
                if(this.parent.getParent() != null) this.parent.getParent().broadcast(new ValidateBlockRq(bloque, this.id));
                else this.parent.broadcast(new ValidateBlockRq(bloque, this.id));
            }
            else{
                System.out.println("[" + this.fullname() + "] Transaction already confirmed: Tx-" + ((TransactionNotification) msg).getTransaction().getId());
            }
        }
        else if(msg instanceof ValidateBlockRq){
            System.out.println("[" + this.fullname() + "] Received task: ValidateBlockRq: " + msg.getMessage());
            if(((ValidateBlockRq) msg).getSrcKey() == this.id){
                System.out.println("[" + this.fullname() + "] You cannot validate your own block");
                return;
            }
            ValidateBlockRes message = new ValidateBlockRes(((ValidateBlockRq) msg).getBlock(), this.validateMethod.validate(this.miningMethod, ((ValidateBlockRq) msg).getBlock()), this.id);
            System.out.println("[" + this.fullname() + "] Emitted task: " + message.getMessageBroadcast());
            if(this.validateMethod.validate(this.miningMethod, ((ValidateBlockRq) msg).getBlock())){
                this.bloquesValidados.add(((ValidateBlockRq) msg).getBlock());      // Provisional
                if(this.parent.getParent() != null) this.parent.getParent().broadcast(message);
                else this.parent.broadcast(message);
            }
        }
        else{
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
    }

    /* Se usa en Subnet:11 */
    public void setParent(IConnectable parent){
        this.parent = parent;
    }
}