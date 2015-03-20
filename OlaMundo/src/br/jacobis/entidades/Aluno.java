package br.jacobis.entidades;

import java.util.Date;

public class Aluno extends Pessoa {

	private Long matricula;
	private Date dataAniversario;

	public Aluno(Long id, Long matricula, String nome, String cpf,
			Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	public Aluno(Long id, Long matricula, String nome, String cpf) {
		super(id, nome, cpf);
		this.matricula = matricula;
	}

	public Aluno(Long id, Long matricula, String nome) {
		super(id, nome, null);
		this.matricula = matricula;
	}

	public static boolean verificaMatricula(String matricula) {
		return matricula != null && !matricula.isEmpty()
				&& matricula.matches("^\\d+$");
	}

	public Long getMatricula() {
		return matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno [matricula=" + matricula
				+ ", dataAniversario=" + dataAniversario + "]";
	}

}
