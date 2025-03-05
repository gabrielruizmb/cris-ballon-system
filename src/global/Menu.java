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
            System.out.print(" 1.Produtos \n 2.Clientes \n 3.Pedidos \n\n 0.Sair \n\n");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    productMenu();
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
            System.out.print(" 1.Cadastrar \n 2.Editar \n 3.Excluir\n");
            System.out.print(" 4.Ver produtos \n\n 0.Voltar\n\n");
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
}
