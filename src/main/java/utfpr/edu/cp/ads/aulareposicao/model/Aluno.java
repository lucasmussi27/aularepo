package utfpr.edu.cp.ads.aulareposicao.model;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Aluno")
@Table(name = "aluno")
public class Aluno implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nomeAluno;
}