package com.example.project;

public class CupomFiscal {

	public static String NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	public static String LOGRADOURO = "Av. Projetada Leste";
	public static int NUMERO = 500;
	public static String COMPLEMENTO = "EUC F32/33/34";
	public static String BAIRRO = "Br. Sta Genebra";
	public static String MUNICIPIO = "Campinas";
	public static String ESTADO = "SP";
	public static String CEP = "13080-395";
	public static String TELEFONE = "(19) 3756-7408";
	public static String OBSERVACAO = "Loja 1317 (PDP)";
	public static String CNPJ = "42.591.651/0797-34";
	public static String INSCRICAO_ESTADUAL = "244.898.500.113";

	private static final String ENDLN = System.lineSeparator();

	public static void main(final String[] args) {
		//Implemente aqui
		String num = NUMERO + "";
		if(NOME_LOJA.equals("")){
			System.out.print("O campo nome da loja é obrigatório");
			return;
		}
		if(LOGRADOURO.equals("")){
			System.out.print("O campo logradouro do endereço é obrigatório");
			return;
		}
		if(NUMERO == 0){
			num = "s/n";
		}
		if(MUNICIPIO.equals("")){
			System.out.print("O campo município do endereço é obrigatório");
			return;
		}
		if(ESTADO.equals("")){
			System.out.print("O campo estado do endereço é obrigatório");
			return; 
		}
		if(CNPJ.equals("")){
			System.out.print("O campo CNPJ da loja é obrigatório");
			return;
		}
		if(INSCRICAO_ESTADUAL.equals("")){
			System.out.print("O campo inscrição estadual da loja é obrigatório");
			return;
			}

		String output = NOME_LOJA + ENDLN;
        output += LOGRADOURO + ", " + num + " " + COMPLEMENTO + ENDLN;
        output += BAIRRO + " - " + MUNICIPIO + " - " + ESTADO + ENDLN;
        output += "CEP:" + CEP + " Tel " + TELEFONE + ENDLN;
        output += OBSERVACAO + ENDLN;
        output += "CNPJ: " + CNPJ + ENDLN;
		output += "IE: " + INSCRICAO_ESTADUAL;
		System.out.println(output);
	}

}
