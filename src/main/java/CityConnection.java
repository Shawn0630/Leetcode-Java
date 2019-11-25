import java.util.*;

public class CityConnection {
    public static class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    Map<String, Integer> cities = new HashMap<>();
    int[] parent;
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> list = new ArrayList<>();
        if (connections == null) {
            return list;
        }

        connections.sort((o1, o2) -> {
            if (o1.cost != o2.cost) {
                return o1.cost - o2.cost;
            } else if (!o1.city1.equals(o2.city1)) {
                return o1.city1.compareTo(o2.city1);
            } else {
                return o1.city2.compareTo(o2.city2);
            }
        });


        int cityCount = 0;
        for(Connection c: connections) {
            cities.putIfAbsent(c.city1, cityCount++);
            cities.putIfAbsent(c.city2, cityCount++);
        }

        parent = new int[cityCount];
        for(int i = 0; i < cityCount; i++) {
            parent[i] = i;
        }


        for(Connection c : connections) {
            if (union(c.city1, c.city2)) {
                list.add(c);
            }
        }

        return list;

    }

    private int findParent(int cityId) {
        if (parent[cityId] != cityId) parent[cityId] = findParent(parent[cityId]);
        return parent[cityId];
    }

    private boolean union(String city1, String city2) {
        int city1_parent = findParent(cities.get(city1));
        int city2_parent = findParent(cities.get(city2));
        if (city1_parent == city2_parent) {
            return false;
        }
        parent[city1_parent] = city2_parent;
        return true;

    }

    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost2(List<Connection> connections) {
        // Sort the list
        Collections.sort(connections, new Comparator<Connection>(){
            public int compare(Connection c1, Connection c2) {
                if (c1.cost != c2.cost) {
                    return (c1.cost - c2.cost);
                }
                if (!c1.city1.equals(c2.city1)) {
                    return c1.city1.compareTo(c2.city1);
                }
                return c1.city2.compareTo(c2.city2);
            }
        });

        //give each city id
        Map<String, Integer> nameId = new HashMap<>();
        int id = 0;
        for (Connection connect : connections) {
            if (!nameId.containsKey(connect.city1)) {
                nameId.put(connect.city1, ++id);
            }
            if (!nameId.containsKey(connect.city2)) {
                nameId.put(connect.city2, ++id);
            }
        }

        //initial father array
        int[] father = new int[id + 1];
        for (int i = 1; i < id + 1; i++) {
            father[i] = i;
        }

        //union find
        List<Connection> result = new ArrayList<>();
        for (Connection connect : connections) {
            int id1 = nameId.get(connect.city1);
            int id2 = nameId.get(connect.city2);

            if (find(father, id1) != find(father, id2)) {
                union(father, id1, id2);
                result.add(connect);
            }
        }

        // id = node number, size() = edge number = node number - 1
        return (result.size() == id - 1) ? result : new ArrayList<Connection>();
    }

    private int find (int[] father, int id) {
        if (father[id] == id) {
            return id;
        }

        return father[id] = find(father, father[id]);
    }

    private void union (int[] father, int id1, int id2) {
        int father1 = find(father, id1);
        int father2 = find(father, id2);

        father[father1] = father2;
    }
}
