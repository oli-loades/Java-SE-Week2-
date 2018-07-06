package code;

public class OfflineExercises {


    // Given a string, return a string where
    // for every char in the original,
    // there are two chars.

    // doubleChar("The") → "TThhee"
    // doubleChar("AAbb") → "AAAAbbbb"
    // doubleChar("Hi-There") → "HHii--TThheerree"

    public static String doubleChar(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i) + "" + input.charAt(i);
        }
        return result;
    }
    //
    // A sandwich is two pieces of bread with something in between. Return the
    // string that is between the first and last appearance of "bread" in the
    // given string, or return the empty string "" if there are not two pieces
    // of bread.

    // getSandwich("breadjambread") → "jam"
    // getSandwich("xxbreadjambreadyy") → "jam"
    // getSandwich("xxbreadyy") → ""
    // getSandwich("xxbreadhoneybreadyy") → "honey"


    public static String getSandwich(String input) {
        String result = "";
        int start = -1;
        int end = -1;
        for (int i = 0; i < input.length() - 4; i++) {
            if (input.substring(i, i + 5).equalsIgnoreCase("bread")) {
                if (start == -1) {
                    start = i + 5;
                } else {
                    end = i;
                }
            }
        }
        if (start != -1 && end != -1) {
            result = input.substring(start, end);
        }
        return result;
    }

    // Given three ints, a b c, one of them is small, one is medium and one is
    // large. Return true if the three values are evenly spaced, so the
    // difference between small and medium is the same as the difference between
    // medium and large.

    // evenlySpaced(2, 4, 6) → true
    // evenlySpaced(4, 6, 2) → true
    // evenlySpaced(4, 6, 3) → false

    public static boolean evenlySpaced(int a, int b, int c) {
        boolean evenlySpaced = false;
        int biggest, meduim, smallest, bmSpace, msSpace;

        biggest = biggest(a, b);
        biggest = biggest(biggest, c);

        smallest = smallest(a, b);
        smallest = smallest(smallest, c);

        if (biggest == a) {
            if (smallest == b) {
                meduim = c;
            } else {
                meduim = b;
            }
        } else {// c or b is biggest
            if (biggest == b) {
                if (smallest == a) {
                    meduim = c;
                } else {//b is smallest
                    meduim = a;
                }
            } else {//c is biggest
                if (smallest == a) {
                    meduim = b;
                } else {
                    meduim = a;
                }
            }
        }
        bmSpace = biggest - meduim;
        msSpace = meduim - smallest;

        return bmSpace == msSpace;
    }

    private static int biggest(int a, int b) {
        int biggest;
        if (a >= b) {
            biggest = a;
        } else {
            biggest = b;
        }
        return biggest;
    }

    private static int smallest(int a, int b) {
        int smallest;
        if (a >= b) {
            smallest = b;
        } else {
            smallest = a;
        }
        return smallest;
    }


    // Given a string and an int n, return a string made of the first and last n
    // chars from the string. The string length will be at least n.

    // nTwice("Hello", 2) → "Helo"
    // nTwice("Chocolate", 3) → "Choate"
    // nTwice("Chocolate", 1) → "Ce"

    public static String nTwice(String input, int a) {
        return input.substring(0, a) + input.substring(input.length() - a, input.length());
    }

    // Given a string, return true if it ends in "ly".

    // endsLy("oddly") → true
    // endsLy("y") → false
    // endsLy("oddy") → false
    // endsLy("l") → false

    public static boolean endsly(String input) {
        boolean endsLy = false;
        if (input.length() >= 2) {
            endsLy = input.substring(input.length() - 2, input.length()).equalsIgnoreCase("ly");
        }
        return endsLy;
    }

    // Given a string, return recursively a "cleaned" string where adjacent
    // chars that are the same have been reduced to a single char. So "yyzzza"
    // yields "yza".

    // stringClean("yyzzza") → "yza"
    // stringClean("abbbcdd") → "abcd"
    // stringClean("Hello") → "Helo"
    public static String stringClean(String input) {
        if (input.length() <= 1) {//base case
            return input;
        }
        if (input.substring(1,2).equals(input.substring(0,1))){//duplicate chars
            return  stringClean(input.substring(1));
        }else{
            return input.substring(0,1) + stringClean(input.substring(1));
        }
    }

    // The fibonacci sequence is a famous bit of mathematics, and it happens to
    // have a recursive definition. The first two values in the sequence are 0
    // and 1 (essentially 2 base cases). Each subsequent value is the sum of the
    // previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
    // 21 and so on. Define a recursive fibonacci(n) method that returns the nth
    // fibonacci number, with n=0 representing the start of the sequence.

    // fibonacci(0) → 0
    // fibonacci(1) → 1
    // fibonacci(2) → 1
    // fibonacci(3) → 2
    // fibonacci(4) → 3
    // fibonacci(5) → 5
    // fibonacci(6) → 8
    // fibonacci(25) → 75025

    public static int fibonacci(int input) {//0,1,1,2,3,5,8,13,21
        int total = 0;
        if (input == 1) {
            return 1;
        } else if (input == 0) {
            return 0;
        } else {
            return fibonacci(input - 1) + fibonacci(input - 2);
        }
    }

    // We have a number of bunnies and each bunny has two big floppy ears. We
    // want to compute the total number of ears across all the bunnies
    // recursively (without loops or multiplication).

    // bunnyEars(0) → 0
    // bunnyEars(1) → 2
    // bunnyEars(2) → 4
    // bunnyEars(4) → 8
    // bunnyEars(16) → 32

    public static int bunnyEars(int input) {//input*2???????????
        int total = 0;
        if (input == 0) {
            return 0;
        } else {
            return total += bunnyEars(input - 1) + 2;
        }

    }

    // Given a string, return the length of the largest "block" in the string.
    // A block is a run of adjacent chars that are the same.

    // superBlock("jeffbert") → 2
    // superBlock("abbCCCddBBBxx") → 3
    // superBlock("") → 0

    public static int superBlock(String str) {
        int longest = 1;
        int temp = 1;
        if (str.length() != 0) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    temp++;
                } else {
                    if (longest < temp) {
                        longest = temp;
                    }
                    temp = 1;
                }
            }
        } else {
            longest = 0;
        }
        return longest;

    }

}

