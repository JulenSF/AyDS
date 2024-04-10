package A3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesterMainExercise2Test {

	@Test
	void testMain() {
        TesterMainExercise3 tme = new TesterMainExercise3();
        tme.buildNetwork();
        tme.createTransactions();
        assertEquals(tme.miningNode.miningMethod, SimpleMining);
	}

}