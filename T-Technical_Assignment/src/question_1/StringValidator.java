package question_1;

import java.util.*;

public class StringValidator {

    //!.The String should have non-repetitive identical characters
    // Should only contain the characters among given list of valid characters

    // Why Character Class?
    // The Character class wraps a value of the primitive type char in an object. An object of class Character contains a single field whose type is char
    public  static boolean isValidString(String str, List<Character> validChars) {
        if(str== null || str.isEmpty()){
            return false; // Null or empty Strings are not considered Valid
        }
        // 1. Ensure all characters are from the valid set
        for (int i = 0; i < str.length(); i++) {
            if (!validChars.contains(str.charAt(i))) {
                return false;
            }
        }

        // 2. Check for no immediate repetition
        // This loop traverses the array to check that the element at i is similar to element at i-1(previous)
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }

        // This is for unique characters only, does not allow for repetition even once!

//        //!. Check id all characters are from the valid set
//        // Using a Hashset _ Research more about this but this is good if we want uniqueness
//        Set<Character> validCharSet = new HashSet<Character>(validChars);
//
//        // For every character c in the array, if it does not have c then return false
//        for(char c : str.toCharArray()){
//            if(!validCharSet.contains(c)){
//                return false;
//            }
//        }
//
//        //2. Check for no repetitive characters
//        Set<Character> seenCharacters = new HashSet<>();
//        for(char c : str.toCharArray()){
//            if(seenCharacters.contains(c)){
//                return false;
//            }
//            seenCharacters.add(c);
//        }
        // If it passes all the above checks it will return tru
        return true;
    }

    // Finding the longest valid String
    // The inputs are the array of strings & the list of valid characters
    public static String getLongestString(List<String> strings, List<Character> validChars) {
        String longestValidString =null;

        //??
        int maxLength = -1;
        for(String s : strings){
            if(isValidString(s, validChars)){
                if(s.length() > maxLength){
                    maxLength = s.length();
                    longestValidString = s;
                }
            }
        }
        return longestValidString;
    }

    public static void main(String[] args) {
        // Allowed Characters
        List<Character> allowedChars = new ArrayList<>();
        Collections.addAll(allowedChars, 'a','b','c','e','f','@');
        List<String> Teststrings = new ArrayList<String>();
        Teststrings.add("aabc");
        Teststrings.add("efa@bcbc");
        Teststrings.add("ghhhi");
        Teststrings.add("jkksl");
        Teststrings.add("abce@fabc");

        String longestValidString = getLongestString(Teststrings, allowedChars);
        System.out.println(longestValidString);

    }
}
