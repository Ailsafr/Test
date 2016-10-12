package replace;

public class TestReplaceAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "sss'sss";
		System.out.println(str.replaceAll("\'","\\\\'"));   //\\\\'->\\'->\'
	}

}
