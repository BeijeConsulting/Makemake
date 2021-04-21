package abstracttrials;

public class Mercedes extends Car{

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Sportiva";
	}

	@Override
	public int getWheel() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getCilinder() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getCv() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public String getFuel() {
		// TODO Auto-generated method stub
		return "ibrido";
	}
	
	
	public static void main(String[] args) {
		
		Mercedes x = new Mercedes();
		System.out.println(x.getFuel());
		System.out.println(x.getType());
		System.out.println(x.getCilinder());
		System.out.println(x.getCv());
		System.out.println(x.getWheel());
		
	}

}
