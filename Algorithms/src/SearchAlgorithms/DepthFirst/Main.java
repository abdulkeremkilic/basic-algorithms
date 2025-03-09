package SearchAlgorithms.DepthFirst;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d", "e"));
        graph.put("c", List.of("f"));
        graph.put("d", Collections.emptyList());
        graph.put("e", Collections.emptyList());
        graph.put("f", Collections.emptyList());

// A visual representation of the graph
//        a - c - f
//        |
//    e - b
//        |
//        d

        depthFirstSearch(graph, "a");

    }


    private static void depthFirstSearch(Map<String, List<String>> graph, String node) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(node); // We push the given value into the stack

        while(!stack.isEmpty()) {
            String current = stack.pop();

            if(!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");

                List<String> neighbors = graph.getOrDefault(current, Collections.emptyList());
                //Collections.reverse(neighbors); // reversing the neighbors to maintain order
                for(String neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
