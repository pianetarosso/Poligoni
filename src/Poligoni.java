import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Poligoni extends JFrame 
{

	/*Variabili globali
	A,B,C => triangolo
	raggio => cerchio
	base, altezza => rettangolo
	pixelPerCM => risoluzione dello schermo
	offset => serve a posizionare i disegni
	selezione => permette la scelta dell'immagine da calcolare 
	 				(1-> rettangolo, 2-> triangolo, 3-> triangolo R., 4-> cerchio)
	resetTotale => quando il tasto "Reset" viene schiacciato 2 volte cancella anche 
				   le immagini, questa variabile serve ad identificare quel caso
	dpi => densit� dei pollici (?)int dpi=100;	
	*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double A,B,C,raggio,base,altezza, pixelPerCM;	
	 private int offset=10, selezione=0, resetTotale=0;
	 int dpi=100;			
	 
	//Sfondo principale su cui vengono montate le altre strutture grafiche
	private JPanel fondo = new JPanel();
	
	//Sfondo pulsanti sx
	private JPanel pulsantiSx = new JPanel();
		// Pulsante  Rettangolo
		private JButton Jrettangolo = new JButton("Rettangolo");
		//Pulsante Cerchio
		private JButton Jcerchio = new JButton("Cerchio");
		//Pulsante Triangolo
		private JButton Jtriangolo = new JButton("Triangolo");
		//Pulsante Triangolo rettangolo
		private JButton JtriangoloR = new JButton ("Triangolo R.");
	
	//Sfondo pulsanti dx
	private JPanel pulsantiDx = new JPanel();
		//Pulsante Calcola
		private JButton Jcalcola = new JButton ("Calcola");
		//Pulsante Reset
		private JButton Jreset = new JButton ("Reset");
		//Pulsante Memorizza
		private JButton Jsave = new JButton ("Salva Immagine");
		//Pulsante Cancella immagini
		private JButton Jmostra = new JButton ("Mostra Immagini");
			
	//Sfondo risultati dw
	private JPanel risultatiDw = new JPanel();
		//Area
		private JTextField textFieldArea = new JTextField (10);
		private JLabel IArea = new JLabel ("Area", JLabel.RIGHT);
		//Perimetro
		private JTextField textFieldPerimetro = new JTextField (10);
		private JLabel IPerimetro = new JLabel ("Perimetro", JLabel.RIGHT);
		//Ipotenusa
		private JTextField textFieldIpotenusa = new JTextField (10);
		private JLabel IIpotenusa = new JLabel ("Ipotenusa", JLabel.RIGHT);
	
	//Sfondo dati up
	private JPanel datiUp = new JPanel();
		//Base Rettangolo
		private JTextField textFieldBase = new JTextField (5);
		private JLabel IBase = new JLabel ("Base", JLabel.RIGHT);
		//Altezza Rettangolo
		private JTextField textFieldAltezza = new JTextField (5);
		private JLabel IAltezza = new JLabel ("Altezza", JLabel.RIGHT);
		//Raggio
		private JTextField textFieldRaggio = new JTextField (5);
		private JLabel IRaggio = new JLabel ("Raggio", JLabel.RIGHT);
		//Diametro
		private JTextField textFieldDiametro = new JTextField (5);
		private JLabel IDiametro = new JLabel ("Diametro", JLabel.RIGHT);
		//Cateto 1
		private JTextField textFieldCateto1 = new JTextField (5);
		private JLabel ICateto1 = new JLabel ("Lato 1", JLabel.RIGHT);
		//Cateto 2
		private JTextField textFieldCateto2 = new JTextField (5);
		private JLabel ICateto2 = new JLabel ("Lato 2", JLabel.RIGHT);
		//Cateto 3
		private JTextField textFieldCateto3 = new JTextField (5);
		private JLabel ICateto3 = new JLabel ("Lato 3", JLabel.RIGHT);
		
	//Sfondo disegni centrale
	//private JPanel disegno = new JPanel();
	private JDisegnaPanel disegno=new JDisegnaPanel();
	private Triangolo triangolo=new Triangolo(0,0,0);
	private FiguraPiana figura=triangolo;
	
	
	public Poligoni (String titolo)
	{
		setTitle(titolo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cp = getContentPane();
		pixelPerCM= dpi /2.54;
		
		//Configuro fondo
		fondo.setLayout(new BorderLayout());
		
		//Configuro i pulsanti a sx
		pulsantiSx.setLayout(new GridLayout(4,1,10,10));
		pulsantiSx.add(Jrettangolo);
		pulsantiSx.add(Jtriangolo);
		pulsantiSx.add(JtriangoloR);
		pulsantiSx.add(Jcerchio);
		pulsantiSx.setBackground(Color.GREEN);
		
		//Configuro i pulsanti a dx
		pulsantiDx.setLayout(new GridLayout(4,1,10,10));
		pulsantiDx.add(Jcalcola);
		pulsantiDx.add(Jreset);
		pulsantiDx.add(Jsave);
		pulsantiDx.add(Jmostra);
		pulsantiDx.setBackground(Color.GREEN);
		
		//Configuro lo spazio superiore e setto l'editabilit�
		datiUp.setLayout(new FlowLayout());
		datiUp.add(IBase);
		datiUp.add(textFieldBase);
		textFieldBase.setEditable(false);
		datiUp.add(IAltezza);
		datiUp.add(textFieldAltezza);
		textFieldAltezza.setEditable(false);
		datiUp.add(IRaggio);
		datiUp.add(textFieldRaggio);
		textFieldRaggio.setEditable(false);
		datiUp.add(ICateto1);
		datiUp.add(textFieldCateto1);
		textFieldCateto1.setEditable(false);
		datiUp.add(ICateto2);
		datiUp.add(textFieldCateto2);
		textFieldCateto2.setEditable(false);
		datiUp.add(ICateto3);
		datiUp.add(textFieldCateto3);
		textFieldCateto3.setEditable(false);
		datiUp.setBackground(Color.GREEN);
				
		//Configuro lo spazio inferiore
		risultatiDw.setLayout(new FlowLayout());
		risultatiDw.add(IArea);
		risultatiDw.add(textFieldArea);
		textFieldArea.setEditable(false);
		risultatiDw.add(IPerimetro);
		risultatiDw.add(textFieldPerimetro);
		textFieldPerimetro.setEditable(false);
		risultatiDw.add(IIpotenusa);
		risultatiDw.add(textFieldIpotenusa);
		textFieldIpotenusa.setEditable(false);
		risultatiDw.add(IDiametro);
		risultatiDw.add(textFieldDiametro);
		textFieldDiametro.setEditable(false);
		risultatiDw.setBackground(Color.GREEN);
		
		//Inserisco tutto in "fondo"
		fondo.add(pulsantiDx, BorderLayout.EAST);
		fondo.add(pulsantiSx, BorderLayout.WEST);
		fondo.add(datiUp, BorderLayout.NORTH);
		fondo.add(risultatiDw, BorderLayout.SOUTH);
		fondo.add(disegno, BorderLayout.CENTER);
		disegno.setBackground(Color.GREEN);
		
		//Rendo "fondo" visibile
		cp.add(fondo);
		cp.setVisible(true);
		repaint();
		
		//Inserisco gli ascoltatori per i pulsanti
		Jrettangolo.addActionListener(new Rettangolo_A());
		Jtriangolo.addActionListener(new Triangolo_A());
		JtriangoloR.addActionListener(new TriangoloR_A());
		Jcerchio.addActionListener(new Cerchio_A());
		Jreset.addActionListener(new Reset_A());
	/*	Jmostra.addActionListener(new Mostra_A());
	*/	
	}
	//Tasto "Rettangolo"
	class Rettangolo_A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Reset();
			resetTotale=0;
			textFieldBase.setEditable(true);
			textFieldAltezza.setEditable(true);
			textFieldRaggio.setEditable(false);
			textFieldCateto1.setEditable(false);
			textFieldCateto2.setEditable(false);
			textFieldCateto3.setEditable(false);
			selezione = 1;
			Jcalcola.addActionListener(new Calcola_A());
			textFieldBase.addActionListener(new Calcola_A());
			textFieldAltezza.addActionListener(new Calcola_A());
		}
	} 
	 //Tasto "triangolo"
	class Triangolo_A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Reset();
			resetTotale=0;
			textFieldBase.setEditable(false);
			textFieldAltezza.setEditable(false);
			textFieldRaggio.setEditable(false);
			textFieldCateto1.setEditable(true);
			textFieldCateto2.setEditable(true);
			textFieldCateto3.setEditable(true);
			selezione = 2;
			Jcalcola.addActionListener(new Calcola_A());
			textFieldCateto1.addActionListener(new Calcola_A());
			textFieldCateto2.addActionListener(new Calcola_A());
			textFieldCateto3.addActionListener(new Calcola_A());
		}
	}
	//Tasto "Triangolo R:"
	class TriangoloR_A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Reset();
			resetTotale=0;
			textFieldBase.setEditable(false);
			textFieldAltezza.setEditable(false);
			textFieldRaggio.setEditable(false);
			textFieldCateto1.setEditable(true);
			textFieldCateto2.setEditable(true);
			textFieldCateto3.setEditable(false);
			selezione = 3;
			Jcalcola.addActionListener(new Calcola_A());
			textFieldCateto1.addActionListener(new Calcola_A());
			textFieldCateto2.addActionListener(new Calcola_A());
		}
	} 
	//Tasto "Cerchio"
	class Cerchio_A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Reset();
			resetTotale=0;
			textFieldBase.setEditable(false);
			textFieldAltezza.setEditable(false);
			textFieldRaggio.setEditable(true);
			textFieldCateto1.setEditable(false);
			textFieldCateto2.setEditable(false);
			textFieldCateto3.setEditable(false);
			selezione=4;
			Jcalcola.addActionListener(new Calcola_A());
			textFieldRaggio.addActionListener(new Calcola_A());
		}
	} 
	//Calcola le figure in base ai parametri passati e alla variabile "selezione"
	// che ci dice quale figura stiamo trattando
	class Calcola_A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
						 
			double AreaL=0;
			double PerimetroL=0;
			
			DecimalFormat dueDecimali = new DecimalFormat("0.00");
						
			if (selezione == 1)
			{
				//Rettangolo
				base = Double.parseDouble(textFieldBase.getText());
				altezza =Double.parseDouble(textFieldAltezza.getText());
				figura = new Rettangolo (base, altezza);
				AreaL = figura.area();
				PerimetroL = figura.perimetro();
			} 
			else if (selezione == 2)
			{
				//Triangolo
				A = Double.parseDouble(textFieldCateto1.getText());
				B = Double.parseDouble(textFieldCateto2.getText());
				C = Double.parseDouble(textFieldCateto3.getText());
				figura = new Triangolo (A,B,C);
				AreaL = figura.area();
				PerimetroL = figura.perimetro();				
			}
			else if (selezione == 3)
			{
				//Triangolo rettangolo
				A = Double.parseDouble(textFieldCateto1.getText());
				B = Double.parseDouble(textFieldCateto2.getText());
				figura = new TriangoloRettangolo(A,B);
				AreaL = figura.area();
				PerimetroL = figura.perimetro();
				textFieldIpotenusa.setText(dueDecimali.format (figura.getC()));
			}
			else 
			{
				//Cerchio
				raggio = Double.parseDouble(textFieldRaggio.getText());
				figura = new Cerchio(raggio);
				AreaL = figura.area();
				PerimetroL = figura.perimetro();
				textFieldDiametro.setText(dueDecimali.format(raggio * 2));
				}
			repaint();
			textFieldPerimetro.setText(dueDecimali.format(PerimetroL));
			textFieldArea.setText(dueDecimali.format(AreaL));
			Jsave.addActionListener(new Save_A());
		}
	}
	 //Tasto "Reset" (cliccato 2 volte cancella anche le immagini memorizzate)
	 class Reset_A implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 Reset();
			 resetTotale++;
		/*	 if (resetTotale == 2)
			 {
				 //Cancella tutte le immagini in memoria
			 }
		*/		
		 }
	 }
	 
	 //Tasto "Salva Immagine"
	 class Save_A implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 //Salva l'immagine e le sue propriet� nell'array polimorfo
		 }
	 }
	  	  
	 // Funzione esterna di reset, utile per resettare ogni volta che si 
	 // cambia figura da visualizzare
	 private void Reset()
	 {
		 textFieldBase.setText(null);
		 textFieldAltezza.setText(null);
		 textFieldRaggio.setText(null);
		 textFieldCateto1.setText(null);
		 textFieldCateto2.setText(null);
		 textFieldCateto3.setText(null);
		 textFieldArea.setText(null);
		 textFieldPerimetro.setText(null);
		 textFieldIpotenusa.setText(null);
		 textFieldDiametro.setText(null);
		 A=B=C=base=altezza=raggio=0;
		 figura = new Triangolo(0,0,0);
		 repaint();
	 }
	 
		class JDisegnaPanel extends JPanel
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				int w=getWidth();
				int h=getHeight();
				Graphics2D g2=(Graphics2D) g;
				figura.disegna(g2,pixelPerCM,offset,h);
			}
		}
	 
	 
	 
}
