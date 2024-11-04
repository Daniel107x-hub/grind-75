package week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses=  5;
        int[][] prerequisites = {
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nodes = buildGraph(numCourses, prerequisites);
        boolean[] verified = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(hasCycles(i, nodes, path, verified)) return false;
        }
        return true;
    }

    public static boolean hasCycles(int index, List<List<Integer>> graph, boolean[] path, boolean[] verified){
        if(verified[index]) return false;
        if(path[index]) return true;
        path[index] = true;
        for(Integer nei : graph.get(index)){
            if(hasCycles(nei, graph, path, verified)) return true;
        }
        verified[index] = true;
        path[index] = false;
        return false;
    }

    public static List<List<Integer>> buildGraph(int courses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <  courses ; i++) graph.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }
        return graph;
    }
}
