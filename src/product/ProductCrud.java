package product;

import java.util.ArrayList;

import global.Menu;

public class ProductCrud {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de produtos~~~\n\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Produto n.° %d \n", products.get(i).getId());
            System.out.printf("Nome: %s \n", products.get(i).getName());
            System.out.printf("Preço: %.2f \n", products.get(i).getPrice().doubleValue());
            System.out.printf("Descrição: %s \n\n", products.get(i).getDescription());
        }
    }

    public static void create() {
        Product product = new Product();

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

        product.setId(products.size());
        products.add(product);

        System.out.print("\n+++++++++++++++++++++++++\n");
        System.out.print("Produto cadastrado! \n\n");
        System.out.println("Nome: " + products.get(product.getId()).getName());
        System.out.println("Preço: " + products.get(product.getId()).getPrice());
        System.out.println("Descrição: " + products.get(product.getId()).getDescription());

        System.out.print("\nPressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void read() {
        listAll();
        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
