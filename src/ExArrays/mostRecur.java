package ExArrays;

public class mostRecur {
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,4,4,4,4,5};
		int most;
		
		most = mostRecurrent(array);
		System.out.println("L'elemento più ricorrente è: "+most);
	}
	
	public static int mostRecurrent(int[] array) {
		int[] oc = new int[array.length];
		
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array.length; j++) {
				if (array[i] == array[j]) {
					oc[i]++;
				}
			}			
		}
		int max = oc[0];
		for(int m=1; m<oc.length; m++) {
			if(oc[m]>oc[m-1])
				max = m;
		}
		return array[max];
	}

}
