package it.campagnoli.esercitazione;
public class MorraCinese {

		public static final String C ="carta";
		public static final String F ="forbice";
		public static final String S ="sasso";
		public static final String P ="pareggio";
		public static String vincitore(String s1, String s2) {
			if((s1.equals(C)&&s2.equals(F)) || (s1.equals(F)&&s2.equals(C))) {
				return F;
			}
			if((s1.equals(C)&&s2.equals(S)) ||(s1.equals(S)&&s2.equals(C))) {
				return C;
			}
			if((s1.equals(S)&&s2.equals(F)) || (s1.equals(F)&&s2.equals(S))) {
				return S;
			}
			return P;
			
		}
		
		public static void main(String[] args) {
			System.out.println(vincitore(args[0].toLowerCase(),args[1].toLowerCase()));
			
		}
}

