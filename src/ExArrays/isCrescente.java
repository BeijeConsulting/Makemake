package ExArrays;

public class isCrescente {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		boolean ans;
		
		ans = isCres(array);
		if (ans == true)
		System.out.println("L'array è ordinato in ordine crescente!");
		else System.out.println("L'array NON è ordinato in ordine crescente!");
		
	}
	
	
	public static boolean isCres(int[] array) {
		boolean flag = false;
		int cntrl = 0;
		
		for (int i=0; i<array.length; i++) {
			if (array[i] >= cntrl ) {
			cntrl = array[i];
			flag = true;
			}
			else flag = false;
		}
		return flag;
	}

}
