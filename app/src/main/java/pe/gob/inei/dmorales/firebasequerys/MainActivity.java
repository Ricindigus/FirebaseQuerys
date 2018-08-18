package pe.gob.inei.dmorales.firebasequerys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText edtDni;
    EditText edtNombre;
    EditText edtEdad;
    EditText edtDia;
    EditText edtMes;
    EditText edtAnio;

    Button btnEnviar;
    Button btnActualizar;

    Spinner spNombres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDni = (EditText) findViewById(R.id.edt_dni);
        edtNombre = (EditText) findViewById(R.id.edt_nombre);
        edtDia = (EditText) findViewById(R.id.edt_dia);
        edtMes = (EditText) findViewById(R.id.edt_mes);
        edtAnio = (EditText) findViewById(R.id.edt_anio);
        edtEdad = (EditText) findViewById(R.id.edt_edad);
        spNombres = (Spinner) findViewById(R.id.sp_nombres);

        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        btnActualizar = (Button) findViewById(R.id.btn_actualizar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = edtDni.getText().toString();
                String nombre = edtNombre.getText().toString();

                Map<String, Object> persona = new HashMap<>();
                persona.put("dni", dni);
                persona.put("nombre", nombre);

//                Persona persona = new Persona(dni,nombre,0,0,0,0);

                FirebaseFirestore.getInstance().collection("personas").document(dni)
                        .set(persona)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("FIREBASE", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("FIREBASE", "Error writing document", e);
                            }
                        });


//                Toast.makeText(MainActivity.this, ""+spNombres.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = edtDni.getText().toString();
                int edad = Integer.parseInt(edtEdad.getText().toString());
                int dia = Integer.parseInt(edtDia.getText().toString());
                int mes = Integer.parseInt(edtMes.getText().toString());
                int anio = Integer.parseInt(edtAnio.getText().toString());


                Map<String, Object> persona1 = new HashMap<>();
                persona1.put("edad", edad);
                persona1.put("dia", dia);
                persona1.put("mes", mes);
                persona1.put("anio", anio);


                FirebaseFirestore.getInstance().collection("personas").document(dni)
                        .set(persona1)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("FIREBASE", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("FIREBASE", "Error writing document", e);
                            }
                        });

//                WriteBatch batch = FirebaseFirestore.getInstance().batch();
//
//
//                DocumentReference documentReference = FirebaseFirestore.getInstance().collection("personas").document(dni);
//                batch.update(documentReference, "edad", edad);
//                batch.update(documentReference, "dia", dia);
//                batch.update(documentReference, "mes", mes);
//                batch.update(documentReference, "anio", anio);
//                batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(MainActivity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, "NO GUARDO", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                FirebaseFirestore.getInstance().collection("personas").document(dni)
//                        .update("nombre", nombre)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Log.d("FIREBASE", "DocumentSnapshot successfully updated!");
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("FIREBASE", "Error updating document", e);
//                                Toast.makeText(MainActivity.this, "NO SE PUDO ACTUALIZAR", Toast.LENGTH_SHORT).show();
//                            }
//                        });



            }
        });


    }
}
