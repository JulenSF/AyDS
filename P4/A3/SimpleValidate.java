public class SimpleValidate implements IValidateMethod{
    public boolean validate(IMiningMethod miningMethod, Block block){
        block.setValido(miningMethod.createHash(block).equals(block.getHash()));
    }
}