package pokerhand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPokerhand {

	@Test
	public void testPokerHandGiveBackTheHighCardWiner() {

		// Given
		String black = "Black: 2H 3H 4H 5H 7D";
		String white = "White: 2H 3H 4H 5H 8D";
		String expected = "White wins. - with high card: 8";

		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}

	@Test
	public void testPokerHandShuldGiveBackTheHighCardWhinierWhenCardisString() {
		// Given
		String black = "Black: AH 3H 4H 5H 6D";
		String white = "White: 2H 3H 4H 5H 7D";
		String expected = "Black wins. - with high card: Ace";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testTie() {
		// Given
				String black = "Black: 2H 3H 4H 5H 7D";
				String white = "White: 2H 3H 4H 5H 7D";
				String expected = "Tie.";
				PokerHand hands = new PokerHand();
				// When
				String actual = hands.hiherHand(black, white);
				// Then
				assertEquals(expected, actual);
		
	}

	@Test
	public void testPokerHandShuoldGiveBackPairWhenTheAthoreHasNothing() {
		// Given
		String black = "Black: 3H 3H 4H 5H 6D";
		String white = "White: 2H 3H 4H 5H 7D";
		String expected = "Black wins. - with pair: 3";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	
	@Test
	public void testPokerHandShuoldGiveBackTheHigerPairWhenBothHasPair() {
		// Given
		String black = "Black: 1H 2H 3H 5H 3D";
		String white = "White: 2H 2H 4H 5H 7D";
		String expected = "Black wins. - with pair: 3";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}

	@Test
	public void testPokerHandShuoldGiveBackTheHigerCardWhenBothHasTheSamePair() {
		// Given
		String black = "Black: 9H JH 4H 5H 4D";
		String white = "White: 2H JH 4H JH 7D";
		String expected = "White wins. - with pair: Jack";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheHigerPairWhenBothHasPairAndOneIsJackPair() {
		// Given
		String black = "Black: 9H JH 4H 5H JD";
		String white = "White: 2H JH JH 5H 7D";
		String expected = "Black wins. - with high card: 9";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheTwoPairWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 5H JH 4H 5H JD";
		String white = "White: 2H 3H 4H 5H 8D";;
		String expected = "Black wins. - with two pair: Jack";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheTwoPairWinerwhitHighPairWehnOnePairIsIdentical() {
		// Given
		String black = "Black: 5H JH 4H 5H JD";
		String white = "White: 5H 3H 4H 5H 4D";;
		String expected = "Black wins. - with two pair: Jack";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheWinerWhitHighCardWehnBothHasTheSameTwoPair() {
		// Given
		String black = "Black: 5H KH 4H 5H KD";
		String white = "White: 5H KH AH 5H KD";;
		String expected = "White wins. - with high card: Ace";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheThreeOfAKindWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 5H 5H 4H 5H JD";
		String white = "White: 2H 3H 4H 5H 8D";;
		String expected = "Black wins. - with three of a kind: 5";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheThreeOfAKindWinerwhitHighkTheThreeOfAKindwhenBothHasTreeOfAKind() {
		// Given
		String black = "Black: 5H JH 4H JH JD";
		String white = "White: 5H 3H 5H 5H 4D";;
		String expected = "Black wins. - with three of a kind: Jack";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTheWinerWhitHighCardWehnBothHasTheSameThreeOfAKind() {
		// Given
		String black = "Black: KH KH 4H 5H KD";
		String white = "White: KH KH 6H 5H KD";;
		String expected = "White wins. - with high card: 6";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTieWehnBothHasTheSameCards() {
		// Given
		String black = "Black: KH KH 4H 5H KD";
		String white = "White: KH KH 4H 5H KD";;
		String expected = "Tie.";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackStraightWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 2H 3H 4H 5H 6D";
		String white = "White: 2H 3H 4H 5H 8D";;
		String expected = "Black wins. - with straight: 6";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTStraightWinerwhitHigherStraightWhenBothHasStraight() {
		// Given
		String black = "Black: 6H 5H 4H 7H 8D";
		String white = "White: 3H 4H 5H 6H 7D";;
		String expected = "Black wins. - with straight: 8";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTeiWhitHighCardWehnBothHasTheSameStraight() {
		// Given
		String black = "Black: 2H 3H 4H 5H 6D";
		String white = "White: 2H 3H 4H 5H 6D";;
		String expected = "Tie.";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFlushWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 2H 3H 4H 5H TH";
		String white = "White: 2H 3H 4H 5H AD";;
		String expected = "Black wins. - with flush: 10";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFlushWinerWhitHigherFlushWhenBothHasFlush() {
		// Given
		String black = "Black: 6H 5H 2H 7H 8H";
		String white = "White: 3D 4D TD 6D 7D";;
		String expected = "White wins. - with flush: 10";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackTeiWhitHighCardWehnBothHasTheSameFlushs() {
		// Given
		String black = "Black: 2H 3H 4H 5H 6H";
		String white = "White: 2D 3D 4D 5D 6D";;
		String expected = "Tie.";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFullHousehWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 2H 4S 4C 2D 4H";
		String white = "White: 2S 8S AS QS 3S";;
		String expected = "Black wins. - with full house: 4 over 2";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFullHouseWinerWhitHigherFullHouseWhenBothHasFullHouse() {
		// Given
		String black = "Black: 3H 2H 3H 2F 3H";
		String white = "White: 4D 5D 4D 5G 5D";;
		String expected = "White wins. - with full house: 5 over 4";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFourOfAKindWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 2H 2S 2C 2D 4H";
		String white = "White: 2S 8S AS QS 3S";;
		String expected = "Black wins. - with four of a kind: 2";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black,white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackFourOfAKindWinerWhitHigherFourOfAKindWhenBothHasFourOfAKind() {
		// Given
		String black = "Black: AH AH AH AF 3H";
		String white = "White: KD KD KD KG 5D";;
		String expected = "Black wins. - with four of a kind: Ace";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	
	@Test
	public void testPokerHandShuoldGiveBackStraightFlushWinerWehnTheNotherHasNoting() {
		// Given
		String black = "Black: 1H 2H 3H 4H 5H";
		String white = "White: 2S 8S AS QS 3S";;
		String expected = "Black wins. - with straight flush: 5";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black,white);
		// Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testPokerHandShuoldGiveBackStraightFlushWinerWhitHigherStraightFlushWhenBothHasStraightFlush() {
		// Given
		String black = "Black: 1H 2H 3H 4H 5H";
		String white = "White: 2H 3H 4H 5H 6H";;
		String expected = "White wins. - with straight flush: 6";
		PokerHand hands = new PokerHand();
		// When
		String actual = hands.hiherHand(black, white);
		// Then
		assertEquals(expected, actual);

	}
	
	
	
	
	
}
