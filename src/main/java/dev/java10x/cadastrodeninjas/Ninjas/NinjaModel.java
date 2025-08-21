package dev.java10x.cadastrodeninjas.Ninjas;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String nome;
    private String email;
    private String aldeia;
    private int idade;

    //private List<MissoesModel> missoes;

    @ManyToOne //Um ninja tem uma unica missao
    @JoinColumn(name = "missoes_id") // Foreing Key (Chave Estrangeira)
    private MissoesModel missoes;


    public NinjaModel(){

    }


    public NinjaModel(String nome, String email, String aldeia, int idade) {
        this.nome = nome;
        this.email = email;
        this.aldeia = aldeia;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void AdicionarMissao(){

    }

    @Override
    public String toString() {
        return "NinjaModel{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", aldeia='" + aldeia + '\'' +
                ", idade=" + idade +
                '}';
    }

}
