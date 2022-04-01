package com.example.a1;

public class product extends Thongtin {
    private  Catalog Danhmuc;

    public Catalog getDanhmuc() {
        return Danhmuc;
    }
    public  void setDanhmuc(Catalog danhmuc){
        Danhmuc = danhmuc;
    }
    public product(String ma, String name,Catalog danhmuc){
        super(ma,name);
        Danhmuc=danhmuc;
    }
    public product(String ma, String name ){
        super(ma,name);
    }
    public product(){
        super();
    }
}
