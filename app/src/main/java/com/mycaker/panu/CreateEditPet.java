package com.mycaker.panu;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.net.URL;

import static java.lang.Integer.parseInt;

public class CreateEditPet extends AppCompatActivity {

    ManagerBD db;
    int id;
    Pet pet;
    String imgpath;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView foto_gallery;
   // Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_pet);
        id= getIntent().getIntExtra("id", 0);
        foto_gallery = (ImageView)findViewById(R.id.petimage);
        db= new ManagerBD(this, "panu", null, 1);


        final EditText name= (EditText) findViewById(R.id.createEdit_Name);
        final EditText color= (EditText) findViewById(R.id.createEdit_Color);
        final EditText breed = (EditText)findViewById(R.id.createEdit_Breed);
        final EditText weight = (EditText) findViewById(R.id.createEdit_Weight);
        final Spinner sex= (Spinner) findViewById(R.id.createedit_SpinnerSex);
        final Spinner specie= (Spinner) findViewById(R.id.creatEdit_SpinnerEspecies);
        final Spinner hair= (Spinner) findViewById(R.id.createEdit_SpinnerHair);
        final Spinner size= (Spinner) findViewById(R.id.createEdit_SpinnerSize);
        final Button save= (Button) findViewById(R.id.createEddit_ButtonSave);
        final EditText date=(EditText) findViewById(R.id.createEdit_Date);

        date.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    DateDialog dialog= new DateDialog((v));
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });
        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        //en caso de no mandar una mascota, crear una nueva
 /*       if(id<=0){
            //habilitar los controladores
            name.setFocusable(true);
            date.setFocusable(true);
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
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
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

            try {
                pet= (Pet) db.showpet(id);
            } catch (Exception e) {
                e.printStackTrace();
                id=0;
            }
            //ingresar los valores que se tienen de la mascota
            name.setText(pet.getName());
            color.setText(pet.getColor());
            breed.setText(pet.getBreed());
            weight.setText(pet.getWeigth());

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Sex, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sex.setAdapter(adapter);
                int spinnerPosition = adapter.getPosition(pet.getSex());
                sex.setSelection(spinnerPosition);

            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Hair, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            specie.setAdapter(adapter1);
            int spinnerPosition1 = adapter.getPosition(pet.getHair());
            hair.setSelection(spinnerPosition1);

            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.species, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            specie.setAdapter(adapter2);
            int spinnerPosition2 = adapter.getPosition(pet.getSpecie());
            specie.setSelection(spinnerPosition2);

            ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Size, android.R.layout.simple_spinner_item);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            specie.setAdapter(adapter3);
            int spinnerPosition3 = adapter.getPosition(pet.getSize());
            specie.setSelection(spinnerPosition2);

            foto_gallery.setImageBitmap(BitmapFactory.decodeFile(pet.getImagepath()));




            //Editar el boton guardar
            save.setText("Editar");
        }*/

        //función para el boton de guardar-editar
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux="Guardar";
                if(save.getText().toString()==aux){

                    if(name.getText().toString()!="" &&
                            date.getText().toString()!="" &&
                            breed.getText().toString()!="" &&
                            color.getText().toString()!="" &&
                            hair.getSelectedItem().toString()!="" &&
                            sex.getSelectedItem().toString()!="" &&
                            specie.getSelectedItem().toString()!="" &&
                            imageUri.toString()!="" ){


                        //Es una edicion de la mascota que se tiene
                        if(id>0){
                            //realizar una insersión con un id*****
                            try {
                                db.edpet(pet);
                                Toast.makeText(getApplicationContext(), "Mascota Guardada", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Error al cargar la mascota", Toast.LENGTH_LONG).show();
                            }
                            Intent intent= new Intent(CreateEditPet.this, myPets.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        //se crea una inserción
                        else{
                            //realizar una insersión SIN un id*****
                            Pet p= new Pet(
                                    parseInt(weight.getText().toString()),
                                    name.getText().toString(),
                                    date.getText().toString(),
                                    breed.getText().toString(),
                                    color.getText().toString(),
                                    hair.getSelectedItem().toString(),
                                    sex.getSelectedItem().toString(),
                                    specie.getSelectedItem().toString(),
                                    getRealPathFromURI(imageUri),
                                    size.getSelectedItem().toString());
                            try {
                                db.inpet(p);
                                Toast.makeText(getApplicationContext(), "Mascota Guardada", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Error al agregar mascota", Toast.LENGTH_LONG).show();

                            }
                            Intent intent= new Intent(CreateEditPet.this, myPets.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        }


                    }else{
                        name.setFocusable(true);
                        date.setFocusable(true);
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

                }






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
            Toast.makeText(getApplicationContext(),imageUri.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }



 }


