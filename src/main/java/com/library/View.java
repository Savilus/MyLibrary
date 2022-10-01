package com.library;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class View {

    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        System.out.println("wprowadz dane");
        return scanner.nextLine();
    }

}
