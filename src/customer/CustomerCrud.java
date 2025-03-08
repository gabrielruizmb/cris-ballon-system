package customer;

import java.util.*;
import global.Menu;

public class CustomerCrud {
    
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de clientes~~~\n\n");
        for (int i = 0; i < customers.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Cliente n.° %d \n", i);
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
        customer.setPhone(Menu.scanner.nextLine());

        System.out.print("Informe o endereço do cliente: ");
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
        int customerNumber;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Editar um cliente~~~\n");
        listAll();
        System.out.print("Escolha um cliente pelo n.° para editar: ");
        customerNumber = Menu.scanner.nextInt();

        System.out.printf("\nCliente n.° %d \n", customerNumber);

        System.out.printf("Nome: %s \n", 
            customers.get(customerNumber).getName());

        System.out.printf("Telefone: %s \n", 
            customers.get(customerNumber).getPhone());
        
        System.out.printf("Endereço: %s \n\n", 
            customers.get(customerNumber).getAddress());
        
        Menu.scanner.nextLine();
        System.out.print("Novo nome: ");
        customers.get(customerNumber).setName(Menu.scanner.nextLine());

        System.out.print("Novo telefone: ");
        customers.get(customerNumber).setPhone(Menu.scanner.nextLine());

        System.out.print("Novo endereço: ");
        customers.get(customerNumber).setAddress(Menu.scanner.nextLine());

        System.out.print("\nCadastro de cliente atualizado!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        int customerNumber;
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Excluir um cliente~~~\n");
        listAll();
        System.out.print("Escolha um cliente pelo n.° para excluir: ");
        customerNumber = Menu.scanner.nextInt();

        customers.remove(customerNumber);
        System.out.print("\nCadastro de cliente excluido!\n\n");
        
        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}