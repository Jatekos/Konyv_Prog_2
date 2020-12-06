package pokerhand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PokerHand {

	private Map<String, Integer> cardNumberToIntegerMap;
	private Map<Integer, String> cardItegerToCardNameMap;
	private List<PartialOrder> rules;

	public PokerHand() {
		cardNumberToIntegerMap = new HashMap<>();

		cardNumberToIntegerMap.put("T", 10);
		cardNumberToIntegerMap.put("J", 11);
		cardNumberToIntegerMap.put("Q", 12);
		cardNumberToIntegerMap.put("K", 13);
		cardNumberToIntegerMap.put("A", 14);

		cardItegerToCardNameMap = new HashMap<>();

		cardItegerToCardNameMap.put(10, "10");
		cardItegerToCardNameMap.put(11, "Jack");
		cardItegerToCardNameMap.put(12, "Queen");
		cardItegerToCardNameMap.put(13, "King");
		cardItegerToCardNameMap.put(14, "Ace");

		rules = new ArrayList<>();

		rules.add(new StraightFlushPartialOrder(new FlushPartialOrder(), new StraightPartialOrder()));
		rules.add(new FourOfAKindPartialOrder());
		rules.add(new FullHausePartialOrder());
		rules.add(new FlushPartialOrder());
		rules.add(new StraightPartialOrder());
		rules.add(new ThreeOfAKindPartialOrder());
		rules.add(new twoPairPartialOrder());
		rules.add(new onePairPartialOrder());
		rules.add(new highCardPartialOrder());
	}

	public String hiherHand(String firstHand, String secondHand) {

		String outputString = new String();

		Player firstPlayer = new Player(firstHand, rules);
		Player seconfPlayer = new Player(secondHand, rules);

		if (firstPlayer.getValueOfHand() == seconfPlayer.getValueOfHand()) {
			if (firstPlayer.getValueOfHandHighCard() == seconfPlayer.getValueOfHandHighCard()) {
				if (firstPlayer.getValueOfHighCard() == seconfPlayer.getValueOfHighCard()) {
					outputString = "Tie.";
				} else if (firstPlayer.getValueOfHighCard() > seconfPlayer.getValueOfHighCard()) {
					outputString = outputStringWriter(firstPlayer.getPlayerName(), rules.size() - 1,
							firstPlayer.getValueOfHighCard(), firstPlayer);
				} else {
					outputString = outputStringWriter(seconfPlayer.getPlayerName(), rules.size() - 1,
							seconfPlayer.getValueOfHighCard(), seconfPlayer);
				}
			} else if (firstPlayer.getValueOfHandHighCard() > seconfPlayer.getValueOfHandHighCard()) {
				outputString = outputStringWriter(firstPlayer.getPlayerName(), firstPlayer.getValueOfHand(),
						firstPlayer.getValueOfHandHighCard(), firstPlayer);
			} else {
				outputString = outputStringWriter(seconfPlayer.getPlayerName(), seconfPlayer.getValueOfHand(),
						seconfPlayer.getValueOfHandHighCard(), seconfPlayer);
			}
		} else if (firstPlayer.getValueOfHand() < seconfPlayer.getValueOfHand()) {
			outputString = outputStringWriter(firstPlayer.getPlayerName(), firstPlayer.getValueOfHand(),
					firstPlayer.getValueOfHandHighCard(), firstPlayer);
		} else {
			outputString = outputStringWriter(seconfPlayer.getPlayerName(), seconfPlayer.getValueOfHand(),
					seconfPlayer.getValueOfHandHighCard(), seconfPlayer);
		}

		return outputString;
//
//		String[] firstName = firstHand.split(":");
//		String[] firstHandCards = firstName[1].trim().split(" ");
//
//		String[] secondName = secondHand.split(":");
//		String[] secondHandCards = secondName[1].trim().split(" ");
//
//		String outputString = new String();
//
//		List<Card> firstHandList = creatListFromString(firstHandCards);
//		List<Card> secondHandList = creatListFromString(secondHandCards);
//
//		firstHandList.sort(null);
//		secondHandList.sort(null);
//
//		if (containExactlyOnePair(firstHandList) && containExactlyOnePair(secondHandList)) {
//			Integer firstHighCard = getHighCardFromPair(firstHandList);
//			Integer secondHighCard = getHighCardFromPair(secondHandList);
//
//			if (firstHighCard > secondHighCard) {
//
//				outputString = outputStringCratorForOnePair(firstName[0], firstHighCard);
//
//			} else if (firstHighCard < secondHighCard) {
//
//				outputString = outputStringCratorForOnePair(secondName[0], secondHighCard);
//
//			} else {
//				firstHighCard = getHighCard(firstHandList);
//				secondHighCard = getHighCard(secondHandList);
//
//				if (firstHighCard > secondHighCard) {
//
//					outputString = outputStringCratorForHighCard(firstName[0], firstHighCard);
//
//				} else if (firstHighCard < secondHighCard) {
//
//					outputString = outputStringCratorForHighCard(secondName[0], secondHighCard);
//
//				} else {
//					outputString = "Tie.";
//				}
//			}
//
//		} else if (containExactlyOnePair(firstHandList)) {
//			outputString = outputStringCratorForOnePair(firstName[0], getHighCardFromPair(firstHandList));
//
//		} else if (containExactlyOnePair(secondHandList)) {
//			outputString = outputStringCratorForOnePair(secondName[0], getHighCardFromPair(secondHandList));
//		} else {
//
//			Integer firstHighCard = getHighCard(firstHandList);
//			Integer secondHighCard = getHighCard(secondHandList);
//
//			if (firstHighCard > secondHighCard) {
//
//				outputString = outputStringCratorForHighCard(firstName[0], firstHighCard);
//
//			} else if (firstHighCard < secondHighCard) {
//
//				outputString = outputStringCratorForHighCard(secondName[0], secondHighCard);
//
//			} else {
//				outputString = "Tie.";
//			}
//		}
//		return outputString;

	}

	private String outputStringWriter(String playerName, Integer valueOfHand, Integer highCardValue, Player player) {
		// TODO Auto-generated method stub
		String card;
		if (cardItegerToCardNameMap.containsKey(highCardValue)) {
			card = cardItegerToCardNameMap.get(highCardValue);
		} else {
			card = highCardValue.toString();
		}

		if (rules.get(valueOfHand).getName().equals("full house")) {
			return playerName + " wins. - with " + rules.get(valueOfHand).getName() + ": "
					+ player.getValueOfHandHighCard() + " over " + player.getValueOfHighCard();
		}

		return playerName + " wins. - with " + rules.get(valueOfHand).getName() + ": " + card;
	}

//	private List<Card> creatListFromString(String[] hand) {
//		return Arrays.stream(hand).map(card -> new Card(String.valueOf(card.charAt(0)))).collect(Collectors.toList());
//	}
//
//	private Integer getHighCard(List<Card> hand) {
//
//		int highCard = 0;
//
//		for (Card card : hand) {
//			Integer actual = card.getNumberInInteger();
//
//			if (actual > highCard) {
//				highCard = actual;
//			}
//
//			if (highCard == 0) {
//				throw new RuntimeException("Somtin wrong in HigCard");
//			}
//		}
//		return highCard;
//
//	}
//
//	private boolean containExactlyOnePair(List<Card> hand) {
//
//		boolean contain = false;
//		for (int i = 1; i < hand.size(); i++) {
//			if (!contain) {
//				if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
//					contain = true;
//				}
//			} else {
//				if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
//					return false;
//				}
//			}
//		}
//
//		return contain;
//	}
//
//	private Integer getHighCardFromPair(List<Card> hand) {
//		boolean contain = false;
//		int i = 1;
//		while (!contain && (i < hand.size())) {
//			if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
//				contain = true;
//			}
//			i++;
//		}
//
//		return hand.get(i - 1).getNumberInInteger();
//	}
//
//	/*
//	 * private Integer getCardValue(String[] hand, int index) { return
//	 * Integer.parseInt(String.valueOf((hand[index].charAt(0)))); }
//	 */
//	private String outputStringCratorForHighCard(String winner, Integer number) {
//
//		String numberString;
//
//		if (cardItegerToCardNameMap.containsKey(number)) {
//			numberString = cardItegerToCardNameMap.get(number);
//		} else {
//			numberString = number.toString();
//		}
//
//		return winner + " wins. - with high card: " + numberString;
//	}
//
//	private String outputStringCratorForOnePair(String winner, Integer number) {
//		String numberString;
//
//		if (cardItegerToCardNameMap.containsKey(number)) {
//			numberString = cardItegerToCardNameMap.get(number);
//		} else {
//			numberString = number.toString();
//		}
//
//		return winner + " wins. - with pair: " + numberString;
//	}

	private class Card implements Comparable<Card> {

		public String getSuit() {
			return suit;
		}

		// String Suit;
		private String number;
		private String suit;

		public Card(String number, String suit) {

			this.number = number;
			this.suit = suit;
		}

		public String getNumber() {
			return number;
		}

		@Override
		public String toString() {
			return "Card [number=" + number + "suit=" + suit + "]";
		}

		public Integer getNumberInInteger() {

			Integer actual;

			Pattern pattern = Pattern.compile("\\d");

			if (pattern.matcher(number).matches()) {
				actual = Integer.valueOf(number);
			} else if (cardNumberToIntegerMap.containsKey(number)) {

				actual = cardNumberToIntegerMap.get(number);

			} else {
				throw new RuntimeException("wrong number of card" + this.toString());

			}

			return actual;

		}

		public void setNumber(String number) {
			this.number = number;
		}

		@Override
		public int compareTo(Card o) {
			// TODO Auto-generated method stub
			return this.getNumberInInteger().compareTo(o.getNumberInInteger());
		}

	}

	private class Player {

		private String playerName;
		private List<Card> hand;
		private Integer valueOfHand;
		private Integer valueOfHandHighCard;
		private Integer valueOfHighCard;
		private List<PartialOrder> rules;

		public Player(String data, List<PartialOrder> rules) {

			super();
			String[] splitedData = data.split(":");
			this.playerName = splitedData[0];
			this.hand = creatHand(splitedData[1]);
			this.rules = rules;
			createValues();

		}

		private List<Card> creatHand(String handInString) {
			List<Card> hand = new ArrayList<>(Arrays.stream(handInString.trim().split(" "))
					.map(card -> new Card(String.valueOf(card.charAt(0)), String.valueOf(card.charAt(1))))
					.collect(Collectors.toList()));
			hand.sort(null);
			return hand;
		}

		private void createValues() {
			setValueOfHand(createValueOfHand(hand));
			setValueOfHandHighCard(rules.get(valueOfHand).getValueOfHighCardFromOrder(hand));
			setValueOfHighCard(rules.get(valueOfHand).getValueOfHighCardOutsideOrder(hand));

		}

		private Integer createValueOfHand(List<Card> hand2) {
			// TODO Auto-generated method stub
			for (PartialOrder rule : rules) {
				if (rule.isItAplayAble(hand2)) {
					return rules.indexOf(rule);
				}
			}

			throw new RuntimeException("There was no aplaiable rule");
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public List<Card> getHand() {
			return hand;
		}

		public void setHand(List<Card> hand) {
			this.hand = hand;
		}

		public Integer getValueOfHand() {
			return valueOfHand;
		}

		public void setValueOfHand(Integer valueOfHand) {
			this.valueOfHand = valueOfHand;
		}

		public Integer getValueOfHandHighCard() {
			return valueOfHandHighCard;
		}

		public void setValueOfHandHighCard(Integer valueOfHandHighCard) {
			this.valueOfHandHighCard = valueOfHandHighCard;
		}

		public Integer getValueOfHighCard() {
			return valueOfHighCard;
		}

		public void setValueOfHighCard(Integer valueOfHighCard) {
			this.valueOfHighCard = valueOfHighCard;
		}

	}

	private interface PartialOrder {
		boolean isItAplayAble(List<Card> hand);

		Integer getValueOfHighCardFromOrder(List<Card> hand);

		Integer getValueOfHighCardOutsideOrder(List<Card> hand);

		String getName();
	}

	private class onePairPartialOrder implements PartialOrder {

		String name = "pair";

		@Override
		public boolean isItAplayAble(List<Card> hand) {

			boolean contain = false;
			for (int i = 1; i < hand.size(); i++) {
				if (!contain) {
					if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
						contain = true;
					}
				} else {
					if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
						return false;
					}
				}
			}

			return contain;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {
			boolean contain = false;
			int i = 1;
			while (!contain && (i < hand.size())) {
				if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
					contain = true;
				}
				i++;
			}

			return hand.get(i - 1).getNumberInInteger();
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			boolean contain = false;
			int i = 1;
			while (!contain && (i < hand.size())) {
				if (0 == hand.get(i).compareTo(hand.get(i - 1))) {
					contain = true;
				}
				i++;
			}

			hand.remove(i - 1);
			hand.remove(i - 2);

			int highCard = 0;

			for (Card card : hand) {
				Integer actual = card.getNumberInInteger();

				if (actual > highCard) {
					highCard = actual;
				}

				if (highCard == 0) {
					throw new RuntimeException("Somtin wrong in HigCard");
				}
			}
			return highCard;

		}

	}

	private class highCardPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {

			int highCard = 0;

			for (Card card : hand) {
				Integer actual = card.getNumberInInteger();

				if (actual > highCard) {
					highCard = actual;
				}

				if (highCard == 0) {
					throw new RuntimeException("Somtin wrong in HigCard");
				}
			}
			return highCard;
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {

			int highCard = 0;

			for (Card card : hand) {
				Integer actual = card.getNumberInInteger();

				if (actual > highCard) {
					highCard = actual;
				}

				if (highCard == 0) {
					throw new RuntimeException("Somtin wrong in HigCard");
				}
			}
			return highCard;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "high card";
		}
	}

	private class twoPairPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			Integer numberOfpair = 0;
			Integer index = 1;

			while ((index < hand.size())) {
				if (0 == hand.get(index).compareTo(hand.get(index - 1))) {
					if (index < hand.size() - 1) {
						if (0 == hand.get(index).compareTo(hand.get(index + 1))) {
							return false;
						} else {
							numberOfpair++;
						}
					} else {
						numberOfpair++;
					}

				}
				index++;
			}

			if (numberOfpair == 2) {
				return true;

			} else {
				return false;
			}

		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {

			Integer numberOfpair = 0;
			Integer index = 1;
			Integer value = 0;
			while ((index < hand.size())) {
				if (0 == hand.get(index).compareTo(hand.get(index - 1))) {

					if (value < hand.get(index).getNumberInInteger()) {
						value = hand.get(index).getNumberInInteger();
					}
				}

				index++;
			}

			return value;
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub

			Integer value = 0;

			for (int i = 0; i < hand.size(); i++) {
				boolean t = true;
				Integer actualCard = hand.get(i).getNumberInInteger();
				List<Card> actualHand = new ArrayList<Card>(hand);
				value = actualHand.get(i).getNumberInInteger();
				actualHand.remove(i);

				for (int j = 0; j < actualHand.size(); j++) {
					if (actualCard == actualHand.get(j).getNumberInInteger()) {
						t = false;
						break;
					}
				}
				if (t) {
					break;
				}
			}
			return value;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "two pair";
		}

	}

	private class ThreeOfAKindPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			boolean contians = false;
			List<Card> curentHand = new ArrayList<>(hand);
			for (int i = 3; i < curentHand.size(); i++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {
					contians = true;
					curentHand.remove(i);
					curentHand.remove(i - 1);
					curentHand.remove(i - 2);
				}
				if (0 == curentHand.get(0).compareTo(hand.get(1))) {
					contians = false;
				}
			}

			return contians;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> curentHand) {
			// TODO Auto-generated method stub
			Integer value = 0;
			for (int i = 3; i < curentHand.size(); i++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {

					value = curentHand.get(i).getNumberInInteger();
				}
			}

			return value;
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			Integer value = 0;
			List<Card> curentHand = new ArrayList<>(hand);
			for (int i = 3; i < curentHand.size(); i++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {

					curentHand.remove(i);
					curentHand.remove(i - 1);
					curentHand.remove(i - 2);
				}
			}

			if (0 < curentHand.get(0).compareTo(hand.get(1))) {
				value = curentHand.get(0).getNumberInInteger();
			} else {
				value = curentHand.get(1).getNumberInInteger();
			}
			return value;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "three of a kind";
		}

	}

	private class StraightPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			boolean contains = true;

			Integer previous = hand.get(0).getNumberInInteger();

			for (int i = 1; i < hand.size(); i++) {
				if ((previous + 1) != hand.get(i).getNumberInInteger()) {
					contains = false;
					break;
				}
				previous = hand.get(i).getNumberInInteger();
			}

			return contains;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return hand.get(4).getNumberInInteger();
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "straight";
		}

	}

	private class FlushPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub

			String suit = hand.get(0).getSuit();

			boolean contains = true;
			for (int i = 1; i < hand.size(); i++) {
				if (!(suit.equals(hand.get(i).getSuit()))) {
					contains = false;
					break;
				}
			}

			return contains;

		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return hand.get(4).getNumberInInteger();
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "flush";
		}
	}

	private class FullHausePartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			int i = 3;
			List<Card> curentHand = new ArrayList<>(hand);

			for (int j = 0; j < 2; j++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {

					curentHand.remove(i);
					curentHand.remove(i - 1);
					curentHand.remove(i - 2);

					if (0 == curentHand.get(0).compareTo(hand.get(1))) {
						return true;
					} else {
						return false;
					}

				}
				i = 4;
			}

			return false;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> curentHand) {
			// TODO Auto-generated method stub
			int i = 3;
			for (int j = 0; j < 2; j++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {
					return curentHand.get(i).getNumberInInteger();

				}
				i = 4;
			}
			return null;
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			int i = 3;
			List<Card> curentHand = new ArrayList<>(hand);

			for (int j = 0; j < 2; j++) {
				if ((0 == curentHand.get(i).compareTo(curentHand.get(i - 1)))
						&& 0 == curentHand.get(i).compareTo(curentHand.get(i - 2))) {

					curentHand.remove(i);
					curentHand.remove(i - 1);
					curentHand.remove(i - 2);

					if (0 == curentHand.get(0).compareTo(hand.get(1))) {
						return curentHand.get(0).getNumberInInteger();
					}

				}
				i = 4;
			}
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "full house";
		}

	}

	private class FourOfAKindPartialOrder implements PartialOrder {

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub

			boolean contains = true;

			for (int j = 0; j < 2; j++) {
				contains = true;
				Integer value = hand.get(j).getNumberInInteger();
				for (int i = 1 + j; i < 4 + j; i++) {
					if (value != hand.get(i).getNumberInInteger()) {
						contains = false;
						break;
					}
				}
				if (contains)
					return true;
			}
			return contains;
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {
			// TODO Auto-generated method stub

			if (hand.get(0).getNumberInInteger() == hand.get(1).getNumberInInteger())
				return hand.get(0).getNumberInInteger();

			return hand.get(1).getNumberInInteger();
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "four of a kind";
		}

	}

	private class StraightFlushPartialOrder implements PartialOrder {

		PartialOrder flush;
		PartialOrder straight;

		public StraightFlushPartialOrder(PartialOrder flush, PartialOrder straight) {
			super();
			this.flush = flush;
			this.straight = straight;
		}

		@Override
		public boolean isItAplayAble(List<Card> hand) {
			// TODO Auto-generated method stub
			return flush.isItAplayAble(hand) && straight.isItAplayAble(hand);
		}

		@Override
		public Integer getValueOfHighCardFromOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return hand.get(4).getNumberInInteger();
		}

		@Override
		public Integer getValueOfHighCardOutsideOrder(List<Card> hand) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "straight flush";
		}

	}

}