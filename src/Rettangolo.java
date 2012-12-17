import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;


class Rettangolo extends FiguraPiana {

	private double b;
		
	public Rettangolo (double a, double b)
	{
		super(a);
		this.b=b;		
	}
	
	public double getB()
	{
		return b;
	}
	
	public double area()
	{
		return b * getA();
	}
	
	public double perimetro()
	{
		return 2 * b + 2 * getA();
	}
	
	public void disegna(Graphics2D g2D, double pixelPerCM, int w, int h)
	{
		GradientPaint gradiente = new GradientPaint(75, 75, Color.red, 95, 95,
													Color.orange, true);
		g2D.setPaint(gradiente);
		g2D.fill(new Rectangle2D.Double(w,10,getA()*pixelPerCM, b*pixelPerCM));
		
	}
	
	public double getC()
	{
		return 0;
	}
	
	public String toString()
	{
		return super.toString()+ "ha queste caratteristiche: \n Base:"+b+"\n Altezza:"+getA()+"\n Area:"+area()+"\n Perimetro:"+ perimetro();
	}
}
