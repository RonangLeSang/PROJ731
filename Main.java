import java.rmi.Naming;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize RMI registry
            java.rmi.registry.LocateRegistry.createRegistry(1099);

            // Start CoordinatorNode
            Coordinator coordinatorNode = new CoordinatorNode();
            Naming.rebind("CoordinatorNode", coordinatorNode);
            System.out.println("CoordinatorNode is ready.");

            // Create NodeMapping instances for parallel mapping
            int numMappingNodes = 3; // Adjust based on your needs
            List<NodeMapping> mappingNodes = new ArrayList<>();

            for (int i = 0; i < numMappingNodes; i++) {
                NodeMapping mappingNode = new NodeMappingImpl();
                Naming.rebind("MappingNode" + i, mappingNode);
                mappingNodes.add(mappingNode);
                System.out.println("MappingNode" + i + " is ready.");
            }

            // Generate a list of sentences for processing
            List<String> sentences = Arrays.asList(
                    "This is sentence one.",
                    "Another sentence here.",
                    "Yet another sentence for testing."
            );

            // Perform parallel mapping using ExecutorService
            ExecutorService executorService = Executors.newFixedThreadPool(numMappingNodes);
            List<Future<Map<String, Integer>>> mappingResults = new ArrayList<>();

            for (int i = 0; i < numMappingNodes; i++) {
                int startIndex = i * (sentences.size() / numMappingNodes);
                int endIndex = (i + 1) * (sentences.size() / numMappingNodes);

                List<String> subList = sentences.subList(startIndex, endIndex);

                int finalI = i;
                Callable<Map<String, Integer>> mappingTask = () -> {
                    NodeMapping mappingNode = mappingNodes.get(finalI);
                    return mappingNode.mapping(processSentences(subList));
                };

                Future<Map<String, Integer>> future = executorService.submit(mappingTask);
                mappingResults.add(future);
            }

            // Wait for mapping tasks to complete
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            // Aggregate mapping results
            ArrayList<Future<Map<String, Integer>>> aggregatedMapResult = new ArrayList<Future<Map<String, Integer>>>();

            for (Future<Map<String, Integer>> result : mappingResults) {
                aggregatedMapResult.add(result);
            }

            // Submit aggregated mapping result to CoordinatorNode
            coordinatorNode.submitMapResult(aggregatedMapResult);

            // Perform reduction
            NodeReduction reductionNode = new NodeReductionImpl();
            Map<String, Integer> finalResult = reductionNode.reduction(coordinatorNode.getReduceResult());

            // Display the final result
            System.out.println("Final Result: " + finalResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> processSentences(List<String> sentences) {
        ArrayList<String> result = new ArrayList<>();

        for(String sentence : sentences){
            String[] sentenceList = sentence.substring(0, sentence.length() - 1).split(" ");
            for (String element : sentenceList) {
                result.add(element);
            }
        }
        System.out.println(result);

        return result;
    }
}
