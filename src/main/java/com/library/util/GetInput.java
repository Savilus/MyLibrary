package com.library.util;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class GetInput {

    private final Scanner scanner;

    public GetInput() {
        scanner = new Scanner(System.in);
    }
    

    public String getInput() {
        return scanner.nextLine();
    }
}
