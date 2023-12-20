package network;

import network.user.UserProfile;
import network.user.UserProfileBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetworkSystem {
    private Map<String, UserProfile> userProfiles;

    public SocialNetworkSystem() {
        userProfiles = new HashMap<>();
    }

    public void createUserProfile(String username, String bio) {
        UserProfile userProfile = UserProfileBuilder.create()
                .setUserName(username)
                .setBio(bio)
                .build();
        userProfiles.put(username, userProfile);
    }

    public void connectUsers(String username1, String username2) {
        UserProfile profile1 = userProfiles.get(username1);
        UserProfile profile2 = userProfiles.get(username2);

        if (profile1 != null && profile2 != null) {
            profile1.addConnection(profile2);
            profile2.addConnection(profile1);
            System.out.println(username1 + " and " + username2 + " are now connected.");
        } else {
            System.out.println("Invalid usernames. Cannot establish connection.");
        }
    }

    public void displayUserProfile(String username) {
        UserProfile profile = getUserProfileByUserName(username);

        if (profile != null) {
            System.out.println("Username: " + profile.getUserName());
            System.out.println("Bio: " + profile.getBio());
            List<UserProfile> connections = profile.getConnections();
            if (!connections.isEmpty()) {
                System.out.println("Connections:");
                for (UserProfile connection : connections) {
                    System.out.println("- " + connection.getUserName());
                }
            } else {
                System.out.println("No connections yet.");
            }
        } else {
            System.out.println("User profile not found.");
        }
    }

    public UserProfile getUserProfileByUserName(String userName) {
        return userProfiles.get(userName);
    }

    public static void main(String[] args) {
        SocialNetworkSystem socialNetwork = new SocialNetworkSystem();

        socialNetwork.createUserProfile("Mariusz", "Hi, I'm Mariusz!");
        socialNetwork.createUserProfile("Bartek", "Hello from Bartek!");
        socialNetwork.createUserProfile("Joanna", "Nice to meet you all!");

        socialNetwork.connectUsers("Alice", "Bob");
        socialNetwork.connectUsers("Bob", "Charlie");

        socialNetwork.displayUserProfile("Alice");
        socialNetwork.displayUserProfile("Bob");
        socialNetwork.displayUserProfile("Charlie");
    }
}