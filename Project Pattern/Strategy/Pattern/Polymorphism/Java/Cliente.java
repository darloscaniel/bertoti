public class Cliente {
    public Emprestimo emprestimo;

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void callEmprestimo(Double valor) {
        if (emprestimo != null) {
            emprestimo.emprestar(valor);
        } else {
            System.out.println("Nenhum tipo de emprestimo definido");
        }
    }
}