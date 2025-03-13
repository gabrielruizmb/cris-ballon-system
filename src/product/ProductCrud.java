package product;

import java.time.LocalDateTime;
import java.util.ArrayList;

import system.Menu;

public class ProductCrud {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void listAll() {
        System.out.print("\n~~~Lista de produtos~~~\n\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.print("+++++++++++++++++++++++++\n");
            System.out.printf("Produto n.° %d \n", i);
            
            System.out.printf("Data de criação: %d/%d/%d às %d:%d:%d \n", 
                products.get(i).getCreationDate().getDayOfMonth(),
                products.get(i).getCreationDate().getMonthValue(),
                products.get(i).getCreationDate().getYear(),
                products.get(i).getCreationDate().getHour(),
                products.get(i).getCreationDate().getMinute(),
                products.get(i).getCreationDate().getSecond());
            
                System.out.printf("Nome: %s \n", products.get(i).getName());
            System.out.printf("Preço: %.2f \n", products.get(i).getPrice().doubleValue());
            System.out.printf("Descrição: %s \n\n", products.get(i).getDescription());
        }
    }

    public static void create() {
        Product product = new Product();    // Cria novo produto vazio.

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Cadastrar novo produto~~~\n");
        
        Menu.scanner.nextLine();    // Limpa o buffer do teclado.
        
        // Começo do loop que é quebrado ao usuário informar 
        // um nome de produto válido, ou cancelar a operação.
        while (true) {  // True para forçar um loop infinito.
            System.out.print("\nInforme o nome do produto: ");
            
            // Se o nome for válido, encerra o loop.
            if(product.setName(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nO nome do produto não deve estar em branco!");
        }
        // Fim do loop de definição do nome do produto.
        
        System.out.print("Informe o preço do produto: ");
        product.setPrice(Menu.scanner.next());

        System.out.print("Descreva o produto: ");
        Menu.scanner.nextLine();
        product.setDescription(Menu.scanner.nextLine());

        product.setCreationDate(LocalDateTime.now());

        products.add(product);

        System.out.print("\n+++++++++++++++++++++++++\n");
        System.out.print("Produto cadastrado! \n\n");
        System.out.println("Nome: " + product.getName());
        System.out.println("Preço: " + product.getPrice());
        System.out.println("Descrição: " + product.getDescription());

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
        int productNumber;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Editar um produto~~~\n");
        listAll();
        System.out.print("Escolha um produto pelo n.° para editar: ");
        productNumber = Menu.scanner.nextInt();

        System.out.printf("\nProduto n.° %d \n", productNumber);

        System.out.printf("Nome: %s \n", 
            products.get(productNumber).getName());

        System.out.printf("Preço: %.2f \n", 
            products.get(productNumber).getPrice().doubleValue());
        
        System.out.printf("Descrição: %s \n\n", 
            products.get(productNumber).getDescription());
        
        Menu.scanner.nextLine();
        System.out.print("Novo nome: ");
        products.get(productNumber).setName(Menu.scanner.nextLine());

        System.out.print("Novo preço: ");
        products.get(productNumber).setPrice(Menu.scanner.next());

        Menu.scanner.nextLine();
        System.out.print("Nova descrição: ");
        products.get(productNumber).setDescription(Menu.scanner.nextLine());

        System.out.print("\nProduto atualizado!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        int productNumber;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Excluir um produto~~~\n");
        listAll();
        System.out.print("Escolha um produto pelo n.° para excluir: ");
        productNumber = Menu.scanner.nextInt();

        // System.out.print("\n-------------------------\n");
        // System.out.printf("\nProduto n.° %d \n", productNumber);

        // System.out.printf("Nome: %s \n", 
        //     products.get(productNumber).getName());

        // System.out.printf("Preço: %.2f \n", 
        //     products.get(productNumber).getPrice().doubleValue());
        
        // System.out.printf("Descrição: %s \n\n", 
        //     products.get(productNumber).getDescription());

        // Menu.scanner.nextLine();
        // System.out.print("Pressione Enter para comfirmar a exclusão . . .");

        products.remove(productNumber);
        System.out.print("\nProduto excluido!\n\n");
        
        Menu.scanner.nextLine();
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
