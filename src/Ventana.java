
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Ventana implements ActionListener{

    public Ventana(){
        // Creacion de frame y sus propiedades
        JFrame jFrame = new JFrame("Diablo Gear");
        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        public static final Image LOGO = new ImageIcon("img/logo.png").getImage();
//        setIconImage(LOGO);
        jFrame.setSize(800,600);
//        setLocationRelativeTo(null);
        
        //Panel norte y sus componentes
        JPanel north = new JPanel();
        JComboBox opcionesDefault = new JComboBox();
        opcionesDefault.addItem("Sunwuko");
        opcionesDefault.addItem("Inna");
        opcionesDefault.addItem("Mil tormentas");
        
        JButton cargarDefault = new JButton("Cargar Seleccionado");
        JButton cargarArchivo = new JButton("Cargar Archivo");
        
        north.add(opcionesDefault);
        north.add(cargarDefault);
        north.add(cargarArchivo);
        
        JPanel west = new JPanel(new BorderLayout());
        JButton cabeza = new JButton("Cabeza");
        JButton hombros = new JButton("Hombros");
        JButton cuello = new JButton("Cuello");
        JButton torso = new JButton("Torso");
        JButton manos = new JButton("Manos");
        JButton brazales = new JButton("Brazales");
        JButton cintura = new JButton("Cintura");
        JButton piernas = new JButton("Piernas");
        JButton dedoIzq = new JButton("Dedo Izq");
        JButton dedoDer = new JButton("Dedo Der");
        JButton pies = new JButton("Pies");
        JButton arma = new JButton("Arma");
        JButton secundaria = new JButton("Secundaria");
        west.add(cabeza);
        west.add(hombros);
        west.add(cuello);
        west.add(torso);
        west.add(manos);
        west.add(brazales);
        west.add(cintura);
        west.add(piernas);
        west.add(dedoIzq);
        west.add(dedoDer);
        west.add(pies);
        west.add(arma);
        west.add(secundaria);
        
        JPanel center = new JPanel();
        JPanel east = new JPanel();
        JPanel south = new JPanel();
        
        
        jFrame.add(north, BorderLayout.NORTH);
        jFrame.add(west, BorderLayout.WEST);
        jFrame.add(center, BorderLayout.CENTER);
        jFrame.add(east, BorderLayout.EAST);
        jFrame.add(south, BorderLayout.SOUTH);
        
        jFrame.setVisible(true);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ventana();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
