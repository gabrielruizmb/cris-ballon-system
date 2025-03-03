package global;

import java.util.ArrayList;
import java.util.Scanner;

import product.Product;
import product.ProductCrud;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    private static int choice = 1;
    private static ArrayList<Product> products = new ArrayList();

    public static void mainMenu() {
        while (choice != 4) {
            System.out.print("\n\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu principal~~~\n\n");
            System.out.print(" 1.Produtos \n 2.Clientes \n 3.Pedidos \n\n 4.Sair \n\n");
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
        while (choice != 5) {
            System.out.print("\n\n---SISTEMA CRIS BALLON---\n");
            System.out.print("~~~Menu produtos~~~\n\n");
            System.out.print(" 1.Cadastrar \n 2.Editar \n 3.Excluir\n");
            System.out.print(" 4.Ver produtos \n\n 5.Voltar\n\n");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    ProductCrud.createProduct(products);
                    break;
            
                default:
                    break;
            }
        }
    }
}
