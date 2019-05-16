package suncn.jdk18;

public interface Formula {
		double caulate(double d1,double d2) ;
		
		default double sqart(double arg0) {
			return Math.sqrt(arg0);
		}
}
