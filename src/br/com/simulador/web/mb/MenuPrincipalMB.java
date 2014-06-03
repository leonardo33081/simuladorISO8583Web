package br.com.simulador.web.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="principal")
public class MenuPrincipalMB {

	private String opcao;
	private static final String opCadastro = "Cadastro";
	private static final String opTransacao = "Transacao";
	/*
	private static final String CADASTRO_CTESTE = "cadastroCasoTeste.xhtml";	
	private static final String CADASTRO_CONF ="cadastroConfiguracao.xhtml";
	private static final String CADASTRO_TTRANS ="cadastroTipoTransacao.xhtml";
	private static final String CADASTRO_TRANS = "cadastroTransacao.xhtml";
	*/
	private static final String CADASTRO_MASTER = "cadastroMaster.xhtml";
	private static final String TRANSACOES = "transacoes.xhtml";
	
	public String getOpCadastro() {
		return opCadastro;
	}
	public String getOpTransacao() {
		return opTransacao;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public MenuPrincipalMB(){}
	
	public String direcionar(){
		if(opcao.equalsIgnoreCase(getOpCadastro())){
			System.out.println("Opcao " + getOpCadastro());
			return CADASTRO_MASTER;
		}else{
			System.out.println("Opcao " + getOpTransacao());
			return TRANSACOES;
		}
	}
}
