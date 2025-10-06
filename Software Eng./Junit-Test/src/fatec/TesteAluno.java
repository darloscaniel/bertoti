package fatec;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TesteAluno {

	@Test
	void test() {
	
		SalaAula fatec = new SalaAula();
		
		Aluno carlo = new Aluno("Carlos","12345");
		Aluno luiz = new Aluno("Luiz","12346");
		
		fatec.cadastrarAluno(luiz);
		fatec.cadastrarAluno(carlo);
		
		assertEquals(fatec.getAlunos().size(), 2);
		
		List<Aluno> encontrar = fatec.buscarAluno("Luiz");
		assertEquals(encontrar.get(0).getRa(), luiz.getRa());
		
	}

}
