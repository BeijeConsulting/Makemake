package ExArrays;

public class MediaMultipliTre {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		int ans;
		
		ans = meanMultThree(array);
		System.out.println("La media dei multipli di 3 nell' array è: "+ans);
	}
	
	public static int meanMultThree(int[] array) {
		int[] mult = new int[array.length];
		int j=0;
		int sum=0;
		int res=0;
		
		for(int i=0; i<array.length; i++) {
			if((array[i]%3) == 0) {
				sum += array[i];	
				j++;
			}
		}
		res = sum/j;
		return res;
	}

}
