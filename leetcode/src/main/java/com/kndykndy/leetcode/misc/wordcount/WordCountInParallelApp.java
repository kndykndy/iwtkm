package com.kndykndy.leetcode.misc.wordcount;

import java.io.EOFException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class WordCountInParallelApp {

    private static final int READER_THREADS_COUNT = 10;
    private static final int REPORT_TIMER_PERIOD_MILLIS = 10 * 1000;

    private CountDownLatch readerThreadsLatch;
    private Map<String, Integer> wordFrequenciesMap;
    private List<String> wordsList;

    private void getWordsFrequenciesInParallel(final CharacterReader characterReader) {
        if (characterReader == null) {
            readerThreadsLatch.countDown();

            return;
        }

        char currentCharacter;

        StringBuilder sb = new StringBuilder();

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
                ie.printStackTrace();
            }
        }

        readerThreadsLatch.countDown();
    }

    public static void main(String[] args) {
        final Map<String, Integer> wordFrequenciesMap = new ConcurrentHashMap<>();
        final List<String> wordsList = new CopyOnWriteArrayList<>();

        final CountDownLatch readerThreadsLatch = new CountDownLatch(READER_THREADS_COUNT);

        final Timer progressReportingTimer = new Timer(true);
        progressReportingTimer.schedule(new TimerTask() {

            int iteration = 1;

            @Override
            public void run() {
                System.out.println("Intermediate results (iteration " + iteration++ + "):");
                dumpIterationProgress(wordFrequenciesMap, wordsList);
            }

        }, REPORT_TIMER_PERIOD_MILLIS, REPORT_TIMER_PERIOD_MILLIS);

        IntStream
            .range(0, READER_THREADS_COUNT)
            .forEach(
                a -> new Thread(() -> {
                    final WordCountInParallelApp wordCountInParallelApp = new WordCountInParallelApp();
                    wordCountInParallelApp.readerThreadsLatch = readerThreadsLatch;
                    wordCountInParallelApp.wordFrequenciesMap = wordFrequenciesMap;
                    wordCountInParallelApp.wordsList = wordsList;

                    wordCountInParallelApp
                        .getWordsFrequenciesInParallel(new SlowCharacterReaderImpl());
                }).start()
            );

        try {
            readerThreadsLatch.await();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("Final results:");
        dumpIterationProgress(wordFrequenciesMap, wordsList);
    }

    private static void dumpIterationProgress(
        final Map<String, Integer> wordFrequenciesMap,
        final List<String> wordsList) {

        wordsList.sort((o1, o2) -> {
            final Integer freqO1 = wordFrequenciesMap.get(o1);
            final Integer freqO2 = wordFrequenciesMap.get(o2);
            assert freqO1 != null && freqO2 != null;

            return freqO1.equals(freqO2) ? o1.compareTo(o2) : freqO2.compareTo(freqO1);
        });

        wordsList.forEach(word -> System.out.println(word + " - " + wordFrequenciesMap.get(word)));
        System.out.println();
    }

}
