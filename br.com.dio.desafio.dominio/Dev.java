package br.com.dio.desafio.dominio;


import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudosInscritos =  new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		
		this.conteudosInscritos.addAll(bootcamp.getConteudo());
		bootcamp.getDevsInscritos().add(this);		
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
			
		}else {
			System.err.println("Você não está matriculado");
	}
	}
	
	public double calcularTotalXp() {
		
		return this.conteudosConcluidos
			.stream()
			.mapToDouble(Conteudo :: calcularXp)
			.sum();
	}
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}
	
	
	

}
