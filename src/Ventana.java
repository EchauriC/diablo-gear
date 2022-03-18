
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

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

    boolean devMode = true;
    
    StatsParser statsParser;
    
    JFrame jFrame;
    JPanel north;
    JComboBox opcionesDefault;
    JPanel west;
    JPanel center;
    CardLayout itemsCardLayout;
    JPanel east;
    JPanel south;
    
    public Ventana(){
        
        cargarUIBasica();
        cargarDatosBasicos();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ventana();
    }
    
    
    /* Cargamos la insterfaz básica del programa */
    void cargarUIBasica(){
    // Creacion de frame y sus propiedades
        jFrame = new JFrame("Diablo Gear");
        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        public static final Image LOGO = new ImageIcon("img/logo.png").getImage();
//        setIconImage(LOGO);
        jFrame.setSize(800,600);
//        setLocationRelativeTo(null);
        
        //Panel norte, sus componentes y listeners
        north = new JPanel();
        opcionesDefault = new JComboBox();
        opcionesDefault.addItem("Sunwuko");
        opcionesDefault.addItem("Inna");
        
        JButton cargarDefault = new JButton("Cargar Seleccionado");
        JButton cargarArchivo = new JButton("Cargar Archivo");
        // Aplicamos los ActionCommand que serán utilizados para filtrar en el ActionListener
        cargarDefault.setActionCommand("default");
        cargarArchivo.setActionCommand("file");
        cargarDefault.addActionListener(this);
        cargarArchivo.addActionListener(this);
        
        north.add(opcionesDefault);
        north.add(cargarDefault);
        north.add(cargarArchivo);
        
        //Panel west sus componentes y listeners
        west = new JPanel(new GridLayout(0, 2));
        ////Botones para cambiar pestaña de items
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
        ///Añadimos el action listener que realizará el cambio de pestaña
        ItemsCardLayoutListener itemsCardLayoutListener = new ItemsCardLayoutListener();
        cabeza.addActionListener(itemsCardLayoutListener);
        hombros.addActionListener(itemsCardLayoutListener);
        cuello.addActionListener(itemsCardLayoutListener);
        torso.addActionListener(itemsCardLayoutListener);
        manos.addActionListener(itemsCardLayoutListener);
        brazales.addActionListener(itemsCardLayoutListener);
        cintura.addActionListener(itemsCardLayoutListener);
        piernas.addActionListener(itemsCardLayoutListener);
        dedoIzq.addActionListener(itemsCardLayoutListener);
        dedoDer.addActionListener(itemsCardLayoutListener);
        pies.addActionListener(itemsCardLayoutListener);
        arma.addActionListener(itemsCardLayoutListener);
        secundaria.addActionListener(itemsCardLayoutListener);
        
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
        
        //Panel center y sus elementos
        itemsCardLayout = new CardLayout();
        center = new JPanel();
        center.setLayout(itemsCardLayout);
        JPanel cabezaCard = new JPanel();
        JPanel hombrosCard = new JPanel();
        JPanel cuelloCard = new JPanel();
        JPanel torsoCard = new JPanel();
        JPanel manosCard = new JPanel();
        JPanel brazalesCard = new JPanel();
        JPanel cinturaCard = new JPanel();
        JPanel piernasCard = new JPanel();
        JPanel dedoIzqCard = new JPanel();
        JPanel dedoDerCard = new JPanel();
        JPanel piesCard = new JPanel();
        JPanel armaCard = new JPanel();
        JPanel secundariaCard = new JPanel();
        
        center.add( cabezaCard ,"Cabeza");
        center.add( hombrosCard ,"Hombros");
        center.add( cuelloCard ,"Cuello");
        center.add( torsoCard ,"Torso");
        center.add( manosCard ,"Manos");
        center.add( brazalesCard ,"Brazales");
        center.add( cinturaCard ,"Cintura");
        center.add( piernasCard ,"Piernas");
        center.add( dedoIzqCard ,"Dedo Izq");
        center.add( dedoDerCard ,"Dedo Der");
        center.add( piesCard ,"Pies");
        center.add( armaCard ,"Arma");
        center.add( secundariaCard ,"Secundaria");
        
        
        
        east = new JPanel();
        south = new JPanel();
        
        
        jFrame.add(north, BorderLayout.NORTH);
        jFrame.add(west, BorderLayout.WEST);
        jFrame.add(center, BorderLayout.CENTER);
        jFrame.add(east, BorderLayout.EAST);
        jFrame.add(south, BorderLayout.SOUTH);
        
        jFrame.setVisible(true);
    }
    
    /* Cargamos información genérica que se usará en todos los Sets. */
    void cargarDatosBasicos(){
        
        try {
            File archivoJson = new File("resources/stats.json");
            statsParser = new ObjectMapper().readerFor(StatsParser.class).readValue(archivoJson);
            
            // Si devMode, mostramos los datos cargados por consola
            if(devMode){
                Map<Integer, String> principalesMap;
                Map<Integer, String> secundariosMap;
                principalesMap = statsParser.getPrincipalesAsMap();
                secundariosMap = statsParser.getSecundariosAsMap();
                principalesMap.forEach((key, value) -> System.out.println(key + " : " + value));
                secundariosMap.forEach((key, value) -> System.out.println(key + " : " + value));
            }
            
        } catch (IOException ex) {
            if(devMode) Logger.getLogger(VentanaLegacy.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), 
                    "Error al cargar el archivo crítico 'stats.json'. La aplicación no puede "
                            + "continuar con la ejecución. Por favor, comprueba que el archivo "
                            + "no ha sido borrado por error o reinstale la aplicación. "
                            + "Si estás intentando aplicar tu "
                            + "propio archivo stats, comprueba el formato con el manual.",
                    "Error al iniciar la aplicación", 
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    
    /**
     * Esta función se encarga de preparar una cadena de texto para ser usada como
     * nombre de archivo en la carga de un objeto File.
     * 
     * @param texto = nombre del Set a cargar, que a su vez será el
     * nombre del archivo JSON a cargar. Los espacios en blanco se reemplazan por
     * guiones '-' y las mayúsculas serán convertidas a minúsculas.
     * 
     * @return nombre permitido del archivo
     */
    public String sanearString(String texto){
        return texto.toLowerCase().replace(" ", "-")+".json";
    }
    

    /**
     * Esta función se encarga de cargar un archivo JSON y convertirlo en un
     * objeto Java de tipo Set.
     * 
     * @param nombreConjunto = nombre del Set a cargar, que a su vez será el
     * nombre del archivo JSON a cargar. Los espacios en blanco se reemplazan por
     * guiones '-' y las mayúsculas serán convertidas a minúsculas.
     */
    private void cargarConjuntoDesdeJson(File archivoJson){
        
        try {
            // Cargamos archivo, mapeamos propiedades y casteamos a Set e Items
            Set conjunto = new ObjectMapper().readerFor(Set.class).readValue(archivoJson);

            //Obtenemos todos los objetos de clase Item en el Set cargado y, por 
            //cada uno, obtenemos su representación visual.
            ArrayList<Item> itemsDisponibles = conjunto.getAllItems();

        // El formato del archivo JSON no es correcto
        } catch (UnrecognizedPropertyException ex) {
            
            if(devMode) Logger.getLogger(VentanaLegacy.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El formato del archivo no es correcto. Comprueba las "
                            + "directrices para escribir tu propio JSON en el "
                            + "manual o utiliza la plantilla proveída con el programa.",
                    "Error al cargar archivo", 
                    JOptionPane.ERROR_MESSAGE);
        
        // Causa comun: Archivo no encontrado
        } catch (IOException ex) {
            if(devMode) Logger.getLogger(VentanaLegacy.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "No se ha encontrado el archivo "
                        + "correspondiente al Set seleccionado. Comprueba que el"
                        + " archivo se encuentra en la carpeta 'resources' y que "
                        + "el nombre del archivo sigue las directrices del manual.",
                    "Error al cargar archivo", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        JButton boton = (JButton)ae.getSource();
//        
//        switch (boton.getActionCommand()) {
//            case "default":
//                //Saneamos el string y preparamos el File
//                String opcion = opcionesDefault.getSelectedItem().toString();
//                File archivoJson = new File("resources/"+ sanearString(opcion));
//                break;
//            case "file":
//                
//                break;
//            default:
//                
//        }
        
        // Cargamos archivo y casteamos a Set.
                 
        //Se inicializa el Componente visual donde se mostrarán los datos.
        // TODO: crear función propia con componentes mejor estructurados
//            StyledDocument documento = jTextPane1.getStyledDocument();
//            jTextPane1.setEnabled(false);
//            jTextPane1.setVisible(false);
//            for(Item item : itemsDisponibles){
//                jTextPane1.insertIcon ( new ImageIcon ( "resources/" + item.getImagen() ) );
//                documento.insertString(documento.getLength(), item.toString(), null);
//            }

    }
    
    
    /**
     * CARDLAYOUT LISTENER
     * 
     * Esta clase se utiliza para crear el ActionListener de los botones que
     * cambian la pestaña del JPanel que contiene los items.
     */
    private class ItemsCardLayoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            itemsCardLayout.show(center, boton.getText());
        }
    }
}
