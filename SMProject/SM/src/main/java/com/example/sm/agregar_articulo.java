package com.example.sm;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Eugenio Cordoba on 17/08/13.
 */
public class agregar_articulo extends Activity {

    private EditText et1, et2, et3, et4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_articulo);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);

        //Salir del activity
        Button salir = (Button) findViewById(R.id.salir);

        // Evento onclick del botón, cuando se pulse, cerramos la actividad
        salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre = et1.getText().toString();
        String precio = et2.getText().toString();
        String descripcion = et3.getText().toString();
        String code = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("precio", precio);
        registro.put("descripcion", descripcion);
        registro.put("code", code);
        bd.insert("articulos", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona",
                Toast.LENGTH_SHORT).show();
    }
}
