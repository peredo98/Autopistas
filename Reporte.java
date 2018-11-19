import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.LinkedList;

public class Reporte extends Canvas implements ItemListener{

  private Mapa map;
  private JFrame frame;
  public static JTextArea area1, area2, area3;
  public static LinkedList<Recorrido> registro;
  private JScrollPane scroll;
  private JPanel panel;
  private JTextField textf;
  private JLabel l,l1,l2,l3,l4;
  private JComboBox lugares;

  private static String title = "Reporte del dia";
  public static int width = 800;
  public static int height = 600;

  public Reporte(Mapa map){

    		panel = new JPanel();
    		scroll = new JScrollPane(panel);
    		frame = new JFrame(title);

    		this.map = map;

        registro = new LinkedList<Recorrido>();

    		area1 = new JTextArea();
    		area1.setEditable(false);
        area1.setText("LUGAR\n");
    		panel.add(area1);

    		area2 = new JTextArea();
    		area2.setEditable(false);
        area2.setText("SALIDA\n");
    		panel.add(area2);

    		area3 = new JTextArea();
    		area3.setEditable(false);
        area3.setText("ENTRADA\n");
    		panel.add(area3);

        l = new JLabel("Mostrar recorrido de auto:");
        l.setBounds(20,450,200, 25);
        frame.add(l);

        l1 = new JLabel("Mostrar registro de:");
        l1.setBounds(20,490,150, 25);
        frame.add(l1);

        lugares = new JComboBox();
        for(int i = 0; i<map.au.getSize(); i++){
    				lugares.addItem(map.au.getVertex(i).getNombre());
        }
        lugares.setBounds(145,490,150,25);
        lugares.addItemListener(this);
        frame.add(lugares);

        l2 = new JLabel("Total de autos de entrada:");
        l2.setBounds(350,450,200, 25);
        frame.add(l2);

        l3 = new JLabel("Total de autos de salida:");
        l3.setBounds(350,490,200, 25);
        frame.add(l3);

        l4 = new JLabel("TOTAL:");
        l4.setBounds(550,530,100, 25);
        frame.add(l4);

        textf = new JTextField("Auto 1");
        textf.setBounds(180,450,100,25);
        frame.add(textf);

        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(25, 25, width -50, height -200);
        frame.add(scroll);

    		panel.setSize(width-50, height-200);
    		panel.setLayout(new GridLayout(0,3));

    		frame.setLocation(0, 0);
    		frame.setLayout(null);
    		frame.setSize(width, height);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setResizable(false);
    		frame.setVisible(true);


  }

  public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == lugares) {

        }
    }
}
