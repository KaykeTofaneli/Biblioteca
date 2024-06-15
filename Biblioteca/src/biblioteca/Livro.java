/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 * Classe abstrata que define um Livro básico com atributos e métodos comuns.
 * Subclasses devem implementar o método exibeInfoCustomizadas() para exibir
 * informações adicionais.
 *
 * @author ZF
 */
abstract public class Livro {

    private String titulo, autor, editora, genero;
    private boolean isEmprestado;
    private int numeroDePaginas;
    public static Livro[] listaLivros = new Livro[10];

    /**
     * Construtor da classe Livro.
     *
     * @param titulo Título do livro.
     * @param autor Nome do autor do livro.
     * @param editora Nome da editora do livro.
     * @param numeroDePaginas Número total de páginas do livro.
     * @param genero Gênero do livro.
     */
    public Livro(String titulo, String autor, String editora, int numeroDePaginas, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.numeroDePaginas = numeroDePaginas;
        this.genero = genero;
        addLivro(this);
    }

    /**
     * Define a quantidade de páginas do livro.
     *
     * @param quantidadePaginas Quantidade de páginas do livro.
     */
    public void setNumeroDePaginas(int quantidadePaginas) {
        numeroDePaginas = quantidadePaginas;
    }

    /**
     * Obtém o título do livro.
     *
     * @return O título do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtém o título do livro.
     *
     * @return O título do livro.
     */
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    /**
     * Define o título do livro.
     *
     * @param novoTitulo Novo título do livro.
     */
    public void setTitulo(String novoTitulo) {
        titulo = novoTitulo;
    }

    /**
     * Obtém o nome do Autor do livro
     *
     * @return String autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Define o Autor do livro.
     *
     * @param NovoAutor Novo Autor do livro.
     */
    public void setAutor(String NovoAutor) {
        autor = NovoAutor;
    }

    /**
     * Obtém o nome da Editora do livro
     *
     * @return String editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Define a Editora do livro.
     *
     * @param novaEditora Nova Editora do livro.
     */
    public void setEditora(String novaEditora) {
        editora = novaEditora;
    }

    /**
     * Obtém o nome do genero do livro
     *
     * @return String genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define a Editora do livro.
     *
     * @param novoGenero Novo Genero do livro.
     */
    public void setGenero(String novoGenero) {
        genero = novoGenero;
    }

    /**
     * Método para realizar o empréstimo de um livro.
     *
     * Define o status de empréstimo do livro como true.
     */
    public void emprestimo() {
        isEmprestado = true;
    }

    /**
     * Método para realizar a devolução de um livro.
     *
     * Define o status de empréstimo do livro como false.
     */
    public void devolucao() {
        isEmprestado = false;
    }

    /**
     * Verifica se o livro pode ser emprestado.
     *
     * @return true se o livro pode ser emprestado, false caso contrário.
     */
    public boolean podeSerEmprestado() {
        if (isEmprestado == true) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Obtém a lista de livros cadastrados.
     *
     * Este método imprime os detalhes de todos os livros cadastrados na lista
     * de livros. Se nenhum livro foi cadastrado ainda, uma mensagem indicando
     * isso será exibida.
     */
    final static public void getListaLivros() {
        if (listaQuantidadeLivros() == 0) {
            System.out.println("Nenhum livro cadastrado! ");
        } else {
            for (int i = 0; i < listaLivros.length; i++) {
                if (listaLivros[i] == null) {
                    //break;
                    continue;
                }

                System.out.print((i + 1) + ". ");
                System.out.printf("Titulo Livro: %s\n", listaLivros[i].getTitulo());
                System.out.printf("Autor(a): %s\n", listaLivros[i].getAutor());
                System.out.printf("Editora: %s\n", listaLivros[i].getEditora());
                System.out.printf("Genero: %s\n", listaLivros[i].getGenero());
                System.out.println("");

            }
        }
    }

    /**
     * Adiciona um novo livro à lista de livros.
     *
     * Este método adiciona o livro especificado à lista de livros. O livro é
     * adicionado na primeira posição disponível na lista.
     *
     * @param novoLivro O livro a ser adicionado à lista.
     */
    void addLivro(Livro novoLivro) {
        for (int i = 0; i < listaLivros.length; i++) {
            if (listaLivros[i] == null) {
                listaLivros[i] = novoLivro;
                return;
            }
        }
    }

    /**
     * Altera as informações de um livro na lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser alterado (de 1 a 10)
     * @param novoTitulo o novo título do livro
     * @param novoAutor o novo autor do livro
     * @param novaEditora a nova editora do livro
     * @param novoGenero o novo gênero do livro
     */
    final protected void alteraLivro(int index, String novoTitulo, String novoAutor, String novaEditora, String novoGenero) {
        Livro livro = listaLivros[index - 1];
        if (livro == null) {
            System.out.println("Nenhum livro encontrado nesse índice.");
            return;
        }
        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        livro.setEditora(novaEditora);
        livro.setGenero(novoGenero);
        System.out.println("\nINFORMAÇÕES ALTERADAS COM SUCESSO!");
    }
    
    /**
     * Remove um livro da lista com base no índice e na instância do livro fornecidos.
     *
     * @param index o índice do livro a ser removido
     * @param livro a instância do livro a ser removido
     */
    static void removerLivro(int index, Livro livro) {
        if (index <= 0) {
            System.out.println("Número inválido!");
            return; // Adicionado return para sair do método em caso de índice inválido
        }
        for (int i = 0; i < listaLivros.length; i++) {
            if (livro == listaLivros[i]) {
                listaLivros[index - 1] = null;
                break;
            }
        }
    }


 /**
     * Obtém um livro da lista com base no índice fornecido.
     *
     * @param index o índice do livro a ser obtido (de 1 a 10)
     * @return o livro didático na posição especificada ou null se a posição estiver vazia.
     */
    
    public Livro pegarLivroList(int index) {
        if (index <= 0) {
            System.out.println("digite um numero de 1 a 10");
        }
        return listaLivros[index - 1];
    }

    /**
     * Retorna a quantidade de livros presentes na lista.
     *
     * @return a quantidade de livros presentes na lista
     */
    final static int listaQuantidadeLivros() {
        int quantidadeLivros = 0;

        for (int i = 0; i < listaLivros.length; i++) {
            if (listaLivros[i] != null) {
                quantidadeLivros += 1;
            }
        }
        return quantidadeLivros;
    }

    /**
     * Método abstrato para criar uma exibição customizada das informações do
     * livro.
     */
    abstract void exibeInfoCustomizadas();
    
    


}
