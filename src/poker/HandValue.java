package poker;

import java.util.Arrays;



public class HandValue {
	
	private int Scores;
	private Card[] allcards;
	private Card[][] combos;
	
	public HandValue(Card[] allcards){
		this.Scores = 0;
		this.allcards = allcards;
		this.combos = Combinations.combinations(allcards);	
		this.Scores+=Type15s(this.combos);
		this.Scores+=Typenobs(this.allcards);
		this.Scores+=TypeFlushes(this.allcards);
		this.Scores+=TypePairs(this.combos);
		this.Scores+=TypeRuns(this.combos);
	}
	
	//加所有组合的点数，如果夹起来为15，加2分（J、Q、K按照10来计算）
	private static int Type15s(Card[][] Fifteens){
		int score = 0;
		for(Card[] set:Fifteens){
			int sum =0;
			for(Card c:set){
				sum+=c.getCount();
			}
			if(sum==15){
				score+=2;
			}
		}
		return score;
	}
	
	//在所有只有两张牌的排列中，如果两张牌一样，加2分
	private static int TypePairs(Card[][] combos_Pairs){
		int score=0;
		for(Card[] set:combos_Pairs){
			if(set.length==2){
				if(set[0].getRankO()==set[1].getRankO()){
					score+=2;
				}
			}
		}
		return score;
	}
	
	//计算顺子的分数，三张牌或三张以上相连为顺子，返回的分数为（最大的连续数目*最大连续牌的组数）
	private static int TypeRuns(Card[][] combos_Runs){
		int score = 0;
		int maxlength = 0;
		for(Card[] set:combos_Runs){
			
			if(set.length>=3&&set.length>=maxlength){
				boolean run = true;
				int[] Rank= new int[set.length];
				for(int i=0;i<set.length;i++){
					Rank[i]=set[i].getRank();
				}
				Arrays.sort(Rank);
				for(int i=1;i<set.length;i++){
					if((Rank[i]-Rank[i-1])!=1){
						run = false;
						break;
					}
				}
				if(run&&set.length>maxlength){
					score =1 ;
					maxlength=set.length;
				}else if(run&&set.length==maxlength){
					score++;
				}
			}
		}
		return score*maxlength;
	}

	//这个地方会报错吧，c[o]应该是一个牌，比如6，然后c[0].getSuit() 就是6.charAt(1)，这个越界了啊，6只有charAt(0)
	//这个方法的意思应该是这些牌里有三个一样的，返回4分，有四个一样的，返回5分
	private static int TypeFlushes(Card[] c){
		
		int score = 0;
		//if(c[0].getSuit()==c[1].getSuit()&&c[1].getSuit()==c[2].getSuit()&&c[2].getSuit()==c[3].getSuit()){
		if(c[0].getRankO()==c[1].getRankO()&&c[1].getRankO()==c[2].getRankO()&&c[2].getRankO()==c[3].getRankO()){
			score = 4;
		}else if(c[0].getRankO()==c[1].getRankO()&&c[1].getRankO()==c[2].getRankO()&&c[2].getRankO()==c[3].getRankO()&&c[3].getRankO()==c[4].getSuit()){
			score = 5;
		}
		return score;
	}
	
	
	//同理，c[i].getSuit()会报错
	private static int Typenobs(Card[] c){
	
		int point = 0;
		for(int i=0;i<4;i++){
			if(c[i].getRankO()=='J'&&c[i].getSuit()==c[4].getSuit()){
				point = 1;
				break;
			}
		}
		return point;
	}
	

	public int getScores(){
		return Scores;
		}
	
	//计算分数
	public static void main(String[] args){
		String array[] = new String[]{"8","5","J","J","K"};
		Card[] Handcards = new Card[5];
		for(int i=0;i<5;i++){
			Handcards[i]= new Card(array[i]);
		}
		HandValue Handvalue = new HandValue(Handcards);
		System.out.println(Handvalue.getScores());
		
		
	}
	
}
