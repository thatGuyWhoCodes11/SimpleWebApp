package com.develogical.app;

public class QueryProcessor {

    public String process(String query) {
        String result = "no result found";
        if (query.toLowerCase().contains("shakespeare")) {
            result = " \"William Shakespeare (26 April 1564 - 23 April 1616) was an \" +\n" +
                    "                    \"English poet, playwright, and actor, widely regarded as the greatest \" +\n" +
                    "                    \"writer in the English language and the world's pre-eminent dramatist.\"";
        }
        return result;
    }
}
