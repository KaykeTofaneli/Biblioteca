package biblioteca;

import biblioteca.Livro;

/**
 * Esta classe representa um livro de receitas na biblioteca. Estende a classe
 * abstrata Livro e inclui atributos específicos como o tipo de culinária e o
 * número de receitas.
 *
 *
 */
public class LivrodeCulinaria extends Livro {

    private String tipoDeCulinaria;
    private int numeroDeReceitas;
    public static LivrodeCulinaria[] listaLivroCulinaria = new LivrodeCulinaria[10];
    
    /**
     * Construtor para inicializar um objeto LivrodeCulinaria.
     *
     * @param titulo O título do livro.
     * @param autor O autor do livro.
     * @param editora A editora do livro.
     * @param numeroDePaginas O número de páginas do livro.
     * @param genero O gênero do livro.
     * @param tipoDeCulinaria O tipo de culinária do livro de receitas.
     */
    public LivrodeCulinaria(String titulo, String autor, String editora, int numeroDePaginas, String genero, String tipoDeCulinaria) {
        super(titulo, autor, editora, numeroDePaginas, genero);
        this.tipoDeCulinaria = tipoDeCulinaria;
        addLivroCulinaria(this);
    }

    /**
     * Obtém o tipo de culinária do livro de receitas.
     *
     * @return O tipo de culinária.
     */
    public String getTipoDeCulinaria() {
        return tipoDeCulinaria;
    }

    /**
     * Define o tipo de culinária do livro de receitas.
     *
     * @param tipoDeCulinaria O novo tipo de culinária.
     */
    public void setTipoDeCulinaria(String tipoDeCulinaria) {
        this.tipoDeCulinaria = tipoDeCulinaria;
    }

    /**
     * Obtém a lista de livros cadastrados.
     *
     * Este método imprime os detalhes de todos os livros cadastrados na lista
     * de livros. Se nenhum livro foi cadastrado ainda, uma mensagem indicando
     * isso será exibida.
     */
    public static void getListaLivrosCulinaria() {
        if (listaQuantidadeLivrosCulinaria() == 0) {
            System.out.println("Nenhum livro cadastrado!");
        } else {
            for (int i = 0; i < listaLivroCulinaria.length; i++) {
                if (listaLivroCulinaria[i] == null) {
                    continue;
                }
                System.out.print((i + 1) + ". ");
                listaLivroCulinaria[i].exibeInfoCustomizadas();
                System.out.println("");
            }
        }
    }

 /**
     * Obtém um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser obtido (de 1 a 10)
     * @return o livro didático na posição especificada ou null se a posição estiver vazia.
     */
    public static Livro pegarLivroCulinaria(int index) {
        LivrodeCulinaria livroCulinaria = listaLivroCulinaria[index - 1];
        if (livroCulinaria == null) {
            System.out.println("Posição vazia, digite novamente!!");
            return null;
        }
        return livroCulinaria;
    }

    /**
     * Retorna a quantidade de livros presentes na lista.
     *
     * @return a quantidade de livros presentes na lista.
     */
    public static int listaQuantidadeLivrosCulinaria() {
        int quantidadeLivros = 0;
        for (int i = 0; i < listaLivroCulinaria.length; i++) {
            if (listaLivroCulinaria[i] != null) {
                quantidadeLivros += 1;
            }
        }
        return quantidadeLivros;
    }

    /**
     * Adiciona um novo livro à lista de LivrodeCulinaria.
     *
     * Este método adiciona o livro especificado à lista de livros de culinária.
     * O livro é adicionado na primeira posição disponível na lista.
     *
     * @param novoLivroCulinaria O livro a ser adicionado à lista.
     */
    public void addLivroCulinaria(LivrodeCulinaria novoLivroCulinaria) {
        for (int i = 0; i < listaLivroCulinaria.length; i++) {
            if (listaLivroCulinaria[i] == null) {
                listaLivroCulinaria[i] = novoLivroCulinaria;
                return;
            }
        }
    }

    /**
     * Altera as informações de um livro de culinária na lista com base no
     * índice fornecido.
     *
     * @param index o índice do livro a ser alterado (de 1 a 10)
     * @param novoTitulo o novo título do livro
     * @param novoAutor o novo autor do livro
     * @param novaEditora a nova editora do livro
     * @param novoGenero o novo gênero do livro
     * @param tipoDeCulinaria o novo tipo de culinária do livro
     */
    public static void alteraLivroCulinaria(int index, String novoTitulo, String novoAutor, String novaEditora, String novoGenero, String tipoDeCulinaria) {
        LivrodeCulinaria livroCulinaria = listaLivroCulinaria[index - 1];
        if (livroCulinaria == null) {
            System.out.println("Nenhum livro encontrado nesse índice.");
            return;
        }
        livroCulinaria.setTitulo(novoTitulo);
        livroCulinaria.setAutor(novoAutor);
        livroCulinaria.setEditora(novaEditora);
        livroCulinaria.setGenero(novoGenero);
        livroCulinaria.setTipoDeCulinaria(tipoDeCulinaria);
        System.out.println("\nINFORMAÇÕES ALTERADAS COM SUCESSO!");
    }

    /**
     * Remove um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser removido (de 1 a 10)
     */
    public static void removerLivroCulinaria(int index) {
        if (index <= 0) {
            System.out.println("Número inválido!");
            return;
        }
        listaLivroCulinaria[index - 1] = null;
        System.out.println("\nLIVRO REMOVIDO COM SUCESSO!");
    }

    /**
     * Fornece uma representação em forma de string do livro de receitas.
     */
    @Override
    public void exibeInfoCustomizadas() {
        System.out.printf(""
            + "Titulo Livro: %s\n"
            + "Autor(a): %s\n"
            + "Editora: %s\n"
            + "Tipo de Culinária: %s\n"
            + "Gênero: %s\n", getTitulo(), getAutor(), getEditora(), getTipoDeCulinaria(), getGenero());
    }
}
