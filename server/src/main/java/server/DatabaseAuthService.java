package server;



public class DatabaseAuthService implements AuthService {

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return Database.getUserNickname(login, password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {


        Database.createUser(login, password, nickname);
        return true;
    }

}

