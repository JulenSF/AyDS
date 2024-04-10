package A3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.utils.*
class TesterMainExercise1Test {
 
	@Test
	void testMain() {
        TesterMainExercise1 tme = new TesterMainExercise1();
        tme.buildNetwork();
        assertNotNull(tme.wallet1);
        assertNotNull(tme.wallet2);
        assertNotNull(tme.wallet3);
        assertEquals(tme.wallet1.userName,"Bob");
        assertEquals(tme.wallet1.key,CommonUtils.sha1("PK-Bob"));
        assertEquals(tme.wallet3.balance,777);
        assertEquals(tme.wallet2.balance,110);
        assertNotNull(tme.node);
        assertNotNull(tme.miningNode);
        assertNotNull(tme.miningNode2);
        assertNotNull(tme.subnet);
        assertNotNull(tme.network);
	}

}
