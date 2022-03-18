
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author EchauriC
 */
public class Item {

    String nombre;
    String tipo;
    String imagen;

    int[] principales;
    int[] secundarios;

    int principalesMax;
    int secundariosMax;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int[] getPrincipales() {
        return principales;
    }

    public void setPrincipales(int[] principales) {
        this.principales = principales;
    }

    public int[] getSecundarios() {
        return secundarios;
    }

    public void setSecundarios(int[] secundarios) {
        this.secundarios = secundarios;
    }

    public int getPrincipalesMax() {
        return principalesMax;
    }

    public void setPrincipalesMax(int principalesMax) {
        this.principalesMax = principalesMax;
    }

    public int getSecundariosMax() {
        return secundariosMax;
    }

    public void setSecundariosMax(int secundariosMax) {
        this.secundariosMax = secundariosMax;
    }
    
    public void removePrincipalById(int id){
        int[] temp = new int[principales.length - 1]; 
 
        // copy all the elements in the original to proxy array except the one at index 
        for (int i = 0, k = 0; i < principales.length; i++) { 
 
            // check if index is crossed, continue without copying 
            if (principales[i] == id) { 
                continue; 
            } 
 
            // else copy the element
            temp[k++] = principales[i]; 
        }
        
        principales = temp;
        
    }

    public void removeSecundarioById(int id){
        int[] temp = new int[secundarios.length - 1]; 
 
        // copy all the elements in the original to proxy array except the one at index 
        for (int i = 0, k = 0; i < secundarios.length; i++) { 
 
            // check if index is crossed, continue without copying 
            if (secundarios[i] == id) { 
                continue; 
            } 
 
            // else copy the element
            temp[k++] = secundarios[i]; 
        }
        
        secundarios = temp;
        
    }
        
    @Override
    public String toString() {
        //return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return  "\n" +
                "OBJETO: " + this.nombre
                + "\n"
                + "- Tipo -> " + this.tipo
                + "\n"
                + "- Atributos principales máximos -> " + this.principalesMax
                + "\n"
                + "- Atributos principales -> " + Arrays.toString(this.principales)
                + "\n"
                + "- Atributos secundarios máximos -> " + this.secundariosMax
                + "\n"
                + "- Atributos secundarios -> " + Arrays.toString(this.secundarios)
                + "\n"
                + "\n";
    }
}
