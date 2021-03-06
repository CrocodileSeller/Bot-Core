package dikanev.nikita.core.controllers.groups;

import dikanev.nikita.core.controllers.db.groups.GroupDBController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupController {

    private static final Logger LOG = LoggerFactory.getLogger(GroupController.class);

    private static GroupController ourInstance = new GroupController();

    private PreparedStatement prStatement;

    public static GroupController getInstance() {
        return ourInstance;
    }

    //Создание группы
    public int createGroup(String name) throws SQLException {
        return GroupDBController.getInstance().createGroup(name);
    }

    //Создание группы
    public int createGroup(String name, int id) throws SQLException {
        return GroupDBController.getInstance().createGroup(name, id);
    }

    //Удаление группы
    public boolean deleteGroup(int idGroup) throws SQLException {
        return GroupDBController.getInstance().deleteGroup(idGroup);
    }

    //Получение имени группы
    public String getName(int idGroup) throws SQLException {
        return GroupDBController.getInstance().getName(idGroup);
    }
}
