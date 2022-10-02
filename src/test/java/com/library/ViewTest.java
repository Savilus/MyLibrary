package com.library;

import com.library.util.GetInput;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ViewTest {

    private final static String EXPECTED_RESULT = "Przykladowy tekst";
    public static final File USER_INPUT = new File("src/test/resources/viewInput.txt");

    @Test
    void shouldReturnInputProvidedByTheUser() throws FileNotFoundException {
        GetInput view = new GetInput(new Scanner(USER_INPUT));

        assertThat(view.getInput()).isEqualTo(EXPECTED_RESULT);
    }

}