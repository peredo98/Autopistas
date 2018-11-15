import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.util.LinkedList;

public class Registro extends Canvas{

	private Mapa map;
	private JFrame frame;
	public static JTextArea area;
  public static LinkedList<Recorrido> registro;
	private JScrollPane scroll;

	private static String title = "Registro";
	public static int width = 800;
	public static int height = 600;

	public Registro(Mapa map){

		frame = new JFrame(title);
		this.map = map;

    registro = new LinkedList<Recorrido>();

		area = new JTextArea(10, 20);
		area.setEditable(false);
    area.append("ID                              LUGAR                              FECHA                              HORA\n");
		scroll = new JScrollPane(area);
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
    scroll.setBounds(25, 25, width -50, height -100);
    frame.add(scroll);


		frame.setLocation(0, 0);
		frame.setLayout(null);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}