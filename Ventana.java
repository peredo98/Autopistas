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

public class Ventana extends Canvas implements ActionListener, ChangeListener, ItemListener{

	private JButton b, b2;
	private Mapa map;
	private JFrame frame;
	private JLabel image, l1, l2, l3, l4;
	private JSlider slider;
	private JComboBox de, a;
	private String origen = "Cuernavaca", destino = "Cuernavaca";
	private int counter = 0;

	private static String title = "Autopistas";
	public static int width = 800;
	public static int height = 600;
	
	public Ventana(Mapa map){
		

		frame = new JFrame(title);
		b = new JButton("Reproducir");
		image = new JLabel();
		l1 = new JLabel("time speed:");
		slider = new JSlider(1, 8);
		l2 = new JLabel("crear auto:");
		l3 = new JLabel("De:");
		l4 = new JLabel("A:");
		de = new JComboBox();
		a = new JComboBox();
		b2 = new JButton("Generar Auto");

		this.map = map;
		map.setRate(6);

		b.setBounds((width * 3 / 4) + 25, 25, 100, 25);
		frame.add(b);
		b.addActionListener(this);

		image.setBounds(0, 0, (width * 3 / 4), height);
		image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapa_prototipo.png")));
		frame.add(image);
		
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

		b2.setBounds((width * 3 / 4) + 25, 240, 150, 25);
		frame.add(b2);
		b2.addActionListener(this);

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

			map.addAuto(new Auto(id, inicio, fin, map.tiempo.toString(), map.au));
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
    }
}