public class SimpleMining implements IMiningMethod{
    public String createHash(Block block){
        String str = "" + block.getVersion();
        if(block.getPrevious() == null) str += BlockConfig.GENESIS_BLOCK;
        else str += block.getPrevious().getHash();
        str += block.getTimeStamp() + block.getDifficulty() + block.getNonce();
        return CommonUtils.sha256(str);
    }
    
    public Block mineBlock(Transaction transaction, Block previousConfirmedBlock, String MinerKey){
        Block block = new Block(MinerKey, transaction, previousConfirmedBlock);
        block.setHash(createHash(block));
        return block;
    }
}