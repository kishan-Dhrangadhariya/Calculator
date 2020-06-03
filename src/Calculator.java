import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int Add(String numbers) throws IOException, NegativeNumberException{
		if(numbers.length() == 0) {
			return 0;
		}
		else if(numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
			int in = numbers.indexOf("\n");
			String del = numbers.substring(2, in), del2=null;
		
			if(numbers.charAt(2) != '[') {
				del2 = numbers.substring(2,3);
			}
			else {
				
				StringBuilder builder = new StringBuilder(); //
				
				Pattern regex = Pattern.compile("\\[(.*?)\\]");
				Matcher regexMatcher = regex.matcher(del);
				builder.append("[");
				while (regexMatcher.find()) {
					builder.append(regexMatcher.group(1));
					builder.append(" ");
				}
				builder.append("]+");
				del2 = builder.toString();
			}
			numbers = numbers.substring(in+1, numbers.length());
			System.out.println("del2 = " +del2);
			System.out.println("numbers = " +numbers);
			String[] split = numbers.split(del2);
			int n = split.length;
			int sum=0, num;
			
			for(int i=0;i<n;i++) {
				try {
					System.out.println(i + " = "+ split[i] );
					num = Integer.parseInt(split[i]);
					
					if(num > 1000) 
						continue;
					if(num < 0) {
						throw new NegativeNumberException();
					}
					sum += num;
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
			}
			System.out.println(numbers + " " + sum);
			return sum;
		}
		else if(numbers.contains(",")) {
			String del = ",|\\\n";
			String[] split = numbers.split(del);
			int n = split.length;
			int sum=0, num;
			for(int i=0;i<n;i++) {
				try {
					num = Integer.parseInt(split[i]);
					if(num > 1000) 
						continue;
					if(num < 0) {
						throw new NegativeNumberException();
					}
					sum += num;
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
			}
			System.out.println(numbers + " " + sum);
			return sum;	
		}
		else {
			try {
				int num = Integer.parseInt(numbers);
				return num;
			} catch (Exception e) {
				System.out.println("Invalid String");
				return -1;
			}	
		}
	}
	static class NegativeNumberException extends Exception {
    	public NegativeNumberException() {
    		super();
    	}
    }/*
	public static void main(String[] args) {
		try{
			System.out.println(Add("//[*][%]\n1*3%4*3"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}*/
}