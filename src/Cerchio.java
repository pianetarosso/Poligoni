import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;;


class Cerchio extends FiguraPiana {
	
	public Cerchio (double a)
	{
		super(a);
	}

	public double perimetro() {
		return 2*Math.PI*getA();
	}

	public double area() {
		return Math.pow(getA(), 2)* Math.PI;
	}
	
	public void disegna(Graphics2D g2D, double pixelPerCM, int w, int h)
	{
		GradientPaint gradiente = new GradientPaint(75, 75, Color.blue, 95, 95,
													Color.red, true);
		g2D.setPaint(gradiente);
		g2D.fill(new Ellipse2D.Double(w,10,getA()*pixelPerCM, getA()*pixelPerCM));
		
	}
	
	public double getC()
	{
		return 0;
	}
	public String toString()
	{
		return super.toString()+"ha queste caratteristiche:\n Raggio:"+getA()+"\n Diametro:"
								+2*getA()+"\n Perimetro:"+perimetro()+"\n Area:"+area();
	}

}
