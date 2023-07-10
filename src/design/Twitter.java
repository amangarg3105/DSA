package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author amgarg
 */


class TweetNode {
    public int tweetId;
    public int timeStamp;

    public TweetNode(int tweetId) {
        this.tweetId = tweetId;
        timeStamp++;
    }
}


class User {
    public int userId;

    /**
     * What users this particular is following
     */
    public Set<Integer> followed;


    public User(int userId) {
        this.userId = userId;
        followed = new HashSet<>();
    }
}

public class Twitter {

    Map<Integer, User> usersMap;


    public Twitter() {
        usersMap = new HashMap<>();
    }


    public void postTweet(int userId, int tweetId) { //unique tweetId


        if (!usersMap.containsKey(userId)) {

        }
    }

    public List<Integer> getNewsFeed(int userId) {

        return null;
    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }

}
