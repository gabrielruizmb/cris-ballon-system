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
            System.out.printf("Preço: %.2f \n", 
                               products.get(i).getPrice().doubleValue());
            System.out.printf("Descrição: %s \n\n", 
                               products.get(i).getDescription());
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

        // Definição do preço. Usa a mesma lógica do
        // bloco de código de definição do nome.
        while (true) { 
            System.out.print("\nPreço: ");
            
            if(product.setPrice(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nInforme apenas números e pontos para \n");
            System.out.print("o preço, ex(1250.90 ou 0.50)");
        }

        // Definição da descrição. Usa a mesma lógica 
        // do bloco de código da definição do nome.
        while (true) { 
            System.out.print("\nDescreva o produto: ");
            
            if(product.setDescription(Menu.scanner.nextLine()))
                break;        

            System.out.print("\nA descrição não deve estar em branco!");
        }

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
        String choice = "s";

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

        // Exibe na tela o produto a ser editado.
        System.out.printf("\nProduto n.° %d \n", productNumber);

        System.out.printf("Nome: %s \n", 
            products.get(productNumber).getName());

        System.out.printf("Preço: %.2f \n", 
            products.get(productNumber).getPrice().doubleValue());
        
        System.out.printf("Descrição: %s \n\n", 
            products.get(productNumber).getDescription());
        
        Menu.scanner.nextLine();    // Limpar o buffer do teclado.

        // Loop que é quebrado ao usuário informar o novo nome do 
        // produto, ou se ele desejar continuar sem trocar o nome.
        while (true) {
            System.out.print("Deseja alterar o nome? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();

            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNovo nome: ");
        
                    if(products.get(productNumber)
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
            System.out.print("Deseja alterar o preço? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();

            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNovo preço: ");
        
                    if(products.get(productNumber)
                        .setPrice(Menu.scanner.nextLine()))
                        break;
        
                    System.out.print("\nInforme apenas números e pontos para");
                    System.out.print(" o preço, ex(1250.90 ou 0.50)");
                }
                break;
            } else if (choice.equals("n"))
                break;
            
            System.out.print("\nOpção inválida, escolha 's' ou 'n'!\n");              
        }

        // Loop que é quebrado ao usuário informar a nova descrição do 
        // produto, ou se ele desejar continuar sem trocar a descrição.
        while (true) {
            System.out.print("Deseja alterar a descrição? Sim ou não(s/n)? ");
            choice = Menu.scanner.next();
            Menu.scanner.nextLine();

            if (choice.equals("s")) {
                while (true) {
                    System.out.print("\nNova descrição: ");
        
                    if(products.get(productNumber)
                        .setDescription(Menu.scanner.nextLine()))
                        break;
        
                    System.out.print("\nA descrição não pode ");
                    System.out.print("ficar em branco!");
                }
                break;
            } else if (choice.equals("n"))
                break;
            
            System.out.print("\nOpção inválida, escolha 's' ou 'n'!\n");              
        }


        System.out.print("\nProduto atualizado!\n\n");
        System.out.print("Pressione Enter para voltar . . .");
        Menu.scanner.nextLine();
    }

    public static void delete() {
        String choice = "s";

        System.out.print("\n---SISTEMA CRIS BALLON---\n");
        System.out.print("~~~Excluir um produto~~~\n");
        listAll();
        
        while (true) {
            System.out.print("Escolha um produto pelo n.° para excluir: ");
            try{    // Tenta remover o produto.
                products.remove(Menu.scanner.nextInt());
                System.out.print("\nProduto excluido!");
                break;
            } catch(Exception exception) {  
                // Se não conseguir, informa ao usuário
                // as instruções para prosseguir.

                System.out.print("Número de produto inválido!");
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