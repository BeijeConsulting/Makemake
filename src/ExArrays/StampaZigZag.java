package ExArrays;
import java.util.Arrays;

public class StampaZigZag {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		int[] exit = new int[array.length];
		
		exit = zigzag(array);
		System.out.println(Arrays.toString(exit));			
	}
	
	public static int[] zigzag(int[] array){
		int[] out = new int[array.length];
		int j=0;
		
			for (int i=0; i<array.length; i++) {
				if(i%2 == 0) {
				out[i] = array[i];
				}
				else {
					out[i] = array[array.length-i];
				}
		}
		return out;
	}
}
