package dataBase;

import java.util.ArrayList;

import models.Producto;

public class Data {

    public static ArrayList<Producto> products = new ArrayList<>();

    public static ArrayList<Producto> getProducts(){
        return products;
    }

    public static void setProducts(ArrayList<Producto> products){
        Data.products = products;
    }

    public static void fill(){
        for(int i = 0; i < 15; i++){
            Producto p = new Producto();

            p.setId(id());
            p.setName("Producto " + i);
            p.setInfo("Producto " + i);
            p.setState(true);

            products.add(p);
        }
    }

    public static int id(){
        int id = 0;
            for(Producto p: products){
                if(p.getId() > id){
                    id = p.getId();
                }
            }
        return id;
    }

}
