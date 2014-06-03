package br.com.simulador.web.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.TipoTransacao;
import br.com.simulador.persistencia.DAOTipoTransacao;

@ManagedBean(name="tipoTransacao")
@RequestScoped
public class TipoTransacaoMB {
	@PersistenceContext(unitName="persistenciaISO")    
	private EntityManager em;
	TipoTransacao tipoTrx;
	@EJB
	DAOTipoTransacao dao;
	
	public TipoTransacao getTipoTrx(){
		return tipoTrx;
	}
	public void setTipoTrx(TipoTransacao tipoTrx) {
		this.tipoTrx = tipoTrx;
	}
	public TipoTransacaoMB(){
		tipoTrx = new TipoTransacao();
	}
	public String cadastrar(){
		try {
			dao.createDAO(this.em);
			if(dao.gravar(getTipoTrx()))
				System.out.println("Tipo de transação gravado com sucesso!");
			else
				System.out.println("Falha na gravação do dado!");
		} catch (Exception e) {
			System.out.println("Erro ao gravar registro. Motivo:" + e.getMessage());
		}
		
		return "cadastroConfiguracao.xhtml";
	}
	public String atualizar(){
		
		return "Ok";
	}
	public String pesquisar(){
		return "Ok";
	}
	public String delete(){
		try {
			if(dao.remover(getTipoTrx()))
				System.out.println("Tipo de Transação removido com sucesso!");
			else
				System.out.println("Tipo de Transação não pode ser removido!");
			
		} catch (Exception e) {
			System.out.println("Erro ao excluir registro. Motivo:" + e.getMessage());
		}
		return "Ok";
	}
}
