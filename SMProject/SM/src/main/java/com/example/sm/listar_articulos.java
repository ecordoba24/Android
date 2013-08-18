package com.example.sm;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eugenio Cordoba on 17/08/13.
 */
public class listar_articulos extends Activity {

    private TextView tv_nombre1, tv_precio1, tv_descripcion1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_articulos);

        tv_nombre1 = (TextView) findViewById(R.id.tv_nombre1);
        tv_precio1 = (TextView) findViewById(R.id.tv_precio1);
        tv_descripcion1 = (TextView) findViewById(R.id.tv_descripcion1);

        //Salir del activity
        Button salir = (Button) findViewById(R.id.salir);

        // Evento onclick del botón, cuando se pulse, cerramos la actividad
        salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery(
                "select nombre, precio, descripcion, code  from articulos ", null);
        if (fila.moveToFirst()) {
            tv_nombre1.setText(fila.getString(0));
            tv_precio1.setText(fila.getString(1));
            tv_descripcion1.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe una persona con dicho dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }
}
