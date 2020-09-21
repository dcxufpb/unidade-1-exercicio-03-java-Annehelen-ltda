package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	@Test
	public void lojaCompleta() {
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		rodarTestarOutput("O campo nome da loja é obrigatório");
		CupomFiscal.NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	}
	
	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		rodarTestarOutput("O campo logradouro do endereço é obrigatório");
		CupomFiscal.LOGRADOURO = "Av. Projetada Leste";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK +
				"Av. Projetada Leste, s/n EUC F32/33/34" + BREAK +
				"Br. Sta Genebra - Campinas - SP" + BREAK +
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK +
				"CNPJ: 42.591.651/0797-34" + BREAK +
				"IE: 244.898.500.113" + BREAK);

		CupomFiscal.NUMERO = 500;
	}
	
	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		rodarTestarOutput("O campo município do endereço é obrigatório");
		CupomFiscal.MUNICIPIO = "Campinas";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		rodarTestarOutput("O campo estado do endereço é obrigatório");
	    CupomFiscal.ESTADO = "SP";
	}
	
	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		rodarTestarOutput("O campo CNPJ da loja é obrigatório");
	    CupomFiscal.CNPJ = "42.591.651/0797-34";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		rodarTestarOutput("O campo inscrição estadual da loja é obrigatório");
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Smelly Cat";
		CupomFiscal.LOGRADOURO = "Rua Etheria";
		CupomFiscal.NUMERO = 205;
		CupomFiscal.COMPLEMENTO = "Perto da velhinha que mora em uma caverna";
		CupomFiscal.BAIRRO = "Br. Templo do Cristal";
		CupomFiscal.MUNICIPIO = "Beach City";
		CupomFiscal.ESTADO = "BC";
		CupomFiscal.CEP = "78051-604";
		CupomFiscal.TELEFONE = "(66)4002-8922";
		CupomFiscal.OBSERVACAO = "Por Favor ignorar os exército Intergalácticos em guerra tentando dominar o planeta";
		CupomFiscal.CNPJ = "53.409.609/0001-85";
		CupomFiscal.INSCRICAO_ESTADUAL = "512.670.302.653";

		String expected = "Smelly Cat"+ BREAK;
		expected += "Rua Etheria, 205 Perto da velhinha que mora em uma caverna" + BREAK;
		expected += "Br. Templo do Cristal - Beach City - BC" + BREAK;
		expected += "CEP:78051-604 Tel (66)4002-8922" + BREAK;
		expected += "Por Favor ignorar os exército Intergalácticos em guerra tentando dominar o planeta" + BREAK;
		expected +="CNPJ: 53.409.609/0001-85" + BREAK;
		expected += "IE: 512.670.302.653";
		
		//E atualize o texto esperado abaixo
		rodarTestarOutput(expected + BREAK);
	}

	private void rodarTestarOutput(String expected) {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		CupomFiscal.main(null);

		// assertion
		assertEquals(expected, bos.toString());

		// undo the binding in System
		System.setOut(originalOut);
	}
}
