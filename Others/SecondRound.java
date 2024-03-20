package org.example.Others;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondRound {
    public static void main(String[] args) {
        String str = "aseahesa";
        int modeCount = findModeCount1(str);
        System.out.println(modeCount);
    }
    public static void anagram_1(){
        System.out.println("Hello world!");

        String input = "abc defGhi JklmnOP QRStuv";

        char[] chars = input.toCharArray();

        Set<String> aToZ = new HashSet<>();

        long count=0;

        for (int i=0 ; i<input.length() ;i++){
            String s = String.valueOf(chars[i]);
            Character.isAlphabetic(chars[i]);

            if ( !aToZ.contains(s) && !s.equals(" ")){
                aToZ.add(s);
                count ++;
            }
        }
        System.out.println(count == 26);
        System.out.println(count);
        System.out.println(aToZ);
    }
    public static void password(){

        String password = "Qwerty@123";
        int ruleSatisFied = 0 ;
        boolean rule_1 = lengthOfThePassWord(password);
        if (isPresentBothUpperAndLowerCase(password)){
            ruleSatisFied ++;
        }
        if (isDigitPresent(password)){
            ruleSatisFied ++;
        }
        if (isSpecialCharPresent(password)){
            ruleSatisFied ++;
        }
        System.out.println("ruleSatisFied "+ ruleSatisFied);

        if (rule_1 && (ruleSatisFied >= 1)){
            if (ruleSatisFied == 1 ){
                System.out.println("Medium");
            }
            else if(ruleSatisFied == 2){
                System.out.println("Good");
            }
            else {
                System.out.println("Strong");
            }
        }
        else {
            System.out.println("Weak");
        }

    }

    public static boolean lengthOfThePassWord(String password){
        return password.length()>=8;
    }
    public static boolean isPresentBothUpperAndLowerCase(String password ){
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }
    public static boolean isDigitPresent(String password){
        return  password.matches(".*\\d.*");
    }
    public static boolean isSpecialCharPresent(String password){
        return password.matches(".*[^A-Za-z0-9 ].*");
    }


 /************* 3.Find Occurrences    *********/
    public static void findOccurrences(){

    }
    /***** 4.Matrix Diagonal sum ***/

    public static void  matrixDiagonalSum(){
        int row = 3;
        int column = 3;

        int[][] matrix = new int[row][column];

        // Initialize matrix values
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        int sumOfRightDiagonal = 0;
        int sumOfLeftDiagonal = 0;

        for (int i=0 ;i< row ; i++){
            for (int j=0 ;j< column ;j++){
                if(i+j < row-1){
                    sumOfLeftDiagonal = sumOfLeftDiagonal + matrix[i][j];

                }
                else if(i+j > row-1){
                    sumOfRightDiagonal = sumOfRightDiagonal + matrix[i][j];
                }
                else {
                    sumOfLeftDiagonal = sumOfLeftDiagonal + matrix[i][j];
                    sumOfRightDiagonal = sumOfRightDiagonal + matrix[i][j];
                }
            }
        }
        int largest = sumOfLeftDiagonal>sumOfRightDiagonal ? sumOfLeftDiagonal : sumOfRightDiagonal;
        System.out.println(largest);

    }
    /******** 5.Matrix Addition *****/
    public static void matrixAddition(){
        int [][] matrix = {
                {3, 5, 4, 2},
                {2, 4, 5},
                {4, 5, 6, 7, 8},
                {4, 9, 2, 1},
                {1, 2}
        };

        int result = 0;
        int flag = 0 ;
        int currentSum = 0;
        for (int [] array : matrix){
            int index = array.length;
            int val = array[index];

        }

    }

    public static void ArraySum(){
        int[][] inputArrays = {
                {3, 5, 4, 2},
                {2, 4, 5},
                {4, 5, 6, 7, 8},
                {4, 9, 2, 1},
                {1, 2}
        };

        long sum = 0;

        for (int[] array : inputArrays) {
            StringBuilder numberString = new StringBuilder();

            // Convert each element of the inner array to a string
            for (int num : array) {
                numberString.append(num);
            }
            System.out.println("s : "+numberString.getClass().getName() );
            System.out.println("s : "+Long.parseLong(numberString.toString()));
            // Parse the concatenated string as an integer and add to the sum
            sum += Long.parseLong(numberString.toString());
        }

        System.out.println("Sum: " + sum);
    }

    public int findPeak(){

        // input only here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Array length : ");
        int size = scanner.nextInt();
        int[] input = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i=0 ;i< size ; i++){
            input[i] = scanner.nextInt();
        }
        scanner.close();

        // logic here
        if(input[0]>input[1]){
            return input[0];
        }
        if (input[input.length-1] > input[input.length-2]){
            return input[input.length-1];
        }
        int n = input.length;
        for (int i=1;i<n;i++){
            if(input[i]> input[i-1] && input[i]>input[i+1]){
                return input[i];
            }
        }
        return -1;
    }
    public void getMinAndMax(){
        // input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of the input Array :");
        int  size = scanner.nextInt();
        int [] arr = new int[size];
        for (int i = 0 ; i<size;i++){
            arr[i] = scanner.nextInt();
        }

        // logic for get Min
        int min = arr[0];
        int max = arr[0];
        for (int i=1;i<size;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        System.out.println("The minimum element of the Array is : " + min);
        System.out.println("The Maximum element of the Array is : " + max);
    }

    public int[] reverseArray (){
        // input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of the input Array :");
        int  size = scanner.nextInt();
        int [] arr = new int[size];
        for (int i = 0 ; i<size;i++){
            arr[i] = scanner.nextInt();
        }

        // logic
        for (int i = 0 ; i<size/2 ; i++){
            int temp = arr[i];
            arr[i] = arr[size-1-i];
            arr[size-1-i]=temp;
        }

        System.out.println("The Reversed Array is : " + arr);
        return arr;
    }

//    public int[] sortArray (){
//        // input
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Length of the input Array :");
//        int  size = scanner.nextInt();
//        int [] arr = new int[size];
//        for (int i = 0 ; i<size;i++){
//            arr[i] = scanner.nextInt();
//        }
//
//        return mergeSort(arr);
//    }
//    int[]mergeSort(int[] arr){
//        if(arr.length == 1){
//            return arr;
//        }
//        int mid = arr.length/2;
//        int[]left = mergeSort(Arrays.copyOfRange(arr,0,mid));
//        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
//        return merge(left,right);
//    }
//    private static int[] merge(int[] first , int[] second){
//        int [] mix = new int[first.length+second.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i<first.length && j< second.length){
//            if (first[i]<=second[j]){
//                mix[k] = first[i];
//                i++;
//            } else{
//                mix[k] = second[j];
//                j++;
//            }
//            k++;
//        }
//        while (i<first.length){
//            mix[k] = first[i];
//            i++;
//            k++;
//        }
//        while (j<second.length){
//            mix[k] = second[j];
//            j++;
//            k++;
//        }
//        return mix;
//    }


//    public  void kthLargestAndSmallestNumber(){
//        int[]sortedArray = sortArray();
//        System.out.println("The sorted Array is : "+Arrays.toString(sortedArray));
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        System.out.println("Smallest Number is :" + sortedArray[k-1]);
//    }
    public static int kthSmallest(int[] arr, int k) {
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements of the array to the min heap
        for (int num : arr) {
            minHeap.offer(num);
        }

        // Perform K-1 extract-min operations
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        // Return the K'th smallest element
        return minHeap.peek();
    }
    public static int binarySearch(int[] arr , int target){
        int start = 0;
        int end = arr.length;

        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid]>target){
                end = mid-1;
            } else if (arr[mid]<target) {
                start = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static int findPeakBinaryMethod(int [] arr){

        int start = 0;
        int end = arr.length;
        while(start <= end){
            int mid = start + (end - start) /2;

            if (mid == 0 || arr[mid]<arr[mid-1] && (arr[mid] > arr[mid+1] || mid == arr.length-1)){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int numberOfOccurances(int[] arr , int num){
        int count = 0;

        for (int i : arr){
            if (i == num){
                count++;
            }
        }
        return count;
    }
    public static int numberOfOccurrancesBinarySearch(int[] arr , int num ,boolean firstIndex){

        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while (start<=end){
            int mid = start+(end -start)/2;

            if (arr[mid]>num){
                end = mid-1;
            }
            else if(arr[mid]<num){
                start = mid+1;
            }
            else{
                ans = mid;
                if (firstIndex){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }


    ///********************************** string problems *********************************\

    /** String reversal

     **/

    public void reverseString(String string){
        String[] splict = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=splict.length-1;i>=0;i--){
            stringBuilder.append(splict[i]);
            if (i!=0){
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);
    }

    public void reverse(String string){
        char[] chars = string.toCharArray();
        reverseWord(chars,0,chars.length-1);
        int start = 0;
        int length = chars.length;
        for (int end = 0 ; end< length; end++){
            if (chars[end] ==' '){
                reverseWord(chars,start,end-1);

                // we need to move start after space
                start = end+1;
            }
        }
        reverseWord(chars,start,length-1);
        System.out.println(new String(chars));
    }
    public void reverseWord(char[] chars,int start,int end){
        while (start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        System.out.println(chars);

    }

    /**
     Longest Common Prefix using Sorting
     */


    public static void longestCommonPrefix(String[] words){
        StringBuilder ans = new StringBuilder();
        Arrays.sort(words);

        char[] minLengthString = words[0].toCharArray();
        char[] maxLengthString = words[words.length-1].toCharArray();

        for (int i= 0 ; i<minLengthString.length ; i++){
            if (minLengthString[i]!= maxLengthString[i]){
                break;
            }
            ans.append(minLengthString[i]);
        }
        System.out.println("Longest Common Prefix is : "+ ans.length());
    }

    /**
     Roman Number to Integer
     */

    public static void romanToInteger(String roman){
        Map<Character,Integer>romanValues = new HashMap<>();
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);

        int result = 0;
        int prevValue = 0;
        for (int i=roman.length()-1;i>=0;i--){
            int currentValue = romanValues.get(roman.charAt(i));
            if (currentValue<prevValue){
                result = result-currentValue;
            }
            else {
                result = result+currentValue;
            }
            prevValue = currentValue;
        }
        System.out.println("The Value is : "+ result);
    }

    public static void distanceBetweenTwoWords(String[] s , String word1 , String word2){
        int minPath = 0;

        for (int i=0;i<s.length;i++){
            for (int j=1;j<s.length;j++){
                if (s[i].equalsIgnoreCase(word1) && s[j].equalsIgnoreCase(word2)){

                        if (minPath == 0){
                            minPath = j-i;
                        }
                        else {
                            minPath = minPath > (j-i) ?(j-i):minPath;
                        }

                }
            }
        }
        System.out.println(minPath);
    }
    void test(){

    }

    public  void messageParsing(String[][] input , int length){
        Map<Integer,String> map = new HashMap<>();
        int[] list = new int[length];

        for (int i=0 ; i < length ; i++){
            int index = Integer.parseInt(input[i][0]);
            String character = input[i][1];
            map.put(index, character);
            if (!character.isEmpty()) {
                list[i] = index;
            }
        }
        Arrays.sort(list);

        List<StringBuilder> output = new ArrayList<>();
        
        StringBuilder string = new StringBuilder();


        for (int i = 1 ; i< length ; i++){
            if (list[i] + list[i+1]-1 != 1 ){
                boolean isTrue = isValidString(string);
                if (isTrue){
                    output.add(string);
                    string = new StringBuilder();
                }
            } else {
                string.append(map.get(list[i]));
            }
        }
        for (StringBuilder o : output){
            System.out.println(o);
        }

        
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[]left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] first , int[] second){
        int [] mix = new int[first.length+second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<first.length && j< second.length){
            if (first[i]<=second[j]){
                mix[k] = first[i];
                i++;
            } else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    public  boolean isValidString(StringBuilder str) {
        // Regular expression to match valid strings
        String regex = "(\\*.*\\*)|[^_*]*";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the string against the pattern
        Matcher matcher = pattern.matcher(str);

        // Check if the string matches the pattern
        return matcher.matches();
    }

    public void printingLetter(String input){
        StringBuilder result = new StringBuilder();

        char inputChar  = ' ';
        int howManyTimes = 0;

        for (int i=0 ; i<input.length();i++){
            char currentChar = input.charAt(i);
            if (Character.isLetter(input.charAt(i))){
                inputChar = input.charAt(i);
            } else if (Character.isDigit(input.charAt(i))) {
                howManyTimes = howManyTimes * 10 + (currentChar - '0');
                if (i+1 < input.length() && Character.isDigit(input.charAt(i+1))){
                    continue;
                }
            }
            if (inputChar != ' ' && howManyTimes!=0 ){
                for (int j = 0 ; j<howManyTimes;j++){
                    result.append(inputChar);
                }
                inputChar = ' ';
                howManyTimes = 0;
            }
        }
        System.out.println("result : " + result);
    }

    public static void patterPrinting_1(String input){
        int length = input.length();
        int maxLength = input.length() * 2 - 1;

        char[] chars = input.toCharArray();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Character.getNumericValue(chars[i]);
        }

        for (int i=0 ; i<length ; i++){
            for (int j=0 ; j<maxLength ; j++){
                if (j==i){
                    System.out.print(numbers[i]);
                } else if ( j == maxLength-i-1) {
                    System.out.print(numbers[length-i-1]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    // patter printing practice kunaal video

    // How to approach
    // (1) NO of lines = no of rows = no of times outer loop will run

    // (2) Identify for every row NO:
        // how many columns are there
        // types of column is there

    // (3) what do you need to print

    static void pattern1(int n ){
        for (int row = 1; row <= n; row++) {
            // for every row run col

            for (int col = 1; col <= row ; col++) {
                System.out.print("* ");
            }
            // when one row is printed we need new line
            System.out.println();
        }
    }
    static void pattern2(int n ){
        for (int row = 1; row <= n; row++) {
            // for every row run col

            for (int col = 0; col <= n-row ; col++) {
                System.out.print("* ");
            }
            // when one row is printed we need new line
            System.out.println();
        }
    }

    static void pattern3(int n ){
        for (int row = 1; row <= n; row++) {
            // for every row run col

            for (int col = n; col >= n ; col--) {
                System.out.print("* ");
            }
            // when one row is printed we need new line
            System.out.println();
        }
    }

    static void pattern4(int n ){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        for (int row = 1; row < 2*n; row++) {
            int totalColsInRow = row > n ? 2*n - row : row;

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){


        for (int row = 1; row < 2*n; row++) {

            int totalColsInRow = row > n ? 2*n - row : row;

            int noOfSpaces = n-totalColsInRow;
            for (int space = 0; space < noOfSpaces; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static boolean palindrome_rec(String s , int i , int j){

        if(i>j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return palindrome_rec(s,i+1,j-1);
        }
        return false;
    }

    public static void zohoQues(int[] arr){
        int[] res = new int[arr.length];
        int prev = arr[0];
        int index=0;
        for (int i = 1; i <arr.length ; i++) {
            int cur = arr[i];
            if(cur == 0)continue;

            if (prev == cur){
                res[index++] = prev+cur;
                prev = -1;
            }
            else if(prev == -1){
                prev = cur;
            }
            else{
                res[index++] = prev;
                res[index++] = cur;
            }
        }
        if (prev != -1){
            res[index++] = arr[arr.length-1];
        }
        for (int i = index; i <arr.length ; i++) {
            res[index] = 0;
        }
        System.out.println(Arrays.toString(res));
    }

    public static int findModeCount(String str) {
        // Map to store the frequency of each character

        Map<Character,Integer>frequencyMap = new HashMap<>();

        // Calculate the frequency of each character
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the character with the maximum frequency
        char modeChar = '\0'; // Initialize with null character
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                modeChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return maxFrequency;
    }

    public static int findModeCount1(String str) {
        int[] frequency = new int[26]; // Array to store frequency of each character ('a' to 'z')

        // Count the frequency of each character
        for (char ch : str.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int freq : frequency) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        return maxFrequency;
    }

}















