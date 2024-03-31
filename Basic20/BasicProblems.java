package org.example.Basic20;

import com.mysql.cj.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicProblems {


    public static void main(String[] args){
//        reverseString("Reverse the strings");
//        swapWithToutThirdVariable();
//        isPrime();
//        System.out.println(fibonacci(10));
//        System.out.println(isPalindrome(""));

//        int[] input = new int[]{5,2,6,1,9,8,3};
//        int [] result = mergeSort(input,false);
//        System.out.println(Arrays.toString(result));

//        System.out.println(findFactorial(5));

//        System.out.println(removeDuplicates("Arunkumar"));

        System.out.println(isOdd(33));
    }



    /** 1. Reverse the string **/


    public static String reverseWord(String input ){
//        String input = "word";
        char[] arr = input.toCharArray();

        int start = 0;
        int end = arr.length-1;

        while (start<= end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

//        System.out.println("the Reversed String is : "+ new String(arr));

        return new String(arr);
    }

    public static void reverseString(){
        // i/p = Reverse the string   o/p = gnirts eht esreveR

        String input = "Reverse the string";
        String[] arr = input.split(" ");
        String result ="";

        for (int k = arr.length-1; k >=0 ; k--) {
            String cur = reverseWord(arr[k]);
            result = result+" "+cur;
        }
        System.out.println(result);
    }

    /** chatGpt version **/
    public static String reverseWord1(String word) {
        StringBuilder reversedWord = new StringBuilder(word);
        return reversedWord.reverse().toString();
    }

    public static void reverseString(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Can't reverse the null value");
        }

        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(reverseWord1(words[i]));
            if (i > 0) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }



    /** 2.Swap two numbers with and without third number**/

    public static void swapWithThirdVariable(){
        int a = 10;
        int b = 20;   // output => a=20 b=10

        int c = a;
        a = b;
        b = c;

        System.out.println("a="+a+" b="+b);
    }

    public static void swapWithToutThirdVariable(){
        int a = 14;
        int b = 34;   // output => a=20 b=10

        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println("a="+a+" b="+b);
    }

    /** 3. To Check if vowels present in a string or not **/

    public static void isVowelsPresent(){
        String input = "Arun Kumar";
        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('e');
        list1.add('i');
        list1.add('o');
        list1.add('u');

        List<Character> list2 = new ArrayList<>();
        list2.add('A');
        list2.add('E');
        list2.add('I');
        list2.add('O');
        list2.add('U');

        int count = 0;
        for (char c : input.toCharArray()){
            if (list1.contains(c) || list2.contains(c)){
                count++;
            }
        }
        if (count == 0){
            System.out.println("String dosen't have any vowel");
        }
        else {
            System.out.println("Given string have "+count+ " vowels");
        }
    }
    /** Using the Regular Expression(regex) **/
    public static void isVowelsPresent_2(){
        String input = "Arun Kumar";

        String regex = "[aeiouAEIOU]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){
            System.out.println("Yeah, string have vowel");
        }
        else {
            System.out.println("Odd, String doesn't have any vowel");
        }
    }

    /** 4.Given number is prime or not **/

    public static boolean isPrime(){
        int number = 7;

        for (int i = 2; i < number/2; i++) {
            if (number%i==0){
                System.out.println("Not Prime");
                return false;
            }
        }
        System.out.println("Prime");
        return true;
    }

    /** 5.Fibonacci sequence using recursion **/

    public static int fibonacci(int n){
        if (n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /** 6.Check the string is palindrome or not **/

    public static boolean isPalindrome(String input){

        if (input.length()==0){
            System.out.println("String is Empty");
            return false;
        }

        input = input.toLowerCase();
        int i = 0;
        int j=input.length()-1;

        while (i<=j){
            if (input.charAt(i)==input.charAt(j)){
                i++;
                j--;
            }
            else {
                System.out.println("Not Palindrome");
                return false;
            }
        }
        System.out.println("Palindrome");
        return true;
    }

    /** 7.Sort an array in ascending and descending order **/

    // ascending order

    public static int[] mergeSort(int[] input,boolean isAscending){
//        int[] input = new int[]{3,5,1,6,2,9,8};
        if (input.length == 1){
            return input;
        }
        int n = input.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(input,0,n),isAscending);
        int[] right = mergeSort(Arrays.copyOfRange(input,n,input.length),isAscending);

        if (isAscending){
            return ascendingOrder(left,right);
        }
        else {
            return descendingOrder(left,right);
        }
    }

    private static int[] ascendingOrder(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;

        while (i<left.length && j<right.length){
            if (left[i]<=right[j]){
                result[k] = left[i];
                i++;
                k++;
            }
            else {
                result[k] = right[j];
                k++;
                j++;
            }
        }
        while (i<left.length){
            result[k] = left[i];
            i++;
            k++;
        }
        while (j<right.length){
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    private static int[] descendingOrder(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;

        while (i<left.length && j<right.length){
            if (left[i]>=right[j]){
                result[k] = left[i];
                i++;
                k++;
            }
            else {
                result[k] = right[j];
                k++;
                j++;
            }
        }
        while (i<left.length){
            result[k] = left[i];
            i++;
            k++;
        }
        while (j<right.length){
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }


    /** 8.Find the factorial of the given number **/

    public static int findFactorial(int n ){
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of n : " + factorial);
        return factorial;
    }

    /** 9.Remove duplicates from the given string **/

    public static String removeDuplicates(String input){

        List<Character>characters = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()){
            if (!characters.contains(c)){
                result.append(c);
                characters.add(c);
            }
        }
        return result.toString();
    }

    /** CharGPt version **/
    public static String removeDuplicates_2(String input) {

        Set<Character> characters = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (characters.add(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    /** 10 .Check the given number number is odd or even **/

    public static boolean isOdd(int number ){
        int checkOdd = number&1;
        return checkOdd > 0;
    }
}
