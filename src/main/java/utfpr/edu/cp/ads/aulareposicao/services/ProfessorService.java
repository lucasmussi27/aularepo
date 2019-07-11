package utfpr.edu.cp.ads.aulareposicao.services;
import utfpr.edu.cp.ads.aulareposicao.model.Professor;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.edu.cp.ads.aulareposicao.dao.ProfessorDAO;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorDAO dao;

    public List<Professor> listAll() {
        List<Professor> list = new ArrayList<>();
        dao.read().forEach(list::add);
        return list;
    }

    public Professor findById(int id) {
        return dao.read().stream()
                .filter(e -> e.getId() == id)
                .findAny().get();
    }

    public void add(Professor p) {
        dao.create(p);
    }

    public void edit(int id, Professor p) {
        dao.update(p);
    }

    public void remove(int id) {
        dao.delete(id);
    }
}