package system;

import java.util.Scanner;

import customer.CustomerCrud;
import order.OrderCrud;
import product.ProductCrud;

// Classe com os métodos responsáveis pelos menus
public class Menu {

    //Scanner usado em toda a aplicação para ler o teclado do usuário
    public static Scanner scanner = new Scanner(System.in);
    
    public static int tryToReadTheOption(int choice) {
        // Tenta ler um inteiro do teclado, se não conseguir, prossegue
        // para a instrução default do switch case.
        try {    
            choice = scanner.nextInt();
        } catch(Exception exception) {}
        return choice;
    }

    public static void pressEnterToReturn() {
        scanner.nextLine();
        System.out.print("\n\nPressione Enter para voltar . . .");
        scanner.nextLine();
    }

    public static void mainMenu() {
        int choice = 5;
        while (choice != 0) {
            System.out.print("\n=========================\n");
            System.out.print("\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu principal~~~\n\n");
            System.out.print(" 1.Produtos \n 2.Clientes \n 3.Pedidos \n");
            System.out.print(" 4.Manual do usuário \n\n 0.Sair \n\n");
            System.out.print("Escolha uma opção: ");
            
            choice = tryToReadTheOption(choice);
    
            switch (choice) {
                case 1: 
                    productMenu();  
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    orderMenu();
                    break;
                case 4: 
                    userManual();   
                    break;           
                case 0:
                    System.exit(choice);
                default:
                    System.out.print("\nOpção inválida! Escolha entre 0 e 4.");
                    pressEnterToReturn();
                    break;
            }
        }
    }

    private static void productMenu() {
        int choice = 1;
        while (choice != 0) {
            System.out.print("\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu produtos~~~\n\n");
            System.out.print(" 1.Cadastrar produto \n 2.Editar produto\n");
            System.out.print(" 3.Excluir produto \n 4.Ver produtos");
            System.out.print(" \n\n 0.Voltar \n\n");
            System.out.print("Escolha uma opção: ");
    
            choice = tryToReadTheOption(choice);

            switch (choice) {
                case 1:
                    ProductCrud.create();
                    break;

                case 2:
                    ProductCrud.update();
                    break;

                case 3:
                    ProductCrud.delete();
                    break;

                case 4:
                    ProductCrud.read();
                    break; 
                case 0:
                    break;         
                default:
                    System.out.print("\nOpção inválida! Escolha entre 0 e 4.");
                    pressEnterToReturn();
                    break;
            }
        }
    }

    private static void customerMenu() {
        int choice = 1;
        while (choice != 0) {
            System.out.print("\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu clientes~~~\n\n");
            System.out.print(" 1.Cadastrar cliente \n 2.Editar cliente\n");
            System.out.print(" 3.Excluir cliente \n 4.Ver clientes");
            System.out.print(" \n\n 0.Voltar \n\n");
            System.out.print("Escolha uma opção: ");
            
            choice = tryToReadTheOption(choice);

            switch (choice) {
                case 1:
                    CustomerCrud.create();
                    break;
                case 2:
                    CustomerCrud.update();
                    break;
                case 3:
                    CustomerCrud.delete();
                    break;
                case 4:
                    CustomerCrud.read();
                    break;
                case 0:
                    break;  
                default:
                    System.out.print("\nOpção inválida! Escolha entre 0 e 4.");
                    pressEnterToReturn();
                    break;
            }
        }
    }

    public static void orderMenu() {
        int choice = 1;
        while (choice != 0) {
            System.out.print("\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu de pedidos~~~\n\n");
            System.out.print(" 1.Abrir novo pedido \n 2.Editar pedido \n");
            System.out.print(" 3.Excluir pedido \n 4.Ver pedidos");
            System.out.print(" \n\n 0.Voltar \n\n");
            System.out.print("Escolha uma opção: ");

            choice = tryToReadTheOption(choice);

            switch (choice) {
                case 1:
                    OrderCrud.create();
                    break;
                case 2:
                    OrderCrud.update();
                    break;
                case 3:
                    OrderCrud.delete();
                    break;
                case 4:
                    OrderCrud.read();
                    break;
                case 0:
                    break;  
                default:
                    System.out.print("\nOpção inválida! Escolha entre 0 e 4.");
                    pressEnterToReturn();
                    break;
            }
        }
    }

    public static void userManual() {
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Manual do usuário~~~\n\n");
        
        System.out.print("1) Use o teclado para navegar pelo sistema \n\n");
        System.out.print("2) Ao informar valores em dinheiro, não utilize \n");
        System.out.print("   vírgula, apenas ponto para separar o valor \n");
        System.out.print("   inteiro dos centavos. Ex: 1200.35 ou 0.99 \n");

        pressEnterToReturn();
    }
}
