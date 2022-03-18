/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Stat {
    int key;
    String value;
    boolean principal;

    public Stat(int key, String value, boolean principal) {
        this.key = key;
        this.value = value;
        this.principal = principal;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
    @Override
    public String toString(){
        return "["+this.key+"] " + this.value;
    }
}
