package br.cefetrj.sca.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	private Integer numero;

	@OneToOne(mappedBy = "endereco")
	private Aluno aluno;

	private String rua;

	private Endereco() {
	}

	public Endereco(String bairro, String cep, String cidade,
			String complemento, String estado, Integer numero, String rua) {
		super();
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.complemento = complemento;
		this.estado = estado;
		this.numero = numero;
		this.rua = rua;
	}

	/**
	 * @return Returns the bairro.
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return Returns the cep.
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return Returns the cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return Returns the complemento.
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @return Returns the estado.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return Returns the numero.
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @return Returns the aluno.
	 */
	public Aluno getaluno() {
		return aluno;
	}

	/**
	 * @return Returns the rua.
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param bairro
	 *            The bairro to set.
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep
	 *            The cep to set.
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade
	 *            The cidade to set.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param complemento
	 *            The complemento to set.
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @param estado
	 *            The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param numero
	 *            The numero to set.
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @param aluno
	 *            The aluno to set.
	 */
	public void setaluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * @param rua
	 *            The rua to set.
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
}
