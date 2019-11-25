import java.util.List;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        for(Integer key : rooms.get(0)) {
            dfs(key, rooms, visited);
        }

        for(boolean visit : visited) if (!visit) return false;

        return true;
    }

    private void dfs(Integer key, List<List<Integer>> rooms, boolean[] visited) {
        visited[key] = true;
        for(Integer nxt : rooms.get(key)) {
            if (!visited[nxt]) {
                dfs(nxt, rooms, visited);
            }
        }
    }
}
