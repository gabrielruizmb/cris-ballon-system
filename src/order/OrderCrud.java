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
                orders.get(i).getCreationDate().getDayOfMonth(),
                orders.get(i).getCreationDate().getMonthValue(),
                orders.get(i).getCreationDate().getYear(),
                orders.get(i).getCreationDate().getHour(),
                orders.get(i).getCreationDate().getMinute(),
                orders.get(i).getCreationDate().getSecond());

            if (orders.get(i).getStatus().equals("Entregue") 
                || orders.get(i).getStatus().equals("Cancelado")) {
                System.out.print("Data de encerramento: ");
                System.out.printf("%d/%d/%d às %d:%d:%d \n",
                    orders.get(i).getClosingDate().getDayOfMonth(),
                    orders.get(i).getClosingDate().getMonthValue(),
                    orders.get(i).getClosingDate().getYear(),
                    orders.get(i).getClosingDate().getHour(),
                    orders.get(i).getClosingDate().getMinute(),
                    orders.get(i).getClosingDate().getSecond());
            }    

            System.out.printf("Nome do cliente: %s \n", CustomerCrud.customers
                              .get(orders.get(i).getClientNumber()).getName());

            System.out.printf("Telefone: %s \n", CustomerCrud.customers
                              .get(orders.get(i).getClientNumber())
                              .getPhone());

            System.out.printf("Endereço: %s \n\n", CustomerCrud.customers
                              .get(orders.get(i).getClientNumber())
                              .getAddress());

            System.out.printf("Descrição do pedido: %s \n\n", orders.get(i)
                              .getDescription());
        }
    }

    public static void create() {
        int clientNumber;
        Order order = new Order();

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Abrir novo pedido~~~\n\n");
        CustomerCrud.listAll();

        while (true) {
            System.out.print("Escolha um cliente pelo n.°: ");
            clientNumber = Menu.scanner.nextInt();
    
            if(clientNumber < 0 
                || clientNumber >= CustomerCrud.customers.size())
                System.out.print("Número de cliente inválido!\n");

            else
                break;
        }

        order.setClientNumber(clientNumber);

        ProductCrud.listAll();      
        System.out.print("Descreva o pedido: ");
        Menu.scanner.nextLine();

        while (!order.setDescription(Menu.scanner.nextLine())) {
            System.out.print("A descrição não pode ficar em branco! ");
            System.out.print("Descreva novamente: ");
        }
        
        // Define o status do pedido como Aberto.
        order.setStatus(OrderStatus.STATUS1.getName());

        // Define a data e hora de criação.
        order.setCreationDate(LocalDateTime.now());

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

    public static void update() {
        int orderNumber = 0, newStatus = 0;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("\n~~~Editar pedido~~~\n");
        listAll();
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        while (true) {
            System.out.print("Escolha um pedido pelo n° para editar: ");
            orderNumber = Menu.scanner.nextInt();
            if(orderNumber < 0 || orderNumber >= orders.size())
                System.out.print("Número de pedido inválido!\n");
            else
                break;
        }

        System.out.printf("\n~~~Editar pedido n°: %d~~~\n", orderNumber);
        System.out.printf("Status: %s \n\n", orders.get(orderNumber)
                          .getStatus());

        System.out.printf("Data de abertura: %d/%d/%d às %d:%d:%d \n", 
            orders.get(orderNumber).getCreationDate().getDayOfMonth(),
            orders.get(orderNumber).getCreationDate().getMonthValue(),
            orders.get(orderNumber).getCreationDate().getYear(),
            orders.get(orderNumber).getCreationDate().getHour(),
            orders.get(orderNumber).getCreationDate().getMinute(),
            orders.get(orderNumber).getCreationDate().getSecond());

        System.out.printf("Nome do cliente: %s \n", CustomerCrud.customers
                          .get(orders.get(orderNumber).getClientNumber())
                          .getName());

        System.out.printf("Telefone: %s \n", CustomerCrud.customers
                          .get(orders.get(orderNumber).getClientNumber())
                          .getPhone());

        System.out.printf("Endereço: %s \n\n", CustomerCrud.customers
                          .get(orders.get(orderNumber).getClientNumber())
                          .getAddress());

        System.out.printf("Descrição do pedido: %s \n\n", orders
                          .get(orderNumber).getDescription());

        System.out.print("~~~Novas informações do pedido~~~\n\n");
        
        for(OrderStatus status : OrderStatus.values()) {
            System.out.printf("%d)%s \n", 
            status.getNumber(), 
            status.getName());
        }
        
        System.out.print("\nNovo status: ");
        newStatus = Menu.scanner.nextInt();

        switch (newStatus) {
            case 1:
                orders.get(orderNumber)
                    .setStatus(OrderStatus.STATUS1.getName());
                break;
            case 2:
                orders.get(orderNumber)
                    .setStatus(OrderStatus.STATUS2.getName());
                break;
            case 3:
                orders.get(orderNumber)
                    .setStatus(OrderStatus.STATUS3.getName());
                break;
            case 4:
                orders.get(orderNumber)
                    .setStatus(OrderStatus.STATUS4.getName());
                break;
            case 5:
                orders.get(orderNumber)
                    .setStatus(OrderStatus.STATUS5.getName());
                break;
            default:
                System.out.printf("Status inválido! ");
                System.out.printf("O status não mudou.");
                break;
        }

        if (newStatus == 4 || newStatus == 5) {
            orders.get(orderNumber).setClosingDate(LocalDateTime.now());
        }

        System.out.print("\nDeseja alterar o cliente deste pedido(s/n): ");
        if (Menu.scanner.next().equals("s")) {
            CustomerCrud.listAll();
            System.out.print("Escolha o cliente: ");
            orders.get(orderNumber).setClientNumber(Menu.scanner.nextInt());
        }

        System.out.print("\nDeseja alterar a descrição deste pedido(s/n): ");
        if (Menu.scanner.next().equals("s")) {
            //Menu.scanner.nextLine();
            System.out.print("Nova descrição: ");
            orders.get(orderNumber).setDescription(Menu.scanner.nextLine());
        }

        Menu.scanner.nextLine();
        System.out.print("\nPedido atualizado! \n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        listAll();

        while (true) {
            System.out.print("\nInforme o n° do pedido que deseja excluir: ");

            try {
                orders.remove(Menu.scanner.nextInt());
                System.out.print("\nPedido excluido com sucesso!");
            } catch(Exception exception) {
                System.out.print("\nNúmero de pedido inválido!");
            }
            Menu.scanner.nextLine();
            System.out.print("\n\nPressione Enter para voltar . . .");
            Menu.scanner.nextLine();

            break;
        }
    }
}
