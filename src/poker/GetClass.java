package poker;

public class GetClass {
	
	public static void main(String[] args){
		String array[] = new String[] {"1","2","3"};
		System.out.println(array.getClass());
		System.out.println(array.getClass().getComponentType());
	}

}
