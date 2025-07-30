package EmpresaSalarioNeto;
import java.util.Scanner;

public class MainSalario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Preguntamos cuantos empleados hay en el proyecto
        System.out.println("¿Cuántos empleados se han inscrito en el proyecto?: ");
        int cantidad = sc.nextInt();

        //Validamos que sea un numeero positivo
        while (cantidad <= 0) {
            System.out.println("Debe ser mayor a cero.");
            System.out.println("Ingrese nuevamente: ");
            cantidad = sc.nextInt();
        }

        sc.nextLine(); // Limpiamos para evitar errores al leer el texto nuevamente

        double sumaSalariosNetos = 0;

        // Repetimos el proceso para cada empleado
        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\nEmpleado #" + i);

            // Pedimos el nombre
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();

            // Pedimos el salario
            System.out.println("Salario base: $");
            double salario = sc.nextDouble();

            // Validamos que el salario sea valido
            while (salario <= 0) {
                System.out.println("Debe ingresar un monto positivo.");
                System.out.println("Salario: $");
                salario = sc.nextDouble();
            }

            sc.nextLine(); // Limpiamos

            //Calculamos las deducciones
            double renta = (salario > 700) ? salario * 0.10 : 0;
            double isss = salario * 0.03;
            double afp = salario * 0.075;

            // Calculamos el salario final
            double salarioNeto = salario - renta - isss - afp;

            // Sumamos para calcular el promedio final
            sumaSalariosNetos += salarioNeto;

            // Mostramos la informacion individual
            System.out.printf("[Empleado] %s | Salario: $%.2f | Neto: $%.2f\n", nombre, salario, salarioNeto);
        }

        //Calculamos y mostramos el promedio
        double promedio = sumaSalariosNetos / cantidad;
        System.out.printf("\n[Resumen] Promedio de salarios netos: $%.2f\n", promedio);

        sc.close();
    }
}


