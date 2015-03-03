package br.jacobis;

import java.math.BigDecimal;
import java.util.Date;

public class OlaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + " Olá Mundo");	
		}
		/*int i = 0;
		while (i < 10) {
			System.out.println(i + 1 + " Olá Mundo");
			i++;
		}*/
	
	Aluno a1 = new Aluno(11316789L, "Maria Filisbina", "12345678", new Date());
	Aluno a2 = new Aluno(9813045L, "Golaço merece placa", "04395485890", new Date());
	Aluno a3 = new Aluno(30863477L, "Tião da Silva", "55009988333");
	Aluno a4 = new Aluno(54897114L, "Maria Joana");
	
	Professor p1 = new Professor("Humberto Cruvinel", "982354875", new BigDecimal("9587"));
	Professor p2 = new Professor("Leocadio", "124587232");
	
	System.out.println(a1);
	System.out.println(a2);
	System.out.println(a3);
	System.out.println(a4);
	System.out.println(p1);
	System.out.println(p2);
	
	System.out.println("Bonus do professor " + Professor.BONUS);
	System.out.println("Resultado da vericação da matricula = " + Aluno.verificaMatricula("1234"));
	}
}
