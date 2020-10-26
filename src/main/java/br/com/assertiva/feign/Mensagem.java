package br.com.assertiva.feign;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensagem implements Serializable{
	@JsonProperty
	private Integer id;
	@JsonProperty
	private String corpo;

	public Mensagem(Integer id, String corpo) {
		this.id = id;
		this.corpo = corpo;
	}

	public Mensagem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	@Override
	public String toString() {
		return "Mensagem{" +
				"id=" + id +
				", corpo='" + corpo + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mensagem mensagem = (Mensagem) o;
		return id.equals(mensagem.id) &&
				corpo.equals(mensagem.corpo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, corpo);
	}
}
