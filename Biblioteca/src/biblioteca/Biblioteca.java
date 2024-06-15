package biblioteca;

import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        //Testes Apenas 
        LivrodeCulinaria teste = new LivrodeCulinaria("Este é um livro de culinária", "gabriel", "casa", 1500, "comida rapida", "mineira");
        LivrodeCulinaria teste2 = new LivrodeCulinaria("Este é outro livro de culinária", "jose", "teste", 2, "aviao", "helicoptero");
        LivroDidatico teste3 = new LivroDidatico("Calculo Aplicado", "José", "Abril", 100, "Ensino", "Matemática", 5);
        LivroDeFiccao teste4 = new LivroDeFiccao("Livro de Ficcao", "Antonio", "Março", 757, "Ficcao", "Azul", "Terror");

        exibeMenu();
    }

    public static void exibeMenu() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        while (opcao <= 0 || opcao > 5) {
            System.out.println("+----------------------+");
            System.out.println("|      BIBLIOTECA      |");
            System.out.println("|----------------------|");
            System.out.println("|1. Inserir Livro      |");
            System.out.println("|2. Alterar Livro      |");
            System.out.println("|3. Remover Livro      |");
            System.out.println("|4. Listar Livro       |");
            System.out.println("|5. Sair               |");
            System.out.println("+----------------------+");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            opcao = validarInt(input);
        }
        subMenu(opcao);
        //input.nextLine();
    }

    public static void subMenu(int opcao) {
        Scanner input = new Scanner(System.in);
        String titulo, autor, editora, genero;
        int numPaginas;
        switch (opcao) {
            case 1:
                do {
                    //MENU
                    System.out.println("+----------------------+");
                    System.out.println("|Qual livro cadastrar? |");
                    System.out.println("|----------------------|");
                    System.out.println("|1.Culinária           |");
                    System.out.println("|2.Didático            |");
                    System.out.println("|3.Ficção              |");
                    System.out.println("|4.Menu Principal      |");
                    System.out.println("+----------------------+");
                    System.out.print("ESCOLHA UMA OPÇÃO: ");
                    opcao = validarInt(input);
                    input.nextLine();
                } while (opcao <= 0 || opcao > 4);

                if (opcao == 1) {
                    //CADASTRA UM NOVO LIVRO DE CULINARIA
                    System.out.println("\nLIVRO DE CULINÁRIA: ");
                    System.out.print("\nDigite o título: ");
                    titulo = input.nextLine();
                    System.out.print("Digite o autor: ");
                    autor = input.nextLine();
                    System.out.print("Digite a editora: ");
                    editora = input.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    numPaginas = validarInt(input);
                    input.nextLine();
                    System.out.print("Digite o gênero: ");
                    genero = input.nextLine();
                    System.out.print("Tipo de culinária: ");
                    String tipoCulinaria = input.nextLine();

                    LivrodeCulinaria livroDeCulinaria = new LivrodeCulinaria(titulo, autor, editora, numPaginas, genero, tipoCulinaria);
                    exibeMenu();
                } else if (opcao == 2) {
                    //CADASTRA UM NOVO LIVRO DIDATICO
                    System.out.print("\nDigite o título: ");
                    titulo = input.nextLine();
                    System.out.print("Digite o autor: ");
                    autor = input.nextLine();
                    System.out.print("Digite a editora: ");
                    editora = input.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    numPaginas = validarInt(input);
                    input.nextLine();
                    System.out.print("Digite o gênero: ");
                    genero = input.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplina = input.nextLine();
                    System.out.print("Serie: ");
                    int serie = input.nextInt();
                    input.nextLine();

                    LivroDidatico livroDidatico = new LivroDidatico(titulo, autor, editora, numPaginas, genero, disciplina, serie);
                    exibeMenu();//RETORNA AO MENU PRINCIPAL
                } else if (opcao == 3) {
                    //CADASTRA UM NOVO LIVRO DE FICCAO
                    System.out.print("\nDigite o título: ");
                    titulo = input.nextLine();
                    System.out.print("Digite o autor: ");
                    autor = input.nextLine();
                    System.out.print("Digite a editora: ");
                    editora = input.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    numPaginas = validarInt(input);
                    input.nextLine();
                    System.out.print("Digite o gênero: ");
                    genero = input.nextLine();
                    System.out.print("Tema: ");
                    String tema = input.nextLine();
                    System.out.print("Cor do livro:: ");
                    String corDoLivro = input.nextLine();

                    LivroDeFiccao livroDeFiccao = new LivroDeFiccao(titulo, autor, editora, numPaginas, genero, tema, corDoLivro);
                    exibeMenu();//RETORNA AO MENU PRINCIPAL
                } else {
                    exibeMenu();
                }
                break;

            case 2:
                do {
                    System.out.println("+----------------------+");
                    System.out.println("|Qual livro alterar?   |");
                    System.out.println("|----------------------|");
                    System.out.println("|1.Culinária           |");
                    System.out.println("|2.Didático            |");
                    System.out.println("|3.Ficção              |");
                    System.out.println("|4.Menu                |");
                    System.out.println("+----------------------+");
                    System.out.print("ESCOLHA UMA OPÇÃO: ");
                    opcao = input.nextInt();
                } while (opcao <= 0 || opcao > 4);
                if (opcao == 1) {
                    LivrodeCulinaria.getListaLivrosCulinaria();

                    System.out.print("Qual livro você quer alterar? ");
                    opcao = validarInt(input);
                    input.nextLine();
                    while (LivrodeCulinaria.pegarLivroCulinaria(opcao) == null) {
                        System.out.print("Livro não encontrado, digite novamente: ");
                        opcao = validarInt(input);
                        input.nextLine();

                    }
                    LivrodeCulinaria.pegarLivroCulinaria(opcao);

                    System.out.print("Digite a alteração do título: ");
                    String novoTitulo = input.nextLine();
                    System.out.print("Digite a alteração do autor: ");
                    String novoAutor = input.nextLine();
                    System.out.print("Digite a alteração da editora: ");
                    String novaEditora = input.nextLine();
                    System.out.print("Digite a alteração do genero: ");
                    String novoGenero = input.nextLine();
                    System.out.print("Digite a alteração do tipo de Culinaria: ");
                    String novoTipoCulinaria = input.nextLine();

                    LivrodeCulinaria.alteraLivroCulinaria(opcao, novoTitulo, novoAutor, novaEditora, novoGenero, novoTipoCulinaria);
                    System.out.println("\nPressione ENTER tecla para voltar ao menu!");
                    input.nextLine();
                    exibeMenu();
                }

                if (opcao == 2) {
                    LivroDidatico.getListaLivrosDitatico();

                    System.out.print("Qual livro você quer alterar? ");
                    opcao = validarInt(input);
                    input.nextLine();
                    while (LivroDidatico.pegarLivroDidatico(opcao) == null) {
                        System.out.print("Livro não encontrado, digite novamente: ");
                        opcao = validarInt(input);
                        input.nextLine();

                    }
                    LivroDidatico.pegarLivroDidatico(opcao);

                    System.out.print("Digite a alteração do título: ");
                    String novoTitulo = input.nextLine();
                    System.out.print("Digite a alteração do autor: ");
                    String novoAutor = input.nextLine();
                    System.out.print("Digite a alteração da editora: ");
                    String novaEditora = input.nextLine();
                    System.out.print("Digite a alteração do genero: ");
                    String novoGenero = input.nextLine();
                    System.out.print("Digite a alteração da Disciplina: ");
                    String novaDisciplina = input.nextLine();
                    System.out.print("Digite a alteração da série: ");
                    int novaSerie = validarInt(input);
                    input.nextLine();

                    LivroDidatico.alteraLivroDidatico(opcao, novoTitulo, novoAutor, novaEditora, novoGenero, novaDisciplina, novaSerie);
                    System.out.println("\nPressione ENTER tecla para voltar ao menu!");
                    input.nextLine();
                    exibeMenu();
                } else if (opcao == 3) {

                    LivroDeFiccao.getListaLivrosFiccao();
                    System.out.print("Qual livro você quer alterar? ");
                    opcao = validarInt(input);
                    input.nextLine();

                    while (LivroDeFiccao.pegarLivroFiccao(opcao) == null) {
                        System.out.print("Livro não encontrado, digite novamente: ");
                        opcao = validarInt(input);
                        input.nextLine();

                    }
                    LivroDeFiccao.pegarLivroFiccao(opcao);

                    System.out.print("Digite a alteração do título: ");
                    String novoTitulo = input.nextLine();
                    System.out.print("Digite a alteração do autor: ");
                    String novoAutor = input.nextLine();
                    System.out.print("Digite a alteração da editora: ");
                    String novaEditora = input.nextLine();
                    System.out.print("Digite a alteração do genero: ");
                    String novoGenero = input.nextLine();
                    System.out.print("Digite a alteração da cor: ");
                    String novaCor = input.nextLine();
                    System.out.print("Digite a alteração do tema: ");
                    String novoTema = input.nextLine();

                    LivroDeFiccao.alteraLivroFiccao(opcao, novoTitulo, novoAutor, novaEditora, novoGenero, novaCor, novoTema);
                    System.out.println("\nPressione ENTER tecla para voltar ao menu!");
                    input.nextLine();
                    exibeMenu();
                } else {
                    exibeMenu();
                }

                break;

            case 3:
                do {
                    System.out.println("+----------------------+");
                    System.out.println("|Qual livro remover?   |");
                    System.out.println("|----------------------|");
                    System.out.println("|1.Culinária           |");
                    System.out.println("|2.Didático            |");
                    System.out.println("|3.Ficção              |");
                    System.out.println("|4.Menu                |");
                    System.out.println("+----------------------+");
                    System.out.print("ESCOLHA UMA OPÇÃO: ");
                    opcao = input.nextInt();
                } while (opcao <= 0 || opcao > 4);
                if (opcao == 1) {

                    LivrodeCulinaria.getListaLivrosCulinaria();

                    System.out.print("Qual livro você quer remover? ");
                    opcao = validarInt(input);
                    input.nextLine();
                    LivrodeCulinaria.pegarLivroCulinaria(opcao);
                    //ALTERAR ISSO AQUI PARA NAO PRECISAR REMOVER DOS DOIS VETORES
                    LivrodeCulinaria.removerLivroCulinaria(opcao);
                    System.out.print("PRESSIONE ENTER PRA VOLTAR AO MENU");
                    input.nextLine();
                    exibeMenu();
                }
                if (opcao == 2) {

                    LivroDidatico.getListaLivrosDitatico();

                    System.out.print("Qual livro você quer remover? ");
                    opcao = validarInt(input);
                    input.nextLine();
                                while (LivroDidatico.pegarLivroDidatico(opcao) == null) {
                System.out.print("Livro não encontrado, digite novamente: ");
                opcao = validarInt(input);
                input.nextLine();

                    }
                    LivroDidatico.pegarLivroDidatico(opcao);
                    //ALTERAR ISSO AQUI PARA NAO PRECISAR REMOVER DOS DOIS VETORES
                    LivroDidatico.removerLivroDidatico(opcao);
                    System.out.print("PRESSIONE ENTER PRA VOLTAR AO MENU");
                    input.nextLine();
                    exibeMenu();
                }
                if (opcao == 3) {

                    LivroDeFiccao.getListaLivrosFiccao();

                    System.out.print("Qual livro você quer remover? ");
                    opcao = validarInt(input);
                    input.nextLine();
                    
                    //ALTERAR ISSO AQUI PARA NAO PRECISAR REMOVER DOS DOIS VETORES
                    LivroDeFiccao.pegarLivroFiccao(opcao);
                    LivroDeFiccao.removerLivroFiccao(opcao);
                    System.out.print("PRESSIONE ENTER PRA VOLTAR AO MENU");
                    input.nextLine();
                    exibeMenu();
                } else {
                    exibeMenu();
                }
                break;

            case 4:
                do {
                    System.out.println("+----------------------+");
                    System.out.println("|Lista de Livros       |");
                    System.out.println("|----------------------|");
                    System.out.println("|1.Livros disponíveis  |");
                    System.out.println("|2.Menu Principal      |");
                    System.out.println("+----------------------+");
                    System.out.print("ESCOLHA UMA OPÇÃO: ");
                    opcao = validarInt(input);

                } while (opcao <= 0 || opcao > 2);

                if (opcao == 1) {
                    Livro.getListaLivros();
                    exibeMenu();
                } else if (opcao == 2) {
                    exibeMenu();
                }
                break;

            case 5:
                System.out.println("Tchau!");
                break;
        }
    }

    public static int validarInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Digite um valor numerico: ");
            input.next();
        }
        return input.nextInt();
    }
}
