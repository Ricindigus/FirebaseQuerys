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

                Sede sede1 = new Sede(1,"AMAZONAS-BAGUA GRANDE");
                Sede sede2 = new Sede(2,"AMAZONAS-CHACHAPOYAS");
                Sede sede3 = new Sede(3,"ÁNCASH-CHIMBOTE");
                Sede sede4 = new Sede(4,"ÁNCASH-HUARAZ");
                Sede sede5 = new Sede(5,"APURÍMAC-ABANCAY");
                Sede sede6 = new Sede(6,"APURÍMAC-ANDAHUAYLAS");
                Sede sede7 = new Sede(7,"AREQUIPA");
                Sede sede8 = new Sede(8,"AYACUCHO-HUAMANGA");
                Sede sede9 = new Sede(9,"AYACUCHO-PUQUIO");
                Sede sede10 = new Sede(10,"CAJAMARCA-CAJAMARCA");
                Sede sede11 = new Sede(11,"CAJAMARCA-JAÉN");
                Sede sede12 = new Sede(12,"CALLAO");
                Sede sede13 = new Sede(13,"CUSCO");
                Sede sede14 = new Sede(14,"HUANCAVELICA");
                Sede sede15 = new Sede(15,"HUÁNUCO");
                Sede sede16 = new Sede(16,"ICA");
                Sede sede17 = new Sede(17,"JUNÍN");
                Sede sede18 = new Sede(18,"LA LIBERTAD");
                Sede sede19 = new Sede(19,"LAMBAYEQUE");
                Sede sede20 = new Sede(20,"LIMA METROPOLITANA");
                Sede sede21 = new Sede(21,"LIMA PROVINCIA-CAÑETE");
                Sede sede22 = new Sede(22,"LIMA PROVINCIA-HUACHO");
                Sede sede23 = new Sede(23,"LORETO-IQUITOS");
                Sede sede24 = new Sede(24,"LORETO-YURIMAGUAS");
                Sede sede25 = new Sede(25,"MADRE DE DIOS");
                Sede sede26 = new Sede(26,"MOQUEGUA");
                Sede sede27 = new Sede(27,"PASCO");
                Sede sede28 = new Sede(28,"PIURA");
                Sede sede29 = new Sede(29,"PUNO-JULIACA");
                Sede sede30 = new Sede(30,"PUNO-PUNO");
                Sede sede31 = new Sede(31,"SAN MARTÍN-MOYOBAMBA");
                Sede sede32 = new Sede(32,"SAN MARTÍN-TARAPOTO");
                Sede sede33 = new Sede(33,"TACNA");
                Sede sede34 = new Sede(34,"TUMBES");
                Sede sede35 = new Sede(35,"UCAYALI-PUCALLPA");



                WriteBatch batch = db.batch();
                batch.set(db.collection("sedes").document(sede1.getIdsede()+""), new SedeMap(sede1.getSede()));
                batch.set(db.collection("sedes").document(sede2.getIdsede()+""), new SedeMap(sede2.getSede()));
                batch.set(db.collection("sedes").document(sede3.getIdsede()+""), new SedeMap(sede3.getSede()));
                batch.set(db.collection("sedes").document(sede4.getIdsede()+""), new SedeMap(sede4.getSede()));
                batch.set(db.collection("sedes").document(sede5.getIdsede()+""), new SedeMap(sede5.getSede()));
                batch.set(db.collection("sedes").document(sede6.getIdsede()+""), new SedeMap(sede6.getSede()));
                batch.set(db.collection("sedes").document(sede7.getIdsede()+""), new SedeMap(sede7.getSede()));
                batch.set(db.collection("sedes").document(sede8.getIdsede()+""), new SedeMap(sede8.getSede()));
                batch.set(db.collection("sedes").document(sede9.getIdsede()+""), new SedeMap(sede9.getSede()));
                batch.set(db.collection("sedes").document(sede10.getIdsede()+""), new SedeMap(sede10.getSede()));
                batch.set(db.collection("sedes").document(sede11.getIdsede()+""), new SedeMap(sede11.getSede()));
                batch.set(db.collection("sedes").document(sede12.getIdsede()+""), new SedeMap(sede12.getSede()));
                batch.set(db.collection("sedes").document(sede13.getIdsede()+""), new SedeMap(sede13.getSede()));
                batch.set(db.collection("sedes").document(sede14.getIdsede()+""), new SedeMap(sede14.getSede()));
                batch.set(db.collection("sedes").document(sede15.getIdsede()+""), new SedeMap(sede15.getSede()));
                batch.set(db.collection("sedes").document(sede16.getIdsede()+""), new SedeMap(sede16.getSede()));
                batch.set(db.collection("sedes").document(sede17.getIdsede()+""), new SedeMap(sede17.getSede()));
                batch.set(db.collection("sedes").document(sede18.getIdsede()+""), new SedeMap(sede18.getSede()));
                batch.set(db.collection("sedes").document(sede19.getIdsede()+""), new SedeMap(sede19.getSede()));
                batch.set(db.collection("sedes").document(sede20.getIdsede()+""), new SedeMap(sede20.getSede()));
                batch.set(db.collection("sedes").document(sede21.getIdsede()+""), new SedeMap(sede21.getSede()));
                batch.set(db.collection("sedes").document(sede22.getIdsede()+""), new SedeMap(sede22.getSede()));
                batch.set(db.collection("sedes").document(sede23.getIdsede()+""), new SedeMap(sede23.getSede()));
                batch.set(db.collection("sedes").document(sede24.getIdsede()+""), new SedeMap(sede24.getSede()));
                batch.set(db.collection("sedes").document(sede25.getIdsede()+""), new SedeMap(sede25.getSede()));
                batch.set(db.collection("sedes").document(sede26.getIdsede()+""), new SedeMap(sede26.getSede()));
                batch.set(db.collection("sedes").document(sede27.getIdsede()+""), new SedeMap(sede27.getSede()));
                batch.set(db.collection("sedes").document(sede28.getIdsede()+""), new SedeMap(sede28.getSede()));
                batch.set(db.collection("sedes").document(sede29.getIdsede()+""), new SedeMap(sede29.getSede()));
                batch.set(db.collection("sedes").document(sede30.getIdsede()+""), new SedeMap(sede30.getSede()));
                batch.set(db.collection("sedes").document(sede31.getIdsede()+""), new SedeMap(sede31.getSede()));
                batch.set(db.collection("sedes").document(sede32.getIdsede()+""), new SedeMap(sede32.getSede()));
                batch.set(db.collection("sedes").document(sede33.getIdsede()+""), new SedeMap(sede33.getSede()));
                batch.set(db.collection("sedes").document(sede34.getIdsede()+""), new SedeMap(sede34.getSede()));
                batch.set(db.collection("sedes").document(sede35.getIdsede()+""), new SedeMap(sede35.getSede()));

                batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Subidos correctamente 1", Toast.LENGTH_SHORT).show();
                    }
                });

//                batch.set(
//                        db.collection("sedes").document(caja1.getCodsede()+"")
//                                .collection("locales").document(caja1.getIdlocal()+"")
//                                .collection("cajas").document(caja1.getCod_barra_caja()), caja1);
//                batch.set(db.collection("sedes").document(caja1.getCodsede()+"")
//                        .collection("locales").document(caja1.getIdlocal()+"")
//                        .collection("cajas").document(caja2.getCod_barra_caja()), caja2);
//                batch.set(db.collection("sedes").document(caja1.getCodsede()+"")
//                        .collection("locales").document(caja1.getIdlocal()+"")
//                        .collection("cajas").document(caja3.getCod_barra_caja()), caja3);




//                Caja caja1 = new Caja("700803500110",7008,"AYACUCHO-HUAMANGA",1,"I.E. EMBLEMÁTICA MARISCAL CÁCERES",1,1,"LADO 1",10,1);
//                FirebaseFirestore.getInstance().collection("personas").document(dni).set(persona);



//                String dni = edtDni.getText().toString();
//                String nombre = edtNombre.getText().toString();
//
//                Map<String, Object> persona = new HashMap<>();
//                persona.put("dni", dni);
//                persona.put("nombre", nombre);

//                Persona persona = new Persona(dni,nombre,0,0,0,0);


//                FirebaseFirestore.getInstance().collection("personas").document(dni)
//                        .set(persona)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Log.d("FIREBASE", "DocumentSnapshot successfully written!");
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("FIREBASE", "Error writing document", e);
//                            }
//                        });


//                Toast.makeText(MainActivity.this, ""+spNombres.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        btnEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Local local1 = new Local(1,72,"I.E. ALONSO DE ALVARADO");
                Local local2 = new Local(1,98,"I.E. EMBLEMÁTICA ALEJANDRO SANCHEZ ARTEAGA N° 16210");
                Local local3 = new Local(1,64,"I.E. FÉ Y ALEGRÍA N° 38");
                Local local4 = new Local(2,3,"I.E. EMBLEMÁTICA SAN JUAN DE LA LIBERTAD");
                Local local5 = new Local(2,7,"I.E. SEMINARIO JESÚS MARÍA");
                Local local6 = new Local(2,26,"I.E. VIRGEN ASUNTA");
                Local local7 = new Local(3,32,"I. E. PRIVADA SEÑOR DE LA VIDA");
                Local local8 = new Local(3,15,"I.E. INMACULADA DE LA MERCED");
                Local local9 = new Local(3,6,"UNIVERSIDAD NACIONAL DEL SANTA");
                Local local10 = new Local(3,60,"UNIVERSIDAD SAN PEDRO");
                Local local11 = new Local(4,54,"I.E. FÉ Y ALEGRÍA N° 19");
                Local local12 = new Local(4,92,"I.E. GRAN UNIDAD ESCOLAR MARISCAL TORIBIO DE LUZURIAGA");
                Local local13 = new Local(4,65,"I.E. JORGE BASADRE GROHMAN");
                Local local14 = new Local(4,123,"I.E. PEDRO PABLO ATUSPARIA");
                Local local15 = new Local(4,159,"I.E. REPRESENTATIVA Y EMBLEMÁTICA COLEGIO DE LA LIBERTAD");
                Local local16 = new Local(4,133,"I.E. SIMÓN ANTONIO BOLÍVAR PALACIOS");
                Local local17 = new Local(4,148,"I.E.S.P.P. HUARAZ");
                Local local18 = new Local(4,104,"I.E.S.T.P. ELEAZAR GUZMÁN BARRÓN");
                Local local19 = new Local(4,112,"UNIVERSIDAD SAN PEDRO DE CHIMBOTE (CIUDAD UNIVERSITARIA)");
                Local local20 = new Local(4,38,"UNIVERSIDAD SAN PEDRO DE CHIMBOTE (LOCAL CENTRAL)");
                Local local21 = new Local(5,166,"I.E. EMBLEMÁTICA MIGUEL GRAU");
                Local local22 = new Local(5,173,"I.E. NUESTRA SEÑORA DE LAS MERCEDES");
                Local local23 = new Local(5,156,"UNIVERSIDAD TECNOLÓGICA DE LOS ANDES");
                Local local24 = new Local(6,178,"I.E. AGROPECUARIO N° 08");
                Local local25 = new Local(6,192,"I.E. PRÓCERES DE LA INDEPENDENCIA AMERICANA");
                Local local26 = new Local(6,186,"I.E. VIRGEN DEL CARMEN");
                Local local27 = new Local(7,91,"I.E. AREQUIPA");
                Local local28 = new Local(7,188,"I.E. GRAN UNIDAD ESCOLAR MARIANO MELGAR VALDIVIESO");
                Local local29 = new Local(7,99,"I.E. JUANA CERVANTES DE BOLOGNESI");
                Local local30 = new Local(7,109,"I.E. SALESIANOS DON BOSCO");
                Local local31 = new Local(7,195,"I.E. SAN JUAN BAUTISTA DE LA SALLE");
                Local local32 = new Local(7,84,"I.E. SAN MARTIN DE SOCABAYA");
                Local local33 = new Local(7,179,"I.E.S.P.P. AREQUIPA");
                Local local34 = new Local(7,105,"UNIVERSIDAD ALAS PERUANAS");
                Local local35 = new Local(8,1,"I.E. EMBLEMÁTICA MARISCAL CÁCERES");
                Local local36 = new Local(8,8,"I.E. EMBLEMÁTICA SAN RAMÓN");
                Local local37 = new Local(8,20,"I.E. LUIS CARRANZA");
                Local local38 = new Local(8,14,"I.E. PLANTELES DE APLICACIÓN GUAMAN POMA DE AYALA");
                Local local39 = new Local(8,25,"I.E. SEÑOR DE LOS MILAGROS");
                Local local40 = new Local(9,126,"I.E. PRIMARIA N° 24008 SANTA ROSA DE LIMA");
                Local local41 = new Local(9,160,"I.E. SECUNDARIA MANUEL PRADO");
                Local local42 = new Local(9,117,"I.E. SECUNDARIA NUESTRA SEÑORA DEL PERPETUO SOCORRO ");
                Local local43 = new Local(9,139,"I.E. SECUNDARIA PARROQUIAL JOSÉ MARIA ARGUEDAS");
                Local local44 = new Local(10,163,"CENTRO PRE UNIVERSITARIO DE LA UNIVERSIDAD NACIONAL DE CAJAMARCA - CEPUNC");
                Local local45 = new Local(10,74,"I. E. PÚBLICA ANDRÉS AVELINO CÁCERES");
                Local local46 = new Local(10,191,"I.E. CRISTO REY");
                Local local47 = new Local(10,16,"I.E. EMBLEMÁTICA SAN RAMON DE CHONTAPACCHA");
                Local local48 = new Local(10,61,"I.E. EMBLEMÁTICA SANTA TERESITA");
                Local local49 = new Local(10,102,"I.E. N° 82017 SAN MARCELINO CHAMPAGNAT");
                Local local50 = new Local(10,175,"I.E. NUESTRA SEÑORA DE LA MERCED");
                Local local51 = new Local(10,149,"I.E. PRIVADA CIENCIA Y TECNOLOGÍA");
                Local local52 = new Local(10,46,"I.E. PRIVADA ISAAC NEWTON");
                Local local53 = new Local(10,86,"I.E. PÚBLICA JUAN XXIII");
                Local local54 = new Local(10,132,"I.E. SAN RAMÓN LA RECOLETA");
                Local local55 = new Local(10,184,"I.E. TÉCNICA RAFAEL LOAYZA GUEVARA");
                Local local56 = new Local(10,28,"I.S.P. HERMANO VICTORINO ELORZ GOICOECHEA");
                Local local57 = new Local(11,116,"I.E. RAMÓN CASTILLA Y MARQUESADO N° 16001");
                Local local58 = new Local(11,75,"I.E. SAN LUIS GONZAGA FÉ Y ALEGRÍA 22");
                Local local59 = new Local(11,144,"I.E.S.T. P. 4 DE JUNIO DE 1821");
                Local local60 = new Local(11,124,"UNIVERSIDAD NACIONAL DE CAJAMARCA FILIAL JAEN");
                Local local61 = new Local(11,90,"UNIVERSIDAD NACIONAL DE JAEN");
                Local local62 = new Local(12,187,"COLEGIO SAN ANTONIO MARIANISTAS");
                Local local63 = new Local(12,208,"I.E. 2 DE MAYO");
                Local local64 = new Local(12,206,"I.E. DORA MAYER");
                Local local65 = new Local(12,201,"I.E. GENERAL PRADO");
                Local local66 = new Local(12,198,"I.E. PÚBLICA CALLAO");
                Local local67 = new Local(13,29,"I. E. HUMBERTO LUNA");
                Local local68 = new Local(13,13,"I.E. DIEGO QUISPE TITO");
                Local local69 = new Local(13,37,"I.E. EMBLEMÁTICA GRAN UNIDAD ESCOLAR INCA GARCILASO DE LA VEGA");
                Local local70 = new Local(13,83,"I.E. FÉ Y ALEGRÍA N° 20");
                Local local71 = new Local(13,49,"I.E. GLORIOSO COLEGIO NACIONAL DE CIENCIAS");
                Local local72 = new Local(13,5,"I.E. GRAN UNIDAD ESCOLAR CLORINDA MATTO DE TURNER");
                Local local73 = new Local(13,59,"I.E. MIXTA URIEL GARCíA");
                Local local74 = new Local(13,76,"I.E. SAGRADO CORAZÓN DE JESÚS");
                Local local75 = new Local(13,19,"I.E.S.T.P. TÚPAC AMARU");
                Local local76 = new Local(14,36,"I.E. AMÉRICA");
                Local local77 = new Local(14,4,"I.E. EMBLEMÁTICA FRANCISCA DIEZ CANSECO DE CASTILLA");
                Local local78 = new Local(14,11,"I.E. ISOLINA CLOTET DE FERNANDINI - BILINGÜE");
                Local local79 = new Local(14,45,"I.E. LA VICTORIA DE AYACUCHO");
                Local local80 = new Local(14,70,"I.E. MICAELA BASTIDAS PUYUCAHUA");
                Local local81 = new Local(14,18,"I.E. RAMÓN CASTILLA MARQUESADO");
                Local local82 = new Local(15,202,"COLEGIO NACIONAL ILLATHUPA");
                Local local83 = new Local(15,205,"COLEGIO PRIVADO LA DIVINA MISERICORDIA");
                Local local84 = new Local(15,185,"ESCUELA PRIMARIA DE MENORES N° 32011 HERMILIO VALDIZÁN");
                Local local85 = new Local(15,161,"I.E. DE GESTIÓN PÚBLICA JULIO ARMANDO RUÍZ VÁSQUEZ");
                Local local86 = new Local(15,194,"I.E. ECLESIAL LA INMACULADA CONCEPCIÓN");
                Local local87 = new Local(15,138,"I.E. EMBLEMÁTICA NUESTRA SEÑORA DE LAS MERCEDES");
                Local local88 = new Local(15,209,"I.E. INTEGRADA PRIVADA SAN AGUSTÍN");
                Local local89 = new Local(15,174,"I.E. JUANA MORENO");
                Local local90 = new Local(16,51,"I.E. PARTICULAR  SAN VICENTE");
                Local local91 = new Local(16,23,"I.E. PARTICULAR SANTÍSIMO CRISTO MORENO");
                Local local92 = new Local(16,63,"I.E. PÚBLICA ANTONIA MORENO DE CÁCERES");
                Local local93 = new Local(16,96,"I.E. PÚBLICA N°22305 JULIO CESAR TELLO");
                Local local94 = new Local(16,35,"I.E. PÚBLICA NUESTRA SEÑORA DE LAS MERCEDES");
                Local local95 = new Local(16,80,"UNIVERSIDAD PRIVADA ALAS PERUANAS");
                Local local96 = new Local(17,137,"I.E. 31501 SEBASTIAN LORENTE");
                Local local97 = new Local(17,48,"I.E. EMBLEMÁTICA 31540 SANTA ISABEL");
                Local local98 = new Local(17,77,"I.E. EMBLEMÁTICA NUESTRA SEÑORA DE COCHARCAS");
                Local local99 = new Local(17,87,"I.E. EMBLEMÁTICA POLITECNICO REGIONAL DEL CENTRO");
                Local local100 = new Local(17,107,"I.E. JAVIER HERAUD PEREZ");
                Local local101 = new Local(17,151,"I.E. JOSÉ CARLOS MARIÁTEGUI ");
                Local local102 = new Local(17,113,"I.E. LA ASUNCIÓN");
                Local local103 = new Local(17,125,"I.E. POLITÉCNICO TÚPAC AMARU");
                Local local104 = new Local(17,154,"I.E. PRIVADA SAN JUAN BOSCO");
                Local local105 = new Local(17,41,"I.E. PÚBLICA EMBLEMÁTICA Y CENTENARIA SANTA ISABEL");
                Local local106 = new Local(17,97,"I.E. PÚBLICA MARISCAL CASTILLA");
                Local local107 = new Local(17,119,"I.E. ZÁRATE");
                Local local108 = new Local(18,224,"I.E.  LICEO TRUJILLO");
                Local local109 = new Local(18,225,"I.E.  PARROQUIAL SAGRADO CORAZÓN");
                Local local110 = new Local(18,223,"I.E.  SANTA ROSA");
                Local local111 = new Local(18,216,"I.E. GRAN UNIDAD ESCOLAR JOSÉ FAUSTINO SÁNCHEZ CARRIÓN");
                Local local112 = new Local(18,220,"I.E. GUSTAVO RIES");
                Local local113 = new Local(18,218,"I.E. MARCIAL ACHARÁN Y SMITH");
                Local local114 = new Local(18,222,"I.E. MARÍA NEGRÓN UGARTE");
                Local local115 = new Local(18,219,"I.E. N° 80040 DIVINO MAESTRO");
                Local local116 = new Local(18,217,"I.E. N° 80824 JOSÉ CARLOS MARIÁTEGUI");
                Local local117 = new Local(18,221,"I.E. PARTICULAR HERMANOS BLANCO");
                Local local118 = new Local(18,215,"I.E. SAN JUAN");
                Local local119 = new Local(19,27,"I.E. 10106 JUAN MANUEL ITURREGUI");
                Local local120 = new Local(19,93,"I.E. COLEGIO NACIONAL DE SAN JOSÉ");
                Local local121 = new Local(19,106,"I.E. EMBLEMÁTICA E INCLUSIVA KARL WEISS");
                Local local122 = new Local(19,39,"I.E. SARA A. BULLÓN LAMADRID");
                Local local123 = new Local(19,12,"UNIVERSIDAD NACIONAL PEDRO RUIZ GALLO");
                Local local124 = new Local(19,55,"UNIVERSIDAD PARTICULAR DE CHICLAYO");
                Local local125 = new Local(20,207,"I.E. ANTENOR ORREGO ESPINOZA");
                Local local126 = new Local(20,169,"I.E. EMBLEMÁTICA ALFONSO UGARTE");
                Local local127 = new Local(20,162,"I.E. EMBLEMÁTICA CARLOS WIESSE");
                Local local128 = new Local(20,57,"I.E. EMBLEMÁTICA ISABEL LA CATÓLICA");
                Local local129 = new Local(20,190,"I.E. EMBLEMÁTICA JOSÉ GRANDA");
                Local local130 = new Local(20,183,"I.E. EMBLEMÁTICA JUAN GUERRERO QUIMPER");
                Local local131 = new Local(20,180,"I.E. EMBLEMÁTICA MARÍA PARADO DE BELLIDO");
                Local local132 = new Local(20,150,"I.E. EMBLEMÁTICA MERCEDES CABELLO DE CARBONERA");
                Local local133 = new Local(20,172,"I.E. EMBLEMÁTICA MERCEDES INDACOCHEA");
                Local local134 = new Local(20,24,"I.E. EMBLEMÁTICA MIGUEL GRAU");
                Local local135 = new Local(20,103,"I.E. EMBLEMÁTICA N° 0040 HIPOLITO UNANUE");
                Local local136 = new Local(20,199,"I.E. EMBLEMÁTICA N° 6052 JOSÉ MARÍA EGUREN");
                Local local137 = new Local(20,79,"I.E. EMBLEMÁTICA Nº 1103 ELVIRA GARCIA Y GARCIA");
                Local local138 = new Local(20,143,"I.E. EMBLEMÁTICA Nº 1120 PEDRO ADOLFO LABARTHE EFFIO");
                Local local139 = new Local(20,114,"I.E. EMBLEMÁTICA NUESTRA SEÑORA DE GUADALUPE");
                Local local140 = new Local(20,171,"I.E. EMBLEMÁTICA RICARDO BENTÍN");
                Local local141 = new Local(20,43,"I.E. EMBLEMÁTICA RICARDO PALMA");
                Local local142 = new Local(20,9,"I.E. EMBLEMÁTICA TERESA GONZALEZ DE FANNING");
                Local local143 = new Local(20,196,"I.E. FAP JOSE ABELARDO QUIÑONES");
                Local local144 = new Local(20,193,"I.E. N° 6005 GRAL. EMILIO SOYER CABERO");
                Local local145 = new Local(20,210,"I.E. N° 6085 BRIGIDA SILVA DE OCHOA");
                Local local146 = new Local(20,204,"I.E. N° 6090 JOSÉ OLAYA BALANDRA");
                Local local147 = new Local(20,203,"I.E. NICOLAS COPÉRNICO");
                Local local148 = new Local(20,200,"I.E. Nº 2001 TENIENTE CORONEL ALFREDO BONIFAZ");
                Local local149 = new Local(20,108,"I.E. PARTICULAR PEDRO RUIZ GALLO");
                Local local150 = new Local(21,164,"I.E. PÚBLICA JOSÉ BUENAVENTURA SEPÚLVEDA FERNÁNDEZ -TÉCNICO ");
                Local local151 = new Local(21,129,"I.E. PÚBLICA N°20189 NUESTRA SEÑORA DE LA CONCEPCIÓN ");
                Local local152 = new Local(21,168,"I.E. PÚBLICA N°20874 - CENTRO DE VARONES");
                Local local153 = new Local(21,177,"I.E. PÚBLICA SANTA RITA DE CASSIA");
                Local local154 = new Local(22,197,"I.E. EMBLEMÁTICA LUIS FABIO XAMMAR JURADO");
                Local local155 = new Local(22,176,"UNIVERSIDAD NACIONAL JOSÉ FAUSTINO SÁNCHEZ CARRIÓN");
                Local local156 = new Local(23,140,"CENTRO EDUCATIVO PRIMARIO Y SECUNDARIO PARROQUIAL NUESTRA SEÑORA DE LA SALUD");
                Local local157 = new Local(23,155,"I.E. PRIMARIA SECUNDARIA SAGRADO CORAZÓN");
                Local local158 = new Local(23,130,"I.E. PÚBLICA INICIAL PRIMARIA SECUNDARIA MARISCAL OSCAR R. BENAVIDES");
                Local local159 = new Local(23,111,"I.E. PÚBLICA PRIMARIA SECUNDARIA DE MENORES N° 60024 SAN JUAN DE MIRAFLORES");
                Local local160 = new Local(23,122,"I.E. PÚBLICA PRIMARIA SECUNDARIA DE MENORES N° 60993 RAMÓN CASTILLA Y MARQUESADO");
                Local local161 = new Local(23,101,"I.E. PÚBLICA SECUNDARIA DE MENORES COLEGIO NACIONAL DE IQUITOS");
                Local local162 = new Local(24,146,"I.E. N° 62001 JOSÉ CUPERTINO GOMERO COTILLO");
                Local local163 = new Local(24,157,"I.E. N° 62007-JOSÉ MARÍA ARGUEDAS");
                Local local164 = new Local(24,165,"I.E. N° 62174 REVERENDO PADRE JUAN JULIAN PRIMO RUIZ");
                Local local165 = new Local(25,95,"I.E. AUGUSTO BOURONCLE ACUÑA");
                Local local166 = new Local(25,118,"I.E. EMBLEMÁTICA SANTA ROSA");
                Local local167 = new Local(26,85,"I.E.  RAFAEL DÍAZ");
                Local local168 = new Local(26,69,"I.E. EMBLEMÁTICA SIMÓN BOLÍVAR");
                Local local169 = new Local(27,30,"I.E. EMBLEMÁTICA DANIEL ALCIDES CARRIÓN");
                Local local170 = new Local(27,62,"I.E. EMBLEMÁTICA MARIA PARADO DE BELLIDO");
                Local local171 = new Local(27,52,"I.E. INDUSTRIAL N° 03 ANTENOR RIZO PATRÓN LEQUERICA");
                Local local172 = new Local(28,31,"I.E. CORONEL JOSÉ JOAQUÍN INCLÁN");
                Local local173 = new Local(28,67,"I.E. ENRIQUE LÓPEZ ALBUJAR");
                Local local174 = new Local(28,58,"I.E. HARVARD COLLEGE");
                Local local175 = new Local(28,115,"I.E. JORGE BASADRE");
                Local local176 = new Local(28,135,"I.E. JOSÉ CARLOS MARIÁTEGUI");
                Local local177 = new Local(28,82,"I.E. MANUEL OCTAVIANO HIDALGO CARNERO");
                Local local178 = new Local(28,89,"I.E. NUESTRA SEÑORA DE FÁTIMA");
                Local local179 = new Local(28,47,"I.E. PNP BACILIO RAMIREZ PEÑA");
                Local local180 = new Local(28,128,"I.E. ROSA CARRERA DE MARTOS");
                Local local181 = new Local(28,22,"I.E. SAGRADO CORAZÓN DE JESÚS");
                Local local182 = new Local(28,100,"I.E. SAN MIGUEL");
                Local local183 = new Local(28,110,"I.E. TENIENTE MIGUEL CORTES DEL CASTILLO");
                Local local184 = new Local(28,120,"UNIVERSIDAD ALAS PERUANAS");
                Local local185 = new Local(29,34,"COLEGIO PARROQUIAL FRANCISCANO SAN ROMÁN");
                Local local186 = new Local(29,66,"I.E. PRIVADA CLAUDIO GALENO");
                Local local187 = new Local(29,81,"I.E. SECUNDARIA GRAN UNIDAD ESCOLAR JOSÉ ANTONIO ENCINAS");
                Local local188 = new Local(29,71,"I.E. SECUNDARIA GRAN UNIDAD ESCOLAR LAS MERCEDES");
                Local local189 = new Local(29,56,"I.E. SECUNDARIA POLITÉCNICO REGIONAL LOS ANDES");
                Local local190 = new Local(29,94,"I.E. SECUNDARIA SAN MARTÍN");
                Local local191 = new Local(29,88,"I.E.S.T.P. MANUEL NUÑEZ BUTRÓN");
                Local local192 = new Local(29,50,"I.S.P.P. DE JULIACA");
                Local local193 = new Local(29,40,"UNIVERSIDAD NACIONAL DE JULIACA");
                Local local194 = new Local(30,147,"I.E. SECUNDARIA EMBLEMÁTICA MARÍA AUXILIADORA");
                Local local195 = new Local(30,131,"I.E. SECUNDARIA GRAN UNIDAD ESCOLAR SAN CARLOS");
                Local local196 = new Local(30,136,"I.E. SECUNDARIA SANTA ROSA - PUNO");
                Local local197 = new Local(30,127,"I.S.E.P. JOSÉ ANTONIO ENCINAS");
                Local local198 = new Local(30,152,"UNIVERSIDAD ANDINA NÉSTOR CÁCERES VELASQUEZ ");
                Local local199 = new Local(31,153,"I.E. ÁREAS TÉCNICAS JESÚS ALBERTO MIRANDA CALLE");
                Local local200 = new Local(31,141,"I.E. IGNACIA VELASQUEZ");
                Local local201 = new Local(31,121,"I.E. SERAFÍN FILOMENO");
                Local local202 = new Local(32,158,"I.E. EMBLEMÁTICA JUAN JIMENEZ PIMENTEL");
                Local local203 = new Local(32,189,"I.E. N° 0750 ELSA PEREA FLORES");
                Local local204 = new Local(32,170,"I.E. SANTA ROSA");
                Local local205 = new Local(32,145,"I.S.P.P. TARAPOTO");
                Local local206 = new Local(32,182,"UNIVERSIDAD NACIONAL DE SAN MARTIN");
                Local local207 = new Local(33,181,"I.E. CIMA");
                Local local208 = new Local(33,167,"I.E. MODESTO BASADRE");
                Local local209 = new Local(34,53,"I.E. INMACULADA CONCEPCIÓN");
                Local local210 = new Local(34,44,"UNIVERSIDAD NACIONAL DE TUMBES");
                Local local211 = new Local(35,33,"I.E. COMERCIO N° 64");
                Local local212 = new Local(35,2,"I.E. EMBLEMÁTICA CORONEL PEDRO PORTILLO");
                Local local213 = new Local(35,10,"I.E. EMBLEMÁTICA FAUSTINO MALDONADO");
                Local local214 = new Local(35,21,"I.E. LA INMACULADA");
                Local local215 = new Local(35,42,"I.E. SAN FERNANDO");


                WriteBatch batch = db.batch();
                batch.set(db.collection("sedes").document(local1.getIdsede()+"").collection("locales").document(local1.getIdlocal()+""), new LocalMap(local1.getLocal()));
                batch.set(db.collection("sedes").document(local2.getIdsede()+"").collection("locales").document(local2.getIdlocal()+""), new LocalMap(local2.getLocal()));
                batch.set(db.collection("sedes").document(local3.getIdsede()+"").collection("locales").document(local3.getIdlocal()+""), new LocalMap(local3.getLocal()));
                batch.set(db.collection("sedes").document(local4.getIdsede()+"").collection("locales").document(local4.getIdlocal()+""), new LocalMap(local4.getLocal()));
                batch.set(db.collection("sedes").document(local5.getIdsede()+"").collection("locales").document(local5.getIdlocal()+""), new LocalMap(local5.getLocal()));
                batch.set(db.collection("sedes").document(local6.getIdsede()+"").collection("locales").document(local6.getIdlocal()+""), new LocalMap(local6.getLocal()));
                batch.set(db.collection("sedes").document(local7.getIdsede()+"").collection("locales").document(local7.getIdlocal()+""), new LocalMap(local7.getLocal()));
                batch.set(db.collection("sedes").document(local8.getIdsede()+"").collection("locales").document(local8.getIdlocal()+""), new LocalMap(local8.getLocal()));
                batch.set(db.collection("sedes").document(local9.getIdsede()+"").collection("locales").document(local9.getIdlocal()+""), new LocalMap(local9.getLocal()));
                batch.set(db.collection("sedes").document(local10.getIdsede()+"").collection("locales").document(local10.getIdlocal()+""), new LocalMap(local10.getLocal()));
                batch.set(db.collection("sedes").document(local11.getIdsede()+"").collection("locales").document(local11.getIdlocal()+""), new LocalMap(local11.getLocal()));
                batch.set(db.collection("sedes").document(local12.getIdsede()+"").collection("locales").document(local12.getIdlocal()+""), new LocalMap(local12.getLocal()));
                batch.set(db.collection("sedes").document(local13.getIdsede()+"").collection("locales").document(local13.getIdlocal()+""), new LocalMap(local13.getLocal()));
                batch.set(db.collection("sedes").document(local14.getIdsede()+"").collection("locales").document(local14.getIdlocal()+""), new LocalMap(local14.getLocal()));
                batch.set(db.collection("sedes").document(local15.getIdsede()+"").collection("locales").document(local15.getIdlocal()+""), new LocalMap(local15.getLocal()));
                batch.set(db.collection("sedes").document(local16.getIdsede()+"").collection("locales").document(local16.getIdlocal()+""), new LocalMap(local16.getLocal()));
                batch.set(db.collection("sedes").document(local17.getIdsede()+"").collection("locales").document(local17.getIdlocal()+""), new LocalMap(local17.getLocal()));
                batch.set(db.collection("sedes").document(local18.getIdsede()+"").collection("locales").document(local18.getIdlocal()+""), new LocalMap(local18.getLocal()));
                batch.set(db.collection("sedes").document(local19.getIdsede()+"").collection("locales").document(local19.getIdlocal()+""), new LocalMap(local19.getLocal()));
                batch.set(db.collection("sedes").document(local20.getIdsede()+"").collection("locales").document(local20.getIdlocal()+""), new LocalMap(local20.getLocal()));
                batch.set(db.collection("sedes").document(local21.getIdsede()+"").collection("locales").document(local21.getIdlocal()+""), new LocalMap(local21.getLocal()));
                batch.set(db.collection("sedes").document(local22.getIdsede()+"").collection("locales").document(local22.getIdlocal()+""), new LocalMap(local22.getLocal()));
                batch.set(db.collection("sedes").document(local23.getIdsede()+"").collection("locales").document(local23.getIdlocal()+""), new LocalMap(local23.getLocal()));
                batch.set(db.collection("sedes").document(local24.getIdsede()+"").collection("locales").document(local24.getIdlocal()+""), new LocalMap(local24.getLocal()));
                batch.set(db.collection("sedes").document(local25.getIdsede()+"").collection("locales").document(local25.getIdlocal()+""), new LocalMap(local25.getLocal()));
                batch.set(db.collection("sedes").document(local26.getIdsede()+"").collection("locales").document(local26.getIdlocal()+""), new LocalMap(local26.getLocal()));
                batch.set(db.collection("sedes").document(local27.getIdsede()+"").collection("locales").document(local27.getIdlocal()+""), new LocalMap(local27.getLocal()));
                batch.set(db.collection("sedes").document(local28.getIdsede()+"").collection("locales").document(local28.getIdlocal()+""), new LocalMap(local28.getLocal()));
                batch.set(db.collection("sedes").document(local29.getIdsede()+"").collection("locales").document(local29.getIdlocal()+""), new LocalMap(local29.getLocal()));
                batch.set(db.collection("sedes").document(local30.getIdsede()+"").collection("locales").document(local30.getIdlocal()+""), new LocalMap(local30.getLocal()));
                batch.set(db.collection("sedes").document(local31.getIdsede()+"").collection("locales").document(local31.getIdlocal()+""), new LocalMap(local31.getLocal()));
                batch.set(db.collection("sedes").document(local32.getIdsede()+"").collection("locales").document(local32.getIdlocal()+""), new LocalMap(local32.getLocal()));
                batch.set(db.collection("sedes").document(local33.getIdsede()+"").collection("locales").document(local33.getIdlocal()+""), new LocalMap(local33.getLocal()));
                batch.set(db.collection("sedes").document(local34.getIdsede()+"").collection("locales").document(local34.getIdlocal()+""), new LocalMap(local34.getLocal()));
                batch.set(db.collection("sedes").document(local35.getIdsede()+"").collection("locales").document(local35.getIdlocal()+""), new LocalMap(local35.getLocal()));
                batch.set(db.collection("sedes").document(local36.getIdsede()+"").collection("locales").document(local36.getIdlocal()+""), new LocalMap(local36.getLocal()));
                batch.set(db.collection("sedes").document(local37.getIdsede()+"").collection("locales").document(local37.getIdlocal()+""), new LocalMap(local37.getLocal()));
                batch.set(db.collection("sedes").document(local38.getIdsede()+"").collection("locales").document(local38.getIdlocal()+""), new LocalMap(local38.getLocal()));
                batch.set(db.collection("sedes").document(local39.getIdsede()+"").collection("locales").document(local39.getIdlocal()+""), new LocalMap(local39.getLocal()));
                batch.set(db.collection("sedes").document(local40.getIdsede()+"").collection("locales").document(local40.getIdlocal()+""), new LocalMap(local40.getLocal()));
                batch.set(db.collection("sedes").document(local41.getIdsede()+"").collection("locales").document(local41.getIdlocal()+""), new LocalMap(local41.getLocal()));
                batch.set(db.collection("sedes").document(local42.getIdsede()+"").collection("locales").document(local42.getIdlocal()+""), new LocalMap(local42.getLocal()));
                batch.set(db.collection("sedes").document(local43.getIdsede()+"").collection("locales").document(local43.getIdlocal()+""), new LocalMap(local43.getLocal()));
                batch.set(db.collection("sedes").document(local44.getIdsede()+"").collection("locales").document(local44.getIdlocal()+""), new LocalMap(local44.getLocal()));
                batch.set(db.collection("sedes").document(local45.getIdsede()+"").collection("locales").document(local45.getIdlocal()+""), new LocalMap(local45.getLocal()));
                batch.set(db.collection("sedes").document(local46.getIdsede()+"").collection("locales").document(local46.getIdlocal()+""), new LocalMap(local46.getLocal()));
                batch.set(db.collection("sedes").document(local47.getIdsede()+"").collection("locales").document(local47.getIdlocal()+""), new LocalMap(local47.getLocal()));
                batch.set(db.collection("sedes").document(local48.getIdsede()+"").collection("locales").document(local48.getIdlocal()+""), new LocalMap(local48.getLocal()));
                batch.set(db.collection("sedes").document(local49.getIdsede()+"").collection("locales").document(local49.getIdlocal()+""), new LocalMap(local49.getLocal()));
                batch.set(db.collection("sedes").document(local50.getIdsede()+"").collection("locales").document(local50.getIdlocal()+""), new LocalMap(local50.getLocal()));
                batch.set(db.collection("sedes").document(local51.getIdsede()+"").collection("locales").document(local51.getIdlocal()+""), new LocalMap(local51.getLocal()));
                batch.set(db.collection("sedes").document(local52.getIdsede()+"").collection("locales").document(local52.getIdlocal()+""), new LocalMap(local52.getLocal()));
                batch.set(db.collection("sedes").document(local53.getIdsede()+"").collection("locales").document(local53.getIdlocal()+""), new LocalMap(local53.getLocal()));
                batch.set(db.collection("sedes").document(local54.getIdsede()+"").collection("locales").document(local54.getIdlocal()+""), new LocalMap(local54.getLocal()));
                batch.set(db.collection("sedes").document(local55.getIdsede()+"").collection("locales").document(local55.getIdlocal()+""), new LocalMap(local55.getLocal()));
                batch.set(db.collection("sedes").document(local56.getIdsede()+"").collection("locales").document(local56.getIdlocal()+""), new LocalMap(local56.getLocal()));
                batch.set(db.collection("sedes").document(local57.getIdsede()+"").collection("locales").document(local57.getIdlocal()+""), new LocalMap(local57.getLocal()));
                batch.set(db.collection("sedes").document(local58.getIdsede()+"").collection("locales").document(local58.getIdlocal()+""), new LocalMap(local58.getLocal()));
                batch.set(db.collection("sedes").document(local59.getIdsede()+"").collection("locales").document(local59.getIdlocal()+""), new LocalMap(local59.getLocal()));
                batch.set(db.collection("sedes").document(local60.getIdsede()+"").collection("locales").document(local60.getIdlocal()+""), new LocalMap(local60.getLocal()));
                batch.set(db.collection("sedes").document(local61.getIdsede()+"").collection("locales").document(local61.getIdlocal()+""), new LocalMap(local61.getLocal()));
                batch.set(db.collection("sedes").document(local62.getIdsede()+"").collection("locales").document(local62.getIdlocal()+""), new LocalMap(local62.getLocal()));
                batch.set(db.collection("sedes").document(local63.getIdsede()+"").collection("locales").document(local63.getIdlocal()+""), new LocalMap(local63.getLocal()));
                batch.set(db.collection("sedes").document(local64.getIdsede()+"").collection("locales").document(local64.getIdlocal()+""), new LocalMap(local64.getLocal()));
                batch.set(db.collection("sedes").document(local65.getIdsede()+"").collection("locales").document(local65.getIdlocal()+""), new LocalMap(local65.getLocal()));
                batch.set(db.collection("sedes").document(local66.getIdsede()+"").collection("locales").document(local66.getIdlocal()+""), new LocalMap(local66.getLocal()));
                batch.set(db.collection("sedes").document(local67.getIdsede()+"").collection("locales").document(local67.getIdlocal()+""), new LocalMap(local67.getLocal()));
                batch.set(db.collection("sedes").document(local68.getIdsede()+"").collection("locales").document(local68.getIdlocal()+""), new LocalMap(local68.getLocal()));
                batch.set(db.collection("sedes").document(local69.getIdsede()+"").collection("locales").document(local69.getIdlocal()+""), new LocalMap(local69.getLocal()));
                batch.set(db.collection("sedes").document(local70.getIdsede()+"").collection("locales").document(local70.getIdlocal()+""), new LocalMap(local70.getLocal()));
                batch.set(db.collection("sedes").document(local71.getIdsede()+"").collection("locales").document(local71.getIdlocal()+""), new LocalMap(local71.getLocal()));
                batch.set(db.collection("sedes").document(local72.getIdsede()+"").collection("locales").document(local72.getIdlocal()+""), new LocalMap(local72.getLocal()));
                batch.set(db.collection("sedes").document(local73.getIdsede()+"").collection("locales").document(local73.getIdlocal()+""), new LocalMap(local73.getLocal()));
                batch.set(db.collection("sedes").document(local74.getIdsede()+"").collection("locales").document(local74.getIdlocal()+""), new LocalMap(local74.getLocal()));
                batch.set(db.collection("sedes").document(local75.getIdsede()+"").collection("locales").document(local75.getIdlocal()+""), new LocalMap(local75.getLocal()));
                batch.set(db.collection("sedes").document(local76.getIdsede()+"").collection("locales").document(local76.getIdlocal()+""), new LocalMap(local76.getLocal()));
                batch.set(db.collection("sedes").document(local77.getIdsede()+"").collection("locales").document(local77.getIdlocal()+""), new LocalMap(local77.getLocal()));
                batch.set(db.collection("sedes").document(local78.getIdsede()+"").collection("locales").document(local78.getIdlocal()+""), new LocalMap(local78.getLocal()));
                batch.set(db.collection("sedes").document(local79.getIdsede()+"").collection("locales").document(local79.getIdlocal()+""), new LocalMap(local79.getLocal()));
                batch.set(db.collection("sedes").document(local80.getIdsede()+"").collection("locales").document(local80.getIdlocal()+""), new LocalMap(local80.getLocal()));
                batch.set(db.collection("sedes").document(local81.getIdsede()+"").collection("locales").document(local81.getIdlocal()+""), new LocalMap(local81.getLocal()));
                batch.set(db.collection("sedes").document(local82.getIdsede()+"").collection("locales").document(local82.getIdlocal()+""), new LocalMap(local82.getLocal()));
                batch.set(db.collection("sedes").document(local83.getIdsede()+"").collection("locales").document(local83.getIdlocal()+""), new LocalMap(local83.getLocal()));
                batch.set(db.collection("sedes").document(local84.getIdsede()+"").collection("locales").document(local84.getIdlocal()+""), new LocalMap(local84.getLocal()));
                batch.set(db.collection("sedes").document(local85.getIdsede()+"").collection("locales").document(local85.getIdlocal()+""), new LocalMap(local85.getLocal()));
                batch.set(db.collection("sedes").document(local86.getIdsede()+"").collection("locales").document(local86.getIdlocal()+""), new LocalMap(local86.getLocal()));
                batch.set(db.collection("sedes").document(local87.getIdsede()+"").collection("locales").document(local87.getIdlocal()+""), new LocalMap(local87.getLocal()));
                batch.set(db.collection("sedes").document(local88.getIdsede()+"").collection("locales").document(local88.getIdlocal()+""), new LocalMap(local88.getLocal()));
                batch.set(db.collection("sedes").document(local89.getIdsede()+"").collection("locales").document(local89.getIdlocal()+""), new LocalMap(local89.getLocal()));
                batch.set(db.collection("sedes").document(local90.getIdsede()+"").collection("locales").document(local90.getIdlocal()+""), new LocalMap(local90.getLocal()));
                batch.set(db.collection("sedes").document(local91.getIdsede()+"").collection("locales").document(local91.getIdlocal()+""), new LocalMap(local91.getLocal()));
                batch.set(db.collection("sedes").document(local92.getIdsede()+"").collection("locales").document(local92.getIdlocal()+""), new LocalMap(local92.getLocal()));
                batch.set(db.collection("sedes").document(local93.getIdsede()+"").collection("locales").document(local93.getIdlocal()+""), new LocalMap(local93.getLocal()));
                batch.set(db.collection("sedes").document(local94.getIdsede()+"").collection("locales").document(local94.getIdlocal()+""), new LocalMap(local94.getLocal()));
                batch.set(db.collection("sedes").document(local95.getIdsede()+"").collection("locales").document(local95.getIdlocal()+""), new LocalMap(local95.getLocal()));
                batch.set(db.collection("sedes").document(local96.getIdsede()+"").collection("locales").document(local96.getIdlocal()+""), new LocalMap(local96.getLocal()));
                batch.set(db.collection("sedes").document(local97.getIdsede()+"").collection("locales").document(local97.getIdlocal()+""), new LocalMap(local97.getLocal()));
                batch.set(db.collection("sedes").document(local98.getIdsede()+"").collection("locales").document(local98.getIdlocal()+""), new LocalMap(local98.getLocal()));
                batch.set(db.collection("sedes").document(local99.getIdsede()+"").collection("locales").document(local99.getIdlocal()+""), new LocalMap(local99.getLocal()));
                batch.set(db.collection("sedes").document(local100.getIdsede()+"").collection("locales").document(local100.getIdlocal()+""), new LocalMap(local100.getLocal()));
                batch.set(db.collection("sedes").document(local101.getIdsede()+"").collection("locales").document(local101.getIdlocal()+""), new LocalMap(local101.getLocal()));
                batch.set(db.collection("sedes").document(local102.getIdsede()+"").collection("locales").document(local102.getIdlocal()+""), new LocalMap(local102.getLocal()));
                batch.set(db.collection("sedes").document(local103.getIdsede()+"").collection("locales").document(local103.getIdlocal()+""), new LocalMap(local103.getLocal()));
                batch.set(db.collection("sedes").document(local104.getIdsede()+"").collection("locales").document(local104.getIdlocal()+""), new LocalMap(local104.getLocal()));
                batch.set(db.collection("sedes").document(local105.getIdsede()+"").collection("locales").document(local105.getIdlocal()+""), new LocalMap(local105.getLocal()));
                batch.set(db.collection("sedes").document(local106.getIdsede()+"").collection("locales").document(local106.getIdlocal()+""), new LocalMap(local106.getLocal()));
                batch.set(db.collection("sedes").document(local107.getIdsede()+"").collection("locales").document(local107.getIdlocal()+""), new LocalMap(local107.getLocal()));
                batch.set(db.collection("sedes").document(local108.getIdsede()+"").collection("locales").document(local108.getIdlocal()+""), new LocalMap(local108.getLocal()));
                batch.set(db.collection("sedes").document(local109.getIdsede()+"").collection("locales").document(local109.getIdlocal()+""), new LocalMap(local109.getLocal()));
                batch.set(db.collection("sedes").document(local110.getIdsede()+"").collection("locales").document(local110.getIdlocal()+""), new LocalMap(local110.getLocal()));
                batch.set(db.collection("sedes").document(local111.getIdsede()+"").collection("locales").document(local111.getIdlocal()+""), new LocalMap(local111.getLocal()));
                batch.set(db.collection("sedes").document(local112.getIdsede()+"").collection("locales").document(local112.getIdlocal()+""), new LocalMap(local112.getLocal()));
                batch.set(db.collection("sedes").document(local113.getIdsede()+"").collection("locales").document(local113.getIdlocal()+""), new LocalMap(local113.getLocal()));
                batch.set(db.collection("sedes").document(local114.getIdsede()+"").collection("locales").document(local114.getIdlocal()+""), new LocalMap(local114.getLocal()));
                batch.set(db.collection("sedes").document(local115.getIdsede()+"").collection("locales").document(local115.getIdlocal()+""), new LocalMap(local115.getLocal()));
                batch.set(db.collection("sedes").document(local116.getIdsede()+"").collection("locales").document(local116.getIdlocal()+""), new LocalMap(local116.getLocal()));
                batch.set(db.collection("sedes").document(local117.getIdsede()+"").collection("locales").document(local117.getIdlocal()+""), new LocalMap(local117.getLocal()));
                batch.set(db.collection("sedes").document(local118.getIdsede()+"").collection("locales").document(local118.getIdlocal()+""), new LocalMap(local118.getLocal()));
                batch.set(db.collection("sedes").document(local119.getIdsede()+"").collection("locales").document(local119.getIdlocal()+""), new LocalMap(local119.getLocal()));
                batch.set(db.collection("sedes").document(local120.getIdsede()+"").collection("locales").document(local120.getIdlocal()+""), new LocalMap(local120.getLocal()));
                batch.set(db.collection("sedes").document(local121.getIdsede()+"").collection("locales").document(local121.getIdlocal()+""), new LocalMap(local121.getLocal()));
                batch.set(db.collection("sedes").document(local122.getIdsede()+"").collection("locales").document(local122.getIdlocal()+""), new LocalMap(local122.getLocal()));
                batch.set(db.collection("sedes").document(local123.getIdsede()+"").collection("locales").document(local123.getIdlocal()+""), new LocalMap(local123.getLocal()));
                batch.set(db.collection("sedes").document(local124.getIdsede()+"").collection("locales").document(local124.getIdlocal()+""), new LocalMap(local124.getLocal()));
                batch.set(db.collection("sedes").document(local125.getIdsede()+"").collection("locales").document(local125.getIdlocal()+""), new LocalMap(local125.getLocal()));
                batch.set(db.collection("sedes").document(local126.getIdsede()+"").collection("locales").document(local126.getIdlocal()+""), new LocalMap(local126.getLocal()));
                batch.set(db.collection("sedes").document(local127.getIdsede()+"").collection("locales").document(local127.getIdlocal()+""), new LocalMap(local127.getLocal()));
                batch.set(db.collection("sedes").document(local128.getIdsede()+"").collection("locales").document(local128.getIdlocal()+""), new LocalMap(local128.getLocal()));
                batch.set(db.collection("sedes").document(local129.getIdsede()+"").collection("locales").document(local129.getIdlocal()+""), new LocalMap(local129.getLocal()));
                batch.set(db.collection("sedes").document(local130.getIdsede()+"").collection("locales").document(local130.getIdlocal()+""), new LocalMap(local130.getLocal()));
                batch.set(db.collection("sedes").document(local131.getIdsede()+"").collection("locales").document(local131.getIdlocal()+""), new LocalMap(local131.getLocal()));
                batch.set(db.collection("sedes").document(local132.getIdsede()+"").collection("locales").document(local132.getIdlocal()+""), new LocalMap(local132.getLocal()));
                batch.set(db.collection("sedes").document(local133.getIdsede()+"").collection("locales").document(local133.getIdlocal()+""), new LocalMap(local133.getLocal()));
                batch.set(db.collection("sedes").document(local134.getIdsede()+"").collection("locales").document(local134.getIdlocal()+""), new LocalMap(local134.getLocal()));
                batch.set(db.collection("sedes").document(local135.getIdsede()+"").collection("locales").document(local135.getIdlocal()+""), new LocalMap(local135.getLocal()));
                batch.set(db.collection("sedes").document(local136.getIdsede()+"").collection("locales").document(local136.getIdlocal()+""), new LocalMap(local136.getLocal()));
                batch.set(db.collection("sedes").document(local137.getIdsede()+"").collection("locales").document(local137.getIdlocal()+""), new LocalMap(local137.getLocal()));
                batch.set(db.collection("sedes").document(local138.getIdsede()+"").collection("locales").document(local138.getIdlocal()+""), new LocalMap(local138.getLocal()));
                batch.set(db.collection("sedes").document(local139.getIdsede()+"").collection("locales").document(local139.getIdlocal()+""), new LocalMap(local139.getLocal()));
                batch.set(db.collection("sedes").document(local140.getIdsede()+"").collection("locales").document(local140.getIdlocal()+""), new LocalMap(local140.getLocal()));
                batch.set(db.collection("sedes").document(local141.getIdsede()+"").collection("locales").document(local141.getIdlocal()+""), new LocalMap(local141.getLocal()));
                batch.set(db.collection("sedes").document(local142.getIdsede()+"").collection("locales").document(local142.getIdlocal()+""), new LocalMap(local142.getLocal()));
                batch.set(db.collection("sedes").document(local143.getIdsede()+"").collection("locales").document(local143.getIdlocal()+""), new LocalMap(local143.getLocal()));
                batch.set(db.collection("sedes").document(local144.getIdsede()+"").collection("locales").document(local144.getIdlocal()+""), new LocalMap(local144.getLocal()));
                batch.set(db.collection("sedes").document(local145.getIdsede()+"").collection("locales").document(local145.getIdlocal()+""), new LocalMap(local145.getLocal()));
                batch.set(db.collection("sedes").document(local146.getIdsede()+"").collection("locales").document(local146.getIdlocal()+""), new LocalMap(local146.getLocal()));
                batch.set(db.collection("sedes").document(local147.getIdsede()+"").collection("locales").document(local147.getIdlocal()+""), new LocalMap(local147.getLocal()));
                batch.set(db.collection("sedes").document(local148.getIdsede()+"").collection("locales").document(local148.getIdlocal()+""), new LocalMap(local148.getLocal()));
                batch.set(db.collection("sedes").document(local149.getIdsede()+"").collection("locales").document(local149.getIdlocal()+""), new LocalMap(local149.getLocal()));
                batch.set(db.collection("sedes").document(local150.getIdsede()+"").collection("locales").document(local150.getIdlocal()+""), new LocalMap(local150.getLocal()));
                batch.set(db.collection("sedes").document(local151.getIdsede()+"").collection("locales").document(local151.getIdlocal()+""), new LocalMap(local151.getLocal()));
                batch.set(db.collection("sedes").document(local152.getIdsede()+"").collection("locales").document(local152.getIdlocal()+""), new LocalMap(local152.getLocal()));
                batch.set(db.collection("sedes").document(local153.getIdsede()+"").collection("locales").document(local153.getIdlocal()+""), new LocalMap(local153.getLocal()));
                batch.set(db.collection("sedes").document(local154.getIdsede()+"").collection("locales").document(local154.getIdlocal()+""), new LocalMap(local154.getLocal()));
                batch.set(db.collection("sedes").document(local155.getIdsede()+"").collection("locales").document(local155.getIdlocal()+""), new LocalMap(local155.getLocal()));
                batch.set(db.collection("sedes").document(local156.getIdsede()+"").collection("locales").document(local156.getIdlocal()+""), new LocalMap(local156.getLocal()));
                batch.set(db.collection("sedes").document(local157.getIdsede()+"").collection("locales").document(local157.getIdlocal()+""), new LocalMap(local157.getLocal()));
                batch.set(db.collection("sedes").document(local158.getIdsede()+"").collection("locales").document(local158.getIdlocal()+""), new LocalMap(local158.getLocal()));
                batch.set(db.collection("sedes").document(local159.getIdsede()+"").collection("locales").document(local159.getIdlocal()+""), new LocalMap(local159.getLocal()));
                batch.set(db.collection("sedes").document(local160.getIdsede()+"").collection("locales").document(local160.getIdlocal()+""), new LocalMap(local160.getLocal()));
                batch.set(db.collection("sedes").document(local161.getIdsede()+"").collection("locales").document(local161.getIdlocal()+""), new LocalMap(local161.getLocal()));
                batch.set(db.collection("sedes").document(local162.getIdsede()+"").collection("locales").document(local162.getIdlocal()+""), new LocalMap(local162.getLocal()));
                batch.set(db.collection("sedes").document(local163.getIdsede()+"").collection("locales").document(local163.getIdlocal()+""), new LocalMap(local163.getLocal()));
                batch.set(db.collection("sedes").document(local164.getIdsede()+"").collection("locales").document(local164.getIdlocal()+""), new LocalMap(local164.getLocal()));
                batch.set(db.collection("sedes").document(local165.getIdsede()+"").collection("locales").document(local165.getIdlocal()+""), new LocalMap(local165.getLocal()));
                batch.set(db.collection("sedes").document(local166.getIdsede()+"").collection("locales").document(local166.getIdlocal()+""), new LocalMap(local166.getLocal()));
                batch.set(db.collection("sedes").document(local167.getIdsede()+"").collection("locales").document(local167.getIdlocal()+""), new LocalMap(local167.getLocal()));
                batch.set(db.collection("sedes").document(local168.getIdsede()+"").collection("locales").document(local168.getIdlocal()+""), new LocalMap(local168.getLocal()));
                batch.set(db.collection("sedes").document(local169.getIdsede()+"").collection("locales").document(local169.getIdlocal()+""), new LocalMap(local169.getLocal()));
                batch.set(db.collection("sedes").document(local170.getIdsede()+"").collection("locales").document(local170.getIdlocal()+""), new LocalMap(local170.getLocal()));
                batch.set(db.collection("sedes").document(local171.getIdsede()+"").collection("locales").document(local171.getIdlocal()+""), new LocalMap(local171.getLocal()));
                batch.set(db.collection("sedes").document(local172.getIdsede()+"").collection("locales").document(local172.getIdlocal()+""), new LocalMap(local172.getLocal()));
                batch.set(db.collection("sedes").document(local173.getIdsede()+"").collection("locales").document(local173.getIdlocal()+""), new LocalMap(local173.getLocal()));
                batch.set(db.collection("sedes").document(local174.getIdsede()+"").collection("locales").document(local174.getIdlocal()+""), new LocalMap(local174.getLocal()));
                batch.set(db.collection("sedes").document(local175.getIdsede()+"").collection("locales").document(local175.getIdlocal()+""), new LocalMap(local175.getLocal()));
                batch.set(db.collection("sedes").document(local176.getIdsede()+"").collection("locales").document(local176.getIdlocal()+""), new LocalMap(local176.getLocal()));
                batch.set(db.collection("sedes").document(local177.getIdsede()+"").collection("locales").document(local177.getIdlocal()+""), new LocalMap(local177.getLocal()));
                batch.set(db.collection("sedes").document(local178.getIdsede()+"").collection("locales").document(local178.getIdlocal()+""), new LocalMap(local178.getLocal()));
                batch.set(db.collection("sedes").document(local179.getIdsede()+"").collection("locales").document(local179.getIdlocal()+""), new LocalMap(local179.getLocal()));
                batch.set(db.collection("sedes").document(local180.getIdsede()+"").collection("locales").document(local180.getIdlocal()+""), new LocalMap(local180.getLocal()));
                batch.set(db.collection("sedes").document(local181.getIdsede()+"").collection("locales").document(local181.getIdlocal()+""), new LocalMap(local181.getLocal()));
                batch.set(db.collection("sedes").document(local182.getIdsede()+"").collection("locales").document(local182.getIdlocal()+""), new LocalMap(local182.getLocal()));
                batch.set(db.collection("sedes").document(local183.getIdsede()+"").collection("locales").document(local183.getIdlocal()+""), new LocalMap(local183.getLocal()));
                batch.set(db.collection("sedes").document(local184.getIdsede()+"").collection("locales").document(local184.getIdlocal()+""), new LocalMap(local184.getLocal()));
                batch.set(db.collection("sedes").document(local185.getIdsede()+"").collection("locales").document(local185.getIdlocal()+""), new LocalMap(local185.getLocal()));
                batch.set(db.collection("sedes").document(local186.getIdsede()+"").collection("locales").document(local186.getIdlocal()+""), new LocalMap(local186.getLocal()));
                batch.set(db.collection("sedes").document(local187.getIdsede()+"").collection("locales").document(local187.getIdlocal()+""), new LocalMap(local187.getLocal()));
                batch.set(db.collection("sedes").document(local188.getIdsede()+"").collection("locales").document(local188.getIdlocal()+""), new LocalMap(local188.getLocal()));
                batch.set(db.collection("sedes").document(local189.getIdsede()+"").collection("locales").document(local189.getIdlocal()+""), new LocalMap(local189.getLocal()));
                batch.set(db.collection("sedes").document(local190.getIdsede()+"").collection("locales").document(local190.getIdlocal()+""), new LocalMap(local190.getLocal()));
                batch.set(db.collection("sedes").document(local191.getIdsede()+"").collection("locales").document(local191.getIdlocal()+""), new LocalMap(local191.getLocal()));
                batch.set(db.collection("sedes").document(local192.getIdsede()+"").collection("locales").document(local192.getIdlocal()+""), new LocalMap(local192.getLocal()));
                batch.set(db.collection("sedes").document(local193.getIdsede()+"").collection("locales").document(local193.getIdlocal()+""), new LocalMap(local193.getLocal()));
                batch.set(db.collection("sedes").document(local194.getIdsede()+"").collection("locales").document(local194.getIdlocal()+""), new LocalMap(local194.getLocal()));
                batch.set(db.collection("sedes").document(local195.getIdsede()+"").collection("locales").document(local195.getIdlocal()+""), new LocalMap(local195.getLocal()));
                batch.set(db.collection("sedes").document(local196.getIdsede()+"").collection("locales").document(local196.getIdlocal()+""), new LocalMap(local196.getLocal()));
                batch.set(db.collection("sedes").document(local197.getIdsede()+"").collection("locales").document(local197.getIdlocal()+""), new LocalMap(local197.getLocal()));
                batch.set(db.collection("sedes").document(local198.getIdsede()+"").collection("locales").document(local198.getIdlocal()+""), new LocalMap(local198.getLocal()));
                batch.set(db.collection("sedes").document(local199.getIdsede()+"").collection("locales").document(local199.getIdlocal()+""), new LocalMap(local199.getLocal()));
                batch.set(db.collection("sedes").document(local200.getIdsede()+"").collection("locales").document(local200.getIdlocal()+""), new LocalMap(local200.getLocal()));
                batch.set(db.collection("sedes").document(local201.getIdsede()+"").collection("locales").document(local201.getIdlocal()+""), new LocalMap(local201.getLocal()));
                batch.set(db.collection("sedes").document(local202.getIdsede()+"").collection("locales").document(local202.getIdlocal()+""), new LocalMap(local202.getLocal()));
                batch.set(db.collection("sedes").document(local203.getIdsede()+"").collection("locales").document(local203.getIdlocal()+""), new LocalMap(local203.getLocal()));
                batch.set(db.collection("sedes").document(local204.getIdsede()+"").collection("locales").document(local204.getIdlocal()+""), new LocalMap(local204.getLocal()));
                batch.set(db.collection("sedes").document(local205.getIdsede()+"").collection("locales").document(local205.getIdlocal()+""), new LocalMap(local205.getLocal()));
                batch.set(db.collection("sedes").document(local206.getIdsede()+"").collection("locales").document(local206.getIdlocal()+""), new LocalMap(local206.getLocal()));
                batch.set(db.collection("sedes").document(local207.getIdsede()+"").collection("locales").document(local207.getIdlocal()+""), new LocalMap(local207.getLocal()));
                batch.set(db.collection("sedes").document(local208.getIdsede()+"").collection("locales").document(local208.getIdlocal()+""), new LocalMap(local208.getLocal()));
                batch.set(db.collection("sedes").document(local209.getIdsede()+"").collection("locales").document(local209.getIdlocal()+""), new LocalMap(local209.getLocal()));
                batch.set(db.collection("sedes").document(local210.getIdsede()+"").collection("locales").document(local210.getIdlocal()+""), new LocalMap(local210.getLocal()));
                batch.set(db.collection("sedes").document(local211.getIdsede()+"").collection("locales").document(local211.getIdlocal()+""), new LocalMap(local211.getLocal()));
                batch.set(db.collection("sedes").document(local212.getIdsede()+"").collection("locales").document(local212.getIdlocal()+""), new LocalMap(local212.getLocal()));
                batch.set(db.collection("sedes").document(local213.getIdsede()+"").collection("locales").document(local213.getIdlocal()+""), new LocalMap(local213.getLocal()));
                batch.set(db.collection("sedes").document(local214.getIdsede()+"").collection("locales").document(local214.getIdlocal()+""), new LocalMap(local214.getLocal()));
                batch.set(db.collection("sedes").document(local215.getIdsede()+"").collection("locales").document(local215.getIdlocal()+""), new LocalMap(local215.getLocal()));

                batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Subidos correctamente 2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        btnEnviar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i <=35 ; i++) {
                    final int numero = i;
                    Data data = new Data(MainActivity.this);
                    data.open();
                    ArrayList<Caja> cajas = data.getAllCajasxSede(i);
                    WriteBatch batch = db.batch();
                    for (Caja caja : cajas){
                        Map<String, Object> cajaFirebase = new HashMap<>();
                        cajaFirebase.put("tipo", caja.getTipo());
                        cajaFirebase.put("check_reg_ingreso", 0);
                        cajaFirebase.put("check_reg_salida", 0);
                        batch.set(
                                db.collection("sedes").document(caja.getIdsede()+"")
                                        .collection("locales").document(caja.getIdlocal()+"")
                                        .collection("cajas").document(caja.getCod_barra_caja()), cajaFirebase);
                    }
                    batch.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity.this, "Subidos correctamente cajas " + numero, Toast.LENGTH_SHORT).show();
                        }
                    });
                    data.close();
                }
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
                SedeRes sedeRes1 = new SedeRes(3,1,"AMAZONAS-BAGUA GRANDE",15,4,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes1);
                SedeRes sedeRes2 = new SedeRes(3,2,"AMAZONAS-CHACHAPOYAS",12,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes2);
                SedeRes sedeRes3 = new SedeRes(3,3,"ANCASH-CHIMBOTE",25,6,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes3);
                SedeRes sedeRes4 = new SedeRes(3,4,"ANCASH-HUARAZ",46,10,10,0,0,0,0,0,0);sedeResArrayList.add(sedeRes4);
                SedeRes sedeRes5 = new SedeRes(3,5,"APURIMAC-ABANCAY",17,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes5);
                SedeRes sedeRes6 = new SedeRes(3,6,"APURIMAC-ANDAHUAYLAS",15,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes6);
                SedeRes sedeRes7 = new SedeRes(3,7,"AREQUIPA",52,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes7);
                SedeRes sedeRes8 = new SedeRes(3,8,"AYACUCHO-HUAMANGA",33,7,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes8);
                SedeRes sedeRes9 = new SedeRes(3,9,"AYACUCHO-PUQUIO",12,4,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes9);
                SedeRes sedeRes10 = new SedeRes(3,10,"CAJAMARCA-CAJAMARCA",71,14,13,0,0,0,0,0,0);sedeResArrayList.add(sedeRes10);
                SedeRes sedeRes11 = new SedeRes(3,11,"CAJAMARCA-JAEN",26,6,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes11);
                SedeRes sedeRes12 = new SedeRes(2,12,"CALLAO",24,5,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes12);
                SedeRes sedeRes13 = new SedeRes(3,13,"CUSCO",60,12,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes13);
                SedeRes sedeRes14 = new SedeRes(3,14,"HUANCAVELICA",25,6,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes14);
                SedeRes sedeRes15 = new SedeRes(3,15,"HUANUCO",42,9,8,0,0,0,0,0,0);sedeResArrayList.add(sedeRes15);
                SedeRes sedeRes16 = new SedeRes(3,16,"ICA",39,8,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes16);
                SedeRes sedeRes17 = new SedeRes(3,17,"JUNIN",63,12,12,0,0,0,0,0,0);sedeResArrayList.add(sedeRes17);
                SedeRes sedeRes18 = new SedeRes(3,18,"LA LIBERTAD",74,14,11,0,0,0,0,0,0);sedeResArrayList.add(sedeRes18);
                SedeRes sedeRes19 = new SedeRes(3,19,"LAMBAYEQUE",54,9,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes19);
                SedeRes sedeRes20 = new SedeRes(1,20,"LIMA METROPOLITANA",206,33,25,0,0,0,0,0,0);sedeResArrayList.add(sedeRes20);
                SedeRes sedeRes21 = new SedeRes(1,21,"LIMA PROVINCIA-CAÑETE",16,4,4,0,0,0,0,0,0);sedeResArrayList.add(sedeRes21);
                SedeRes sedeRes22 = new SedeRes(1,22,"LIMA PROVINCIA-HUACHO",26,4,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes22);
                SedeRes sedeRes23 = new SedeRes(3,23,"LORETO-IQUITOS",42,8,6,0,0,0,0,0,0);sedeResArrayList.add(sedeRes23);
                SedeRes sedeRes24 = new SedeRes(3,24,"LORETO-YURIMAGUAS",9,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes24);
                SedeRes sedeRes25 = new SedeRes(3,25,"MADRE DE DIOS",6,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes25);
                SedeRes sedeRes26 = new SedeRes(3,26,"MOQUEGUA",11,2,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes26);
                SedeRes sedeRes27 = new SedeRes(3,27,"PASCO",15,3,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes27);
                SedeRes sedeRes28 = new SedeRes(3,28,"PIURA",74,17,13,0,0,0,0,0,0);sedeResArrayList.add(sedeRes28);
                SedeRes sedeRes29 = new SedeRes(3,29,"PUNO-JULIACA",48,11,9,0,0,0,0,0,0);sedeResArrayList.add(sedeRes29);
                SedeRes sedeRes30 = new SedeRes(3,30,"PUNO-PUNO",36,8,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes30);
                SedeRes sedeRes31 = new SedeRes(3,31,"SAN MARTIN-MOYOBAMBA",17,4,3,0,0,0,0,0,0);sedeResArrayList.add(sedeRes31);
                SedeRes sedeRes32 = new SedeRes(3,32,"SAN MARTIN-TARAPOTO",27,6,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes32);
                SedeRes sedeRes33 = new SedeRes(3,33,"TACNA",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes33);
                SedeRes sedeRes34 = new SedeRes(3,34,"TUMBES",16,3,2,0,0,0,0,0,0);sedeResArrayList.add(sedeRes34);
                SedeRes sedeRes35 = new SedeRes(3,35,"UCAYALI-PUCALLPA",31,7,5,0,0,0,0,0,0);sedeResArrayList.add(sedeRes35);

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
                            .collection("locales").document(localRes.getIdlocal()+""), localRes);
                    data.close();
                }
                batch3.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "local resumen subido", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarMarco();
//                String dni = edtDni.getText().toString();
//                int edad = Integer.parseInt(edtEdad.getText().toString());
//                int dia = Integer.parseInt(edtDia.getText().toString());
//                int mes = Integer.parseInt(edtMes.getText().toString());
//                int anio = Integer.parseInt(edtAnio.getText().toString());
//
//                Map<String, Object> persona1 = new HashMap<>();
//                persona1.put("edad", edad);
//                persona1.put("dia", dia);
//                persona1.put("mes", mes);
//                persona1.put("anio", anio);
//
//
//                FirebaseFirestore.getInstance().collection("personas").document(dni)
//                        .set(persona1)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Log.d("FIREBASE", "DocumentSnapshot successfully written!");
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("FIREBASE", "Error writing document", e);
//                            }
//                        });

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

    public void cargarMarco(){
        FileChooser fileChooser = new FileChooser(MainActivity.this);
        fileChooser.setFileListener(new FileChooser.FileSelectedListener() {
            @Override
            public void fileSelected(File file) {
                String filename = file.getAbsolutePath();
                Log.d("File", filename);
                Toast.makeText(MainActivity.this, "Cargando..." + filename, Toast.LENGTH_SHORT).show();
                try {
                    Data data = new Data(MainActivity.this,filename);
                    data.open();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fileChooser.showDialog();
    }
}
