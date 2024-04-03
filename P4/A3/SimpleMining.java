public class SimpleMining implements IMiningMethod{
    public String createHash(Block block){
        return CommonUtils.sha256(block.getVersion() + (block.getPrevious() == null)? BlockConfig.GENESIS_BLOCK: block.getPrevious().getHash() 
                                  + block.getTimeStamp() + block.getDifficulty() + block.getNonce());
    }
    
    public Block mineBlock(Transaction transaction, Block previousConfirmedBlock, String MinerKey){
        Block block = new Block(MinerKey, transaction, previousConfirmedBlock);
        block.setHash(createHash(block));
        return block;
    }
}