package global;

import java.util.Scanner;

import product.ProductCrud;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    
    public static void mainMenu() {
        int choice = 1;
        while (choice != 0) {
            System.out.print("\n=========================\n");
            System.out.print("\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu principal~~~\n\n");
            System.out.print(" 1.Produtos \n 2.Clientes \n 3.Pedidos \n");
            System.out.print(" 4.Manual do usuário \n\n 0.Sair \n\n");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1: 
                    productMenu();  
                    break;

                case 4: 
                    userManual();   
                    break;
            
                default:
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
            System.out.print(" \n\n 0.Sair \n\n");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    ProductCrud.create();
                    break;

                case 4:
                    ProductCrud.read();
                    break;
            
                default:
                    break;
            }
        }
    }

    public static void userManual() {
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Manual do usuário~~~\n\n");
        
        System.out.println("1) Use o teclado para navegar pelo sistema \n");
        System.out.println("2) Ao informar valores em dinheiro, não utilize");
        System.out.println("   vírgula, apenas ponto para separar o valor");
        System.out.println("   inteiro dos centavos. Ex: 1200.35 ou 0.99 \n");

        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
