package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.domain.Modalidade;
import model.service.ModalidadeService;

@WebService(serviceName="ws/modalidade")
public class ModalidadeFacade {

	@Inject
	private ModalidadeService modalidadeService;
	
	@WebMethod
	public List<Modalidade> getModalidadeesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@WebMethod
	public List<Modalidade> getModalidadees(@WebParam Modalidade modalidade){
		return modalidadeService.getModalidades(modalidade);
	}
	
	@WebMethod
	public Modalidade salvar(@WebParam Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@WebMethod
	public void atualizar(@WebParam Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
	
	@WebMethod
	public void excluir(@WebParam Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		modalidadeService.excluir(modalidade);
	}
}