package br.com.udesc.ProjetoIntegrador3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medicos")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class Medico{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "CRM é obrigatório.")
	private String crm;
	
	@NotNull(message = "Nome é obrigatório.")
	private String nome;
	
	@NotNull(message = "Especialidade é obrigatório.")
	private String especialidade;
	
	@OneToMany(mappedBy = "medico")
	private List<Exame> exames;
	
	public List<Exame> getExames() {
		return exames;
	}
	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
	public Medico() {
		
	}
	
	public Medico(String crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	

}
