import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import java.awt.*;
import java.awt.Graphics2D;

public class Triangolo2D implements Shape
{
	private Double v1, v2, v3;

	public Triangolo2D(Graphics2D g2D, int w, int h, double a, double b, double c) {
		double d = a;
		if ((c>=b) && (c>=a))
		{
			a = c;
			c = d;
		} else if ((b>=a) && (b>=c))
		{
			a = b;
			b = d;
		}
		v1=new Point2D.Double(0,0);
		v2=new Point2D.Double(a,0);
		double x = ((Math.pow(a,2)-Math.pow(b, 2)+Math.pow(c, 2))/(2*a));
		double y = Math.sqrt(Math.pow(c,2)-Math.pow(x,2));
		v3=new Point2D.Double(x,y);	
		translate(w,h);
		Double(g2D);
		
		
	}
	
	public void Double(Graphics2D g2D)
	{
		
		Line2D.Double linea1=new Line2D.Double(v1,v2);
		Line2D.Double linea2=new Line2D.Double(v2,v3);
		Line2D.Double linea3=new Line2D.Double(v3,v1);
				
		g2D.draw(linea1);
		g2D.draw(linea2);
		g2D.draw(linea3);
		
		
	}
	
	
	
	public void translate(double x,double y)
	{
			v1.x += x;
			v1.y += y;
			v2.x += x;
			v2.y += y;
			v3.x += x;
			v3.y += y;
						
	}

	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
