package br.unicamp.ic.inf335.aula4;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.aula4.beans.AnuncioBean;
import br.unicamp.ic.inf335.aula4.beans.ProdutoBean;
import br.unicamp.ic.inf335.aula4.exceptions.ValorDescontoForaDosPermitidosException;

class AnuncioBeanTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Testando get e set da classe")
	void testGetSet() throws ValorDescontoForaDosPermitidosException {
		AnuncioBean anuncioBean = new AnuncioBean();
		ProdutoBean produto = new ProdutoBean();
		ArrayList<URL> url = new ArrayList<>();
		anuncioBean.setDesconto(1.0);
		anuncioBean.setProduto(produto);
		anuncioBean.setFotosUrl(url);
		
		assertEquals(produto, anuncioBean.getProduto());
		assertEquals(url, anuncioBean.getFotosUrl());
		assertEquals(1.0, anuncioBean.getDesconto());
	}
	
	@Test
	@DisplayName("Testando o construtor completo")
	void testConstrutorCompleto() {
		ProdutoBean produto = new ProdutoBean();
		ArrayList<URL> url = new ArrayList<>();
		
		AnuncioBean anuncioBean = new AnuncioBean(produto, url, 1.0);
		
		assertEquals(produto, anuncioBean.getProduto());
		assertEquals(url, anuncioBean.getFotosUrl());
		assertEquals(1.0, anuncioBean.getDesconto());
		
	}
	
	@Test
	@DisplayName("Testando se o desconto aceita valor maior que um")
	void testSetDescontoMaiorQueUm() {
		AnuncioBean anuncioBean = new AnuncioBean();
		assertThrows(ValorDescontoForaDosPermitidosException.class, () -> anuncioBean.setDesconto(2.0));
	}
	
	@Test
	@DisplayName("Testando se o desconto aceita valor menor que zero")
	void testSetDescontoMenorQueZero() {
		AnuncioBean anuncioBean = new AnuncioBean();
		assertThrows(ValorDescontoForaDosPermitidosException.class, () -> anuncioBean.setDesconto(-1.0));		
	}
	
	@Test
	@DisplayName("Testando o resultado do valor com desconto igual a zero")
	void testGetValorZeroDesconto() throws ValorDescontoForaDosPermitidosException {
		ProdutoBean produto = new ProdutoBean();
		produto.setValor(100.0);
		
		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setProduto(produto);
		
		anuncioBean.setDesconto(0.0);
		assertEquals(100.0, anuncioBean.getValor());
		
	}
	
	@Test
	@DisplayName("Testando o resultado do valor com desconto igual a 0.5")
	void testGetValorCinquentaDesconto() throws ValorDescontoForaDosPermitidosException {
		ProdutoBean produto = new ProdutoBean();
		produto.setValor(100.0);
		
		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setProduto(produto);
		
		anuncioBean.setDesconto(0.5);
		assertEquals(50.0, anuncioBean.getValor());
	}
	
	@Test
	@DisplayName("Testando o resultado do valor ccom desconto igual a 1.0")
	void testGetValorCemDesconto() throws ValorDescontoForaDosPermitidosException {
		ProdutoBean produto = new ProdutoBean();
		produto.setValor(100.0);
		
		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setProduto(produto);
		
		anuncioBean.setDesconto(1.0);
		assertEquals(0.0, anuncioBean.getValor());
	}

}
