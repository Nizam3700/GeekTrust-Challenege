package org.example.Repo;

import java.util.HashMap;
import java.util.Map;

public class RoutePath {
    private static final Map<String, Integer> routePathsA = new HashMap<>();
    private static final Map<String, Integer> routePathsB = new HashMap<>();

    static {
//        RouteA Path for Train A
        routePathsA.put("CHN", 0);
        routePathsA.put("SLM", 350);
        routePathsA.put("BLR", 550);
        routePathsA.put("KRN", 900);
        routePathsA.put("HYB", 1200);
        routePathsA.put("NGP", 1600);
        routePathsA.put("ITJ", 1900);
        routePathsA.put("BPL", 2000);
        routePathsA.put("AGA", 2500);
        routePathsA.put("NDL", 2700);
        routePathsA.put("PTA", 3800);
        routePathsA.put("NJP", 4200);
        routePathsA.put("GHY", 4700);


//        Route B for Train B
        routePathsB.put("TVC", 0);
        routePathsB.put("SRR", 300);
        routePathsB.put("MAQ", 600);
        routePathsB.put("MAO", 1000);
        routePathsB.put("PNE", 1400);
        routePathsB.put("HYB", 2000);
        routePathsB.put("NGP", 2400);
        routePathsB.put("ITJ", 2700);
        routePathsB.put("BPL", 2800);
        routePathsB.put("PTA", 3800);
        routePathsB.put("NJP", 4200);
        routePathsB.put("GHY", 4700);
        routePathsB.put("AGA", 2500);

    }

    public static int getDistanceForTrainA(String destination) {
        return routePathsA.getOrDefault(destination, 0);
    }
    public static int getDistanceForTrainB(String destination) {
        return routePathsB.getOrDefault(destination, 0);
    }
}
