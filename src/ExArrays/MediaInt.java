package ExArrays;

public class MediaInt {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		int out=0;
		
		out = media(array);
		System.out.println("La media dell'array è: "+out);		
	}
	
	public static int media(int[] array) {
		int j=0;
		int sum=0;
		int res=0;
		
		for(int i=0; i<array.length; i++) {
				sum += array[i];	
				j++;
		}
		res = sum/j;
		return res;
		}
}
