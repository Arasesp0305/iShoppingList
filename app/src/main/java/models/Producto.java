package models;

import java.io.Serializable;

public class Producto implements Serializable {

    private int id;
    private String name;
    private String info;
    private boolean state;

    //Empty constructor
    public Producto(){

    }

    //Full constructor
    public Producto(int id, String name, String info, boolean state){
        this.id = id;
        this.name = name;
        this.info = info;
        this.state = state;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
