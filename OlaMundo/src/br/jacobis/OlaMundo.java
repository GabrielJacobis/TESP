package br.jacobis;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.jacobis.entidades.Aluno;
import br.jacobis.entidades.Professor;
import br.jacobis.persistencia.JDBCUtil;

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
	
	Aluno a1 = new Aluno(1L, 11316789L, "Maria Filisbina", "12345678", new Date());
	Aluno a2 = new Aluno(2L, 9813045L, "Golaço merece placa", "04395485890", new Date());
	Aluno a3 = new Aluno(3L, 30863477L, "Tião da Silva", "55009988333");
	Aluno a4 = new Aluno(4L, 54897114L, "Maria Joana");
	
	Professor p1 = new Professor(1L, "Humberto Cruvinel", "982354875", new BigDecimal("9587"));
	Professor p2 = new Professor(2L, "Leocadio", "124587232");
	
	System.out.println(a1);
	System.out.println(a2);
	System.out.println(a3);
	System.out.println(a4);
	System.out.println(p1);
	System.out.println(p2);
	
	System.out.println("Bonus do professor " + Professor.BONUS);
	System.out.println("Resultado da vericação da matricula = " + Aluno.verificaMatricula("1234"));
	
	try {
		ResultSet res = JDBCUtil.getConnection().prepareStatement(
				"select * from tb_aluno").executeQuery();
		while (res.next()){
			System.out.println(res.getLong("id")+"\t"+res.getString("nome"));
		}
		JDBCUtil.closeConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
