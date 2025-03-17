package customer;

import java.time.LocalDateTime;
import java.util.ArrayList;

import system.Menu;

public class CustomerCrud {
    
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de clientes~~~\n\n");
        for (int i = 0; i < customers.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Cliente n.° %d \n", i);

            System.out.printf("Data de criação: %d/%d/%d às %d:%d:%d \n", 
                customers.get(i).getCreationDate().getDayOfMonth(),
                customers.get(i).getCreationDate().getMonthValue(),
                customers.get(i).getCreationDate().getYear(),
                customers.get(i).getCreationDate().getHour(),
                customers.get(i).getCreationDate().getMinute(),
                customers.get(i).getCreationDate().getSecond());

            System.out.printf("Nome: %s \n", customers.get(i).getName());
            System.out.printf("Telefone: %s \n", customers.get(i).getPhone());
            System.out.printf("Endereço: %s \n\n", 
                               customers.get(i).getAddress());
        }
    }

    public static void create() {
        Customer customer = new Customer();

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Cadastrar novo cliente~~~\n\n");

        Menu.scanner.nextLine();    // Limpa o buffer do teclado.
        
        // Começo do loop que é quebrado ao usuário 
        // informar um nome do cliente válido.
        while (true) {  // "true" para forçar um loop infinito.
            System.out.print("Nome: ");
            
            // Se o nome for válido, quebra o loop.
            if(customer.setName(Menu.scanner.nextLine()))
                break;        

                System.out.print("\nO nome do cliente não ");
                System.out.print("pode ficar em branco!\n");
        }
        // Fim do loop de definição do nome do cliente.

        // Definição do telefone do cliente, usa a 
        // mesma lógica da definição de nome.
        while (true) {  
            System.out.print("Telefone: ");
            
            if(customer.setPhone(Menu.scanner.nextLine()))
                break;        
    
            System.out.print("\nO telefone do cliente não ");
            System.out.print("pode ficar em branco!\n");
        }
        
        // Definição do endereço do cliente, usa a 
        // mesma lógica da definição de nome.
        while (true) {  
            System.out.print("Endereço: ");
            
            if(customer.setAddress(Menu.scanner.nextLine()))
                break;        
    
                System.out.print("\nO endereço do cliente não ");
                System.out.print("pode ficar em branco!\n");
        }

        customer.setCreationDate(LocalDateTime.now());

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
        String choice = "s";

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Editar um cliente~~~\n");
        listAll();

        while (true) {
            System.out.print("Escolha um cliente pelo n.° para editar: ");

            // Tenta ver se o cliente existe.
            try {
                customerNumber = Menu.scanner.nextInt();
                customers.get(customerNumber);

                break;
            // Se não existir, informa ao usuário.
            } catch(Exception exception) {
                System.out.print("\nNúmero de cliente inválido!");
            
                Menu.scanner.nextLine();
                System.out.print("\n\nPressione Enter para voltar . . .");
                Menu.scanner.nextLine();

                return;
            }
        }

        System.out.printf("\nCliente n.° %d \n", customerNumber);

        System.out.printf("Nome: %s \n", 
            customers.get(customerNumber).getName());

        System.out.printf("Telefone: %s \n", 
            customers.get(customerNumber).getPhone());
        
        System.out.printf("Endereço: %s \n\n", 
            customers.get(customerNumber).getAddress());
        
        Menu.scanner.nextLine(); // Limpar o buffer do teclado.
    
        // Loop que é quebrado ao usuário informar o novo nome do 
        // produto, ou se ele desejar continuar sem trocar o nome.
        while (true) {
            System.out.print("Deseja alterar o nome? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();
    
            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNovo nome: ");
        
                    if(customers.get(customerNumber)
                        .setName(Menu.scanner.nextLine()))
                        break;
                    
                    System.out.print("\nO nome não pode ficar em branco!");
                }
                break;
            } else if (choice.equals("n"))
                break;
            
            System.out.print("\nOpção inválida, escolha 's' ou 'n'!\n");              
        }
    
        // Loop que é quebrado ao usuário informar o novo preço do 
        // produto, ou se ele desejar continuar sem trocar o preço.
        while (true) {
            System.out.print("Deseja alterar o telefone? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();
    
            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNovo telefone: ");
        
                    if(customers.get(customerNumber)
                        .setPhone(Menu.scanner.nextLine()))
                        break;
        
                    System.out.print("\nO telefone não pode ficar em branco!");
                }
                break;
            } else if (choice.equals("n"))
                break;
            
            System.out.print("\nOpção inválida, escolha 's' ou 'n'!\n");              
        }
    
        // Loop que é quebrado ao usuário informar a nova descrição do 
        // produto, ou se ele desejar continuar sem trocar a descrição.
        while (true) {
            System.out.print("Deseja alterar o endereço? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();
    
            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNovo endereço: ");
        
                    if(customers.get(customerNumber)
                        .setAddress(Menu.scanner.nextLine()))
                        break;
        
                    System.out.print("\nO endereço não pode ficar em branco!");
                }
                break;
            } else if (choice.equals("n"))
                break;
            
            System.out.print("\nOpção inválida, escolha 's' ou 'n'!\n"); 
        }

        System.out.print("\nCadastro de cliente atualizado!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        String choice = "s";

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Excluir um cliente~~~\n");
        listAll();

        while (true) {
            System.out.print("Escolha um cliente pelo n.° para excluir: ");
            try{    // Tenta excluir o cliente.
                customers.remove(Menu.scanner.nextInt());
                System.out.print("\nCliente excluido!");
                break;
            } catch(Exception exception) {  
                // Se não conseguir, informa ao usuário
                // as instruções para prosseguir.

                System.out.print("Número de cliente inválido!");
                while (true) {
                    System.out.print("\nDeseja tentar novamente? ");
                    System.out.print("Sim ou não(s/n)? ");
                    choice = Menu.scanner.next();
    
                    if(choice.equals("s") || choice.equals("n"))
                        break;
                    else
                        System.out.print("\nOpção inválida!\n");
                }
                if(choice.equals("n")) {
                    System.out.print("\nOperação cancelada!");
                    break;
                }
            }
        }
        
        Menu.scanner.nextLine();
        System.out.print("\n\nPressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}