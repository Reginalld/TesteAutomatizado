package br.com.entregarequisicoes.requisicoescalculos;

import br.com.entregarequisicoes.requisicoescalculos.dto.EntradaDTO;
import br.com.entregarequisicoes.requisicoescalculos.service.CalculaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RequisicoesCalculosApplicationTests {

	@Autowired
	private CalculaService calculaService;

	@Test
	public void soma(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double somaTotalTest = calculaService.somatotal(entradaDTO);
		Assertions.assertEquals(25.0, somaTotalTest);
	}
	@Test
	public void maiorNumero(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double maiorCalculado = calculaService.maiorNumero(entradaDTO);
		Assertions.assertEquals(5.0,maiorCalculado);
	}

	@Test
	public void menorNumero(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double menorCalculado = calculaService.menorNumero(entradaDTO);
		Assertions.assertEquals(3.0,menorCalculado);
	}

	@Test
	public void media(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double mediaCalculada = calculaService.media(entradaDTO);
		Assertions.assertEquals(4.0, mediaCalculada);
	}

	@Test
	public void mediana(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double medianaTest = calculaService.mediana(entradaDTO);
		Assertions.assertEquals(5,medianaTest);
	}

	@Test
	public void  desvio(){
		EntradaDTO entradaDTO = new EntradaDTO();

		entradaDTO.setNumeros(List.of(3,5,5,5,4,3));

		double desvioTest = calculaService.desvioPadrao(entradaDTO);
		Assertions.assertEquals(0.9128709291752769, desvioTest);
	}

}
