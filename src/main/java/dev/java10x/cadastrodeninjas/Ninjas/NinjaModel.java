package dev.java10x.cadastrodeninjas.Ninjas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tb_cadastro") //Cria uma tabela e tem a opcao nao obrigatoria de adicionar o nome da tabela tambem
@Data // Retorna todos os metodos Getters & Setters
@NoArgsConstructor // Construtor sem parametro
@AllArgsConstructor // Construtor com todos os parametros
@ToString(exclude = "missoes")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID Id ; //Primary key

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) //Gerado com nome email
    private String email;

    @Column(name = "nome_aldeia")
    private String aldeia;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @JsonIgnore
    @ManyToOne //Um ninja tem uma unica missao
    @JoinColumn(name = "missoes_id") // Foreing Key (Chave Estrangeira)
    private MissoesModel missoes;

}
