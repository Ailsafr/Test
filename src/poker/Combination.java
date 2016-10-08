package poker;

import java.lang.reflect.Array;

public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String array[] = new String[] {"1","2","3","4","5"};
		String[][] result = combinations(array);
		for(int i=0;i<result.length;i++){
			System.out.println(i);
			for(int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]);
				System.out.print("  ");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] combinations(T[] list) {
        T[][] combos = (T[][])Array.newInstance(list.getClass(),(int) Math.pow(2, list.length));   //数组类型是list的元素类型，长度是2的list.length次幂
        
        for (int i = 0 ; i < combos.length ; ++i) {
            int count = 0;
            for (int j = 0 ; j < list.length ; ++j) {
                if ((i & 1<<j) != 0) ++count;
            }
            combos[i] = (T[])Array.newInstance(list.getClass().getComponentType(), count);
            count = 0;
            for (int j = 0 ; j < list.length ; ++j) {
                if ((i & 1<<j) != 0) {
                    combos[i][count] = list[j];
                    ++count;
                }
            }
        }
        return combos;
    }

}
