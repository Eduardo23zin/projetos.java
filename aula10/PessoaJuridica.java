package aula10;

public class PessoaJuridica  extends Cliente{
    private String cnpj;
    private String nomeFantasia;

    public PessoaJuridica(String n, String e, String t, String cnpj, String nomeFantasia ){
        super(n, e, t);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public void imprimirDados(){

        System.out.println("Cliente{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone()+ '\'' +
                 "CNPJ = " + getCnpj() + "Nome fantasia = " + getNomeFantasia() +
                '}');
    }
}
