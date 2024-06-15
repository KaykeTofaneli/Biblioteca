package biblioteca;

import static biblioteca.LivroDidatico.listaLivroDidatico;

public class LivroDeFiccao extends Livro {
    private String corDoLivro;
    private String tema;
    public static LivroDeFiccao[] listaLivroFiccao = new LivroDeFiccao[10];
    
    /**
     * Construtor para inicializar um livro de ficção com os atributos fornecidos.
     * 
     * @param titulo           O título do livro.
     * @param autor            O autor do livro.
     * @param editora          A editora do livro.
     * @param numeroDePaginas  O número de páginas do livro.
     * @param genero           O gênero do livro.
     * @param corDoLivro       A cor da capa do livro.
     * @param tema             O tema do livro.
     */
    public LivroDeFiccao(String titulo, String autor, String editora, int numeroDePaginas, String genero, String corDoLivro, String tema) {
        super(titulo, autor, editora, numeroDePaginas, genero);
        this.corDoLivro = corDoLivro;
        this.tema = tema;
        addLivroFiccao(this);
    } 
    
    /**
     * Obtém a cor da capa do livro.
     * 
     * @return A cor da capa do livro.
     */
    public String getCorDoLivro() {  
         return corDoLivro;
    }
    
    /**
     * Obtém o tema do livro.
     * 
     * @return O tema do livro.
     */
    public String getTema() {
        return tema;
    }
    
    /**
     * Define a cor do livro.
     *
     * @param corDoLivro a nova cor do livro.
     */
    public void setCorDoLivro(String corDoLivro) {  
        this.corDoLivro = corDoLivro;
    }
    
    /**
     * Define o tema do livro.
     *
     * @param tema O novo tema do livro.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    /**
     * Obtém a lista de livros cadastrados.
     *
     * Este método imprime os detalhes de todos os livros cadastrados na lista
     * de livros. Se nenhum livro foi cadastrado ainda, uma mensagem indicando
     * isso será exibida.
     */
    public static void getListaLivrosFiccao() {
        if (listaQuantidadeLivrosFiccao() == 0) {
            System.out.println("Nenhum livro cadastrado! ");
        } else {
            for (int i = 0; i < listaLivroFiccao.length; i++) {
                if (listaLivroFiccao[i] == null) {
                    continue;
                }
                
                System.out.print((i + 1) + ". ");
                listaLivroFiccao[i].exibeInfoCustomizadas();
                System.out.println("");
            }
        }
    }

    /**
     * Retorna a quantidade de livros presentes na lista.
     *
     * @return a quantidade de livros presentes na lista.
     */
    public static int listaQuantidadeLivrosFiccao() {
        int quantidadeLivros = 0;
        for (int i = 0; i < listaLivroFiccao.length; i++) {
            if (listaLivroFiccao[i] != null) {
                quantidadeLivros += 1;
            }
        }
        return quantidadeLivros;
    }

    /**
     * Obtém um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser obtido (de 1 a 10)
     * @return o livro de ficção na posição especificada ou null se a posição estiver vazia.
     */
    public static LivroDeFiccao pegarLivroFiccao(int index) {
        LivroDeFiccao livroDeFiccao = listaLivroFiccao[index - 1];
        if (livroDeFiccao == null) {
            System.out.println("Posição vazia, digite novamente!!");
            return null;
        }
        return livroDeFiccao;
    }

    /**
     * Adiciona um novo livro à lista de LivroDeFiccao.
     *
     * Este método adiciona o livro especificado à lista de livros de ficção. O
     * livro é adicionado na primeira posição disponível na lista.
     *
     * @param novoLivroFiccao O livro a ser adicionado à lista.
     */
    public void addLivroFiccao(LivroDeFiccao novoLivroFiccao) {
        for (int i = 0; i < listaLivroFiccao.length; i++) {
            if (listaLivroFiccao[i] == null) {
                listaLivroFiccao[i] = novoLivroFiccao;
                return;
            }
        }
    }

    /**
     * Altera um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser alterado (de 1 a 10)
     * @param novoTitulo o novo título do livro
     * @param novoAutor o novo autor do livro
     * @param novaEditora a nova editora do livro
     * @param novoGenero o novo gênero do livro
     * @param novoTema o novo tema do livro
     * @param novaCorDoLivro a nova cor da capa do livro
     */
    public static void alteraLivroFiccao(int index, String novoTitulo, String novoAutor, String novaEditora, String novoGenero, String novoTema, String novaCorDoLivro) {
        LivroDeFiccao livroDeFiccao = listaLivroFiccao[index - 1];
        if (livroDeFiccao == null) {
            System.out.println("Nenhum livro encontrado nesse índice.");
            return;
        }
        livroDeFiccao.setTitulo(novoTitulo);
        livroDeFiccao.setAutor(novoAutor);
        livroDeFiccao.setEditora(novaEditora);
        livroDeFiccao.setGenero(novoGenero);
        livroDeFiccao.setTema(novoTema);
        livroDeFiccao.setCorDoLivro(novaCorDoLivro);
        System.out.println("\nINFORMAÇÕES ALTERADAS COM SUCESSO!");
    }

    /**
     * Remove um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser removido (de 1 a 10)
     */
    public static void removerLivroFiccao(int index) {
        if (index <= 0) {
            System.out.println("Número inválido!");
            return;
        }
        listaLivroFiccao[index - 1] = null;
        System.out.println("\nLIVRO REMOVIDO COM SUCESSO!");
    }

    /**
     * Fornece uma representação em forma de string do livro de ficção.
     */
    @Override
    public void exibeInfoCustomizadas() {
        System.out.printf(""
            + "Titulo Livro: %s\n"
            + "Autor(a): %s\n"
            + "Editora: %s\n"
            + "CorDoLivro: %s\n"
            + "Tema: %s\n", getTitulo(), getAutor(), getEditora(), getCorDoLivro(), getTema());
    }
}
