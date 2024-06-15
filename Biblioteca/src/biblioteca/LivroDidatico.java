package biblioteca;

//Subclasse de livro sobre livros escolares
import static biblioteca.LivrodeCulinaria.listaLivroCulinaria;

public class LivroDidatico extends Livro {

    private String disciplina;
    private int serie;
    public static LivroDidatico[] listaLivroDidatico = new LivroDidatico[10];

    /**
     * Construtor para a classe LivroDidatico.
     *
     * Construtor para inicializar um objeto LivroDeReceita.
     *
     * @param titulo o título do livro didático
     * @param autor o autor do livro didático
     * @param editora a editora do livro didático
     * @param numeroDePaginas o número de páginas do livro didático
     * @param genero o gênero do livro didático
     * @param disciplina a disciplina associada ao livro didático
     * @param serie a série escolar para a qual o livro didático é destinado
     */
    public LivroDidatico(String titulo, String autor, String editora, int numeroDePaginas, String genero, String disciplina, int serie) {
        super(titulo, autor, editora, numeroDePaginas, genero);
        this.disciplina = disciplina;
        this.serie = serie;
        addLivroDidatico(this);
    }

    /**
     * Retorna a disciplina.
     *
     * @return a disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * Define a disciplina.
     *
     * @param disciplina a disciplina a ser definida
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Retorna a série.
     *
     * @return a série
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Define a série.
     *
     * @param serie a série a ser definida
     */
    public void setSerie(int serie) {
        this.serie = serie;
    }

    /**
     * Obtém a lista de livros cadastrados.
     *
     * Este método imprime os detalhes de todos os livros cadastrados na lista
     * de livros. Se nenhum livro foi cadastrado ainda, uma mensagem indicando
     * isso será exibida.
     */
    public static void getListaLivrosDitatico() {
        if (listaQuantidadeLivrosDidatico() == 0) {
            System.out.println("Nenhum livro cadastrado! ");
        } else {
            for (int i = 0; i < listaLivroDidatico.length; i++) {
                if (listaLivroDidatico[i] == null) {
                    continue;
                }

                System.out.print((i + 1) + ". ");
                listaLivroDidatico[i].exibeInfoCustomizadas();
                System.out.println("");
            }
        }
    }

    /**
     * Retorna a quantidade de livros presentes na lista.
     *
     * @return a quantidade de livros presentes na lista     
     */
    public static int listaQuantidadeLivrosDidatico() {
        int quantidadeLivros = 0;
        for (int i = 0; i < listaLivroDidatico.length; i++) {
            if (listaLivroDidatico[i] != null) {
                quantidadeLivros += 1;
            }
        }
        return quantidadeLivros;
    }
    


    /**
     * Obtém um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser obtido (de 1 a 10)
     * @return o livro didático na posição especificada ou null se a posição estiver vazia.
     */
    public static Livro pegarLivroDidatico(int index) {
        if (index <= 0 || index > listaLivroDidatico.length) {
            System.out.println("Número inválido!");
            return null;
        }

        LivroDidatico livroDidatico = listaLivroDidatico[index - 1];
        if (livroDidatico == null) {
            System.out.println("Posição vazia, digite novamente!!");
            return null;
        }
        return livroDidatico;
    }

    /**
     * Adiciona um novo livro à lista de LivroDidatico.
     *
     * Este método adiciona o livro especificado à lista de livros didaticos. O
     * livro é adicionado na primeira posição disponível na lista.
     *
     * @param novoLivroDidatico O livro a ser adicionado à lista.
     */
    public void addLivroDidatico(LivroDidatico novoLivroDidatico) {
        for (int i = 0; i < listaLivroDidatico.length; i++) {
            if (listaLivroDidatico[i] == null) {
                listaLivroDidatico[i] = novoLivroDidatico;
                return;
            }
        }
    }

    /**
     * Altera as informações de um livro didático na lista com base no índice
     * fornecido.
     *
     * @param index o índice do livro a ser alterado (de 1 a 10)
     * @param novoTitulo o novo título do livro
     * @param novoAutor o novo autor do livro
     * @param novaEditora a nova editora do livro
     * @param novoGenero o novo gênero do livro
     * @param novaDisciplina a nova disciplina do livro didático
     * @param novaSerie a nova série do livro didático
     */
    public static void alteraLivroDidatico(int index, String novoTitulo, String novoAutor, String novaEditora, String novoGenero, String novaDisciplina, int novaSerie) {
        LivroDidatico livroDidatico = listaLivroDidatico[index - 1];
        if (livroDidatico == null) {
            System.out.println("Nenhum livro encontrado nesse índice.");
            return;
        }
        livroDidatico.setTitulo(novoTitulo);
        livroDidatico.setAutor(novoAutor);
        livroDidatico.setEditora(novaEditora);
        livroDidatico.setGenero(novoGenero);
        livroDidatico.setDisciplina(novaDisciplina);
        livroDidatico.setSerie(novaSerie);
        System.out.println("\nINFORMAÇÕES ALTERADAS COM SUCESSO!");
    }

    /**
     * Remove um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser removido (de 1 a 10)
     */
    public static void removerLivroDidatico(int index) {
        
        if (index <= 0) {
            System.out.println("Número inválido!");
        }
        
            removerLivro(index,listaLivroDidatico[index-1]);
            listaLivroDidatico[index - 1] = null;
        System.out.println("\nLIVRO REMOVIDO COM SUCESSO! ");
    }

    /**
     * Exibe informações personalizadas do livro didático.
     *
     *
     * Este método imprime no console informações detalhadas sobre o livro
     * didático, incluindo título, autor, editora, gênero, número de páginas,
     * disciplina e série.
     */
    @Override
    public void exibeInfoCustomizadas() {
        System.out.println("Informações do Livro Didático:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Editora: " + getEditora());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Número de Páginas: " + getNumeroDePaginas());
        System.out.println("Disciplina: " + getDisciplina());
        System.out.println("Série: " + getSerie());
    }
}
