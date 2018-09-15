package pe.gob.inei.dmorales.firebasequerys;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
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
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.opencensus.tags.TagContext;

public class MainActivity extends AppCompatActivity {


    EditText edtDni;
    EditText edtNombre;
    EditText edtEdad;
    EditText edtDia;
    EditText edtMes;
    EditText edtAnio;

    Button btnEnviar1;
    Button btnEnviar2;
    Button btnEnviar3;
    Button btnResumen1;
    Button btnResumen2;



    Button btnActualizar;

    Spinner spNombres;

    FirebaseFirestore db;

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

        btnEnviar1 = (Button) findViewById(R.id.btn_enviar1);
        btnEnviar2 = (Button) findViewById(R.id.btn_enviar2);
        btnEnviar3 = (Button) findViewById(R.id.btn_enviar3);
        btnResumen1 = (Button) findViewById(R.id.btn_resumen1);
        btnResumen2 = (Button) findViewById(R.id.btn_resumen2);


        db = FirebaseFirestore.getInstance();

        btnActualizar = (Button) findViewById(R.id.btn_actualizar);

        btnEnviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data =  new Data(MainActivity.this);
                data.open();
//                for (int i = 1; i <= 10 ; i++) {
//                    final int c = i;
//                    ArrayList<Caja> cajas = data.getAllCajasxSede(checkDigito(i));
//                    WriteBatch batch = db.batch();
//                    for (Caja caja: cajas){
//                        batch.set(db.collection("cajas").document(caja.getCod_barra_caja()),caja.toMap());
//                    }
//                    batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(MainActivity.this, "Subidos correctamente " + c, Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }

                ArrayList<Caja> cajas = data.getAllCajasxLocal(2);
                WriteBatch batch = db.batch();
                for (Caja caja: cajas){
                    batch.set(db.collection("cajas").document(caja.getCod_barra_caja()),caja.toMap());
                }
                batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Subidos correctamente ", Toast.LENGTH_SHORT).show();
                    }
                });
                data.close();
            }
        });


        btnEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data =  new Data(MainActivity.this);
                data.open();

                for (int i = 11; i <= 20 ; i++) {
                    final int c = i;
                    ArrayList<Caja> cajas = data.getAllCajasxSede(checkDigito(i));
                    if(i != 20){
                        WriteBatch batch = db.batch();
                        for (Caja caja: cajas){
                            batch.set(db.collection("cajas").document(caja.getCod_barra_caja()),caja.toMap());
                        }
                        batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Subidos correctamente " + c, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        WriteBatch batchAux1 = db.batch();
                        for (int j = 0; j < 400 ; j++) {
                            batchAux1.set(db.collection("cajas").document(cajas.get(i).getCod_barra_caja()),cajas.get(i).toMap());
                        }
                        batchAux1.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Subidos correctamente " + c + " parte 1", Toast.LENGTH_SHORT).show();
                            }
                        });
                        WriteBatch batchAux2 = db.batch();
                        for (int j = 400; j < cajas.size() ; j++) {
                            batchAux2.set(db.collection("cajas").document(cajas.get(i).getCod_barra_caja()),cajas.get(i).toMap());
                        }
                        batchAux2.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Subidos correctamente " + c + " parte 2", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                data.close();
            }
        });




        btnEnviar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data =  new Data(MainActivity.this);
                data.open();

                for (int i = 21; i <= 35 ; i++) {
                    final int c = i;
                    ArrayList<Caja> cajas = data.getAllCajasxSede(checkDigito(i));
                    WriteBatch batch = db.batch();
                    for (Caja caja: cajas){
                        batch.set(db.collection("cajas").document(caja.getCod_barra_caja()),caja.toMap());
                    }
                    batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity.this, "Subidos correctamente " + c, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                data.close();
            }
        });

        btnResumen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resumen resumen =  new Resumen(1301,262,215,0,0,0,0,0,0);
                db.collection("resumen").document("resumen_total").set(resumen).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "RESUMEN TOTAL SUBIDO", Toast.LENGTH_SHORT).show();
                    }
                });

                SedeOperativa sedeOperativa1 = new SedeOperativa(1,"LIMA METROPOLITANA",248,41,31,0,0,0,0,0,0);
                SedeOperativa sedeOperativa2 = new SedeOperativa(2,"CALLAO",24,5,5,0,0,0,0,0,0);
                SedeOperativa sedeOperativa3 = new SedeOperativa(3,"RESTO DEL PAIS",1029,216,179,0,0,0,0,0,0);

                WriteBatch batch1 = db.batch();
                batch1.set(db.collection("resumen").document("resumen_total").collection("sedes_nacionales").document(sedeOperativa1.getId_operativa()+""), sedeOperativa1);
                batch1.set(db.collection("resumen").document("resumen_total").collection("sedes_nacionales").document(sedeOperativa2.getId_operativa()+""), sedeOperativa2);
                batch1.set(db.collection("resumen").document("resumen_total").collection("sedes_nacionales").document(sedeOperativa3.getId_operativa()+""), sedeOperativa3);

                batch1.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "SEDES OPERATIVAS RESUMEN SUBIDAS", Toast.LENGTH_SHORT).show();
                    }
                });

                ArrayList<SedeRes> sedeResArrayList = new ArrayList<>();
                SedeRes sedeRes1 = new SedeRes("01","AMAZONAS-BAGUA GRANDE",15,4,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeRes sedeRes2 = new SedeRes("02","AMAZONAS-CHACHAPOYAS",12,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes2);
                SedeRes sedeRes3 = new SedeRes("03","ANCASH-CHIMBOTE",25,6,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes3);
                SedeRes sedeRes4 = new SedeRes("04","ANCASH-HUARAZ",46,10,10,0,0,0,0,0,0);sedeResArrayList.add(sedeRes4);
                SedeRes sedeRes5 = new SedeRes("05","APURIMAC-ABANCAY",17,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes5);
                SedeRes sedeRes6 = new SedeRes("06","APURIMAC-ANDAHUAYLAS",15,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes6);
                SedeRes sedeRes7 = new SedeRes("07","AREQUIPA",52,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes7);
                SedeRes sedeRes8 = new SedeRes("08","AYACUCHO-HUAMANGA",33,7,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes8);
                SedeRes sedeRes9 = new SedeRes("09","AYACUCHO-PUQUIO",12,4,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes9);
                SedeRes sedeRes10 = new SedeRes("10","CAJAMARCA-CAJAMARCA",71,14,13,0,0,0,0,0,0);sedeResArrayList.add(sedeRes10);
                SedeRes sedeRes11 = new SedeRes("11","CAJAMARCA-JAEN",26,6,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes11);
                SedeRes sedeRes12 = new SedeRes("12","CALLAO",24,5,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes12);
                SedeRes sedeRes13 = new SedeRes("13","CUSCO",60,12,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes13);
                SedeRes sedeRes14 = new SedeRes("14","HUANCAVELICA",25,6,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes14);
                SedeRes sedeRes15 = new SedeRes("15","HUANUCO",42,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes15);
                SedeRes sedeRes16 = new SedeRes("16","ICA",39,8,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes16);
                SedeRes sedeRes17 = new SedeRes("17","JUNIN",63,12,12,0,0,0,0,0,0);sedeResArrayList.add(sedeRes17);
                SedeRes sedeRes18 = new SedeRes("18","LA LIBERTAD",74,14,11,0,0,0,0,0,0);sedeResArrayList.add(sedeRes18);
                SedeRes sedeRes19 = new SedeRes("19","LAMBAYEQUE",54,9,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes19);
                SedeRes sedeRes20 = new SedeRes("20","LIMA METROPOLITANA",206,33,25,0,0,0,0,0,0);sedeResArrayList.add(sedeRes20);
                SedeRes sedeRes21 = new SedeRes("21","LIMA PROVINCIA-CAÑETE",16,4,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes21);
                SedeRes sedeRes22 = new SedeRes("22","LIMA PROVINCIA-HUACHO",26,4,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes22);
                SedeRes sedeRes23 = new SedeRes("23","LORETO-IQUITOS",42,8,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes23);
                SedeRes sedeRes24 = new SedeRes("24","LORETO-YURIMAGUAS",9,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes24);
                SedeRes sedeRes25 = new SedeRes("25","MADRE DE DIOS",6,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes25);
                SedeRes sedeRes26 = new SedeRes("26","MOQUEGUA",11,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes26);
                SedeRes sedeRes27 = new SedeRes("27","PASCO",15,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes27);
                SedeRes sedeRes28 = new SedeRes("28","PIURA",74,17,13,0,0,0,0,0,0);sedeResArrayList.add(sedeRes28);
                SedeRes sedeRes29 = new SedeRes("29","PUNO-JULIACA",48,11,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes29);
                SedeRes sedeRes30 = new SedeRes("30","PUNO-PUNO",36,8,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes30);
                SedeRes sedeRes31 = new SedeRes("31","SAN MARTIN-MOYOBAMBA",17,4,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes31);
                SedeRes sedeRes32 = new SedeRes("32","SAN MARTIN-TARAPOTO",27,6,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes32);
                SedeRes sedeRes33 = new SedeRes("33","TACNA",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes33);
                SedeRes sedeRes34 = new SedeRes("34","TUMBES",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes34);
                SedeRes sedeRes35 = new SedeRes("35","UCAYALI-PUCALLPA",31,7,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes35);


                WriteBatch batch2 = db.batch();
                for (SedeRes sedeRes : sedeResArrayList){
                    batch2.set(db.collection("resumen").document("resumen_total")
                                    .collection("sedes_operativas").document(sedeRes.getIdsede()+""), sedeRes);
                }
                batch2.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "sedes resumen 1 subido", Toast.LENGTH_SHORT).show();
                    }
                });


                ArrayList<SedeDepartamental>  sedeDepartamentals= new ArrayList<>();
                SedeDepartamental sedeDep1 = new SedeDepartamental("01","AMAZONAS",27,7,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep2 = new SedeDepartamental("02","ANCASH",71,16,14,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep3 = new SedeDepartamental("03","APURIMAC",32,6,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep4 = new SedeDepartamental("04","AREQUIPA",52,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep5 = new SedeDepartamental("05","AYACUCHO",45,11,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep6 = new SedeDepartamental("06","CAJAMARCA",97,20,18,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep7 = new SedeDepartamental("07","CALLAO",24,5,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep8 = new SedeDepartamental("08","CUSCO",60,12,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep9 = new SedeDepartamental("09","HUANCAVELICA",25,6,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep10 = new SedeDepartamental("10","HUANUCO",42,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep11 = new SedeDepartamental("11","ICA",39,8,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep12 = new SedeDepartamental("12","JUNIN",63,12,12,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep13 = new SedeDepartamental("13","LA LIBERTAD",74,14,11,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep14 = new SedeDepartamental("14","LAMBAYEQUE",54,9,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep15 = new SedeDepartamental("15","LIMA",248,41,31,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep16 = new SedeDepartamental("16","LORETO",51,11,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep17 = new SedeDepartamental("17","MADRE DE DIOS",6,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep18 = new SedeDepartamental("18","MOQUEGUA",11,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep19 = new SedeDepartamental("19","PASCO",15,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep20 = new SedeDepartamental("20","PIURA",74,17,13,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep21 = new SedeDepartamental("21","PUNO",84,19,14,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep22 = new SedeDepartamental("22","SAN MARTIN",44,10,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep23 = new SedeDepartamental("23","TACNA",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep24 = new SedeDepartamental("24","TUMBES",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeDepartamental sedeDep25 = new SedeDepartamental("25","UCAYALI",31,7,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);


                WriteBatch batch3 = db.batch();
                for (SedeRes sedeRes : sedeResArrayList){
                    batch3.set(db.collection("resumen").document("resumen_total")
                            .collection("sedes_departamentales").document(sedeRes.getIdsede()+""), sedeRes);
                }

                batch3.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "sedes departamentales subido", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnResumen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data da = new Data(MainActivity.this);
                da.open();
                ArrayList<String> idsLocales = da.getIdsLocales();
                da.close();
                WriteBatch batch3 = db.batch();
                for (String idLocal : idsLocales) {
                    Data data = new Data(MainActivity.this);
                    data.open();
                    LocalRes localRes = data.getLocalResumen(idLocal);
                    batch3.set(db.collection("resumen").document("resumen_total")
                            .collection("locales").document(localRes.getIdlocal() + ""), localRes);
                    data.close();
                }
                batch3.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "local resumen subido", Toast.LENGTH_SHORT).show();
                    }
                });

//                Data da = new Data(MainActivity.this);
//                da.open();
//                ArrayList<Asistencia> asistencias = da.getAllAsistencia(2);
//                ArrayList<Inventario> inventarios = da.getAllInventario(2);
//                da.close();
//                final int nAsistencias = asistencias.size();
//                final int nInventarios = inventarios.size();
//                int i = 0;
//                for (Asistencia asistencia : asistencias) {
//                    i++;
//                    final int j = i;
//                    db.collection("asistencia").document(asistencia.getDni())
//                            .set(asistencia.toMap())
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    Log.d("FIREBASE", "DocumentSnapshot successfully written!");
//                                    if (j == nAsistencias) {
//                                        Toast.makeText(MainActivity.this, "subido asistencia", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.w("FIREBASE", "Error writing document", e);
//                                }
//                            });
//                }

//                int k = 0;
//                for (Inventario inventario : inventarios){
//                    k++;
//                    final int j=k;
//                    String idDocumento;
//                    if (inventario.getTipo() == 3){
//                        idDocumento = inventario.getCodigo();
//                        db.collection("inventario").document(idDocumento).set(inventario.toMapLista())
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void aVoid) {
//                                        Log.d("FIREBASE", "DocumentSnapshot successfully written!");
//                                        if(j == nInventarios){
//                                            Toast.makeText(MainActivity.this, "subido inventario", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Log.w("FIREBASE", "Error writing document", e);
//                                    }
//                                });
//                    }else{
//                        idDocumento = inventario.getTipo() + "" + inventario.getCodigo();
//                        db.collection("inventario").document(idDocumento).set(inventario.toMap())
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void aVoid) {
//                                        Log.d("FIREBASE", "DocumentSnapshot successfully written!");
//                                        if(j == nInventarios){
//                                            Toast.makeText(MainActivity.this, "subido inventario", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Log.w("FIREBASE", "Error writing document", e);
//                                    }
//                                });
//                    }
//                }
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarMarco();
            }
        });
    }
    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void cargarMarco(){
        FileChooser fileChooser = new FileChooser(MainActivity.this);
        fileChooser.setFileListener(new FileChooser.FileSelectedListener() {
            @Override
            public void fileSelected(File file) {
                String filename = file.getAbsolutePath();
                Log.d("File", filename);
                Toast.makeText(MainActivity.this, "Cargando..." + filename, Toast.LENGTH_SHORT).show();
                try {
                    Data data = new Data(MainActivity.this,1);
                    data.open();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fileChooser.showDialog();
    }
}
