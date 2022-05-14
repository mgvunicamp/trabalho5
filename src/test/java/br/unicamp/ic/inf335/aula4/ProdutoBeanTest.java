package br.unicamp.ic.inf335.aula4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.aula4.beans.ProdutoBean;

class ProdutoBeanTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Testando os Set e Get da classe")
	void testGetSet() {
		String codigo = "1234";
		String descricao = "Descri��o de Teste";
		String estado = "Estado";
		String nome = "Nome Teste";
		double valor = 100.0;
		
		ProdutoBean produto = new ProdutoBean();
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setEstado(estado);
		produto.setNome(nome);
		produto.setValor(valor);
		
		assertTrue(codigo.equals(produto.getCodigo()), "O valor retornado do c�digo � diferente");
		assertTrue(descricao.equals(produto.getDescricao()), "O valor retornado da descricao � diferente ");
		assertTrue(estado.equals(produto.getEstado()), "O valor retornado do estado � diferente");
		assertTrue(nome.equals(produto.getNome()), "O valor retornado do nome � diferente");
		assertEquals(valor, produto.getValor());
	}
	
	@Test
	@DisplayName("Testando o construtor completo da classe")
	void testConstrutorCompleto() {
		String codigo = "1234";
		String descricao = "Descri��o de Teste";
		String estado = "Estado";
		String nome = "Nome Teste";
		double valor = 100.0;
		
		ProdutoBean produto = new ProdutoBean(codigo, nome, descricao, valor, estado);

		assertTrue(codigo.equals(produto.getCodigo()), "O valor retornado do c�digo � diferente");
		assertTrue(descricao.equals(produto.getDescricao()), "O valor retornado da descricao � diferente ");
		assertTrue(estado.equals(produto.getEstado()), "O valor retornado do estado � diferente");
		assertTrue(nome.equals(produto.getNome()), "O valor retornado do nome � diferente");
		assertEquals(valor, produto.getValor());
	}
	
	@Test
	@DisplayName("Testando o compareTo quando A � maior que B")
	void testCompareToToMaior() {
		ProdutoBean produtoA = new ProdutoBean();
		produtoA.setValor(100.0);
		ProdutoBean produtoB = new ProdutoBean();
		produtoB.setValor(50.0);
		
		assertEquals(1, produtoA.compareTo(produtoB));
	}
	
	@Test
	@DisplayName("Testando o compareTo quando A � menor que B")
	void testComparteToMenor() {
		ProdutoBean produtoA = new ProdutoBean();
		produtoA.setValor(50.0);
		ProdutoBean produtoB = new ProdutoBean();
		produtoB.setValor(100.0);
		
		assertEquals(-1, produtoA.compareTo(produtoB));
	}
	
	@Test
	@DisplayName("Testando o compareTo quando A e B s�o iguais")
	void testComparteToIgual() {
		ProdutoBean produtoA = new ProdutoBean();
		produtoA.setValor(100.0);
		ProdutoBean produtoB = new ProdutoBean();
		produtoB.setValor(100.0);
		
		assertEquals(0, produtoA.compareTo(produtoB));
	}

}
