package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
    Map<Integer,Set<Integer>> followUser = new HashMap<>();
    int time = 0;
    /** Initialize your data structure here. */
    public Twitter() {

    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Map<Integer,Integer> tweet = map.getOrDefault(userId,new HashMap<Integer,Integer>());
        tweet.put(time++,tweetId);
        map.put(userId, tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(10,(a,b) -> a[0] - b[0]);
        Set<Integer> followees = followUser.getOrDefault(userId,new HashSet<Integer>());
        Map<Integer,Integer> tweet = map.getOrDefault(userId,new HashMap<Integer,Integer>());
        for(int key : tweet.keySet()){
            int val = tweet.get(key);
            if(pq.size() < 10){
                 pq.offer(new int[]{key,val});
            }else if(pq.peek()[0] < key){
                pq.poll();
                pq.offer(new int[]{key,val});
            }
        }
        for(int followeeId : followees){
            Map<Integer,Integer> followeeTweet = map.getOrDefault(followeeId,new HashMap<Integer,Integer>());
            for(int key : followeeTweet.keySet()){
                int val = followeeTweet.get(key);
                if(pq.size() < 10){
                    pq.offer(new int[]{key,val});
                }else if(pq.peek()[0] < key){
                    pq.poll();
                    pq.offer(new int[]{key,val});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        Collections.reverse(ans);
        System.out.println(ans);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
         Set<Integer> followees = followUser.getOrDefault(followerId,new HashSet<Integer>());
         followees.add(followeeId);
         followUser.put(followerId, followees);
         
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
       Set<Integer> followees = followUser.getOrDefault(followerId,new HashSet<Integer>());
       if(!followees.contains(followeeId)) return;
       followees.remove(followeeId);
    }
    public static void main(String[] args) {
		Twitter twitter = new Twitter();
		
		twitter.postTweet(1, 6);
		twitter.postTweet(1, 7);
		twitter.postTweet(1, 8);
		twitter.postTweet(1, 9);
		twitter.postTweet(1, 10);
		twitter.postTweet(2, 11);
		twitter.postTweet(2, 12);
		twitter.postTweet(2, 13);
		twitter.postTweet(2, 14);
		twitter.postTweet(2, 15);
		twitter.postTweet(2, 16);
		twitter.postTweet(2, 17);
		twitter.postTweet(2, 18);
		
		twitter.getNewsFeed(1);
		twitter.follow(1, 2);
		twitter.getNewsFeed(1);
		twitter.unfollow(1, 2);
		twitter.follow(1, 3);
		twitter.getNewsFeed(1);

	}
}
