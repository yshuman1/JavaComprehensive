package homework_3_1;


public class Circle {
	private double radius;
	private static int i;
	public Circle(double radius) {
		this.radius = radius;
		i++;
	}
	
	public double getCircumference() {
		return  2 * Math.PI * radius;
	}
	public String getFormattedCircumference() {
		double x = getCircumference();
		return formatNumber(x);
	}
	public double getArea() {
		return Math.PI * radius;
	}
	public String getFormattedArea() {
		double x = getArea();
		return formatNumber(x);
	}
	private String formatNumber(double x) {
		return String.format("%.2f", x);
	}
	public static int getObjectCount() {
		return i;
	}
}
