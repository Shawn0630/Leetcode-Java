package com.graph.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<Set<String>>> names = new HashMap<>();
        for(List<String> account : accounts) {
            String accountName = account.get(0);
            names.putIfAbsent(accountName, new ArrayList<>());
            names.get(accountName).add(new HashSet<>(account.subList(1, account.size())));
        }

        for(Map.Entry<String, List<Set<String>>> entry : names.entrySet()) {
            String name = entry.getKey();
            List<Set<String>> emails = entry.getValue();
            boolean[][] connected = new boolean[emails.size()][emails.size()];
            Set<Integer> visited = new HashSet<>();

            for(int i = 0; i < emails.size() - 1; i++) {
                for(int j = i + 1; j < emails.size(); j++) {
                    connected[i][j] = isConnected(emails.get(i), emails.get(j));
                    connected[j][i] = connected[i][j];
                }
            }

            for(int i = 0; i < emails.size(); i++) {
                if (!visited.contains(i)) {
                    Set<String> group = new HashSet<>();
                    dfs(i, name, connected, visited, emails, group, ans);
                    List<String> sorted = group.stream().sorted().collect(Collectors.toList());
                    sorted.add(0, name);
                    ans.add(sorted);
                }
            }

        }

        return ans;
    }

    private boolean isConnected(Set<String> a, Set<String> b) {
        for(String item : a) {
            if (b.contains(item)) return true;
        }

        return false;
    }

    private void dfs(int current, String name, boolean[][] graph, Set<Integer> visited, List<Set<String>> emails, Set<String> group, List<List<String>> ans) {
        visited.add(current);
        group.addAll(emails.get(current));
        for(int i = 0; i < graph.length; i++) {
            if (!visited.contains(i) && graph[current][i]) {
                dfs(i, name, graph, visited, emails, group, ans);
            }
        }
        // pitfall here, terminate condition shouldn't after recursive functions, will terminate early or miss result
        // 1->2, 3, 4
        // 2-> null, miss 3, 4
    }


    // list.get(0) name
    // list.get(1...) emails
    // list always has a name
    // [[aa, a, b, c], [aa, d], [aa, a, e]]
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        int id = 0;
        Map<Integer, String> idToAccountName = new HashMap<>();
        Map<String, Integer> emailAddresstoId = new HashMap<>();
        for(List<String> account : accounts) {
            idToAccountName.put(id, account.get(0));
            for(String email : account.subList(1, account.size())) {
                if (emailAddresstoId.containsKey(email)) {
                    uf.union(id, emailAddresstoId.get(email));
                    emailAddresstoId.put(email, uf.find(id));
                } else {
                    emailAddresstoId.put(email, id);
                }
            }
            id++;
        }
        Map<Integer, List<String>> idToEmailAddress = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailAddresstoId.entrySet()) {
            String emailAddress = entry.getKey();
            Integer emailId = entry.getValue();

            Integer root = uf.find(emailId);
            idToEmailAddress.putIfAbsent(root, new ArrayList<>());
            idToEmailAddress.get(root).add(emailAddress);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry : idToEmailAddress.entrySet()) {
            List<String> emailAddress = entry.getValue();
            Integer emailId = entry.getKey();
            String accountName = idToAccountName.get(emailId);
            List<String> merged = new ArrayList<>();
            merged.add(accountName);
            emailAddress.sort((a, b) -> a.compareTo(b));
            merged.addAll(emailAddress);
            ans.add(merged);
        }

        return ans;
    }

    // https://leetcode.com/problems/accounts-merge/discuss/1076789/Java-Two-Methods%3A-Union-Find-and-DFS
    // first email as connector
    // a -> b   b -> a
    // a -> c   c -> a
    // a -> d   d - > a

    // b -> e
    // b -> d
    public List<List<String>> accountsMerge3(List<List<String>> accounts) {
        Map<String, Set<String>> emailToEmailList = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for(List<String> account : accounts) {
            List<String> emails = account.subList(1, account.size());
            String emailKey = emails.get(0);

            for(String email : emails) {
                emailToEmailList.putIfAbsent(emailKey, new HashSet<>());
                emailToEmailList.get(emailKey).add(email);
                emailToEmailList.putIfAbsent(email, new HashSet<>());
                emailToEmailList.get(email).add(emailKey);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> account : accounts) {
            String accountName = account.get(0);
            List<String> emails = account.subList(1, account.size());
            String emailKey = emails.get(0);

            if (!visited.contains(emailKey)) {
                List<String> mergedList = new ArrayList<>();
                dfs(emailKey, visited, emailToEmailList, mergedList);
                mergedList.sort((a, b) -> a.compareTo(b));

                List<String> returnedList = new ArrayList<>();
                returnedList.add(accountName);
                returnedList.addAll(mergedList);
                ans.add(returnedList);
            }


        }

        return ans;
    }


    private void dfs(String cur, Set<String> visited, Map<String, Set<String>> neighours, List<String> mergedList) {
        visited.add(cur);
        mergedList.add(cur);

        if (neighours.containsKey(cur)) {
            for(String next : neighours.get(cur)) {
                if (!visited.contains(next)) {
                    dfs(next, visited, neighours, mergedList);
                }
            }
        }
    }

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
//        accountsMerge.accountsMerge4(Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
//                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
//                Arrays.asList("Mary","mary@mail.com"),
//                Arrays.asList("John","johnnybravo@mail.com")));

        accountsMerge.accountsMerge4(Arrays.asList(
                Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),
                Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),
                Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),
                Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),
                Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co")
        ));

//        accountsMerge.accountsMerge(Arrays.asList(
//                Arrays.asList("David","David0@m.co","David1@m.co"),
//                Arrays.asList("David","David3@m.co","David4@m.co"),
//                Arrays.asList("David","David4@m.co","David5@m.co"),
//                Arrays.asList("David","David2@m.co","David3@m.co"),Arrays.asList("David","David1@m.co","David2@m.co")));

//        accountsMerge.accountsMerge4(Arrays.asList(
//                Arrays.asList("David","David0@m.co","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co","David6@m.co","David7@m.co"),
//                Arrays.asList("David","David0@m.co","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co","David6@m.co","David7@m.co"),
//                Arrays.asList("David","David2@m.co","David18@m.co","David19@m.co","David20@m.co","David21@m.co","David22@m.co","David23@m.co","David24@m.co","David25@m.co"),
//                Arrays.asList("David","David3@m.co","David27@m.co","David28@m.co","David29@m.co","David30@m.co","David31@m.co","David32@m.co","David33@m.co","David34@m.co"),
//                Arrays.asList("David","David1@m.co","David9@m.co","David10@m.co","David11@m.co","David12@m.co","David13@m.co","David14@m.co","David15@m.co","David16@m.co")));
    }

    private class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int num) {
            this.parent = new int[num];
            this.size = new int[num];

            for(int i = 0; i < num; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }


        public int find(int i) {
            if (parent[i] == i) return i;

            parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return false;

            if (size[pi] <= size[pj]) { // merge smaller tree to a larger one
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            return true;
        }
    }



    // A -> B
    // A -> C
    // A -> D

    // B -> E

    // A -> B -> E
    public List<List<String>> accountsMerge4(List<List<String>> accounts) {
        Map<String, Set<String>> adjcents = new HashMap<>();
        Map<String, String> keyToName = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for(List<String> account : accounts) {
            String name = account.get(0);
            String key = account.get(1);

            keyToName.put(key, name);

            for(int i = 2; i < account.size(); i++) {
                String anotherEmail = account.get(i);
                adjcents.putIfAbsent(key, new HashSet<>());
                adjcents.get(key).add(anotherEmail);
                adjcents.putIfAbsent(anotherEmail, new HashSet<>());
                adjcents.get(anotherEmail).add(key);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, String> entry : keyToName.entrySet()) {
            String key = entry.getKey();
            String name = entry.getValue();

            if (!visited.contains(key)) {
                List<String> emails = new ArrayList<>();
                visited.add(key);
                dfs(key, emails, adjcents, visited);

                emails.sort((a, b) -> a.compareTo(b));
                List<String> returnedList = new ArrayList<>();
                returnedList.add(name);
                returnedList.addAll(emails);

                ans.add(returnedList);
            }
        }

        return ans;
    }

    private void dfs(String cur, List<String> emails, Map<String, Set<String>> adjcents, Set<String> visited) {
        emails.add(cur);

        if (adjcents.get(cur) == null) {
            return;
        }
        Set<String> nexts = adjcents.get(cur);

        for(String next : nexts) {
            if(!visited.contains(next)) {
                visited.add(next);
                dfs(next, emails, adjcents, visited);
            }
        }
    }


    private class UnionFind2 {
        int[] parent;
        int[] size;

        public UnionFind2(int count) {
            parent = new int[count];
            size = new int[count];

            for(int i = 0; i < count; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if(parent[i] == i) return i;

            parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return false; // same tree

            if (size[pi] <= size[pj]) { // merge smaller tree to larger one
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            return true;
        }
    }
}
