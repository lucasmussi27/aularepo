package utfpr.edu.cp.ads.aulareposicao.dao;
import org.springframework.stereotype.Repository;
import utfpr.edu.cp.ads.aulareposicao.model.Aluno;

@Repository
public class AlunoDAO extends GenericDAO<Aluno> {
    public AlunoDAO() {
        super(Aluno.class);
    }
}