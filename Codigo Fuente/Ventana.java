import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.util.Hashtable;
import javax.swing.JComboBox;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.FileInputStream;


public class Ventana extends Canvas implements ActionListener, ChangeListener, ItemListener{

	private JButton b,b1, b2, b3, b4;
	private Mapa map;
	private JFrame frame;
	private JLabel image, l1, l2, l3, l4, l5, l6, l7 , l8 , l9, l10;
	private JSlider slider;
	private JComboBox de, a, o1, o2, d1, d2;
	private String origen = "Cuernavaca", destino = "Cuernavaca", origen1 = "Cuernavaca", destino1 = "Cuernavaca",origen2 = "Cuernavaca", destino2 = "Cuernavaca";
	private int counter = 0;

	private static String title = "Autopistas";
	public static int width = 800;
	public static int height = 600;

	public Ventana(Mapa map){


		frame = new JFrame(title);
		b = new JButton("Reproducir");
		b1 = new JButton ("Generar reporte");
		image = new JLabel();
		l1 = new JLabel("time speed:");
		slider = new JSlider(1, 8);
		l2 = new JLabel("crear auto:");
		l3 = new JLabel("De:");
		l4 = new JLabel("A:");
		l5 = new JLabel("BFS:");
		l6 = new JLabel("DFS:");
		l7 = new JLabel("Origen:");
		l8 = new JLabel("Origen:");
		l9 = new JLabel("Buscar:");
		l10 = new JLabel("Buscar:");
		de = new JComboBox();
		a = new JComboBox();
		b2 = new JButton("Generar Auto");
		o1 = new JComboBox();
		d1 = new JComboBox();
		o2 = new JComboBox();
		d2 = new JComboBox();
		b3 = new JButton("Buscar (BFS)");
		b4 = new JButton("Buscar (DFS)");

		this.map = map;
		map.setRate(6);

		b.setBounds((width * 3 / 4) + 25, 25, 100, 25);
		frame.add(b);
		b.addActionListener(this);

		b1.setBounds((width * 3 / 4) + 25, 525, 150, 25);
		frame.add(b1);
		b1.addActionListener(this);

		try{
		image.setBounds(0, 0, (width * 3 / 4), height);
		String imagePath = "images/mapa_prototipo.png";
		BufferedImage myImg = ImageIO.read(new FileInputStream(imagePath));
		ImageIcon icon = new ImageIcon(myImg);
		image.setIcon(icon);
		frame.add(image);
		}catch(IOException e){}

		l1.setBounds((width * 3 / 4) + 25, 67, 100, 15);
		frame.add(l1);

		l2.setBounds((width * 3 / 4) + 25, 167, 100, 15);
		frame.add(l2);

		l3.setBounds((width * 3 / 4) + 25, 187, 100, 15);
		frame.add(l3);

		de.setBounds((width * 3 / 4) + 50, 187, 100, 20);
		a.setBounds((width * 3 / 4) + 50, 212, 100, 20);
		for(int i = 0; i<map.au.getSize(); i++){
			if(map.au.getVertex(i).getEntrada()){
				de.addItem(map.au.getVertex(i).getNombre());
			}
			if(map.au.getVertex(i).getSalida()){
				a.addItem(map.au.getVertex(i).getNombre());
			}
		}
		frame.add(de);
		frame.add(a);
		de.addItemListener(this);
		a.addItemListener(this);

		o1.setBounds((width * 3 / 4) + 75, 320, 100, 20);
		d1.setBounds((width * 3 / 4) + 75, 340, 100, 20);
		o2.setBounds((width * 3 / 4) + 75, 420, 100, 20);
		d2.setBounds((width * 3 / 4) + 75, 440, 100, 20);
		for (Vertice v : map.au.getVertices()) {
			o1.addItem(v.getNombre());
			d1.addItem(v.getNombre());
			o2.addItem(v.getNombre());
			d2.addItem(v.getNombre());
		}
		frame.add(o1);
		frame.add(d1);
		frame.add(o2);
		frame.add(d2);
		o1.addItemListener(this);
		d1.addItemListener(this);
		o2.addItemListener(this);
		d2.addItemListener(this);


		b2.setBounds((width * 3 / 4) + 25, 240, 150, 25);
		frame.add(b2);
		b2.addActionListener(this);

		b3.setBounds((width * 3 / 4) + 25, 365, 150, 25);
		frame.add(b3);
		b3.addActionListener(this);

		b4.setBounds((width * 3 / 4) + 25, 465, 150, 25);
		frame.add(b4);
		b4.addActionListener(this);

		l4.setBounds((width * 3 / 4) + 25, 212, 100, 15);
		frame.add(l4);

		slider.setBounds((width * 3 / 4) + 25, 80, 150, 50);
		Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
	    table.put(1, new JLabel("1"));
	    table.put(2, new JLabel("2"));
	    table.put(3, new JLabel("4"));
	    table.put(4, new JLabel("6"));
	    table.put(5, new JLabel("10"));
	    table.put(6, new JLabel("20"));
	    table.put(7, new JLabel("30"));
	    table.put(8, new JLabel("60"));
    	slider.setMajorTickSpacing(1);
    	slider.setPaintTicks(true);
    	slider.setPaintLabels(true);
    	slider.setLabelTable(table);
		frame.add(slider);
		slider.addChangeListener(this);

		l5.setBounds((width * 3 / 4) + 25, 300, 100, 15);
		l6.setBounds((width * 3 / 4) + 25, 400, 100, 15);
		l7.setBounds((width * 3 / 4) + 25, 320, 100, 15);
		l8.setBounds((width * 3 / 4) + 25, 420, 100, 15);
		l9.setBounds((width * 3 / 4) + 25, 340, 100, 15);
		l10.setBounds((width * 3 / 4) + 25, 440, 100, 15);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(l8);
		frame.add(l9);
		frame.add(l10);

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
		if(e.getSource() == b2){
			if(origen == destino){
				System.out.println("Error: entrada y salida son iguales");
				return;
			}
			counter++;
			Vertice inicio = map.au.searchVertex(origen);
			Vertice fin = map.au.searchVertex(destino);

			String id = "Auto" + counter;

			map.addAuto(new Auto(id, inicio, fin, map.tiempo, map.au));
		}

		if(e.getSource() == b1){
			Reporte reporte = new Reporte(map);
		}
		if(e.getSource() == b3){
			if(origen1 == destino1){
				System.out.println("Error: son iguales");
				return;
			}
			Vertice rootNode = map.au.searchVertex(origen1);
			Vertice findNode = map.au.searchVertex(destino1);

			new Busqueda(map.au.bfs(rootNode, findNode));
		}
		if(e.getSource() == b4){
			if(origen2 == destino2){
				System.out.println("Error: son iguales");
				return;
			}
			Vertice rootNode = map.au.searchVertex(origen2);
			Vertice findNode = map.au.searchVertex(destino2);

			new Busqueda(map.au.bfs(rootNode, findNode));
		}
	}

	public void stateChanged(ChangeEvent e){
		switch (slider.getValue()){
			case 1: map.setRate(1);
			break;
			case 2: map.setRate(2);
			break;
			case 3: map.setRate(4);
			break;
			case 4: map.setRate(6);
			break;
			case 5: map.setRate(10);
			break;
			case 6: map.setRate(20);
			break;
			case 7: map.setRate(30);
			break;
			case 8: map.setRate(60);
			break;
		}
	}

	public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == de) {
            origen = (String) de.getSelectedItem();
        }
        if (e.getSource() == a) {
            destino = (String) a.getSelectedItem();
        }
        if (e.getSource() == o1) {
            origen1 = (String) o1.getSelectedItem();
        }
        if (e.getSource() == d1) {
            destino1 = (String) d1.getSelectedItem();
        }

        if (e.getSource() == d2) {
            origen2 = (String) o2.getSelectedItem();
        }
        if (e.getSource() == d2) {
            destino2 = (String) d2.getSelectedItem();
        }

    }
}
