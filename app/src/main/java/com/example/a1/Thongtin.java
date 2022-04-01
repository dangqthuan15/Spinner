package com.example.a1;

public class Thongtin {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
    public String getName(){
        return name;
    }
    public void setName(String name ){
        this.name = name;
    }
    public Thongtin(String id, String name){
        super();
        this.id = id;
        this.name = name;
    }
    public Thongtin(){
        super();
    }
    public String toString(){
        return  this.id+ "\n"+this.name;
    }
}

