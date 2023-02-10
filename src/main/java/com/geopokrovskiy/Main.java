package com.geopokrovskiy;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //12*5+67*8-12 Reverse polish notation
        HashMap<Character, Operation> hashMap = new HashMap<>();
        hashMap.put('+', new Sum());
        hashMap.put('-', new Subtraction());
        hashMap.put('*', new Multiplication());
        hashMap.put('/', new Division());

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Polska polska = new Polska(line);
        System.out.println(polska.convertToPolska(hashMap)); //conversion to postfix notation
        System.out.println(polska.calculate(hashMap)); // result
    }
}
