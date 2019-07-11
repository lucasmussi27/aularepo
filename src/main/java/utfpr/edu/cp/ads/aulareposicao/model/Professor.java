package utfpr.edu.cp.ads.aulareposicao.model;
import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Professor")
@Table(name = "professor")
public class Professor implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nomeProf;
}