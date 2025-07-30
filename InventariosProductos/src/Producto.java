
public class Producto {

    //colores para cada acción
    private static final String VERDE = "\u001B[32m";
    private static final String ROJO = "\u001B[31m";
    private static final String CELESTE = "\u001B[36m";
    private static final String RESET = "\u001B[0m";


    private String nombre;
    private int existencia;


    // Constructor
    public Producto(String nombre, int existenciaInicial) {
        if (existenciaInicial < 0) {
            throw new IllegalArgumentException(ROJO + "\n La existencia inicial debe ser mayor que 0, no puede ser un número negativo." + RESET);
        }
        this.nombre = nombre;
        this.existencia = existenciaInicial;
        mostrarExistencia();
    }


    // Mostrar existencia
    private void mostrarExistencia() {
        System.out.println("Existencia disponible de " + nombre + ": " + existencia + " unidades.");
    }

    // Ingreso simple
    public void ingresar(int cantidad){
        if(cantidad <= 0 ){
            System.out.println(ROJO + "\n La cantidad a ingresar debe ser mayor que 0." + RESET);
            return;
        }
        existencia += cantidad;
        System.out.println(VERDE + "\n Se ingresaron " + cantidad + " unidades de " + nombre + RESET);
        mostrarExistencia();
    }

    // Ingreso desde dos orígenes ya sea lo que entra directamente a bodega
    // o con lo que trae el  proveedor
    public void ingresar(int cantidadBodega, int cantidadProveedor){
        if (cantidadBodega <= 0 || cantidadProveedor <= 0) {
            System.out.println(ROJO + "\n Ambas cantidades deben ser mayores a 0." + RESET);
            return;
        }
        int total = cantidadBodega + cantidadProveedor;
        existencia += total;
        System.out.println(VERDE + "\n Se ingresaron " + total + " unidades de " + nombre + " (bodega + proveedor)" + RESET);
        mostrarExistencia();
    }

    // Descarga del inventario o productos
    public void descargar(int cantidadDescarga){
        if(cantidadDescarga <= 0){
            System.out.println(ROJO + "\n La cantidad a descargar debe ser mayor que 0." + RESET);
            return;
        }
        if (cantidadDescarga > existencia) {
            System.out.println(ROJO + "\n Producto agotado." + RESET);
            return;
        }
        existencia -= cantidadDescarga;
        System.out.println(CELESTE + "\n Se descargaron " + cantidadDescarga + " unidades de " + nombre + " (bodega)" + RESET);
        mostrarExistencia();
    }
}

