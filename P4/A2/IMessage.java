public interface IMessage{
    public String getMessage();
    public default void process(Node n){
        System.out.println("[" + n.fullname() + "]" +
                           " - Received notification - Nex Tx: " +
                           this.getMessage());
    }
}