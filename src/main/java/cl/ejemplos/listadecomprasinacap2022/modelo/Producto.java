package cl.ejemplos.listadecomprasinacap2022.modelo;

public class Producto {
    //Atributos
    private String nombre;
    private int cantidad;
    private String unidad;
    private boolean estado;
    //Constantes
    public static final boolean PENDIENTE=true;
    public static final boolean COMPRADO=false;

    /*
    Versión 1: con arreglo
    */
     /*
    public static final Producto[] productos={
            new Producto("Bebida",1,"litro"),
            new Producto("Papas fritas",2,"bolsas"),
            new Producto("Aceitunas",2,"paquetes")
    };
    */


    //Constructor

    public Producto(String nombre, int cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.estado=PENDIENTE;
    }


    //Métodos accesores y modificadores


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String comprado;
        if(estado==COMPRADO)
        {
            comprado="comprado";
        }
        else
        {
            comprado="pendiente";
        }
        return nombre + ": " + comprado;
    }
}
