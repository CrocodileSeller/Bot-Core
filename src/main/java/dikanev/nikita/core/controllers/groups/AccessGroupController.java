package dikanev.nikita.core.controllers.groups;

import dikanev.nikita.core.controllers.commands.CommandController;
import dikanev.nikita.core.controllers.db.groups.AccessGroupDBController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AccessGroupController {
    private static final Logger LOG = LoggerFactory.getLogger(AccessGroupController.class);

    private static AccessGroupController ourInstance = new AccessGroupController();

    private PreparedStatement prStatement;

    public static AccessGroupController getInstance() {
        return ourInstance;
    }

    //Устанавливает доступ к команде для группы
    public boolean createAccess(int idGroup, int idCommand, boolean privilege) throws SQLException {
        return AccessGroupDBController.getInstance().createAccess(idGroup, idCommand, privilege);
    }

    //Устанавливает доступ к командам для группы
    public boolean createAccess(int idGroup, Integer[] idCommands, boolean privilege) throws SQLException {
        return AccessGroupDBController.getInstance().createAccess(idGroup, idCommands, privilege);
    }

    public boolean createAccess(int idGroup, String command, boolean privilege) throws SQLException{
        return AccessGroupDBController.getInstance().createAccess(idGroup, command, privilege);
    }

    public boolean createAccess(int idGroup, String[] nameCommands, boolean privilege) throws SQLException {
        return AccessGroupDBController.getInstance().createAccess(idGroup, nameCommands, privilege);
    }

    //Проверяет доступна ли комманда пользователю
    public boolean hasAccessUser(int idUser, int idCommand) throws SQLException {
        return AccessGroupDBController.getInstance().hasAccessUser(idUser, idCommand);
    }

    //Проверяет доступна ли комманда группе
    public boolean hasAccessGroup(int idGroup, int idCommand) throws SQLException {
        String commandName = CommandController.getInstance().getName(idCommand);
        if (commandName != null) {
            return AccessGroupDBController.getInstance().hasAccessGroup(idGroup, commandName);
        }
        return false;
    }

    //Проверяет доступна ли комманда группе
    public boolean hasAccessGroup(int idGroup, String commandName) throws SQLException {
        return AccessGroupDBController.getInstance().hasAccessGroup(idGroup, commandName);
    }

    //Возвращает доступность команд для группы
    public Map<String, Boolean> getAccessGroup(int idGroup, List<String> commandsName) throws SQLException {
        return AccessGroupDBController.getInstance().getAccessGroup(idGroup, commandsName);
    }

    //Изменяет доступ к команде для группы
    public boolean editAccess(int idGroup, int idCommand, boolean privilege) throws SQLException {
        return AccessGroupDBController.getInstance().editAccess(idGroup, idCommand, privilege);
    }

    //Удаляет из БД запись с доступом к команде
    public boolean deleteAccess(int idGroup, int idCommand) throws SQLException {
        return AccessGroupDBController.getInstance().deleteAccess(idGroup, idCommand);
    }
}
