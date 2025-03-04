package product;

import java.util.ArrayList;

import global.Menu;

public class ProductCrud {
    private static ArrayList<Product> products = new ArrayList();

    public static void createProduct() {
        Product product = new Product();

        System.out.print("\n=========================\n");
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Cadastrar novo produto~~~\n\n");

        System.out.print("Informe o nome do produto: ");
        Menu.scanner.nextLine();
        product.setName(Menu.scanner.nextLine());

        System.out.print("Informe o preço do produto: ");
        product.setPrice(Menu.scanner.next());

        System.out.print("Descreva o produto: ");
        Menu.scanner.nextLine();
        product.setDescription(Menu.scanner.nextLine());

        products.add(product);

        System.out.print("\n=========================\n");
        System.out.print("Produto cadastrado! \n\n");
        System.out.println("Nome: " + products.get(0).getName());
        System.out.println("Preço: " + product.getPrice());
        System.out.println("Descrição: " + product.getDescription());
        System.out.print("\n=========================\n");

        System.out.print("\nPressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
