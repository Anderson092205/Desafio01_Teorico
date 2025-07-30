//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Se crea un producto con la existencia inicial para llamarlo
        Producto p1 = new Producto("Laptops hp", 50);

        //proceso para que aparezca en consola
        p1.ingresar(20);                               //Ingreso a bodega
        p1.ingresar(10, 10);      //Ingreso a bodega + proveedor
        p1.descargar(10);                       //Cuando ya sale el producto


    }
}