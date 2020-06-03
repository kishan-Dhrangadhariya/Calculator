import java.io.IOException;

public class Calculator {
	public static int Add(String numbers) throws IOException {
		if(numbers.length() == 0) {
			return 0;
		}
		else if(numbers.contains(",")) {
			String del = ",";
			String[] split = numbers.split(del);
			int num1, num2;
			try {
				num1 = Integer.parseInt(split[0]);
				num2 = Integer.parseInt(split[1]);
			} catch (Exception e) {
				System.out.println("Invalid String");
				return -1;
			}
			return num1 + num2;	
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
}