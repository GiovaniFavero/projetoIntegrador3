package br.com.udesc.ProjetoIntegrador3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exames")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class Exame {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Pessoa paciente;
	
	@Column(name="data_nascimento")
	@NotNull(message = "Data Vencimento é obrigatória.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private boolean feito;
	
	@ManyToOne
	@JoinColumn(name="id_local")
	private Local local;
	
	@ManyToOne
	@JoinColumn(name="id_medico")
	private Medico medico;
	
	public Exame() {
		
	}
	
	public Exame(Pessoa paciente, Date data, Local local, Medico medico) {
		super();
		this.paciente = paciente;
		this.data = data;
		this.local = local;
		this.medico = medico;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isFeito() {
		return feito;
	}
	public void setFeito(boolean feito) {
		this.feito = feito;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	@Override
	public String toString() {
		return "Exame [id=" + id + ", paciente=" + paciente + ", data=" + data + ", feito=" + feito + ", local=" + local
				+ ", medico=" + medico + "]";
	}
	
	
	
	

}
