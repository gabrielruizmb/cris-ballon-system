package order;

import java.time.LocalDateTime;
import java.util.ArrayList;

import customer.CustomerCrud;
import product.ProductCrud;
import system.Menu;

public class OrderCrud {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de pedidos~~~\n\n");
        for (int i = 0; i < orders.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Pedido n.° %d \n", i);
            System.out.printf("Data de abertura: %s \n", orders.get(i).getDate());
            System.out.printf("Nome do cliente: %s \n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getName());
            System.out.printf("Telefone: %s \n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getPhone());
            System.out.printf("Endereço: %s \n\n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getAddress());
            System.out.printf("Descrição do pedido: %s \n", orders.get(i).getDescription());
            System.out.printf("Status do pedido: %s \n\n", orders.get(i).getStatus());
        }
    }

    public static void create() {
        Order order = new Order();

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Abrir novo pedido~~~\n\n");
        CustomerCrud.listAll();
        System.out.print("Escolha um cliente pelo n.°: ");
        order.setClientNumber(Menu.scanner.nextInt());
        ProductCrud.listAll();
        System.out.print("Descreva o pedido: ");
        Menu.scanner.nextLine();
        order.setDescription(Menu.scanner.nextLine());
        System.out.print("Status do pedido: ");
        order.setStatus(Menu.scanner.nextLine());        
        order.setDate(LocalDateTime.now());

        orders.add(order);

        System.out.print("\nPedido aberto com sucesso!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void read() {
        listAll();
        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
