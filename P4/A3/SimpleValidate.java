public class SimpleValidate implements IValidateMethod{
    public boolean validate(IMiningMethod miningMethod, Block block){
        return(miningMethod.createHash(block).equals(block.getHash()));
    }
}