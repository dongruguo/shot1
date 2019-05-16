
public class TestDoouble {
	public double du;
	public Double le;
	public double getDu() {
		return du;
	}
	public void setDu(double du) {
		this.du = du;
	}
	public Double getLe() {
		return le;
	}
	public void setLe(Double le) {
		this.le = le;
	}
	public static void main(String[] args) {
		TestDoouble td =new  TestDoouble();
		System.out.println(td.getLe() == null);
	}
}
