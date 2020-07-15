//I created 4 parser objects for the 4 test files 


public class TestParser1 { 
		public static void main(String[] args) {
			Tokenstream ts = new ZeroOnescan("C:\\Users\\chris\\OneDrive\\Desktop\\test1.pas.txt");
			parser1 p = new parser1(ts);
			System.out.println(p.parse());   
			
			Tokenstream ts1 = new ZeroOnescan("C:\\Users\\chris\\OneDrive\\Desktop\\test2.pas.txt");
			parser1 p1 = new parser1(ts1);
			System.out.println(p1.parse()); 
			
			Tokenstream ts2 = new ZeroOnescan("C:\\Users\\chris\\OneDrive\\Desktop\\test3.pas.txt");
			parser1 p2 = new parser1(ts2);
			System.out.println(p2.parse()); 
			
			Tokenstream ts3 = new ZeroOnescan("C:\\Users\\chris\\OneDrive\\Desktop\\test4.pas.txt");
			parser1 p3 = new parser1(ts3);
			System.out.println(p3.parse()); 
			
			
	}
}
