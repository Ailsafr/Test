package poker;

public class Card {
	/**first in first this variables of the cards has been set, 
	 * the ordinal represents the regular succession of each card Rank and 
	 * the faceValue represents the number of each card
	 * @switch means make each card rank to the relevant ordinal and finally link to the represent faceValue
	 * @default when the ordinal change to the faceValue of the card, it would first turns to
	 * ASCII code, so it should subtracted 48 to become the faceValue
	 */
	private char RankO;
	private char Suit;
	private int Rank;
	private int Count;
	
	public Card(String card){
		this.RankO = card.charAt(0);
		//this.Suit = card.charAt(1);
		
		switch(RankO){
		case 'A':
			this.Rank = 1;
			break;
		case 'T':
			this.Rank = 10;
			break;
		case 'J':
			this.Rank = 11;
			break;
		case 'Q':
			this.Rank = 12;
			break;
		case 'K':
			this.Rank = 13;
			break;
		default:
			this.Rank = Integer.valueOf(RankO)-48;      //因为RankO是char型的，所以-48，如果是string，可以直接Integer.valueOf(RankO)
			break;
		}
		this.Count = Math.min(this.Rank, 10);
	}
	
	public char getRankO(){
		return this.RankO;
		}
	
	public char getSuit(){
		return this.Suit;
		}
	
	public int getRank(){
		return this.Rank;
		}
	
	public int getCount(){
		return this.Count;
		}
		
	
}