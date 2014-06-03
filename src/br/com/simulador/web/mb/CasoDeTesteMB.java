package br.com.simulador.web.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.persistencia.DAOCasoDeTeste;

@ManagedBean(name="casoTeste")
@RequestScoped
public class CasoDeTesteMB {
	@PersistenceContext(unitName="persistenciaISO")    
	private EntityManager em;
	@EJB
	DAOCasoDeTeste dao;
	CasoDeTeste ct;
	
	public CasoDeTesteMB(){
		ct = new CasoDeTeste();
	}
	
	public CasoDeTeste getCt() {
		return ct;
	}
	public void setCt(CasoDeTeste ct) {
		this.ct = ct;
	}
	public String cadastrar(){
		try {
			dao.createDAO(em);
			if(dao.gravar(getCt()))
				System.out.println("Caso de Teste gravado com sucesso!");
			else
				System.out.println("Caso de Teste não foi gravado!");
		} catch (Exception e) {
			System.out.println("Erro ao gravar o Caso de Teste. Motivo:" + e.getMessage());
		}
		return "";
	}
	
	public String atualizar(){
		return "Ok";
	}
	public String pesquisar(){
		return "Ok";
	}
	public String delete(){
		try {
			if(dao.remover(getCt()))
				System.out.println("Caso de teste removido com sucesso!");
			else
				System.out.println("Caso de teste não pode ser removido!");
			
		} catch (Exception e) {
			System.out.println("Erro ao excluir registro. Motivo:" + e.getMessage());
		}
		return "Ok";
	}
}
