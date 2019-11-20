package webapp.service;

import dao.EditionDao;
import entity.Edition;

import java.util.List;
import java.util.stream.Collectors;

public class EditionService {
    private EditionDao editionDao = new EditionDao();

    public List<String> getAllEditionByName() {
        List<Edition> editions = editionDao.read();
        return editions.stream().map(edition -> edition.getEditionName()).collect(Collectors.toList());
    }

    public List<Edition> getAllEdition() {
        return editionDao.read();
    }

    public void addEditionName(String newEditionName) {
        editionDao.create(new Edition(newEditionName));
    }

    public int deleteEdition (int idEdition) {
        return editionDao.delete(idEdition);
    }
}
