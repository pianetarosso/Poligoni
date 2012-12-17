import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;



class Triangolo extends FiguraPiana 
{
	private double b,c;
	
	public Triangolo (double a, double b)
	{
		super(a);
		this.b=b;
	}
	
	public Triangolo (double a, double b, double c)
	{
		super(a);
		this.b=b;
		this.c=c;
	}
	
	public double getB()
	{
		return b;
	}
	
	public double getC()
	{
		return c;
	}
	public double area()
	{
		double p=(getA()+b+getC())/2;
		return Math.sqrt(p*(p-getA())*(p-b)*(p-getC()));
	}
	public double perimetro()
	{
		return getA()+b+getC();
	}
	
	public void disegna(Graphics2D g2D, double pixelPerCM, int w, int h)
	{
		GradientPaint gradiente = new GradientPaint(75, 75, Color.blue, 95, 95,
													Color.gray, true);
		g2D.setPaint(gradiente);
		//g2D.fill(
				new Triangolo2D(g2D,w,10,getA()*pixelPerCM, b*pixelPerCM, getC()*pixelPerCM); //);
		
		
	}
	
	public String toString() 
	{
		double c1,c2,hp;
		if ((getA() >= b) && (getA() >= getC()))
		{
			hp=getA();
			c1=b;
			c2=getC();
		}
		else if ((b >= getA()) && (b >= getC()))
		{
			c1=getA();
			hp=b;
			c2=getC();
		}
		else
		{
			hp=getC();
			c1=getA();
			c2=b;
		}
					
		return super.toString()+"ha queste caratteristiche: \n Cateto 1:"+c1+"\n Cateto 2:"+c2+"\n " +
								"Ipotenusa:"+hp+"\n Area:"+area()+"\n Perimetro:"+ perimetro();
	}
	
}