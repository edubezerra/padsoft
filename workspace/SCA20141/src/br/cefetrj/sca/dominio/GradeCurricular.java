package br.cefetrj.sca.dominio;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class GradeCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private SemestreLetivo semestreBase;

	private GradeCurricular() {
	}

	public GradeCurricular(SemestreLetivo semestre) {
		this.semestreBase = semestre;
	}

	@ManyToMany(mappedBy = "gradesCurriculares")
	private Set<Disciplina> disciplinas;

	public void addDisciplina(Disciplina disciplina) {
		getDisciplinas().add(disciplina);
	}

	private Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
