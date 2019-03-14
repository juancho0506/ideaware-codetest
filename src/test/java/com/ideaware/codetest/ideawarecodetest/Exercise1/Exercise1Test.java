package com.ideaware.codetest.ideawarecodetest.Exercise1;

import com.ideaware.codetest.ideawarecodetest.Exercise1.model.UserEntry;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise1Test {

    private Exercise1 exercise1;

    @Before
    public void setup() {
        exercise1 = new Exercise1();
    }

    @Test
    public void testEmptyEntriesOutput() {
        //Given
        Stack<UserEntry> entries = new Stack<>();
        int numentries = 5;
        //Execute
        List<UserEntry> output = exercise1.lastEntriesOutput(numentries, entries);

        //Assert
        assertThat(output).isNotNull();
        assertThat(output).isEmpty();
    }

    @Test
    public void testValidEntriesOutput() {
        //Given
        Stack<UserEntry> entries = new Stack<>();
        entries.push(UserEntry.builder().value("One").build());
        entries.push(UserEntry.builder().value("Two").build());
        entries.push(UserEntry.builder().value("Cars").build());
        entries.push(UserEntry.builder().value("Whatever...").build());
        entries.push(UserEntry.builder().value("More Whatever...").build());
        entries.push(UserEntry.builder().value("Another One").build());
        int numEntries = 5;
        //Execute
        List<UserEntry> output = exercise1.lastEntriesOutput(numEntries, entries);

        //Assert
        assertThat(output).isNotNull().isNotEmpty();
        assertThat(output).hasSize(5)
                .contains(UserEntry.builder().value("Another One").build(),
                        UserEntry.builder().value("More Whatever...").build(),
                        UserEntry.builder().value("Whatever...").build())
                .doesNotContain(UserEntry.builder().value("One").build());
    }

    @Test
    public void testLessThanFiveEntriesOutput() {
        //Given
        Stack<UserEntry> entries = new Stack<>();
        entries.push(UserEntry.builder().value("One").build());
        entries.push(UserEntry.builder().value("Two").build());
        entries.push(UserEntry.builder().value("Cars").build());
        int numEntries = 5;
        //Execute
        List<UserEntry> output = exercise1.lastEntriesOutput(numEntries, entries);

        //Assert
        assertThat(output).isNotNull().isNotEmpty();
        assertThat(output).hasSize(3)
                .contains(UserEntry.builder().value("Cars").build(),
                        UserEntry.builder().value("Two").build(),
                        UserEntry.builder().value("One").build());
    }
}