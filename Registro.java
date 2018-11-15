import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.util.LinkedList;

public class Registro extends Canvas{

	private Mapa map;
	private JFrame frame;
	public static JTextArea area1, area2, area3, area4;
  public static LinkedList<Recorrido> registro;
	private JScrollPane scroll;

	private static String title = "Registro";
	public static int width = 800;
	public static int height = 600;

	public Registro(Mapa map){

		frame = new JFrame(title);
		this.map = map;

    registro = new LinkedList<Recorrido>();

		area1 = new JTextArea();
		area1.setEditable(false);
    area1.setText("ID\n");
		frame.add(area1);

		area2 = new JTextArea();
		area2.setEditable(false);
    area2.setText("LUGAR\n");
		frame.add(area2);

		area3 = new JTextArea();
		area3.setEditable(false);
    area3.setText("FECHA\n");
		frame.add(area3);

		area4 = new JTextArea();
		area4.setEditable(false);
    area4.setText("HORA\n");
		frame.add(area4);

		/*scroll = new JScrollPane(area1);
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
    scroll.setBounds(25, 25, width -50, height -100);
    frame.add(scroll);*/


		frame.setLocation(0, 0);
		frame.setLayout(new GridLayout(0,4));
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}
