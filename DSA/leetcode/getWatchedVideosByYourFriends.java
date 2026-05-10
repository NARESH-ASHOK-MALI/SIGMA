// There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.

// Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest. 
public class getWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited[id] = true;
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == level) {
                break;
            }
            for (int i = 0; i < size; i++) {
                int friendId = queue.poll();
                for (int friend : friends[friendId]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            currentLevel++;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int friendId = queue.poll();
            for (String video : watchedVideos.get(friendId)) {
                frequencyMap.put(video, frequencyMap.getOrDefault(video, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(result, (a, b) -> {
            int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });

        return result;
}
