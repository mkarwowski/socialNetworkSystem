package network.user;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String userName;
    private String bio;
    private final List<UserProfile> connections = new ArrayList<>();

    UserProfile() {
    }

    public String getUserName() {
        return userName;
    }

    public String getBio() {
        return bio;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    void setBio(String bio) {
        this.bio = bio;
    }

    public List<UserProfile> getConnections() {
        return connections;
    }

    public void addConnection(UserProfile profile) {
        connections.add(profile);
    }
}