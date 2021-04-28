package it.beije.makemake.matematica;

public class Quadrato  implements FigurePiane{
		private double lato;
		public Quadrato (double lato) {
			super();
			this.lato=lato;
			
		}
		public Quadrato() {}
		public double getPerimetro() {
			double perimetro=0;
			perimetro= lato*4;
			return perimetro;
			
		}
		public double getArea() {
			double area=0;
			area=lato*lato;
			return area;
		}
		public double getBase() {
			 
			 
			 
			 return lato;
		 }
		 public double getAltezza() {
			 
			 
			 
			 return lato;
		 }
}
