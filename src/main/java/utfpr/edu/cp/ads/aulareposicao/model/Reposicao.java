package utfpr.edu.cp.ads.aulareposicao.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Reposicao")
@Table(name = "reposicao")
public class Reposicao implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @JoinColumn(name = "prof", 
        referencedColumnName = "nomeProf",
        nullable = false,
        insertable = true,
        updatable = true)
    private Professor professor;
    @JoinColumn(name = "aluno", 
        referencedColumnName = "nomeAluno",
        nullable = false,
        insertable = true,
        updatable = true)
    private Aluno aluno;
    private Date horario;
    private Presenca presenca;
    private Sincrono sincrono;
}