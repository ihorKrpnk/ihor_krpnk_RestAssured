package users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Users {

    @JsonProperty("Users")
    private List<UsersItem> users;

    public void setUsers(List<UsersItem> users) {
        this.users = users;
    }

    public List<UsersItem> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}