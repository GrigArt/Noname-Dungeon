import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ImageRuleReader {
	ImageRuleReader(String RuleFileName){
	}
	public int[][] getTextureRule(String RuleFileName) {
		int[][] nums = new int[10][10];
		Reader reader = null;
		try {
			reader = new FileReader(RuleFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader BR = new BufferedReader(reader);
		
		try {
			for (int v = 0; v<10; v++) {
				String line = BR.readLine();
				//System.out.println(line);
				int numer = 0;
				if(line!=null) {
					for (int i = 0; i<line.length(); i++) {
						if (Character.getNumericValue(line.charAt(i))!=-1) {
							int a = (i+1)==line.length()? -1 : (Character.getNumericValue(line.charAt(i+1)));
							
							if (a!=-1) {
								String str = ""+line.charAt(i)+line.charAt(i+1);
								nums[v][numer] = Integer.valueOf(str);
								i++;
								System.out.println("nums["+v+"]["+numer+"] = "+nums[v][numer]);
								numer++;
							} else {
								nums[v][numer] = Character.getNumericValue(line.charAt(i));
								System.out.println("nums["+v+"]["+numer+"] = "+nums[v][numer]);
								numer++;
								}
							} 
						else ;
					}
				}else  break;
			}
		//	System.out.println(nums[0][0]);
		//	System.out.println(nums[1][0]);
		//	System.out.println(nums[1][1]);
		//	System.out.println(nums[2][0]);
		} catch (IOException e) {
		e.printStackTrace();
		}	
	return nums;
	}
}
