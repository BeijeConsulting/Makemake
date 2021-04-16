package ExArrays;

public class BoolContains {
	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,6,7};
		int num = 5;
		Object obj[] = new Object[6];
		String str = new String("LaPatata");
		
		//chiamata dei metodi
		boolean x1 = containsInt(5, array);
		boolean x2 = containsObj(str, obj);
		
		if(x1)
		System.out.println("Il numero inserito "+num+" è contenuto nell'array "+array);
		else System.out.println("Il numero inserito "+num+" NON è contenuto nell'array "+array);
		if(x2)
		System.out.println("L'oggetto inserito "+str+" è contenuto nell'array "+obj);
		else System.out.println("L'oggetto inserito "+str+" NON è contenuto nell'array "+obj);
		
	}
	
//Contiene Interi?	
 public static boolean containsInt(int single, int[] array) {
	 boolean cntrl = false;
	 
	 for (int i=0; i<array.length; i++) {
		 if (array[i] == single)
			 cntrl = true;		 
	 }		 
	return cntrl;
 }
 
 //Contiene Oggetti??
 public static boolean containsObj(Object single, Object[] array) {
	 boolean cntrl = false;
	 
	 for (int i=0; i<array.length; i++) {
		 if (array[i] == single)
			 cntrl = true;		 
	 }		 
	return cntrl;
 }
 
}
