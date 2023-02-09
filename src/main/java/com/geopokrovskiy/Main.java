package com.geopokrovskiy;

import java.util.*;

public class Main {
    public static void main(String[] args) {



        //Exercise 1. Count different words in a string
        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replaceAll("[.,?!:-]", "");
        String[] words = str.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String word : words){
            word = word.toLowerCase();
            int counter = hashMap.getOrDefault(word, 0);
            counter++;
            hashMap.put(word, counter);
        }
        System.out.println(hashMap);*/





        //Exercise 2. 123fghj2fghj78gfhg7
        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        ArrayList<Integer> numbers = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                builder.append(str.charAt(i));
            }
            else if(!builder.isEmpty()){
                int number = Integer.parseInt(builder.toString());
                numbers.add(number);
                builder = new StringBuilder();
            }
        }
        if(!builder.isEmpty()) {
            int number = Integer.parseInt(builder.toString());
            numbers.add(number);
        }
        System.out.println(numbers);*/



        //Exercise 3. 12+45-56+87 (+ and - only)
        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] numbers = str.split("[+-]");
        ArrayList<Character> arithmeticActions = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                arithmeticActions.add(str.charAt(i));
            }
        }

        int result = Integer.parseInt(numbers[0]);
        for(int i = 0; i < numbers.length - 1; i++){
            if(arithmeticActions.get(i).equals('+')){
                result += Integer.parseInt(numbers[i + 1]);
            }
            else if(arithmeticActions.get(i).equals('-')){
                result -= Integer.parseInt(numbers[i + 1]);
            }
        }
        System.out.println(result);*/



        //Exercise 4. 12*5+67*8-12 Reverse polish notation
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