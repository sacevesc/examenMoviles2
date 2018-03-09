package com.iteso.pdm18_scrollabletabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    EditText title,store,location,phone;
    ImageView photo;
    Button save,cancel;
    ItemProduct product1,product2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        title = findViewById(R.id.item_product_title);
        store = findViewById(R.id.item_product_store);
        location = findViewById(R.id.item_product_location);
        phone = findViewById(R.id.item_product_phone);
        save = findViewById(R.id.item_product_save);
        cancel = findViewById(R.id.item_product_cancel);
        photo = findViewById(R.id.item_product_image);

    try{
        if(getIntent().getExtras() != null){
            product1 = getIntent().getParcelableExtra("ITEM");
            if(product1 != null){
                title.setText(product1.getTitle());
                store.setText(product1.getStore());
                location.setText(product1.getAddress());
                phone.setText(product1.getPhone());
                switch (product1.getPhoto()){
                    case 0: photo.setImageResource(R.drawable.mac); break;
                    case  1: photo.setImageResource(R.drawable.alienware); break;
                    case  2: photo.setImageResource(R.drawable.lanix); break;
                    case  3: photo.setImageResource(R.drawable.lampara); break;
                    case  4: photo.setImageResource(R.drawable.planta); break;
                    case  5: photo.setImageResource(R.drawable.phone); break;
                    default: photo.setImageResource(R.drawable.mac); break;
                }
            }
        }
    }catch(Exception e){

    }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product2 = new ItemProduct();
                product2.setTitle(title.getText().toString());
                product2.setStore(store.getText().toString());
                product2.setAddress(location.getText().toString());
                product2.setPhone(phone.getText().toString());
                product2.setPhoto(product1.getPhoto());
                product2.setCode(product1.getCode());

                Intent intent = new Intent();
                intent.putExtra("ITEM", product2);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }



}
