package main.User;

import java.util.Objects;

public class User {
    private final String username;

    public User(String username) {
        if(username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username can't be empty");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
    }
}

