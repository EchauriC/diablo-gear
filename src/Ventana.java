
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EchauriC
 */
public class Ventana extends javax.swing.JFrame {

    boolean dev = true;
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunwuko", "Inna", "Mil tormentas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Cargar");

        jButton2.setText("Cargar archivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(861, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(7, 2));

        jButton3.setText("Cabeza");
        jPanel2.add(jButton3);

        jButton4.setText("Hombros");
        jPanel2.add(jButton4);

        jButton5.setText("Cuello");
        jPanel2.add(jButton5);

        jButton6.setText("Torso");
        jPanel2.add(jButton6);

        jButton7.setText("Manos");
        jPanel2.add(jButton7);

        jButton8.setText("Brazales");
        jPanel2.add(jButton8);

        jButton9.setText("Cintura");
        jPanel2.add(jButton9);

        jButton10.setText("Piernas");
        jPanel2.add(jButton10);

        jButton11.setText("Dedo Izq");
        jPanel2.add(jButton11);

        jButton12.setText("Dedo Der");
        jPanel2.add(jButton12);

        jButton13.setText("Pies");
        jPanel2.add(jButton13);

        jButton14.setText("Arma");
        jPanel2.add(jButton14);

        jButton15.setText("Secundaria");
        jPanel2.add(jButton15);

        getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String opcion= jComboBox1.getSelectedItem().toString();
        cargarConjunto(opcion);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    /**
     * Esta función se encarga de cargar un archivo JSON y convertirlo en un
     * objeto Java de tipo Set.
     * 
     * @param nombreConjunto = nombre del Set a cargar, que a su vez será el
     * nombre del archivo JSON a cargar. Los espacios en blanco se reemplazan por
     * guiones '-' y las mayúsculas serán convertidas a minúsculas.
     */
    private void cargarConjunto(String nombreConjunto){
        
        try {
            //Saneamos el string, cargamos archivo y casteamos a Set.
            File archivoJson = new File("resources/"+ nombreConjunto.toLowerCase().replace(" ", "-")+".json");
            Set conjunto = new ObjectMapper().readerFor(Set.class).readValue(archivoJson);

            //Se inicializa el Componente visual donde se mostrarán los datos.
            // TODO: crear función propia con componentes mejor estructurados
            StyledDocument documento = jTextPane1.getStyledDocument();
            
            //Obtenemos todos los objetos de clase Item en el Set cargado y, por 
            //cada uno, obtenemos su representación visual.
            ArrayList<Item> itemsDisponibles = conjunto.getAllItems();
            for(Item item : itemsDisponibles){
                jTextPane1.insertIcon ( new ImageIcon ( "resources/" + item.getImagen() ) );
                documento.insertString(documento.getLength(), item.toString(), null);
            }
            
            //CODIGO PROPUESTO POR JAVI, PARA EL CARDLAYOUT
            //add to parent panel
            //masterpanel.add(auth, "auth");
            //masterpanel.add(message, "message");
            //
            //((CardLayout) masterpanel.getLayout()).next(masterpanel);
            // show(masterpanel.id)
            
        // El formato del archivo JSON no es correcto
        } catch (UnrecognizedPropertyException ex) {
            
            if(dev) Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El formato del archivo no es correcto. Comprueba las "
                            + "directrices para escribirtu propio JSON en el "
                            + "anual o utiliza la plantilla proveída con el programa.",
                    "Error al cargar archivo", 
                    JOptionPane.ERROR_MESSAGE);
        
        // Causa comun: Archivo no encontrado
        } catch (IOException ex) {
            if(dev) Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "No se ha encontrado el archivo "
                        + "correspondiente al Set seleccionado. Comprueba que el"
                        + " archivo se encuentra en la carpeta 'resources'.",
                    "Error al cargar archivo", 
                    JOptionPane.ERROR_MESSAGE);
            
        // No se ha podido escribir la información en la ventana de visualización
        } catch (BadLocationException ex) {
            if(dev) Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(new JFrame(), 
                    "La información no puede ser escrita. Comprueba que el"
                        + " formato del archivo es el adecuado. Algunos caracteres"
                        + " especiales no son soportados.",
                    "Error al mostrar datos", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
