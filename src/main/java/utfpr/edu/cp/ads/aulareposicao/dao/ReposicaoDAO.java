package utfpr.edu.cp.ads.aulareposicao.dao;
import org.springframework.stereotype.Repository;
import utfpr.edu.cp.ads.aulareposicao.model.Reposicao;;

@Repository
public class ReposicaoDAO extends GenericDAO<Reposicao> {
    public ReposicaoDAO() {
        super(Reposicao.class);
    }
}