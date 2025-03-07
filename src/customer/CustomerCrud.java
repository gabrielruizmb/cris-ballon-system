package customer;

import java.util.*;
import global.Menu;

public class CustomerCrud {
    
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de clientes~~~\n\n");
        for (int i = 0; i < customers.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Cliente n.° %d \n", i+1);
            System.out.printf("Nome: %s \n", customers.get(i).getName());
            System.out.printf("Telefone: %s \n", customers.get(i).getPhone());
            System.out.printf("Endereço: %s \n\n", customers.get(i).getAddress());
        }
    }

    public static void create() {
        Customer customer = new Customer();

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Cadastrar novo cliente~~~\n\n");

        System.out.print("Informe o nome do cliente: ");
        Menu.scanner.nextLine();
        customer.setName(Menu.scanner.nextLine());

        System.out.print("Informe o telefone do cliente: ");
        customer.setPhone(Menu.scanner.next());

        System.out.print("Informe o endereço do cliente: ");
        Menu.scanner.nextLine();
        customer.setAddress(Menu.scanner.nextLine());

        customers.add(customer);

        System.out.print("\n+++++++++++++++++++++++++\n");
        System.out.print("Cliente cadastrado! \n\n");
        System.out.println("Nome: " + customer.getName());
        System.out.println("Telefone: " + customer.getPhone());
        System.out.println("Endereço: " + customer.getAddress());

        System.out.print("\nPressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void read() {
        listAll();
        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void update() {
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Editar um cliente~~~\n");
        listAll();
    }
}
