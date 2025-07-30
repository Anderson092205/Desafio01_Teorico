package empresaSalarioNeto;
import java.util.Scanner;

public class MainSalario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos el nombre y eliminamos espacios al inicio y final
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine().trim();

        // Validamos que el nombre no esté vacío y que tenga solo letras
        // Esto evita que se ingresen números o caracteres raros como símbolos
        while (nombre.isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Debe ingresar un nombre válido (solo letras).");
            System.out.print("Ingrese nuevamente: ");
            nombre = sc.nextLine().trim();
        }

        double[] ahorros = new double[6];
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};

        double total = 0;
        double mayor = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        int mesMayor = -1;
        int mesMenor = -1;

        // Pedimos los ahorros de cada mes
        for (int i = 0; i < 6; i++) {
            System.out.printf("Ahorro en %s: $", meses[i]);
            double monto = sc.nextDouble();

            // Validamos que el monto sea mayor a cero, nada de ahorros negativos o nulos
            while (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero.");
                System.out.printf("Ingrese nuevamente el ahorro en %s: $", meses[i]);
                monto = sc.nextDouble();
            }

            ahorros[i] = monto;
            total += monto;

            // Buscamos el ahorro más alto
            if (monto > mayor) {
                mayor = monto;
                mesMayor = i;
            }

            // Buscamos el ahorro más bajo
            if (monto < menor) {
                menor = monto;
                mesMenor = i;
            }
        }

        // Mostramos el resumen de cada mes
        System.out.println("\nResumen de ahorro de " + nombre + ":");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%s: $%.2f\n", meses[i], ahorros[i]);
        }

        // Mostramos el total y los extremos
        System.out.printf("\nTotal ahorrado en el semestre: $%.2f\n", total);
        System.out.println("Mes con mayor ahorro: " + meses[mesMayor] + " ($" + mayor + ")");
        System.out.println("Mes con menor ahorro: " + meses[mesMenor] + " ($" + menor + ")");

        // Mensaje motivacional si se superan los $1000
        if (total > 1000) {
            System.out.println("\n¡Felicidades " + nombre + "! Superaste los $1000 en ahorros.");
        }

        sc.close(); // Cerramos el escáner para evitar errores futuros
    }
}
