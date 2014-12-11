import java.util.Scanner;
public class SubmitSolution {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String l = in.nextLine();
    	final Integer N = Integer.parseInt(l);
    	l = in.nextLine();
    	String[] l2 = l.split(" ");
    	int[] arr = new int[N];
    	for (int i = 0; i < N; i ++) {
    		arr[i] = Integer.parseInt(l2[i]);
    	}
    	in.close();
    	long sum = 0;
    	for (int i = N - 1; i >= 0; i--) {
    		sum += arr[i];
    		sum = sum % 2 == 0 ?  sum/2 : sum/2 + 1;
    	}
    	System.out.println(sum);   	
     }
}