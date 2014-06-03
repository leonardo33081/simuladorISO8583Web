package br.com.simulador.web.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.Transacao;
import br.com.simulador.persistencia.DAOTransacao;

@ManagedBean(name="transacao")
@RequestScoped
public class TransacaoMB {
	@PersistenceContext(unitName="persistenciaISO")    
	EntityManager em;
	private String iso8583;
	@EJB 
	DAOTransacao dao;
	Transacao transacao;
	
	public TransacaoMB() {
		 transacao = new Transacao();
	}
	
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	public String cadastrar(){
		try {
			dao.createDAO(em);
			if(dao.gravar(getTransacao()))
				System.out.println("Transação gravada com sucesso!");
			else
				System.out.println("Transação não pode ser gravada!");
		} catch (Exception e) {
			System.out.println("Erro ao gravar a transação. Motivo:" + e.getMessage());
		}
		
		return "Ok";
	}
	public String atualizar(){
		return "Ok";
	}
	public String pesquisar(){
		return "Ok";
	}
	public String delete(){
		try {
			if(dao.remover(getTransacao()))
				System.out.println("Transação removido com sucesso!");
			else
				System.out.println("Transação não pode ser removido!");
			
		} catch (Exception e) {
			System.out.println("Erro ao excluir registro. Motivo:" + e.getMessage());
		}
		return "Ok";
	}

	public String getIso8583() {
		return iso8583;
	}

	public void setIso8583(String iso8583) {
		this.iso8583 = iso8583;
	}
	public void enviarTransacao(){
		System.out.println(getIso8583());
	}
}
