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
        
        // Começo do loop que é quebrado ao usuário 
        // informar um nome do produto válido.
        while (true) {  // "true" para forçar um loop infinito.
            System.out.print("\nNome: ");
            
            // Se o nome for válido, quebra o loop.
            if(product.setName(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nO nome do produto não deve estar em branco!");
        }
        // Fim do loop de definição do nome do produto.
        
        // Começo do loop que é quebrado ao usuário
        // informar um preço do produto válido.
        while (true) {  // "true" para forçar um loop infinito.
            System.out.print("\nPreço: ");
            
            // Se o preço for válido, quebra o loop
            if(product.setPrice(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nInforme apenas números e pontos para \n");
            System.out.print("o preço, ex(1250.90 ou 0.50)");
        }
        // Fim do loop de definição do preço do produto.

        // Começo do loop que é quebrado ao usuário 
        // informar uma descrição do produto válida.
        while (true) {  // "true" para forçar um loop infinito.
            System.out.print("\nDescreva o produto: ");
            
            // Se a descrição for válida, quebra o loop.
            if(product.setDescription(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nA descrição não deve estar em branco!");
        }
        // Fim do loop de definição do nome do produto.

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

    // A validação dos inputs para atualizar o  
    // produto é a mesma usada para criá-lo.
    public static void update() {
        int productNumber;

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Editar um produto~~~\n");
        listAll();

        while (true) {
            System.out.print("Escolha um produto pelo n.° para editar: ");

            // Tenta ver se o produto existe.
            try {
                productNumber = Menu.scanner.nextInt();
                products.get(productNumber);

                break;
            // Se não existir, informa ao usuário.
            } catch(Exception exception) {
                System.out.print("\nNúmero de produto inválido!");
            
                Menu.scanner.nextLine();
                System.out.print("\n\nPressione Enter para voltar . . .");
                Menu.scanner.nextLine();

                return;
            }
        }

        System.out.printf("\nProduto n.° %d \n", productNumber);

        System.out.printf("Nome: %s \n", 
            products.get(productNumber).getName());

        System.out.printf("Preço: %.2f \n", 
            products.get(productNumber).getPrice().doubleValue());
        
        System.out.printf("Descrição: %s \n\n", 
            products.get(productNumber).getDescription());
        
        Menu.scanner.nextLine();

        while (true) {
            System.out.print("\nNovo nome: ");

            if(products.get(productNumber).setName(Menu.scanner.nextLine()))
                break;
            
            System.out.print("\nO nome não pode ficar em branco!");
        }

        while (true) {
            System.out.print("\nNovo preço: ");

            if(products.get(productNumber).setPrice(Menu.scanner.nextLine()))
                break;

            System.out.print("\nInforme apenas números e pontos para \n");
            System.out.print("o preço, ex(1250.90 ou 0.50)");
        }

        while (true) {
            System.out.print("\nNova descrição: ");

            if(products.get(productNumber)
                .setDescription(Menu.scanner.nextLine()))
                break;

            System.out.print("\nA descrição não pode ficar em branco!");
        }

        System.out.print("\nProduto atualizado!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Excluir um produto~~~\n");
        listAll();
        System.out.print("Escolha um produto pelo n.° para excluir: ");

        // Tenta excluir o produto.
        try {
            products.remove(Menu.scanner.nextInt());
            System.out.print("\nProduto excluido!");
        // Se não conseguir, informa ao usuário.
        } catch(Exception exception) {
            System.out.print("\nNúmero de produto inválido!");
        }
        
        Menu.scanner.nextLine();
        System.out.print("\n\nPressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }
}
