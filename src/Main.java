import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {

	
	public static void main(String[] args) {
		
		Poligoni finestra = new Poligoni("Poligoni Regolari - By Marco");
		Toolkit kit = finestra.getToolkit();
		Dimension dim = kit.getScreenSize();
		finestra.setBounds((dim.width - 800)/2, (dim.height-400)/2, 800,400);
		finestra.setVisible(true);
	}

}
