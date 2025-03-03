package product;

import java.util.ArrayList;

import global.Menu;

public class ProductCrud {
    public static void createProduct(ArrayList<Product> products) {
        Product product = new Product();

        System.out.print("\n\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Cadastrar novo produto~~~\n\n");
        System.out.print("Informe o nome do produto: ");
        Menu.scanner.nextLine();
        product.setName(Menu.scanner.nextLine());
        System.out.print(product.getName());
    }
}
