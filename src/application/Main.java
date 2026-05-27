package application;

import java.sql.Connection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try (Connection conexao = ConexaoDB.conectar()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

			mostrarProdutos(produtoDAO);

		} catch (Exception e) {
			System.err.println("Erro geral: " + e.getMessage());
		}
	}

	private static void mostrarProdutos(ProdutoDAO produtoDAO) {
		List<Produto> todosProdutos = produtoDAO.listarTodos();
		if (todosProdutos.isEmpty()) {
			System.out.println("Nenhum produto encontado");
		} else {
			System.out.println("Lista de produtos: ");
			for (Produto p : todosProdutos) {
				System.out.println(p.getId() + ": " + p.getNome() + " - " + p.getPreco());
			}
		}
	}
}
