import java.io.IOException;

public class Calculator {
	public static int Add(String numbers) throws IOException {
		if(numbers.length() == 0) {
			return 0;
		}
		else if(numbers.contains(",")) {
			String del = ",";
			String[] split = numbers.split(del);

			int n = split.length;
			int sum=0, num;
			for(int i=0;i<n;i++) {
				try {
					num = Integer.parseInt(split[i]);
					sum += num;
				} catch (Exception e) {
					System.out.println("Invalid String");
					return -1;
				}
			}
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
}