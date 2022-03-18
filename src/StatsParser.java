
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class StatsParser {
    
    String[] principales;
    String[] secundarios;

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
    
    public Map<Integer, String> getPrincipalesAsMap(){
        Map<Integer, String> map =  new HashMap<>();
        int i = 0;
        for (String item : principales){
            map.put(i, item);
            i++;
        }
        return map;
    }
    
    public Map<Integer, String> getSecundariosAsMap(){
        Map<Integer, String> map =  new HashMap<>();
        int i = 0;
        for (String item : secundarios){
            map.put(i, item);
            i++;
        }
        return map;
    }
    
    public ArrayList<Stat> getPrincipalesAsStatArrayList(){
        ArrayList<Stat> statsObjects = new ArrayList();
        int i = 0;
        for (String item : principales){
            statsObjects.add(new Stat(i, item, true));
            i++;
        }
        return statsObjects;
    }
    
    public ArrayList<Stat> getSecundariosAsStatArrayList(){
        ArrayList<Stat> statsObjects = new ArrayList();
        int i = 0;
        for (String item : secundarios){
            statsObjects.add(new Stat(i, item, false));
            i++;
        }
        return statsObjects;
    }
    
    public String getPrincipalById(int id){
        if(id < this.principales.length)
            return this.principales[id];
        else
            return "";
    }
    
    public String getSecundarioById(int id){
        if(id < this.secundarios.length)
            return this.secundarios[id];
        else
            return "";
    }
}
