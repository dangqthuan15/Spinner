package com.example.a1;

import java.util.ArrayList;

public class Catalog extends Thongtin{
    private ArrayList<product>listSp=null;
    public Catalog(String ma, String name){
        super(ma,name);
        this.listSp=new ArrayList<product>();
    }
    public Catalog(){
        super();
        this.listSp=new ArrayList<product>();
    }
    public boolean isDuplicate(product p){
        for(product p1:listSp){
            if(p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;
        }
        return false;
    }
    public boolean addProduct(product p){
        boolean isDup = isDuplicate(p);
        if(!isDup){
            p.setDanhmuc(this);
            return  listSp.add(p);
        }
        return !isDup;
    }

    public ArrayList<product> getListSp() {
        return listSp;
    }
    public int size(){
        return listSp.size();
    }
    public product get(int i){
        return listSp.get(i);
    }
}
