package utfpr.edu.cp.ads.aulareposicao.dao;
import org.springframework.stereotype.Repository;
import utfpr.edu.cp.ads.aulareposicao.model.Professor;

@Repository
public class ProfessorDAO extends GenericDAO<Professor> {
    public ProfessorDAO() {
        super(Professor.class);
    }
}