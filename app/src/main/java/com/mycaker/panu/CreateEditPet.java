package com.mycaker.panu;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class CreateEditPet extends AppCompatActivity {

    ManagerBD db;
    int id=0;
    Pet pet;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView foto_gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_pet);
        foto_gallery = (ImageView)findViewById(R.id.petimage);
        db= new ManagerBD(this, "panu", null, 1);


        EditText name= (EditText) findViewById(R.id.createEdit_Name);
        EditText color= (EditText) findViewById(R.id.createEdit_Color);
        final EditText breed = (EditText)findViewById(R.id.createEdit_Breed);
        EditText weight = (EditText) findViewById(R.id.createEdit_Weight);
        Spinner sex= (Spinner) findViewById(R.id.createedit_SpinnerSex);
        Spinner specie= (Spinner) findViewById(R.id.creatEdit_SpinnerEspecies);
        Spinner hair= (Spinner) findViewById(R.id.createEdit_SpinnerHair);
        Spinner size= (Spinner) findViewById(R.id.createEdit_SpinnerSize);
        Button save= (Button) findViewById(R.id.createEddit_ButtonSave);

        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }

        id= getIntent().getIntExtra("id", -1);
        //en caso de no mandar una mascota, crear una nueva
        if(id<=0){
            //habilitar los controladores
            name.setFocusable(true);
            color.setFocusable(true);
            breed.setFocusable(true);
            weight.setFocusable(true);
            sex.setFocusable(true);
            specie.setFocusable(true);
            hair.setFocusable(true);
            size.setFocusable(true);
            //MODIFICAR EL BOTON PARA SALVAR
            save.setText("Guardar");



        }
        else{
            //Si se mandó una mascota desde la actividad anterior
            //insertar el nombre en el EditText name

            //Deshabilitar los textos y
            name.setFocusable(false);
            color.setFocusable(false);
            breed.setFocusable(false);
            weight.setFocusable(false);
            sex.setFocusable(false);
            specie.setFocusable(false);
            hair.setFocusable(false);
            size.setFocusable(false);

            //ingresar los valores que se tienen de la mascota


            //Editar el boton guardar
            save.setText("Editar");





        }

        //función para el boton de guardar-editar
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux="Guardar";
                if(name.getText().toString()!="" && breed.getText().toString()! ){
                    if(aux.compareTo(save.getText().toString())){

                        //Es una edicion de la mascota que se tiene
                        if(id>0){}
                        //se crea una inserción
                        else{

                        }
                    }else{

                    }
                }

            }
        };
 }

