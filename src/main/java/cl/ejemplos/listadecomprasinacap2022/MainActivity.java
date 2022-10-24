package cl.ejemplos.listadecomprasinacap2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import cl.ejemplos.listadecomprasinacap2022.modelo.ListaDeCompras;
import cl.ejemplos.listadecomprasinacap2022.modelo.Producto;


public class MainActivity extends AppCompatActivity {

    private ListaDeCompras listaDeCompras=ListaDeCompras.getInstancia();
    private ArrayList<Producto> productos=listaDeCompras.getListaDeCompras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ver_lista=(Button) findViewById(R.id.ver_lista);
        ver_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productos.size()>0) {
                    Intent intent = new Intent(MainActivity.this, ListaProductosActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "La lista está vacía",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button botonNuevo=(Button) findViewById(R.id.botonNuevo);
        botonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NuevoProductoActivity.class);
                startActivity(intent);
            }
        });

        Button botonEliminar=(Button) findViewById(R.id.botonEliminar);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaDeCompras.eliminarComprados();
                Toast.makeText(MainActivity.this, "Se han eliminado todos los productos comprados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}