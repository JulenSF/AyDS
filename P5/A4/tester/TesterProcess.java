package tester;
import static registration.RegistrationKind.*;
import state_tracker.*;
import state_tracker.Process;
import registration.*;

public class TesterProcess extends TesterTrajectories{
    public static void main(String[] args) {
        TesterProcess tsc = new TesterProcess();
        tsc.createRegistrations();
        tsc.changeRegistrations();
        tsc.displayTrajectories();
        tsc.buildProcess();
    }
    @Override
    protected void changeRegistrations() {
        super.changeRegistrations();
        this.lisaMartin.setValidated(true);
        this.regState.updateStates();
        this.lisaMartin.pay(MEMBER.getPrice());
        this.regState.updateStates();
    }
    protected void buildProcess() {
        Process<RegistrationState> regProcess = new Process<>(RegistrationState.values());
        for (Registration r : this.regState) // iterates on all Registrations
            regProcess.add(this.regState.trajectory(r));
        System.out.println(regProcess);
    }
}