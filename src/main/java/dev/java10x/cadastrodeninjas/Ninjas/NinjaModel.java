package dev.java10x.cadastrodeninjas.Ninjas;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro") //Cria uma tabela e tem a opcao nao obrigatoria de adicionar o nome da tabela tambem
@Data // Retorna todos os metodos Getters & Setters
@NoArgsConstructor // Construtor sem parametro
@AllArgsConstructor // Construtor com todos os parametros
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String nome;
    @Column(unique = true)
    private String email;
    private String aldeia;
    private int idade;
    @ManyToOne //Um ninja tem uma unica missao
    @JoinColumn(name = "missoes_id") // Foreing Key (Chave Estrangeira)
    private MissoesModel missoes;

}
