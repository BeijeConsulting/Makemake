package ExArrays;

public class MmFinder {
	public static void main(String[] args) {
		
		int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,25};	
		int max = maxfinder_idx(array);
		int min = minfinder_idx(array);
		
		System.out.println("Numero Massimo: "+array[max]+", in posizione: "+max);
		System.out.println("Numero minimo: "+array[min]+", in posizione: "+min);			
	}
	
	//Maxfinder;
	public static int maxfinder_idx(int[] array) {
		int idx = 0;
		int cntrl = 0;
		
		for (int k=0; k<array.length; k++) {
			if(cntrl < array[k]) {
				idx = k;
				cntrl = array[k];
			}
		}									
		return idx;
	}
	
	//minfinder;
	public static int minfinder_idx(int[] array) {
		int idx = 0;
		int MAXIMUS = array[maxfinder_idx(array)];
		int cntrl = MAXIMUS;
		
		for (int k=0; k<array.length; k++) {
			if(cntrl >= array[k]) {
				idx = k;
				cntrl = array[k];
			}
		}									
		return idx;
	}
}
