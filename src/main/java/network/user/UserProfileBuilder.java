package network.user;

import java.util.List;

public class UserProfileBuilder {
    private final UserProfile userProfile = new UserProfile();
    
    public UserProfileBuilder() {
        //nothing on purpose
    }
    
    public static UserProfileBuilder create() {
        return new UserProfileBuilder();
    }

    public UserProfileBuilder setUserName(String userName) {
       userProfile.setUserName(userName);
        return this;
    }
    
    public UserProfileBuilder setBio(String bio) {
        userProfile.setBio(bio);
        return this;
    }
    
    public UserProfileBuilder addConnection(UserProfile userProfile) {
        this.userProfile.addConnection(userProfile);
        return this;
    }

    public UserProfileBuilder addConnections(List<UserProfile> userProfiles) {
        for (UserProfile profile : userProfiles) {
            userProfile.addConnection(profile);
        }
        return this;
    }
    
    public UserProfile build() {
       return userProfile;
    }
}
