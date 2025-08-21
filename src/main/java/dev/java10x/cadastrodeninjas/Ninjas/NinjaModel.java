package dev.java10x.cadastrodeninjas.Ninjas;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
