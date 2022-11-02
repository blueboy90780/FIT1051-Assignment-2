import java.util.Scanner;

/* Bibliography
Anon. n.d.-a. “Bitwise Operators in Java - GeeksforGeeks.” Retrieved August 21, 2022 (https://www.geeksforgeeks.org/bitwise-operators-in-java/).
Anon. n.d.-b. “Degrees to Radians (Conversion Steps with Solved Examples).” BYJUS. Retrieved August 21, 2022 (https://byjus.com/maths/degrees-to-radians/).
Anon. n.d.-c. “Java - Simple Way to Repeat a String - Stack Overflow.” Retrieved August 21, 2022 (https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string).
Anon. n.d.-d. “Java If ... Else.” Retrieved August 21, 2022 (https://www.w3schools.com/java/java_conditions.asp).
Anon. n.d.-e. “Java Math Abs() Round() Ceil() Floor() Min() Methods/Function with Example.” Retrieved August 21, 2022 (https://www.guru99.com/math-java.html#3).
Anon. n.d.-f. “Java Naming Conventions - Javatpoint.” Retrieved August 21, 2022 (https://www.javatpoint.com/java-naming-conventions).
Anon. n.d.-g. “Java String Format() Method - Javatpoint.” Retrieved August 21, 2022 (https://www.javatpoint.com/java-string-format).
mkyong. 2020. “Java - Convert Integer to Binary.” Mkyong.Com. Retrieved August 21, 2022 (https://mkyong.com/java/java-convert-an-integer-to-a-binary-string/).
 */

/*
 * Assessment 2
 *
 * Copyright (c) 2022  Monash University
 *
 * Written by  Jonny Low
 *
 *
 */
public class Assessment2 {
    public static void main(String[] args){

        Assessment2 a2 = new Assessment2();

        // Task 2.1
        // No loops

        //Test Case between 40 - 50
        int n = 42;
        boolean result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        n = 41;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        n = 50;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        //Test case on extreme ends
        n = 1;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        n = 100;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        //Test case outside 40-50
        n = 38;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

        n = 70;
        result = a2.task1(n);
        System.out.println("For the number " + n + " the value is " + result + ".");

//        a2.task2();
//        a2.task3();
//        a2.task4();

//        test your task 5 here
//        double volume = a2.volumeOfACylinder(3,7);
//        System.out.println(volume + "cm^3");

    }

    private boolean task1(int n){
        /* Checks made
        1) N is between 1 and 100 inclusive: (n>=1 && n<=100)
        2) N is between 40 - 50 inclusive AND is an even number (n>=40 && n<=50) && (n%2==0)
           (n>=40 && n<=50) Checks that N is between 40 - 50
           (n%2==0) Checks that N is an even number
           If both conditions are true, then the expression gets negated (!)
        3) If either expression (1) or expression (2) is false, then returns false otherwise true is returned
        4) The result (either true or false) gets stored in the boolean variable (result)
        */
        boolean result = (n>=1 && n<=100) && !((n>=40 && n<=50) && (n%2==0));
        return result;
    }

    private void task2(){

        //Variable declaration
        boolean state1 = true;
        boolean state2 = false;
        boolean buffer;

        System.out.println("Before: Variable State1: " + state1 + " Variable State2: " + state2);

        //Switching values
        buffer = state1; //state1 will later be replaced by the value of state 2.  \
        // Therefore, state1 value needs to be stored in a buffer variable
        state1 = state2;
        state2 = buffer;

        System.out.println("After: Variable State1: " + state1 + " Variable State2: " + state2);
    }

    private void task3(){
        //Initializing Variables
        //All variables gets initialized as a double because Math.tan() and Math.PI returns a double
        double a = 53.13 * Math.PI/180; //Converts degree to radians
        double b = 41.00 * Math.PI/180;

        /*
        Calculating the width and length
        Height and angle of both triangles are given, but not hypotenuse. So I used tan() to work out the adjacent
        sides of both triangle.

         Tan(x) = Opposite/Adjacent
         Adjacent = Opposite/Tan(x)
        */
        double width = 20/Math.tan(a);
        double length = 20/Math.tan(b);

        //Area of the gap = number of slabs needed to fill the gap because 1 slap = 1x1 (1 unit)
        //Math.ceil() rounds the argument (area of gap) to the next whole number
        int answer = (int) Math.ceil(width*length*20); //An integer is used to store the volume because it eliminates the ".0" at the end, making it ideal to display in the string below
        System.out.println("The engineer would need to place " + answer + " stone slabs");
    }

    private void task4(){
        // Variable declaration
        int x,y;

        // User input
        System.out.println("Input X and Y values: ");
        Scanner user_input = new Scanner(System.in);

        //Parses the next token in user_input as an integer then assigns it in variable x and y
        x = user_input.nextInt();
        y = user_input.nextInt();

        //Initializes variables of binaryX and binaryY
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);

        //Finds the length difference between the largest and smallest strings of binaryX and binaryY
        int shortestBinary = Math.min(binaryX.length(), binaryY.length());
        int largestBinary = Math.max(binaryX.length(), binaryY.length());
        int difference = largestBinary - shortestBinary;

        //Offsets the shortest string to match the length of the largest string to be displayed in console output
        if (shortestBinary == binaryX.length()){
            binaryX = " ".repeat(difference) + binaryX;
        } else {
            binaryY = " ".repeat(difference) + binaryY;
        }

        // Performs bitwise AND and exclusive OR on both variables
        int resultAnd = (x & y);
        int resultOr = (x ^ y);

        //Converts the integers of both to its binary equivalent
        String binaryTemp1 = Integer.toBinaryString(resultAnd);
        String binaryTemp2 = Integer.toBinaryString(resultOr);

        //Offsets the binary string to align with the largest binary of either X or Y, then appends the binary string of binaryTemp1 or binaryTemp2
        String binaryResultAnd = " ".repeat(largestBinary-binaryTemp1.length()) + binaryTemp1;
        String binaryResultOr = " ".repeat(largestBinary-binaryTemp2.length()) + binaryTemp2;

        //Displays working out with all the binaries aligned
        //Bitwise AND Operation
        System.out.println("Bitwise AND operation " + (x&y));
        String workingOutAnd = String.format("""
                   %s
                &  %s
                   %s
                   %s
                   
                   
                   1) The program asks for 2 user inputs, x and y
                   2) Program then stores user input in 2 separate integer variable
                   3) When the program reaches (A & B), it then performs a bitwise AND operation
                   4) The program takes the binary representation of the decimal number.
                   5) It then takes each bit in x and compares it to it's corresponding bit in y (1st bit in x, 1st bit in y);
                   6) If both bits are true (1) then the & yields a 1, otherwise it yields a 0
                   7) It compares for every bit then takes the resulting binary and returns the decimal representation of that binary
                   
                """,binaryX, binaryY,"-".repeat(largestBinary), binaryResultAnd);
        System.out.println(workingOutAnd);

        /* Explanation of Bitwise AND
        1) The program asks for 2 user inputs, x and y
        2) Program then stores user input in 2 separate integer variable
        3) When the program reaches (A & B), it then performs a bitwise AND operation
        4) The program converts the decimal argument to its binary equivalent
        5) It then takes each bit in x and compares it to its corresponding bit in y (1st bit in x, 1st bit in y);
        6) If both bits are true (1) then the & yields a 1, otherwise it yields a 0
        7)
         */

        //Bitwise Exclusive OR
        System.out.println("Bitwise exclusive OR operation " + (x^y));
        String workingOutOr = String.format("""
                   %s
                &  %s
                   %s
                   %s
                   
                   1) The program asks for 2 user inputs, x and y
                   2) Program then stores user input in 2 separate integer variable
                   3) When the program reaches (A ^ B), it then performs a bitwise AND operation
                   4) The program takes the binary representation of the decimal number.
                   5) It then takes each bit in x and compares it to it's corresponding bit in y (1st bit in x, 1st bit in y);
                   6) If either bits is true and the other is not, the ^ yields a 1, otherwise it yields a 0
                   7) It compares for every bit then takes the resulting binary and returns the decimal representation of that binary
                """,binaryX, binaryY,"-".repeat(largestBinary), binaryResultOr);
        System.out.println(workingOutOr);

        /* Explanation of Bitwise Exclusive OR
        1) The program asks for 2 user inputs, x and y
        2) Program then stores user input in 2 separate integer variable
        3) When the program reaches (A ^ B), it then performs a bitwise AND operation
        4) The program takes the binary representation of the decimal number.
        5) It then takes each bit in x and compares it to its corresponding bit in y (1st bit in x, 1st bit in y);
        6) If either bits is true and the other is not, the ^ yields a 1, otherwise it yields a 0
        7) It compares for every bit then takes the resulting binary and returns the decimal representation of that binary
         */
    }

    // Code your task 5 method here
    private double volumeOfACylinder(double radius, double height){ //Accepts radius and height arguments as double because Math.pow() and Math.PI returns a double
        //Calculate area and volume of the cylinder
        double area = Math.pow(radius,2);
        double volume = (Math.PI*(area * height));

        return volume;
    };
}

