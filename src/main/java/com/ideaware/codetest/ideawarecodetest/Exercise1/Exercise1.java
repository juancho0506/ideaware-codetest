package com.ideaware.codetest.ideawarecodetest.Exercise1;

import com.ideaware.codetest.ideawarecodetest.Exercise1.model.UserEntry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@Component
public class Exercise1 implements CommandLineRunner {

    private static final Integer LAST_NUMBER_ENTRIES = 5;
    private static final String EXIT_COMMAND = "exit";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************** Exercise 1 ******************************************");
        System.out.println("Program will request values to input with keyboard.");
        System.out.println("Only 5 recent entries will be shown. To exit just enter exit keyword.");
        System.out.println("----------------------------------------------------------------------");
        Stack<UserEntry> entries = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String entry = "";
        do {
            System.out.println("Please enter a value: ");
            entry = sc.next();
            if (!entry.trim().equalsIgnoreCase(EXIT_COMMAND)){
                entries.push(UserEntry.builder().value(entry).build());
            }
        }while (!entry.trim().equalsIgnoreCase(EXIT_COMMAND));
        System.out.println("Number of entries: " + entries.size());
        List<UserEntry> recentEntries = lastEntriesOutput(LAST_NUMBER_ENTRIES, entries);
        System.out.println("Recent Entries: ");
        recentEntries.forEach( e -> {
            System.out.println(e);
        });
    }

    public List<UserEntry> lastEntriesOutput(int numEntries, Stack<UserEntry> entries) {
        if (entries != null && entries.isEmpty()) {
            return entries;
        }
        List<UserEntry> output = new ArrayList<>();
        int cont = 0;
        if (numEntries > entries.size()){
            numEntries = entries.size();
        }
        while(cont<numEntries){
            output.add(entries.pop());
            cont++;
        }
        return output;
    }
}
