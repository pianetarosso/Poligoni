import java.awt.Graphics2D;

abstract class FiguraPiana 
{
	private double a;
	
	public FiguraPiana()
	{
		
	}
	
	public FiguraPiana(double a)
	{
		this.a=a;
	}
	
	public double getA()
	{
		return a;
	}
	
	abstract public double getC();
	abstract public double perimetro();
	abstract public double area();
	abstract public void disegna(Graphics2D g2D, double pixelPerCM, int w, int h);
	
	public String toString()
	{
		return "� una figura piana ed ";
	}
	
}
