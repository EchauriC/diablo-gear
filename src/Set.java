
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author EchauriC
 * 
 * Esta clase representa un Set (conjunto predefinido de objetos que dan bonificaciones
 * adicionales o habilidades al llevarlos juntos) del videojuego Daiblo 3. Cada 
 * Set contiene unas piezas fijas, y no tiene porque contener una pieza de cada 
 * tipo que existe en el juego.
 */
public class Set {

    String nombre;
    String[] bonus;

    Item cabeza;
    Item hombros;
    Item cuello;
    Item torso;
    Item manos;
    Item brazales;
    Item cintura;
    Item piernas;
    Item dedoIzquierdo;
    Item dedoDerecho;
    Item pies;
    Item arma;
    Item secundaria;

    /**
     * Esta funcion indica a la libreria Jackson que debe realizar una acción 
     * en concreto cuando el Mapeador encuentra la propiedad "item". En este caso,
     * esa propiedad se castea a un objeto de Clase Item y se asigna en la 
     * propiedad adecuada del Objeto Set padre.
     * @param itemInJson 
     */
    @JsonProperty("item")
    private void itemFromJson(Map<String, Object> itemInJson) {

        ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        Item item = mapper.convertValue(itemInJson, Item.class);

        switch (item.tipo) {
            case "cabeza":
                this.cabeza = item;
                break;
            case "hombros":
                this.hombros = item;
                break;
            case "cuello":
                this.cuello = item;
                break;
            case "torso":
                this.torso = item;
                break;
            case "manos":
                this.manos = item;
                break;
            case "brazales":
                this.brazales = item;
                break;
            case "cintura":
                this.cintura = item;
                break;
            case "piernas":
                this.piernas = item;
                break;
            case "dedoIzquierdo":
                this.dedoIzquierdo = item;
                break;
            case "dedoDerecho":
                this.dedoDerecho = item;
                break;
            case "pies":
                this.pies = item;
                break;
            case "arma":
                this.arma = item;
                break;
            case "secundaria":
                this.secundaria = item;
                break;
            default:
                //throw new AssertionError();
                break;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getBonus() {
        return bonus;
    }

    public void setBonus(String[] bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        //return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return "nombre: " + this.nombre + " - bonus: " + Arrays.toString(this.bonus);
    }

    /**
     * Obtenemos todos los Item del Set en forma de ArrayList
     * @return ArrayList<Item>
     */
    public ArrayList<Item> getAllItems() {

        ArrayList<Item> items = new ArrayList<Item>();

        if (this.cabeza != null) {
            items.add(this.cabeza);
        }
        if (this.hombros != null) {
            items.add(this.hombros);
        }
        if (this.cuello != null) {
            items.add(this.cuello);
        }
        if (this.torso != null) {
            items.add(this.torso);
        }
        if (this.manos != null) {
            items.add(this.manos);
        }
        if (this.brazales != null) {
            items.add(this.brazales);
        }
        if (this.cintura != null) {
            items.add(this.cintura);
        }
        if (this.piernas != null) {
            items.add(this.piernas);
        }
        if (this.dedoIzquierdo != null) {
            items.add(this.dedoIzquierdo);
        }
        if (this.dedoDerecho != null) {
            items.add(this.dedoDerecho);
        }
        if (this.pies != null) {
            items.add(this.pies);
        }
        if (this.arma != null) {
            items.add(this.arma);
        }
        if (this.secundaria != null) {
            items.add(this.secundaria);
        }
        return items;
    }

    public Item getCabeza() {
        return cabeza;
    }

    public Item getHombros() {
        return hombros;
    }

    public Item getCuello() {
        return cuello;
    }

    public Item getTorso() {
        return torso;
    }

    public Item getManos() {
        return manos;
    }

    public Item getBrazales() {
        return brazales;
    }

    public Item getCintura() {
        return cintura;
    }

    public Item getPiernas() {
        return piernas;
    }

    public Item getDedoIzquierdo() {
        return dedoIzquierdo;
    }

    public Item getDedoDerecho() {
        return dedoDerecho;
    }

    public Item getPies() {
        return pies;
    }

    public Item getArma() {
        return arma;
    }

    public Item getSecundaria() {
        return secundaria;
    }
}
