package server;


import java.io.EOFException;
import java.util.Objects;

public class DatabaseAuthService implements AuthService {


    private boolean checkUser;

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return Database.getUserNickname(login, password);
    }


    @Override
    public boolean registration(String login, String password, String nickname) {
        if (Database.getUserNickname(login, password).equals(nickname)) {
            return false;
        }
        Database.createUser(login, password, nickname);
        return true;
    }
}






