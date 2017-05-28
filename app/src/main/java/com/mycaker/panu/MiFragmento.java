package com.mycaker.panu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Carlos on 27/05/2017.
 */

public class MiFragmento extends Fragment {
    Pet pet;

    public MiFragmento(){}

    @SuppressLint("ValidFragment")
    public MiFragmento(Pet pet){
        this.pet=pet;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_fragmento, null);
        TextView tx= (TextView) view.findViewById(R.id.textView4);
        ImageButton imageButton= (ImageButton) view.findViewById(R.id.imageView10);

        //String ruta = pet.getImagepath();
        //ruta = ruta.substring(ruta.lastIndexOf("DCIM")+4);

        //ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + ruta;

        tx.setText(pet.getName());
        //Uri uri = Uri.parse(pet.getImagepath());
        //imageView.setImageURI(uri);

        //System.out.println("Ruta " + ruta);


        //File imgFile = new  File(ruta);
        File imgFile = new  File(pet.getImagepath());
        Uri uri = Uri.fromFile(imgFile);
        imageButton.setImageURI(uri);






        //imageButton.setImageBitmap(BitmapFactory.decodeFile(pet.getImagepath()));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), petCarnet.class);
                intent.putExtra("id", pet.getId());
                startActivity(intent);
            }
        });





        return view;
    }
}
