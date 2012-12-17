import java.awt.Graphics2D;


class FiguraComplessa extends FiguraPiana {

	private FiguraPiana[]figure=new FiguraPiana[3];
	private int indice;
	
	public FiguraComplessa()
	{
		indice=0;
	}
	
	public FiguraPiana [] getFigure()
	{
		return figure;
	}
	
	public void aggiungi(FiguraPiana figura)
	{
		if(indice<figure.length)
			System.out.println("Aggiungi "+indice);
		else
		{
			figure[indice++]=figura;
		}
	}
	
	public double perimetro() 
	{
	double perimetroTotale=0;
	for(int i=0; i<figure.length; i++)
	{
		perimetroTotale += figure[i].perimetro();
	}
		return perimetroTotale;
	}

	public double area() 
	{
		double areaTotale=0;
		for(int i=0; i<figure.length; i++)
		{
			areaTotale += figure[i].area();
		}
		return areaTotale;
	}

	
	public void disegna(Graphics2D g2d, double pixelPerCM, int w, int h) 
	{
		for (int i=0; i<figure.length; i++)
		{
			figure[i].disegna(g2d, pixelPerCM, w, h);
			w +=(int)figure[i].getA()*pixelPerCM;
		}
		w=0;
	}
	public double getC()
	{
		return 0;
	}
}
