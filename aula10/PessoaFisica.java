package aula10;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String n, String e, String t, String c){
        super(n, e, t);
        this.cpf = c;

    }

    public String getCpf() {
        return cpf;
    }

    public void imprimirDados(){
        System.out.println("Cliente{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone()+ '\'' +
                " cpf= " + cpf +
                '}');

    }
}
