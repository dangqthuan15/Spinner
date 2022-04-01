package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spnDm;
    EditText edtma,edtten;
    Button btnnhap;
    ListView lvSp;

    //Cặp đối tượng dùng cho Spiner
    ArrayList<Catalog> arraySpinner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog>adapterSpinner=null;
    //Cặp đối tượng dùng cho ListView
    ArrayList<product> arrayListView = new ArrayList<product>();
    ArrayAdapter<product>adapterListView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();


    }
    private void getWidgetsControl(){
        spnDm = (Spinner) findViewById(R.id.spDanhmuc);
        edtma = (EditText) findViewById(R.id.editId);
        edtten = (EditText) findViewById(R.id.editName);
        btnnhap = (Button) findViewById(R.id.btnInput);
        lvSp = (ListView) findViewById(R.id.lvsanpham);

        //cấu hình cho Spinner
        adapterSpinner=new ArrayAdapter<Catalog>(this,android.R.layout.simple_spinner_item,arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDm.setAdapter(adapterSpinner);

        //Cấu hình cho ListView
        adapterListView=new ArrayAdapter<product>(this,
                android.R.layout.simple_list_item_1,
                arrayListView);
        lvSp.setAdapter(adapterListView);
    }
    private void fakeDataCatalog(){
        Catalog cat1 = new Catalog("1","SamSung");
        Catalog cat2 = new Catalog("2","iphone");
        Catalog cat3 = new Catalog("3","nokia");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();


    }
    public void addEventsForFormWidgets(){
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addproductForCatalog();
            }
        });
        spnDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Mỗi lần chọn danh mục trong Spinner thì cập nhập Lv
                loadListproductByCatalog(arraySpinner.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void addproductForCatalog(){
        product p = new product();
        p.setId(edtma.getText()+"");
        p.setName(edtten.getText()+"");
        Catalog c =(Catalog) spnDm.getSelectedItem();
        c.addProduct(p);
        //mỗi lần thêm xong thì cập nhật lại lv
        loadListproductByCatalog(c);
    }
    private void loadListproductByCatalog(Catalog c){
        //xóa danh sách cũ
        arrayListView.clear();
        //lấy danh sách mới từ catalog chọn trong spinner
        arrayListView.addAll(c.getListSp());
        //cập nhật lại listview
        adapterListView.notifyDataSetChanged();
    }
}