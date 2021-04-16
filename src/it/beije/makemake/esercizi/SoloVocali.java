package it.beije.makemake.esercizi;

public class SoloVocali {
	
	private String s;
	public SoloVocali() {
	
	}
	
	public void  getVoc(String stringa) {
		char a;
		s=stringa.toLowerCase();
		for(int i=0;i<s.length();i++) {
			a=s.charAt(i);
			switch(a){
			
			   case'a':
				  System.out.println(a);
				  break;
			   case'e':
				   System.out.println(a);
					  break;

			   case'i':
				   System.out.println(a);
					  break;

			   case'o':
				   System.out.println(a);
					  break;

			   case'u':
				   System.out.println(a);		
					  break;

				
			}
			
			
		}
		

	
	}

}
