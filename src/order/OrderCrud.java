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
            System.out.printf("Status: %s \n\n", orders.get(i).getStatus());

            System.out.printf("Data de abertura: %d/%d/%d às %d:%d:%d \n", 
                orders.get(i).getDate().getDayOfMonth(),
                orders.get(i).getDate().getMonthValue(),
                orders.get(i).getDate().getYear(),
                orders.get(i).getDate().getHour(),
                orders.get(i).getDate().getMinute(),
                orders.get(i).getDate().getSecond());

            System.out.printf("Nome do cliente: %s \n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getName());
            System.out.printf("Telefone: %s \n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getPhone());
            System.out.printf("Endereço: %s \n\n", CustomerCrud.customers.get(orders.get(i).getClientNumber()).getAddress());
            System.out.printf("Descrição do pedido: %s \n\n", orders.get(i).getDescription());
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
        order.setStatus(OrderStatus.STATUS1.getName());
        order.setDate(LocalDateTime.now());

        orders.add(order);

        System.out.print("\nPedido aberto com sucesso!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void update() {
        int orderNumber = 0, newStatus = 0;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("\n~~~Editar pedido~~~\n");
        listAll();
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("Escolha um pedido pelo n° para editar: ");
        orderNumber = Menu.scanner.nextInt();
        System.out.printf("\n~~~Editar pedido n°: %d~~~\n", orderNumber);
        System.out.printf("Status: %s \n\n", orders.get(orderNumber).getStatus());

        System.out.printf("Data de abertura: %d/%d/%d às %d:%d:%d \n", 
            orders.get(orderNumber).getDate().getDayOfMonth(),
            orders.get(orderNumber).getDate().getMonthValue(),
            orders.get(orderNumber).getDate().getYear(),
            orders.get(orderNumber).getDate().getHour(),
            orders.get(orderNumber).getDate().getMinute(),
            orders.get(orderNumber).getDate().getSecond());

        System.out.printf("Nome do cliente: %s \n", CustomerCrud.customers.get(orders.get(orderNumber).getClientNumber()).getName());
        System.out.printf("Telefone: %s \n", CustomerCrud.customers.get(orders.get(orderNumber).getClientNumber()).getPhone());
        System.out.printf("Endereço: %s \n\n", CustomerCrud.customers.get(orders.get(orderNumber).getClientNumber()).getAddress());
        System.out.printf("Descrição do pedido: %s \n\n", orders.get(orderNumber).getDescription());

        System.out.print("~~~Novas informações do pedido~~~\n\n");

        System.out.print("Deseja alterar o status deste pedido(s/n): ");
        if (Menu.scanner.next().equals("s")) {

            System.out.print("Novo status: \n\n");
    
            for(OrderStatus status : OrderStatus.values()) {
                System.out.printf("%d)%s \n", status.getNumber(), status.getName());
            }
    
            System.out.print("\nEscolha um status: ");
            newStatus = Menu.scanner.nextInt();
    
            switch (newStatus) {
                case 1:
                    orders.get(orderNumber).setStatus(OrderStatus.STATUS1.getName());
                    break;
                case 2:
                    orders.get(orderNumber).setStatus(OrderStatus.STATUS2.getName());
                    break;
                case 3:
                    orders.get(orderNumber).setStatus(OrderStatus.STATUS3.getName());
                    break;
                case 4:
                    orders.get(orderNumber).setStatus(OrderStatus.STATUS4.getName());
                    break;
                case 5:
                    orders.get(orderNumber).setStatus(OrderStatus.STATUS5.getName());
                    break;
                default:
                    break;
            }
        }

        System.out.print("\nDeseja alterar o cliente deste pedido(s/n): ");
        if (Menu.scanner.next().equals("s")) {
            CustomerCrud.listAll();
            System.out.print("Escolha o cliente: ");
            orders.get(orderNumber).setClientNumber(Menu.scanner.nextInt());
        }

        System.out.print("\nDeseja alterar a descrição deste pedido(s/n): ");
        if (Menu.scanner.next().equals("s")) {
            Menu.scanner.nextLine();
            System.out.print("Nova descrição: ");
            orders.get(orderNumber).setDescription(Menu.scanner.nextLine());
        }

        System.out.print("\nPedido atualizado! \n\n");
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
