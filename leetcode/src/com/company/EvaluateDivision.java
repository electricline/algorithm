package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            // Build graph
            Map<String, Map<String, Double>> graph = buildGraph(equations, values);

            double[] result = new double[queries.size()];

            for(int i=0; i<queries.size(); i++){
                result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
            }

            return result;
        }

        private double getPathWeight(String start, String end, HashSet<String> visitied, Map<String, Map<String, Double>> graph) {

            if(!graph.containsKey(start))
                return -1.0;

            if(graph.get(start).containsKey(end))
                return graph.get(start).get(end);

            visitied.add(start);

            for(Map.Entry<String, Double> neighbour : graph.get(start).entrySet()){
                if(!visitied.contains(neighbour.getKey())){
                    double weight  = getPathWeight(neighbour.getKey(), end, visitied, graph);
                    if(weight != -1.0)
                        return neighbour.getValue() * weight;
                }

            }
            return -1.0;
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){

            Map<String, Map<String, Double>> graph = new HashMap<>();
            String u, v;

            for(int i=0; i<equations.size(); i++){
                u = equations.get(i).get(0);
                v = equations.get(i).get(1);
                graph.putIfAbsent(u, new HashMap<>());
                graph.get(u).put(v, values[i]);
                graph.putIfAbsent(v, new HashMap<>());
                graph.get(v).putIfAbsent(u, 1/values[i]);
            }
            return graph;
        }
    }
}
