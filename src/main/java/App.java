import dao.EditionDao;
import webapp.service.EditionService;

public class App {
    public static void main(String[] args) {
        /*EditionService editionService = new EditionService();
        editionService.deleteEdition(3);*/

        EditionDao editionDao = new EditionDao();
        editionDao.delete(3);
    }
}
