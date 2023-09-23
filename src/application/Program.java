package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Digite o número de funcionários: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Dados do funcionário #" + i);

            System.out.print("Terceirizado? (s/n)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Horas: ");
            int hours = sc.nextInt();

            System.out.print("Valor por hora: ");
            double valuerPerHour = sc.nextDouble();

            if (ch == 's') {
                System.out.print("Taxa adicional: ");
                double additionalCharge = sc.nextDouble();

                Employee emp = new OutsourcedEmployee(name, hours, valuerPerHour, additionalCharge);
                list.add(emp);

                //ou
                //list.add(new OutsourcedEmployee(name, hours, valuerPerHour, additionalCharge));
            } else {
                Employee emp = new Employee(name, hours, valuerPerHour);
                list.add(emp);

                //ou
                //list.add(new Employee(name, hours, valuerPerHour));
            }
        }

        System.out.println();
        System.out.println("PAGAMENTOS:");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }

}
