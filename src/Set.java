import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Programacion
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

}
