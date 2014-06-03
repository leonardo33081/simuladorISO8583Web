package br.com.simulador.web.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.Configuracao;
import br.com.simulador.persistencia.DAOConfiguracao;

@ManagedBean(name="configuracao")
@RequestScoped
public class ConfiguracaoMB {
	@PersistenceContext(unitName="persistenciaISO")    
	private EntityManager em;
	@EJB
	private DAOConfiguracao dao;
	
	Configuracao conf;
	public ConfiguracaoMB(){
		conf = new Configuracao();
	}
	
	public Configuracao getConf() {
		return conf;
	}
	public void setConf(Configuracao conf) {
		this.conf = conf;
	}
	
	public String cadastrar(){
		try {
			dao.createDAO(em);
			if(dao.gravar(getConf()))
				System.out.println("Configura��o salva com sucesso!");
			else
				System.out.println("Problema ao gravar a configura��o!");
		} catch (Exception e) {
			System.out.println("Erro ao gravar a configura��o. Motivo:" + e.getMessage());
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
			if(dao.remover(getConf()))
				System.out.println("Configura��o removida com sucesso!");
			else
				System.out.println("Configura��o n�o pode ser removido!");
			
		} catch (Exception e) {
			System.out.println("Erro ao excluir registro. Motivo:" + e.getMessage());
		}
		return "Ok";
	}
	
}
