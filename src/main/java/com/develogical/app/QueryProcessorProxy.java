package com.develogical.app;

public class QueryProcessorProxy {
    private final QueryProcessor queryProcessor;

    public QueryProcessorProxy() {
        this.queryProcessor = new QueryProcessor();
    }

    public String processQuery(String query) {
        // Additional logic before forwarding the query
        System.out.println("Proxy: Pre-processing query...");

        // Forward the query to the real QueryProcessor
        String result = queryProcessor.process(query);

        // Additional logic after receiving the result
        System.out.println("Proxy: Post-processing result...");

        return result;
    }
}
