package tester;
import registration.*;
import static registration.RegistrationKind.*;

public class TesterRepeatedObjects extends TesterStateChanges{
    public static void main(String[] args) {
        TesterRepeatedObjects tsc = new TesterRepeatedObjects();
        tsc.createRegistrations();
        tsc.regState.addObjects(new Registration("Ann Smith", STUDENT)); // Discarded, since repeated
        System.out.println(tsc.regState);
    }
}
