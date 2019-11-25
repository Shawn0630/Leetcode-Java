import java.util.*;

public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }

        Map<String, String> accountToName = new HashMap<>();
        Map<String, Node> graph = new HashMap<>();
        for(List<String> account : accounts) {
            String accountName = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                accountToName.put(account.get(i), accountName);
                union(graph, account.get(i), account.get(1));
            }
        }

        Map<String, Set<String>> unions = new HashMap<>();
        for(List<String> account : accounts) {
            unions.computeIfAbsent(findParent(graph.get(account.get(1))).val, ignore -> new HashSet<>());
            unions.get(findParent(graph.get(account.get(1))).val).addAll(account.subList(1, account.size()));
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, Set<String>> entry : unions.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(accountToName.get(entry.getKey()));
            List<String> email = new ArrayList<>(entry.getValue());
            email.sort(String::compareTo);
            list.addAll(email);
            res.add(list);
        }

        return res;
    }


    private class Node {
        String val;
        Node parent;
        Node(String val) {
            this.val = val;
            this.parent = this;
        }
    }

    private Node findParent(Node node) {
        if (node.parent != node) node.parent = findParent(node.parent);
        return node.parent;
    }

    private void union(Map<String, Node> graph, String source, String target) {
        graph.computeIfAbsent(source, ignore -> new Node(source));
        graph.computeIfAbsent(target, ignore -> new Node(target));
        Node rootSource = findParent(graph.get(source));
        Node rootTarget = findParent(graph.get(target));
        rootSource.parent = rootTarget;
    }
}
