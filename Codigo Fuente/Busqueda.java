import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

import java.util.LinkedList;

public class Busqueda extends Canvas{

	private JFrame frame;
	public static JTextArea area1;
	private JScrollPane scroll;
	private JPanel panel;
	private LinkedList<Vertice> Busqueda;

	private static String title = "Busqueda";
	public static int width = 800;
	public static int height = 600;

	public Busqueda(LinkedList<Vertice> Busqueda){


		panel = new JPanel();
		scroll = new JScrollPane(panel);
		frame = new JFrame(title);

		area1 = new JTextArea();
		area1.setEditable(false);
    	area1.setText("Nodos Visitados:\n \n");
    	for (Vertice v : Busqueda) {
    		area1.append(v.getNombre()+"\n");
    	}
		panel.add(area1);

	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    scroll.setBounds(25, 25, width -50, height -100);
	    frame.add(scroll);

		panel.setSize(width-50, height-50);
		panel.setLayout(new GridLayout(0,1));

		frame.setLocation(0, 0);
		frame.setLayout(null);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}