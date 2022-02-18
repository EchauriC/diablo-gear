
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

    String[] principales;
    String[] secundarios;

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

    public String[] getPrincipales() {
        return principales;
    }

    public void setPrincipales(String[] principales) {
        this.principales = principales;
    }

    public String[] getSecundarios() {
        return secundarios;
    }

    public void setSecundarios(String[] secundarios) {
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
