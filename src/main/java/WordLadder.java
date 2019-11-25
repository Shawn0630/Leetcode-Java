import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

public class WordLadder {

    boolean found;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.distance - node2.distance);

        Set<String> visited = new HashSet<>();

        queue.add(new Node(beginWord, 1));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String src = node.src;
            int dist = node.distance;

            if (visited.contains(src)) {
                continue;
            } else {
                visited.add(src);
            }

            if (src.equals(endWord)) {
                return dist;
            } else {
                for(String word : wordList) {
                    if (!word.equals(src) && !visited.contains(word) && isNear(word, src)) {
                        queue.add(new Node(word, dist + 1));
                    }
                }
            }
        }

        return 0;
    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        if (beginWord == null || endWord == null || wordList == null) {
//            return new ArrayList<>();
//        }
//        Set<String> visted = new HashSet<>();
//        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
//        List<List<String>> res = new ArrayList<>();
//        queue.add(new Node(beginWord, 0, Arrays.asList(beginWord)));
//        int minDepth = Integer.MAX_VALUE;
//        Map<String, List<String>> map = new HashMap<>();
//        List<String> ajacents = new ArrayList<>();
//        for(String word: wordList) {
//            if (isNear(word, beginWord)) {
//                ajacents.add(word);
//            }
//        }
//        map.put(beginWord, ajacents);
//        for(String word1: wordList) {
//            if (map.keySet().contains(word1)) {
//                continue;
//            }
//            List<String> list = new ArrayList<>();
//            for(String word2: wordList) {
//                if (isNear(word1, word2)) {
//                    list.add(word2);
//                }
//            }
//            map.put(word1, list);
//        }
//
//
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            int dist = node.distance;
//            String src = node.src;
//            visted.add(src);
//
//            if (dist > minDepth) {
//                continue;
//            }
//
//            if (src.equals(endWord)) {
//                res.add(new ArrayList<>(node.path));
//                minDepth = Math.min(minDepth, dist);
//            } else {
//                for(String word : map.get(src)) {
//                    if (!visted.contains(word) ) {
//                        List<String> path = new ArrayList<>(node.path);
//                        path.add(word);
//                        queue.add(new Node(word, dist + 1, path));
//                    }
//                }
//            }
//
//        }
//
//
//        return res;
//    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        List<String> ajacents = new ArrayList<>();
        for(String word: wordList) {
            if (isNear(word, beginWord)) {
                ajacents.add(word);
            }
        }
        map.put(beginWord, ajacents);
        for(String word1: wordList) {
            if (map.keySet().contains(word1)) {
                continue;
            }
            List<String> list = new ArrayList<>();
            for(String word2: wordList) {
                if (isNear(word1, word2)) {
                    list.add(word2);
                }
            }
            map.put(word1, list);
        }

        HashMap<String, List<List<String>>> begin = new HashMap<>();
        List<List<String>> bPath = new ArrayList<>();
        List<String> b = new ArrayList<>();
        b.add(beginWord);
        bPath.add(b);
        begin.put(beginWord, bPath);

        HashMap<String, List<List<String>>> end = new HashMap<>();
        List<List<String>> ePath = new ArrayList<>();
        List<String> e = new ArrayList<>();
        e.add(endWord);
        ePath.add(e);
        end.put(endWord, ePath);
        found = false;

        List<List<String>> res = new ArrayList<>();

        while (!begin.isEmpty() && !end.isEmpty() && !found) {
            if (begin.size() <= end.size()) {
                bfs_traversal(begin, end, map, beginWord, res);
            } else {
                bfs_traversal(end, begin, map, beginWord, res);
            }
        }

        return res;
    }

    private boolean isNear(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }

        boolean first = false;
        for(int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (!first) {
                    first = true;
                } else {
                    return false;
                }
            }
        }

        return first;
    }

    private void bfs_traversal(Map<String, List<List<String>>> begin, Map<String, List<List<String>>> end, Map<String, List<String>> nextString, String beginWord, List<List<String>> res) {
        Map<String, List<List<String>>> curLevel = new HashMap<>();
        Set<String> endSet = end.keySet();
        for(Map.Entry<String, List<List<String>>> beginEntry : begin.entrySet()) {
            List<List<String>> paths = beginEntry.getValue();
            List<String> strings = nextString.get(beginEntry.getKey());
            if (strings != null) {
                for (String next : strings) {
                    if (endSet.contains(next)) {
                        found = true;
                        for (List<String> forward : paths) {
                            for (List<String> backward : end.get(next)) {
                                List<String> newForward = new ArrayList<>(forward);
                                List<String> newBackward = new ArrayList<>(backward);
                                Collections.reverse(newBackward);
                                newForward.addAll(newBackward);
                                if (!newForward.get(0).equals(beginWord)) {
                                    Collections.reverse(newForward);
                                }
                                res.add(newForward);
                            }
                        }
                    } else if (!fromContains(next, paths)) {
                        for (List<String> path : paths) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(next);
                            curLevel.computeIfAbsent(next, ignore -> new ArrayList<>()).add(newPath);
                        }
                    }
                }
            }
        }
        begin.clear();
        begin.putAll(curLevel);
    }

    private boolean fromContains(String to, List<List<String>> from) {
        for (List<String> fromPath : from) {
            if (fromPath.contains(to)) {
                return true;
            }
        }
        return false;
    }


    private class Node {
        String src;
        int distance;
        List<String> path;

        Node(String src, int distance) {
            this.src = src;
            this.distance = distance;
        }

        Node(String src, int distance, List<String> path) {
            this.src = src;
            this.distance = distance;
            this.path = path;
        }
    }

}
