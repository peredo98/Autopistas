import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.LinkedList;

public class Reporte extends Canvas implements ItemListener, ActionListener{

  private Mapa map;
  private JFrame frame;
  public static JTextArea area1, area2, area3;
  public static LinkedList<Recorrido> registro;
  private JScrollPane scroll;
  private JPanel panel;
  private JTextField textf;
  private JButton b, b1;
  private JLabel l,l1,l2,l3,l4;
  private JComboBox lugares;

  private static String title = "Reporte del dia";
  public static int width = 800;
  public static int height = 600;

  public Reporte(Mapa map){

        panel = new JPanel();
        scroll = new JScrollPane(panel);
        frame = new JFrame(title);
        b = new JButton("Buscar");
        b1 = new JButton("Buscar");

        this.map = map;

        registro = new LinkedList<Recorrido>();

        area1 = new JTextArea();
        area1.setEditable(false);
        area1.setText("LUGAR\n");
        panel.add(area1);

        area2 = new JTextArea();
        area2.setEditable(false);
        area2.setText("HORA\n");
        panel.add(area2);

        area3 = new JTextArea();
        area3.setEditable(false);
        area3.setText("FECHA\n");
        panel.add(area3);

        l = new JLabel("Mostrar recorrido de auto:");
        l.setBounds(20,450,200, 25);
        frame.add(l);
        
        b.setBounds(310, 450, 100, 25);
        frame.add(b);
        b.addActionListener(this);

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

        b1.setBounds(310, 490, 100, 25);
        frame.add(b1);
        b1.addActionListener(this);

        l2 = new JLabel("Total de autos de entrada:");
        l2.setBounds(450,450,200, 25);
        frame.add(l2);

        l3 = new JLabel("Total de autos de salida:");
        l3.setBounds(450,490,200, 25);
        frame.add(l3);

        l4 = new JLabel("TOTAL:");
        l4.setBounds(550,530,100, 25);
        frame.add(l4);

        textf = new JTextField("Auto1");
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
        frame.setResizable(false);
        frame.setVisible(true);


  }

  public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == lugares) {
          //salu2
        }
    }

  public void actionPerformed(ActionEvent e){

    if(e.getSource() == b){

      if(textf.getText() != null){
        int success = 0;
        //Recorrer la lista de recorridos
        for(int i=0; i<Registro.registro.size(); i++){
          //Validar que la info sea del ID que selecciona el usuario
          if(textf.getText().equals(Registro.registro.get(i).getId())){
            System.out.println(Registro.registro.get(i));

            if(success == 0){
              area1.append(textf.getText()+":\n");
              area2.append("\n");
              area3.append("\n");
            }

            area1.append(Registro.registro.get(i).getLugar()+"\n");
            area2.append(Registro.registro.get(i).getFecha()+"\n");
            area3.append(Registro.registro.get(i).getHora()+"\n");

            success = 1;
          }
        }

        if(success != 1){
          System.out.println("No se encontraron registros para el ID provisto.");
          area1.append("No se encontraron registros para el ID provisto.\n");
          area2.append("\n");
          area3.append("\n");
        }

      }
      else{
        System.out.println("Error. Por favor ingrese el ID del auto a buscar.");
        area1.append("Error. Por favor ingrese el ID del auto a buscar.\n");
        area2.append("\n");
        area3.append("\n");
      }
    }

    if(e.getSource() == b1){
      String stringEntrada = (String)lugares.getSelectedItem() + " (Entrada)";
      String stringSalida = (String)lugares.getSelectedItem() + " (Salida)";
      int totalEntrada = 0;
      int totalSalida = 0;
      for(int i=0; i<Registro.registro.size(); i++){
        if(stringEntrada.equals(Registro.registro.get(i).getLugar())){
          totalEntrada++;
        }
        if(stringSalida.equals(Registro.registro.get(i).getLugar())){
          totalSalida++;
        }
      }
      l2.setText("Total de autos de entrada: " + totalEntrada);
      l3.setText("Total de autos de salida: " + totalSalida);
      l4.setText("TOTAL: " + (totalEntrada+totalSalida));
    }
  }

}