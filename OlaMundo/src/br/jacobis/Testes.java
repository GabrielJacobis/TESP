package br.jacobis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.jacobis.entidades.Aluno;
import br.jacobis.entidades.Professor;
import br.jacobis.persistencia.AlunoDAO;
import br.jacobis.persistencia.JDBCTestes;
import br.jacobis.persistencia.ProfessorDAO;

public class Testes {

	@Test
	public void testeInsereAluno() {
		AlunoDAO alu = new AlunoDAO();
		Aluno a = new Aluno(1L, 9999L, "Carlos Pereira", "99999999", new Date());
		alu.insert(a);
		Aluno row = alu.findByCPF(a.getCPF());
		Assert.assertEquals(a.getCPF(), row.getCPF());
	}

	@Test
	public void testeBuscarAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.findByCPF("11111111111");
		Assert.assertEquals("Maria Clara", a.getNome());
	}

	@Test
	public void testeInsereProfessor() {
		ProfessorDAO prof = new ProfessorDAO();
		Professor p = new Professor(5L, "Mauro Tramonte", "77777777777", new BigDecimal("5000"));
		prof.insert(p);
		Professor row = prof.findByCPF(p.getCPF());
		Assert.assertEquals(p.getCPF(), row.getCPF());
	}

	@Test
	public void testeBuscarProfessor() {
		ProfessorDAO prof = new ProfessorDAO();
		Professor row = prof.find(1L);
		Assert.assertEquals("Paulo Severo", row.getNome());
	}

	@Before
	public void preparaBanco() {
		AlunoDAO alu = new AlunoDAO();
		Aluno a1 = new Aluno(1L, 1234L, "Maria Clara", "11111111111", new Date());
		Aluno a2 = new Aluno(2L, 4567L, "João Carlos", "22222222222", new Date());
		Aluno a3 = new Aluno(3L, 8910L, "Mário Dupré", "33333333333", new Date());

		alu.insert(a1);
		alu.insert(a2);
		alu.insert(a3);

		ProfessorDAO prof = new ProfessorDAO();
		Professor p1 = new Professor(1L, "Paulo Severo", "44444444444", new BigDecimal("10000"));
		Professor p2 = new Professor(2L, "Ana Castelo", "55555555555", new BigDecimal("12000"));
		Professor p3 = new Professor(2L, "Margareth Rico", "66666666666", new BigDecimal("20000"));

		prof.insert(p1);
		prof.insert(p2);
		prof.insert(p3);
	}

	@After
	public void limpaBanco() {
		JDBCTestes.limparBanco("TB_ALUNO");
		JDBCTestes.limparBanco("TB_PROFESSOR");
	}

	@Test
	public void testeAtualizaAluno() {
		AlunoDAO alu = new AlunoDAO();

		String cpf = "11111111111";
		Aluno a = alu.findByCPF(cpf);
		a.setNome("Maria Clara Santana");

		alu.update(a);

		Aluno b = alu.findByCPF(cpf);
		Assert.assertEquals("Maria Clara Santana", b.getNome());
	}

	@Test
	public void testeAtualizaProfessor() {
		ProfessorDAO prof = new ProfessorDAO();

		String cpf = "55555555555";

		Professor p = prof.findByCPF(cpf);
		p.setNome("Paulo Severo Mole");

		prof.update(p);

		Professor p2 = prof.findByCPF(cpf);
		Assert.assertEquals("Paulo Severo Mole", p2.getNome());
	}

	@Test
	public void testeDeletaAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		String cpf = a.getCPF();
		dao.delete(a);

		Aluno row = dao.findByCPF(cpf);
		Assert.assertNull(row);
	}

	@Test
	public void testeDeletaProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor p = dao.find(1L);
		String cpf = p.getCPF();
		dao.delete(p);

		Professor row = dao.findByCPF(cpf);
		Assert.assertNull(row);
	}

	@Test
	public void testeSelecionarTodosAlunos() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> rows = dao.findALL();
		Assert.assertEquals(3, rows.size());
	}

	@Test
	public void testeSelecionarTodosProfessores() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> rows = dao.findAll();
		Assert.assertEquals(3, rows.size());
	}

}
