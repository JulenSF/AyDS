public class ConnectionException extends Exception {
    String message;
    public ConnectionException(String message) {
        this.message = "\u001B[31mConnectionException: " + message + "\u001B[0m";
    }

    @Override
    public String toString(){
        return this.message;
    }
}