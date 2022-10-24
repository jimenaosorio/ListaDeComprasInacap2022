package cl.ejemplos.listadecomprasinacap2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cl.ejemplos.listadecomprasinacap2022.modelo.ListaDeCompras;
import cl.ejemplos.listadecomprasinacap2022.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {

    public Producto producto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Obtener el ID desde el intent
        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");
        //Recupramos el producto desde el arreglo
        //producto=Producto.productos[id];

        //Recuperamos el producto desde la lista
        producto= ListaDeCompras.getInstancia().getProducto(id);

        //Mostramos la información del producto
        //Nombre del producto
        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        //Cantidad y unidad
        TextView txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtCantidad.setText("Cantidad: "+producto.getCantidad()+" "+producto.getUnidad());

        //Estado, TextView y Botón
        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);
        if(producto.isEstado()==Producto.COMPRADO)
        {
            txtEstado.setText("Estado: COMPRADO");
            estado.setText("Marcar como Pendiente");
        }
        else
        {
            txtEstado.setText("Estado: PENDIENTE");
            estado.setText("Marcar como Comprado");
        }
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto.setEstado(!producto.isEstado());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}







