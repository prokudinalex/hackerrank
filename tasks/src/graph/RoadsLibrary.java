package graph;

import java.util.*;

public class RoadsLibrary {

    private static class Road {
        City A;
        City B;
        boolean enabled;

        Road(City a, City b) {
            this.A = a;
            this.B = b;
        }

        void enable() {
            enabled = true;
            A.linked.add(B);
            B.linked.add(A);
        }

        void disable() {
            enabled = false;
            A.linked.remove(B);
            B.linked.remove(A);
        }
    }

    private static class City {
        boolean covered;
        Set<City> linked = new HashSet<>();

        public void link(City c) {
            linked.add(c);
        }

        public void clear() {
            linked.clear();
            covered = false;
        }
    }

    private static List<City> createCities(int size) {
        List<City> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new City());
        }
        return result;
    }

    private static long countCost(List<City> cities, List<Road> roads, long cost_lib, long cost_road) {
        long[] cost = {0};

        cities.forEach(c -> c.covered = false);

        roads.forEach(r -> {
            if(r.enabled) {
                cost[0] += cost_road;
            }
        });

        cities.forEach(c -> {
            if (!c.covered) {
                c.covered = true;
                cost[0] += cost_lib;
            }

            c.linked.forEach(linked -> linked.covered = true);
        });

        return cost[0];
    }

    private static void iteration(Scanner in) {
        int cities = in.nextInt();
        List<City> city_list = createCities(cities);

        int roads = in.nextInt();
        long cost_lib = in.nextLong();
        long cost_road = in.nextLong();

        List<Road> road_list = new ArrayList<>();
        for(int i = 0; i < roads; i++){
            int i1 = in.nextInt();
            int i2 = in.nextInt();
            City city1 = city_list.get(i1 - 1);
            City city2 = city_list.get(i2 - 1);
            road_list.add(new Road(city1, city2));
        }

        if (cost_road >= cost_lib) {
            System.out.println(cost_lib * cities);
            return;
        }

        // count min without roads at all
        long[] min = {countCost(city_list, road_list, cost_lib, cost_road)};
        road_list.forEach(r -> {
            r.enable();
            long cost = countCost(city_list, road_list, cost_lib, cost_road);
            if (min[0] > cost) {
                min[0] = cost;
            } else {
                r.disable();
            }
        });

        System.out.println(min[0]);
        city_list.clear();
        road_list.clear();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            iteration(in);
        }
    }
}
