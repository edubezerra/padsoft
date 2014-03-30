package br.cefetrj.sca.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

public class GradeDisponibilidade implements Cloneable {

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne
	Professor professor;

	@ManyToMany
	@JoinTable(name = "GRADEDISPONIBILIDADE_DISCIPLINA", joinColumns = { @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "ID") })
	Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	@OneToMany
	Set<ItemHorario> itensGradeHorarios = new HashSet<ItemHorario>();

	private SemestreLetivo semestre;

	private Set<ItemDisponibilidade> horarios = new HashSet<ItemDisponibilidade>();

	private GradeDisponibilidade() {
	}

	public GradeDisponibilidade(Professor professor, SemestreLetivo semestre) {
		if (professor == null) {
			throw new IllegalArgumentException("Professor deve ser fornecido.");
		}
		this.professor = professor;
		this.semestre = semestre;
	}

	public GradeDisponibilidade(Professor professor) {
		this.professor = professor;
		this.semestre = (SemestreLetivo) SemestreLetivo.SEMESTRE_LETIVO_CORRENTE;
	}

	public Long getId() {
		return id;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Set<ItemDisponibilidade> getItensDisponibilidade() {
		return horarios;
	}

	public SemestreLetivo getSemestre() {
		return semestre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina adicionarDisciplina(Disciplina d) {
		if (!this.professor.estaHabilitado(d)) {
			throw new IllegalArgumentException(
					"Professor não está habilitado para disciplina \""
							+ d.getNome() + "\".");
		}
		this.disciplinas.add(d);
		return d;
	}

	public void removerDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
	}

	@Override
	public GradeDisponibilidade clone() {
		GradeDisponibilidade copia = new GradeDisponibilidade(this.professor,
				(SemestreLetivo) this.semestre);
		copia.setDisciplinas(this.disciplinas);
		for (ItemDisponibilidade item : horarios) {
			copia.horarios.add((ItemDisponibilidade) item.clone());
		}
		return copia;
	}

	private void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void adicionarItemDisponibilidade(String diaStr, String fim,
			String inicio) {
		DiaSemana dia = DiaSemana.findByText(diaStr);
		ItemDisponibilidade itemDisponibilidade = new ItemDisponibilidade(dia,
				inicio, fim);
		for (ItemDisponibilidade item : horarios) {
			if (itemDisponibilidade.equals(item)) {
				throw new IllegalArgumentException("Item já inserido.");
			} else if (itemDisponibilidade.colide(item)) {
				throw new IllegalArgumentException("Colisão de horários");
			}
		}
		horarios.add(itemDisponibilidade);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Semestre letivo: " + this.semestre);

		buffer.append("Disciplinas:\n");
		for (Disciplina disciplina : this.disciplinas) {
			buffer.append(disciplina.getNome() + "\n");
		}

		buffer.append("Horários:\n");
		for (ItemDisponibilidade item : this.horarios) {
			buffer.append(item.getInicio() + " às " + item.getFim() + "\n");
		}
		return buffer.toString();
	}

	public void adicionarItemDisponibilidade(DiaSemana dia, String horaInicial,
			String horaFinal) {
		ItemDisponibilidade item;
		item = new ItemDisponibilidade(dia, horaInicial, horaFinal);
		this.horarios.add(item);
	}

	public int getQuantidadeDisciplinas() {
		return disciplinas.size();
	}

	public int getQuantidadeDisponibilidades() {
		return horarios.size();
	}
}