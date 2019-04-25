package com.luchoct.codingtests.chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ChainValidator {

    private static final String ELEMENT_SEPARATOR = ";";
    private static final String NAME_ADDRESS_SEPARATOR = "-";
    private static final String STARTING_NAME = "BEGIN";
    private static final String ENDING_NAME = "END";

     static Map<String, String> indexByName(final String chain) {
        final Map<String, String> sequence = new HashMap<>(chain.length() / 4);
        Arrays.stream(chain.split(ChainValidator.ELEMENT_SEPARATOR)).forEach(
                el -> {
                    final String[] pair = el.split(ChainValidator.NAME_ADDRESS_SEPARATOR);
                    if (pair.length == 2) {
                        final String previousValue = sequence.put(pair[0], pair[1]);
                        if (previousValue != null) {
                            throw new IllegalArgumentException("Wrong chain. Duplicated name " + pair[0]);
                        }
                    } else {
                        throw new IllegalArgumentException("Wrong chain. Expected element with name and address. Received " + el);
                    }
                });
        return sequence;
    }

     static boolean isValid(final String chain) {

        final Map<String,String> indexedChain = indexByName(chain);

        final Set<String> visitedNames = new HashSet<>(indexedChain.size());

        String nameToVisit = ChainValidator.STARTING_NAME;
        for (int numElement = 0; numElement < indexedChain.size(); numElement++) {
            if (visitedNames.contains(nameToVisit)) {
                throw new IllegalArgumentException("Wrong chain. Name already visited " + nameToVisit);
            } else {
                visitedNames.add(nameToVisit);
            }
            nameToVisit = indexedChain.get(nameToVisit);
        }
        return ChainValidator.ENDING_NAME.equals(nameToVisit);
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            boolean isValidChain = false;
            try {
                isValidChain = ChainValidator.isValid(line);
            } catch (IllegalArgumentException iae) {
                System.err.print(iae.getMessage());
            }
            System.out.println(isValidChain? "GOOD" : "BAD");
        }
    }
}