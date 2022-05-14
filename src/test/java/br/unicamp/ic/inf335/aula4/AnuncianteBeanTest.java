package br.unicamp.ic.inf335.aula4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.aula4.beans.AnuncianteBean;
import br.unicamp.ic.inf335.aula4.beans.AnuncioBean;
import br.unicamp.ic.inf335.aula4.beans.ProdutoBean;

class AnuncianteBeanTest {
	
	private AnuncianteBean anuncianteBean;
	

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	@DisplayName("Testando os get e set da classe")
	void testGetSet() {
		anuncianteBean = new AnuncianteBean();
		AnuncioBean anuncioBean = new AnuncioBean();
		
		String cpf = "1234567890";
		String nome = "TESTE NOME";
		ArrayList<AnuncioBean> lista = new ArrayList<>();
		lista.add(anuncioBean);
		
		anuncianteBean.setCPF(cpf);
		anuncianteBean.setNome(nome);
		anuncianteBean.setAnuncios(lista);
		
		assertTrue(cpf.equals(anuncianteBean.getCPF()), "O valor retornado do CPF � diferente");
		assertTrue(nome.equals(anuncianteBean.getNome()), "O valor retornado do Nome � diferente");
		
		assertFalse(anuncianteBean.getAnuncios().size() > 1, "Mais de um elemento");
		assertEquals(anuncioBean, anuncianteBean.getAnuncios().get(0));
		
	}
	
	@Test
	@DisplayName("Testando o construtor completo da classe")
	void testConstrutorCompleto() {
		AnuncioBean anuncioBean = new AnuncioBean();
		
		String cpf = "1234567890";
		String nome = "TESTE NOME";
		ArrayList<AnuncioBean> lista = new ArrayList<>();
		lista.add(anuncioBean);
		
		anuncianteBean = new AnuncianteBean(nome, cpf, lista);
		
		assertTrue(cpf.equals(anuncianteBean.getCPF()), "O valor retornado do CPF � diferente");
		assertTrue(nome.equals(anuncianteBean.getNome()), "O valor retornado do Nome � diferente");
		assertFalse(anuncianteBean.getAnuncios().size() > 1, "Mais de um elemento");
		assertEquals(anuncioBean, anuncianteBean.getAnuncios().get(0));
	}
	
	@Test
	@DisplayName("Testando o addAnuncio")
	void testAddAnuncio() {
		AnuncioBean anuncioBean = new AnuncioBean();
		
		anuncianteBean = new AnuncianteBean();
		
		anuncianteBean.addAnuncio(anuncioBean);
		
		assertFalse(anuncianteBean.getAnuncios().size() > 1, "Mais de um elemento");		
		assertEquals(anuncioBean, anuncianteBean.getAnuncios().get(0));
	}
	
	@Test
	@DisplayName("Testando o removeAnuncio")
	void testRemoveAnuncio() {
		AnuncioBean anuncioBean = new AnuncioBean();
		anuncianteBean = new AnuncianteBean();
		
		anuncianteBean.addAnuncio(anuncioBean);
		
		anuncianteBean.removeAnuncio(0);
		
		assertFalse(anuncianteBean.getAnuncios().contains(anuncioBean), "O item n�o foi removido");
	}
	
	@Test
	@DisplayName("Testando o valorMedioAnuncios")
	void testValorMedioAnuncios() {
		AnuncioBean anuncioBeanA = new AnuncioBean();
		AnuncioBean anuncioBeanB = new AnuncioBean();
		ProdutoBean produtoA = new ProdutoBean();
		produtoA.setValor(100.0);
		anuncioBeanA.setProduto(produtoA);
		ProdutoBean produtoB = new ProdutoBean();
		produtoB.setValor(200.0);
		anuncioBeanB.setProduto(produtoB);
		
		anuncianteBean = new AnuncianteBean();
		anuncianteBean.addAnuncio(anuncioBeanA);
		anuncianteBean.addAnuncio(anuncioBeanB);
		
		assertEquals(150.0, anuncianteBean.valorMedioAnuncios());
	}
	
}
