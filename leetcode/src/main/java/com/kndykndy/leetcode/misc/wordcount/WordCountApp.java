package com.kndykndy.leetcode.misc.wordcount;

import java.io.EOFException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordCountApp {

    private void runFrequenciesCounting(final CharacterReader characterReader) {
        if (characterReader == null) {
            return;
        }

        for (final String word : getWordsFrequencies(characterReader)) {
            System.out.println(word);
        }
        characterReader.close();
    }

    private Collection<String> getWordsFrequencies(final CharacterReader characterReader) {
        if (characterReader == null) {
            return Collections.emptyList();
        }

        char currentCharacter;

        StringBuilder sb = new StringBuilder();

        final Map<String, Integer> wordFrequenciesMap = new HashMap<>();
        final List<String> wordsList = new LinkedList<>();

        String currentWord;

        while (true) {
            try {
                currentCharacter = characterReader.nextCharacter();

                if (Character.isLetter(currentCharacter)) {
                    sb.append(Character.toLowerCase(currentCharacter));
                } else {

                    if ('\'' == currentCharacter) {
                        if (sb.length() == 0) { // it is a beginning of a quote, just skip
                            continue;
                        } else {
                            // it's an intermediate apostrophe, e.g. old English usurp'd or summer's, skip
                            // characters till next whitespace
                            while (!Character.isWhitespace(currentCharacter)) {
                                currentCharacter = characterReader.nextCharacter();
                            }

                            continue;
                        }
                    }

                    currentWord = sb.toString().trim();
                    if (!currentWord.isEmpty()) {
                        if (wordFrequenciesMap.merge(currentWord, 1, Integer::sum) == 1) {
                            wordsList.add(currentWord);
                        }

                        sb = new StringBuilder();
                    }
                }
            } catch (EOFException eofe) {
                break;
            } catch (InterruptedException ie) {
                assert false;
            }
        }

        wordsList.sort((o1, o2) -> {
            final Integer freqO1 = wordFrequenciesMap.get(o1);
            final Integer freqO2 = wordFrequenciesMap.get(o2);
            assert freqO1 != null && freqO2 != null;

            return freqO1.equals(freqO2) ? o1.compareTo(o2) : freqO2.compareTo(freqO1);
        });

        return wordsList;
    }

    public static void main(String[] args) {
        final WordCountApp wordCountApp = new WordCountApp();

        System.out.println("Case 1, fast reader with sample text:");
        wordCountApp.runFrequenciesCounting(
            new FastCharacterReaderImpl("The cat sat on the mat."));

        System.out.println("\nCase 2, fast reader with hardcoded text:");
        wordCountApp.runFrequenciesCounting(new FastCharacterReaderImpl());
    }

}
