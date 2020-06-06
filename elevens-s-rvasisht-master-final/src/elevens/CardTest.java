package elevens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import junit.framework.TestCase;

public class CardTest {
	
	//private static final Card C1 = new Card("ace", "spades", 1);
	//private static final Card C2 = new Card("ace", "spades", 1);
	//private static final Card C3 = new Card("king", "hearts", 0);

	@Test
	public void testCard1() {
		Card c = new Card();
		assertEquals(c.getRank(),"2");
		assertEquals(c.getSuit(),"hearts");
		assertEquals(c.getPointValue(),2);
	}
	
	@Test
	public void testCard2() {
		Card c = new Card("3","spades",1);
		assertEquals(c.getRank(),"3");
		assertEquals(c.getSuit(),"spades");
		assertEquals(c.getPointValue(),1);
	}
	
	@Test
	public void testCardEqualsFalse() {
		Card c1 = new Card("3","spades",1);
		Card c2 = new Card("2","spades",1);
		assertFalse(c1.matches(c2));
	}
	
	@Test
	public void testCardEqualsTrue() {
		Card c1 = new Card("2","spades",1);
		Card c2 = new Card("2","spades",1);
		assertTrue(c1.matches(c2));
	}
	
	@Test
	public void testToString() {
		Card c1 = new Card("2","spades",1);
		assertEquals(c1.toString(),"2 of spades (point value = 2)");
	}
	
}
