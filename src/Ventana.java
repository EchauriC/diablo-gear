
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    Set conjunto;
    ArrayList<Item> itemsDisponibles;
    
    
    JFrame jFrame;
    
    JPanel north;
    JComboBox opcionesDefault;
    
    JPanel west;
    JButton cabeza;
    JButton hombros;
    JButton cuello;
    JButton torso;
    JButton manos;
    JButton brazales;
    JButton cintura;
    JButton piernas;
    JButton dedoIzq;
    JButton dedoDer;
    JButton pies;
    JButton arma;
    JButton secundaria;
    
    JPanel center;
    CardLayout itemsCardLayout;
    JPanel cabezaCard;
    JPanel hombrosCard;
    JPanel cuelloCard;
    JPanel torsoCard;
    JPanel manosCard;
    JPanel brazalesCard;
    JPanel cinturaCard;
    JPanel piernasCard;
    JPanel dedoIzqCard;
    JPanel dedoDerCard;
    JPanel piesCard;
    JPanel armaCard;
    JPanel secundariaCard;
    JComboBox selectorPrincipal;
    JComboBox selectorSecundario;
    
    JPanel east;
    JPanel south;
    
    // Control de errores
    boolean fileLoadError;
    
    String ultimaCardSeleccionada = "";
    
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
    
   
    /* Cargamos la insterfaz b??sica del programa */
    void cargarUIBasica(){
    // Creacion de frame y sus propiedades
        jFrame = new JFrame("Diablo Gear");
        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        public static final Image LOGO = new ImageIcon("img/logo.png").getImage();
//        setIconImage(LOGO);
        jFrame.setSize(600,500);
//        setLocationRelativeTo(null);
        
        //Panel norte, sus componentes y listeners
        north = new JPanel();
        opcionesDefault = new JComboBox();
        opcionesDefault.addItem("Sunwuko");
        opcionesDefault.addItem("Inna");
        
        JButton cargarDefault = new JButton("Cargar Seleccionado");
        JButton cargarArchivo = new JButton("Cargar Archivo");
        JButton guardarArchivo = new JButton("Guardar Archivo");
        // Aplicamos los ActionCommand que ser??n utilizados para filtrar en el ActionListener
        cargarDefault.setActionCommand("default");
        cargarArchivo.setActionCommand("file");
        guardarArchivo.setActionCommand("guardar");
        cargarDefault.addActionListener(this);
        cargarArchivo.addActionListener(this);
        guardarArchivo.addActionListener(this);
        
        north.add(opcionesDefault);
        north.add(cargarDefault);
        north.add(cargarArchivo);
        //north.add(guardarArchivo);
        
        //Panel west sus componentes y listeners
        west = new JPanel(new GridLayout(0, 2));
        ////Botones para cambiar pesta??a de items
        cabeza = new JButton("Cabeza");
        hombros = new JButton("Hombros");
        cuello = new JButton("Cuello");
        torso = new JButton("Torso");
        manos = new JButton("Manos");
        brazales = new JButton("Brazales");
        cintura = new JButton("Cintura");
        piernas = new JButton("Piernas");
        dedoIzq = new JButton("Dedo Izq");
        dedoDer = new JButton("Dedo Der");
        pies = new JButton("Pies");
        arma = new JButton("Arma");
        secundaria = new JButton("Secundaria");
        //// Desactivamos todos los botones
        desactivarBotonesCardLayout();
        //// A??adimos el action listener que realizar?? el cambio de pesta??a
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
        cabezaCard = new JPanel();
        hombrosCard = new JPanel();
        cuelloCard = new JPanel();
        torsoCard = new JPanel();
        manosCard = new JPanel();
        brazalesCard = new JPanel();
        cinturaCard = new JPanel();
        piernasCard = new JPanel();
        dedoIzqCard = new JPanel();
        dedoDerCard = new JPanel();
        piesCard = new JPanel();
        armaCard = new JPanel();
        secundariaCard = new JPanel();
        
        cabezaCard.setLayout(new BoxLayout(cabezaCard, BoxLayout.Y_AXIS));
        hombrosCard.setLayout(new BoxLayout(hombrosCard, BoxLayout.Y_AXIS));
        cuelloCard.setLayout(new BoxLayout(cuelloCard, BoxLayout.Y_AXIS));
        torsoCard.setLayout(new BoxLayout(torsoCard, BoxLayout.Y_AXIS));
        manosCard.setLayout(new BoxLayout(manosCard, BoxLayout.Y_AXIS));
        brazalesCard.setLayout(new BoxLayout(brazalesCard, BoxLayout.Y_AXIS));
        cinturaCard.setLayout(new BoxLayout(cinturaCard, BoxLayout.Y_AXIS));
        piernasCard.setLayout(new BoxLayout(piernasCard, BoxLayout.Y_AXIS));
        dedoIzqCard.setLayout(new BoxLayout(dedoIzqCard, BoxLayout.Y_AXIS));
        dedoDerCard.setLayout(new BoxLayout(dedoDerCard, BoxLayout.Y_AXIS));
        piesCard.setLayout(new BoxLayout(piesCard, BoxLayout.Y_AXIS));
        armaCard.setLayout(new BoxLayout(armaCard, BoxLayout.Y_AXIS));
        secundariaCard.setLayout(new BoxLayout(secundariaCard, BoxLayout.Y_AXIS));
        
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
    
    /* Cargamos informaci??n gen??rica que se usar?? en todos los Sets. */
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
                    "Error al cargar el archivo cr??tico 'stats.json'. La aplicaci??n no puede "
                            + "continuar con la ejecuci??n. Por favor, comprueba que el archivo "
                            + "no ha sido borrado por error o reinstale la aplicaci??n. "
                            + "Si est??s intentando aplicar tu "
                            + "propio archivo stats, comprueba el formato con el manual.",
                    "Error al iniciar la aplicaci??n", 
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    
    /**
     * Esta funci??n se encarga de preparar una cadena de texto para ser usada como
     * nombre de archivo en la carga de un objeto File.
     * 
     * @param texto = nombre del Set a cargar, que a su vez ser?? el
     * nombre del archivo JSON a cargar. Los espacios en blanco se reemplazan por
     * guiones '-' y las may??sculas ser??n convertidas a min??sculas.
     * 
     * @return nombre permitido del archivo
     */
    public String sanearString(String texto){
        return texto.toLowerCase().replace(" ", "-")+".json";
    }
    

    /**
     * Esta funci??n se encarga de cargar un archivo JSON y convertirlo en un
     * objeto Java de tipo Set.
     * 
     * @param nombreConjunto = nombre del Set a cargar, que a su vez ser?? el
     * nombre del archivo JSON a cargar. Los espacios en blanco se reemplazan por
     * guiones '-' y las may??sculas ser??n convertidas a min??sculas.
     */
    private void cargarConjuntoDesdeJson(File archivoJson){
        
        try {
            // Cargamos archivo, mapeamos propiedades y casteamos a Set e Items
            conjunto = new ObjectMapper().readerFor(Set.class).readValue(archivoJson);
            //Obtenemos todos los objetos de clase Item en el Set cargado
            itemsDisponibles = conjunto.getAllItems();

        // El formato del archivo JSON no es correcto
        } catch (UnrecognizedPropertyException ex) {
            
            if(devMode) Logger.getLogger(VentanaLegacy.class.getName()).log(Level.SEVERE, null, ex);
            
            fileLoadError = true;
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El formato del archivo no es correcto. Comprueba las "
                            + "directrices para escribir tu propio JSON en el "
                            + "manual o utiliza la plantilla prove??da con el programa.",
                    "Error al cargar archivo", 
                    JOptionPane.ERROR_MESSAGE);
        
        // Causa comun: Archivo no encontrado
        } catch (IOException ex) {
            if(devMode) Logger.getLogger(VentanaLegacy.class.getName()).log(Level.SEVERE, null, ex);
            
            fileLoadError = true;
            
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
        
        JButton boton = (JButton)ae.getSource();
        File archivoJson;
        fileLoadError = false;
        
        switch (boton.getActionCommand()) {
            case "default":
                //Saneamos el string y preparamos el File
                String opcion = opcionesDefault.getSelectedItem().toString();
                archivoJson = new File("resources/"+ sanearString(opcion));
                // Cargamos el File y lo convertimos a objetos Java
                cargarConjuntoDesdeJson(archivoJson);
                
                if ( !fileLoadError ){
                    desactivarBotonesCardLayout();
                    limpiarCardLayout();
                    activarBotonesCardLayout();
                    rellenarCards(true);
                }
                
                break;
                
            case "file":
                // Creamos un FileChooser que solo permite JSON y preparamos el File
                final JFileChooser fc = new JFileChooser();
                fc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(jFrame);
                
                // Si el usuario ha escogido archivo
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    // Cargamos el File y lo convertimos a objetos Java
                    archivoJson = fc.getSelectedFile();
                    cargarConjuntoDesdeJson(archivoJson);
                    
                    if ( !fileLoadError ){
                        desactivarBotonesCardLayout();
                        limpiarCardLayout();
                        activarBotonesCardLayout();
                        rellenarCards(true);
                    }
                }
                break;
//            case "guardar":
//                // create `ObjectMapper` instance
//                ObjectMapper mapper = new ObjectMapper();
//
//                // create a JSON object
//                ObjectNode set = mapper.createObjectNode();
//                set.put("nombre", conjunto.getNombre());
//                ArrayNode bonusNode = new ObjectMapper().createArrayNode();
//                for(String beneficio : conjunto.getBonus()){
//                    bonusNode.add(beneficio);
//                }
//                
//                set.put("bonus", bonusNode);
//                
//                for( Item item : conjunto.getAllItems()){
//                
//                    ObjectNode subItem = mapper.createObjectNode();
//                    subItem.put( "nombre", item.getNombre());
//                    subItem.put( "tipo", item.getTipo());
//                    ArrayNode principalesNode = new ObjectMapper().createArrayNode();
//                    for(int princ : item.getPrincipales()){
//                        principalesNode.add(princ);
//                    }
//                    subItem.put( "principales", principalesNode);
//                    ArrayNode secundariosNode = new ObjectMapper().createArrayNode();
//                    for(int sec : item.getPrincipales()){
//                        secundariosNode.add(sec);
//                    }
//                    subItem.put( "secundarios", secundariosNode);
//                    subItem.put( "principalesMax", item.getPrincipalesMax());
//                    subItem.put( "secundariosMax", item.getSecundariosMax());
//                    subItem.put( "imagen", item.getImagen());
//                    set.("item", subItem );
//                }
//
//                // append address to user
//                
//                String jsonStr="";
//                try {
//                    jsonStr = mapper.writeValueAsString(set);
//                } catch (JsonProcessingException ex) {
//                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println(jsonStr);
//                break;
            case "quitarPrincipal":
                for (Item item : itemsDisponibles){
                    if (item.getTipo().equals(boton.getName())){
                        item.removePrincipalById(Integer.parseInt(boton.getToolTipText()));
                        rellenarCards(false);
                    }
                }
                break;
            case "quitarSecundario":
                for (Item item : itemsDisponibles){
                    if (item.getTipo().equals(boton.getName())){
                        item.removeSecundarioById(Integer.parseInt(boton.getToolTipText()));
                        rellenarCards(false);
                    }
                }
                break;
            case "addPrincipal":
                int idPrincipal = ((Stat)selectorPrincipal.getSelectedItem()).getKey();
                if (devMode)System.out.println(idPrincipal);
                for (Item item : itemsDisponibles){
                    if (item.getTipo().equals(boton.getName())){
                        item.addPrincipalById(idPrincipal);
                    }
                }
                rellenarCards(false);
                break;
            case "addSecundario":
                int idSecundaria = ((Stat)selectorSecundario.getSelectedItem()).getKey();
                if (devMode)System.out.println(idSecundaria);
                for (Item item : itemsDisponibles){
                    if (item.getTipo().equals(boton.getName())){
                        item.addSecundarioById(idSecundaria);
                    }
                }
                rellenarCards(false);
                break;
            default:
                JOptionPane.showMessageDialog(new JFrame(), 
                    "No se reconoce el comando a ejecutar.\n"
                            + "Comando: " + boton.getActionCommand(),
                    "Error desconocido", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /**
     * Deasactiva todos los botones que controlan el CardLayout al cargar el
     * programa y no haber datos en el mismo o justo antes de cargar un Set
     */
    private void desactivarBotonesCardLayout(){
        cabeza.setEnabled(false);
        hombros.setEnabled(false);
        cuello.setEnabled(false);
        torso.setEnabled(false);
        manos.setEnabled(false);
        brazales.setEnabled(false);
        cintura.setEnabled(false);
        piernas.setEnabled(false);
        dedoIzq.setEnabled(false);
        dedoDer.setEnabled(false);
        pies.setEnabled(false);
        arma.setEnabled(false);
        secundaria.setEnabled(false);
    }
    
    /**
     * Eliminamos todos los elementos de las Cards para cargar un Set nuevo
     */
    private void limpiarCardLayout(){
        cabezaCard.removeAll();
        hombrosCard.removeAll();
        cuelloCard.removeAll();
        torsoCard.removeAll();
        manosCard.removeAll();
        brazalesCard.removeAll();
        cinturaCard.removeAll();
        piernasCard.removeAll();
        dedoIzqCard.removeAll();
        dedoDerCard.removeAll();
        piesCard.removeAll();
        armaCard.removeAll();
        secundariaCard.removeAll();
    }
    
    
    /**
     * Despues de cargar un Set, habilita solo los botones de las Cards que 
     * contendr??n informaci??n
     */
    private void activarBotonesCardLayout(){
        
        for(Item item : itemsDisponibles){
        
            switch (item.getTipo()) {
            case "cabeza":
                cabeza.setEnabled(true);
                break;
            case "hombros":
                hombros.setEnabled(true);
                break;
            case "cuello":
                cuello.setEnabled(true);
                break;
            case "torso":
                torso.setEnabled(true);
                break;
            case "manos":
                manos.setEnabled(true);
                break;
            case "brazales":
                brazales.setEnabled(true);
                break;
            case "cintura":
                cintura.setEnabled(true);
                break;
            case "piernas":
                piernas.setEnabled(true);
                break;
            case "dedoIzquierdo":
                dedoIzq.setEnabled(true);
                break;
            case "dedoDerecho":
                dedoDer.setEnabled(true);
                break;
            case "pies":
                pies.setEnabled(true);
                break;
            case "arma":
                arma.setEnabled(true);
                break;
            case "secundaria":
                secundaria.setEnabled(true);
                break;
            default:
                //throw new AssertionError();
                break;
            }
        }
    }
    
    
    private void rellenarCards(boolean primeraEjecucion){
        
        JPanel parent;
        String tipo;
        
        if(primeraEjecucion){
            for(Item item : itemsDisponibles){

                switch (item.getTipo()) {
                case "cabeza":
                    parent = cabezaCard;
                    break;
                case "hombros":
                    parent = hombrosCard;
                    break;
                case "cuello":
                    parent = cuelloCard;
                    break;
                case "torso":
                    parent = torsoCard;
                    break;
                case "manos":
                    parent = manosCard;
                    break;
                case "brazales":
                    parent = brazalesCard;
                    break;
                case "cintura":
                    parent = cinturaCard;
                    break;
                case "piernas":
                    parent = piernasCard;
                    break;
                case "dedoIzquierdo":
                    parent = dedoIzqCard;
                    break;
                case "dedoDerecho":
                    parent = dedoDerCard;
                    break;
                case "pies":
                    parent = piesCard;
                    break;
                case "arma":
                    parent = armaCard;
                    break;
                case "secundaria":
                    parent = secundariaCard;
                    break;
                default:
                    parent = new JPanel();
                    //throw new AssertionError();
                    break;
                }

                // Icono y nombre del Item
                JPanel header = new JPanel();
                header.add(new JLabel(new ImageIcon ( "resources/" + item.getImagen() )));
                header.add(new JLabel(item.nombre));

                
                // Stats Principales del item y selector de stats principales
                JPanel principales = new JPanel(new GridLayout(0, 2));
                //principales.setLayout(new BoxLayout(principales, BoxLayout.Y_AXIS));

                for(int statId : item.principales){
                    String statNombre = statsParser.getPrincipalById(statId);
                    JButton tempButton = new JButton("");
                    tempButton.setActionCommand("quitarPrincipal");
                    tempButton.setToolTipText(String.valueOf(statId));
                    tempButton.setName(item.getTipo());
                    tempButton.setText("Quitar Stat");
                    tempButton.addActionListener(this);
                    principales.add(new JLabel(statNombre));
                    principales.add(tempButton);
                }

                DefaultComboBoxModel<Stat> modelPrincipal = new DefaultComboBoxModel(statsParser.getPrincipalesAsStatArrayList().toArray());
                selectorPrincipal = new JComboBox();
                selectorPrincipal.setModel(modelPrincipal);
                JButton addPrincipal = new JButton("");
                addPrincipal.setActionCommand("addPrincipal");
                addPrincipal.setName(item.getTipo());
                addPrincipal.setText("A??adir Stat");
                addPrincipal.addActionListener(this);
                principales.add(selectorPrincipal);
                principales.add(addPrincipal);
                
                // Stats Secundarios del item y selector de stats secundarios
                JPanel secundarios = new JPanel(new GridLayout(0, 2));
                //secundarios.setLayout(new BoxLayout(secundarios, BoxLayout.Y_AXIS));
                for(int statId : item.secundarios){
                    String statNombre = statsParser.getSecundarioById(statId);
                    JButton tempButton = new JButton("");
                    tempButton.setActionCommand("quitarSecundario");
                    tempButton.setToolTipText(String.valueOf(statId));
                    tempButton.setName(item.getTipo());
                    tempButton.setText("Quitar Stat");
                    tempButton.addActionListener(this);
                    secundarios.add(new JLabel(statNombre));
                    secundarios.add(tempButton);
                }

                DefaultComboBoxModel<Stat> modelSecundario = new DefaultComboBoxModel(statsParser.getSecundariosAsStatArrayList().toArray());
                selectorSecundario = new JComboBox();
                selectorSecundario.setModel(modelSecundario);
                JButton addSecundario = new JButton("");
                addSecundario.setActionCommand("addSecundario");
                addSecundario.setName(item.getTipo());
                addSecundario.setText("A??adir Stat");
                addSecundario.addActionListener(this);
                secundarios.add(selectorSecundario);
                secundarios.add(addSecundario);

                parent.add(header);
                parent.add(principales);
                parent.add(secundarios);
                parent.revalidate();
            }
        } else {
        
            switch (ultimaCardSeleccionada) {
                case "Cabeza":
                    parent = cabezaCard;
                    tipo = "cabeza";
                    break;
                case "Hombros":
                    parent = hombrosCard;
                    tipo = "hombros";
                    break;
                case "Cuello":
                    parent = cuelloCard;
                    tipo = "cuello";
                    break;
                case "Torso":
                    parent = torsoCard;
                    tipo = "torso";
                    break;
                case "Manos":
                    parent = manosCard;
                    tipo = "manos";
                    break;
                case "Brazales":
                    parent = brazalesCard;
                    tipo = "brazales";
                    break;
                case "Cintura":
                    parent = cinturaCard;
                    tipo = "cintura";
                    break;
                case "Piernas":
                    parent = piernasCard;
                    tipo = "piernas";
                    break;
                case "Dedo Izq":
                    parent = dedoIzqCard;
                    tipo = "dedoIzquierdo";
                    break;
                case "Dedo Der":
                    parent = dedoDerCard;
                    tipo = "dedoDerecho";
                    break;
                case "Pies":
                    parent = piesCard;
                    tipo = "pies";
                    break;
                case "Arma":
                    parent = armaCard;
                    tipo = "arma";
                    break;
                case "Secundaria":
                    parent = secundariaCard;
                    tipo = "secundaria";
                    break;
                default:
                    parent = new JPanel();
                    tipo = "";
                    //TODO
                    //throw new AssertionError();
                    break;
                }
                
                
            for(Item item : itemsDisponibles){
            
                if(item.getTipo().equals(tipo)){
                    parent.removeAll();

                    // Icono y nombre del Item
                    JPanel header = new JPanel();
                    header.add(new JLabel(new ImageIcon ( "resources/" + item.getImagen() )));
                    header.add(new JLabel(item.nombre));


                    // Stats Principales del item y selector de stats principales
                    JPanel principales = new JPanel(new GridLayout(0, 2));
                    //principales.setLayout(new BoxLayout(principales, BoxLayout.Y_AXIS));

                    for(int statId : item.principales){
                        String statNombre = statsParser.getPrincipalById(statId);
                        JButton tempButton = new JButton("");
                        tempButton.setActionCommand("quitarPrincipal");
                        tempButton.setToolTipText(String.valueOf(statId));
                        tempButton.setName(item.getTipo());
                        tempButton.setText("Quitar Stat");
                        tempButton.addActionListener(this);
                        principales.add(new JLabel(statNombre));
                        principales.add(tempButton);
                    }

                    DefaultComboBoxModel<Stat> modelPrincipal = new DefaultComboBoxModel(statsParser.getPrincipalesAsStatArrayList().toArray());
                    selectorPrincipal = new JComboBox();
                    selectorPrincipal.setModel(modelPrincipal);
                    JButton addPrincipal = new JButton("");
                    addPrincipal.setActionCommand("addPrincipal");
                    addPrincipal.setName(item.getTipo());
                    addPrincipal.setText("A??adir Stat");
                    addPrincipal.addActionListener(this);
                    principales.add(selectorPrincipal);
                    principales.add(addPrincipal);


                    // Stats Secundarios del item y selector de stats secundarios
                    JPanel secundarios = new JPanel(new GridLayout(0, 2));
                    //secundarios.setLayout(new BoxLayout(secundarios, BoxLayout.Y_AXIS));
                    for(int statId : item.secundarios){
                        String statNombre = statsParser.getSecundarioById(statId);
                        JButton tempButton = new JButton("");
                        tempButton.setActionCommand("quitarSecundario");
                        tempButton.setToolTipText(String.valueOf(statId));
                        tempButton.setName(item.getTipo());
                        tempButton.setText("Quitar Stat");
                        tempButton.addActionListener(this);
                        secundarios.add(new JLabel(statNombre));
                        secundarios.add(tempButton);
                    }

                    DefaultComboBoxModel<Stat> modelSecundario = new DefaultComboBoxModel(statsParser.getSecundariosAsStatArrayList().toArray());
                    selectorSecundario = new JComboBox();
                    selectorSecundario.setModel(modelSecundario);
                    JButton addSecundario = new JButton("");
                    addSecundario.setActionCommand("addSecundario");
                    addSecundario.setName(item.getTipo());
                    addSecundario.setText("A??adir Stat");
                    addSecundario.addActionListener(this);
                    secundarios.add(selectorSecundario);
                    secundarios.add(addSecundario);

    //                JButton addStat = new JButton("A??adir");
    //                selectorStats.addActionListener((ActionEvent e) -> {
    //                    System.out.println(selectorStats.getSelectedItem());
    //                });

                    parent.add(header);
                    parent.add(principales);
                    parent.add(secundarios);
                    parent.revalidate();
                }
            }

        }
        
        
    
    }
    
    /**
     * CARDLAYOUT LISTENER
     * 
     * Esta clase se utiliza para crear el ActionListener de los botones que
     * cambian la pesta??a (Card) del JPanel que contiene los items.
     */
    private class ItemsCardLayoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            itemsCardLayout.show(center, boton.getText());
            ultimaCardSeleccionada = boton.getText();
        }
    }
}
