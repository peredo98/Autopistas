import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ventana extends Canvas implements ActionListener{

	private JButton b;
	private Mapa map;
	private JFrame frame;
	private JLabel image;

	private static String title = "Autopistas";
	public static int width = 800;
	public static int height = 600;
	
	public Ventana(Mapa map){
		

		frame = new JFrame(title);
		b = new JButton("Reproducir");
		image = new JLabel();
		this.map = map;

		b.setBounds((width * 3 / 4) + 25, 25, 100, 50);
		frame.add(b);
		b.addActionListener(this);

		image.setBounds(0, 0, (width * 3 / 4), height);
		image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapa_prototipo.png")));
		frame.add(image);

		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(map);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b && !map.running){
			map.start();
			b.setText("Detener");
			frame.remove(image);
		}
		else if(e.getSource() == b && map.running){
			map.stop();
			b.setText("Reproducir");
		}
	}
}