package fatec;


import java.util.LinkedList;
import java.util.List;

public class SalaAula {
	
	private List<Aluno> alunosLista = new LinkedList<Aluno>();
	//LinkedList<> é equivalente a uma Array.
	
	public void cadastrarAluno(Aluno aluno) {
		
		alunosLista.add(aluno);
	}
	
	
	public List<Aluno> buscarAluno(String nome){
		
		List<Aluno> alunosEncontrados = new LinkedList<Aluno>();
		for(Aluno alunoVar:this.alunosLista) {
			
			//alunoVar é uma variável que aponta para um objeto do tipo Aluno
			if(alunoVar.getNome().equals(nome)) alunosEncontrados.add(alunoVar);
		}
		
		return alunosEncontrados;
		
	}
	
	public List<Aluno> getAlunos(){
		return alunosLista;
	}

}
