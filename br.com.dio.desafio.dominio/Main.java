package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("Botcamp");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso Java Ja");
		curso2.setDescricao("Java Completo");
		curso2.setCargaHoraria(6);
		
		
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Curso Java");
		mentoria.setDescricao("Mentoria Java");
		mentoria.setData(LocalDate.now());
		
		
		
		//System.out.println(curso1);
		//System.out.println(curso2);
		//System.out.println(mentoria);
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição bootcamp Java Developer");
		bootcamp.getConteudo().add(curso1);
		bootcamp.getConteudo().add(curso2);
		bootcamp.getConteudo().add(mentoria);
		
		
		
		Dev devMarilza= new Dev();
		devMarilza.setNome("Marilza");
		devMarilza.inscreverBootcamp(bootcamp);
		System.out.println("Conteudo Inscritos Marilza: " + devMarilza.getConteudosInscritos());
		devMarilza.progredir();
		System.out.println("-");
		System.out.println("Conteudo Inscritos Marilza: " + devMarilza.getConteudosInscritos());
		System.out.println("Conteudo Concluido Marilza: " + devMarilza.getConteudosConcluidos());
		System.out.println("XP:" + devMarilza.calcularTotalXp());
		
		
		
		System.out.println("---------");
		
		
		Dev devMaria = new Dev();
		devMaria.setNome("Maria");
		devMaria.inscreverBootcamp(bootcamp);	
		System.out.println("Conteudo Inscritos Maria: " + devMarilza.getConteudosInscritos());
		devMaria.progredir();
		devMaria.progredir();
		devMaria.progredir();
		System.out.println("-");
		System.out.println("Conteudo Inscritos Marilza: " + devMarilza.getConteudosInscritos());
		System.out.println("Conteudo Concluido Maria: " + devMarilza.getConteudosConcluidos());
		System.out.println("XP:" + devMaria.calcularTotalXp());
		

	}

}
