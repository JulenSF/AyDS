package A3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesterMainExercise2Test {

	@Test
	void testMain() {
        TesterMainExercise2 tme = new TesterMainExercise2();
        assertThrows(ConnectionException.class, ()->{tme.buildFaultyNetwork()});
        assertThrows(TransactionException.class, ()->{tme.createTransactions()});
	}

}
