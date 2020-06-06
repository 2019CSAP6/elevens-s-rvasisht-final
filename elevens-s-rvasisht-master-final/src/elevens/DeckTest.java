package elevens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeckTest {
	
	@Test
	public void testDeckContents() {
		String[] ranksArr = {"A", "B"};
		String[] suitsArr  = {"Cats"};
		int[] pointValueArr = {1, 2};
		Card a1 = new Card("A","Cats",1);
		Card a2 = new Card("A","Cats",2);
		Card b1 = new Card("B","Cats",1);
		Card b2 = new Card("B","Cats",2);
		
		// ["A","Cats",1]["B,"Cats",2]["B","Cats","1"]["B","Cats",2]
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		for (int i = 0; i< d.getDeck().size(); i++) {
			assertTrue(
					d.getDeck().get(i).matches(a1) ||
					d.getDeck().get(i).matches(a2) ||
					d.getDeck().get(i).matches(b1) ||
					d.getDeck().get(i).matches(b2)
				);	
		}
		
	}

	@Test
	public void testDeckSize() {
		String[] ranksArr = {"A", "B"};
		String[] suitsArr  = {"Cats"};
		int[] pointValueArr = {1, 2};
		
		// ["A","Cats",1]["B,"Cats",2]["B","Cats","1"]["B","Cats",2]
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		assertEquals(d.size(),4);		
	}

	@Test
	public void testDeckException() {
		String[] ranksArr = {"A"};
		String[] suitsArr  = {"Cats"};
		int[] pointValueArr = {1, 2};
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
	    });
	 
	    String expectedMessage = "Ranks must be paired up with values";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
		
	}


	@Test	
	public void testIsEmpty1() {
		String[] ranksArr = {"A"};
		String[] suitsArr  = {"Dogs"};
		int[] pointValueArr = {1};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		assertEquals(d.isEmpty(), false);
	}
	
	@Test
	public void testIsEmpty2() {
		String[] ranksArr = {};
		String[] suitsArr  = {};
		int[] pointValueArr = {};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		assertEquals(d.isEmpty(), true);
	}
	

	@Test
	public void testSize2() {
		String[] ranksArr = {"A", "B", "C", "D", "E", "F", "G", "H"};
		String[] suitsArr  = {"Cats", "Dogs", "Pig", "Sheep"};
		int[] pointValueArr = {1, 2, 3, 4, 5, 6, 7, 8};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		assertEquals(d.size(), 32);
		
	}
	
	@Test
	public void testShuffle1a() {
		String[] ranksArr = {"A", "B", "C", "D", "E"};
		String[] suitsArr  = {"Cats", "Dogs"};
		int[] pointValueArr = {1, 2, 3, 4, 5};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		String beforeShuffle = d.toString();
		d.shuffle();
		assertFalse(d.toString().equals(beforeShuffle));
	}
	
	@Test
	public void testShuffle1b() {
		String[] ranksArr = {"A", "B", "C", "D", "E"};
		String[] suitsArr  = {"Cats", "Dogs"};
		int[] pointValueArr = {1, 2, 3, 4, 5};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		int beforeShuffle = d.size();
		d.shuffle();
		assertEquals(d.size(), beforeShuffle);
	}
	
	@Test
	public void testShuffle2a() {
		String[] ranksArr = {"A", "B", "C", "D", "E"};
		String[] suitsArr  = {"Cats", "Dogs"};
		int[] pointValueArr = {1, 2, 3, 4, 5};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		for(int i = 0; i < 5; i++) {
			d.deal();
		}
		String beforeShuffle = d.toString();
		d.shuffle();
		assertTrue(d.toString().equals(beforeShuffle));
	}
	
	@Test
	public void testShuffle2b() {
		String[] ranksArr = {"A", "B", "C", "D", "E"};
		String[] suitsArr  = {"Cats", "Dogs"};
		int[] pointValueArr = {1, 2, 3, 4, 5};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		int beforeDeal = d.size();
		for(int i = 0; i < 5; i++) {
			d.deal();
		}
		assertFalse(d.size() == beforeDeal);
	}
	
	@Test
	public void testDeal1a() {
		String[] ranksArr = {"A"};
		String[] suitsArr  = {"Cats"};
		int[] pointValueArr = {1};
		Deck d = new Deck(ranksArr, suitsArr, pointValueArr);
		Card c = new Card("A", "Cats", 1);
		assertEquals(d.deal(), c);
	}
	
}
