package com.ideaware.codetest.ideawarecodetest.Exercise2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Stream;

@Component
public class Exercise2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************** Exercise 2 ******************************************");
        System.out.println("Program will find index \'a\' in each element of fiven array.");
        System.out.println("----------------------------------------------------------------------");
        final String[] elements = {"United States", "England", "Germany", "Netherlands", "Slovenia"};

        findFirstLetterAIndexAndPrint(elements);
    }

    public void findFirstLetterAIndexAndPrint(String[] elements) {
        if (elements.length > 0) {
            ExecutorService executorService = Executors.newFixedThreadPool(elements.length);
            System.out.println("Finding index for all the words in array.....");
            Stream<String> stream1 = Arrays.stream(elements);
            stream1.forEach(element -> executeScanFirstIndexforCharInElements(executorService, element));
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        } else {
            System.out.println("No elements found to scan for index.");
        }
    }

    private void executeScanFirstIndexforCharInElements(ExecutorService executorService, String element) {
        Callable<Integer> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("Finding index for: " + element);
            return element.indexOf('a');
        };

        Future<Integer> future = executorService.submit(callableTask);
        Integer index = null;
        try {
            index = future.get();
            if (index >= 0) {
                System.out.println("Character \'a\' is on index: " + index + ", for word: " + element);
            } else {
                System.out.println("No Character \'a\' found on word: " + element);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

