


class TriangoloRettangolo extends Triangolo 
{
	

	public TriangoloRettangolo(double a, double b)
	{
		super(a,b);
		
	}
	
	public TriangoloRettangolo(double a, double b, double c)
	{
		super(a,b,c);		
	}
	
	public double pitagora()
	{
		return Math.sqrt((Math.pow(getA(), 2)) + (Math.pow(getB(), 2)));
	}
	
	public double getC()
	{
		return pitagora();
	}
		
	public String toString()
	{
		return super.toString();
	}
}
