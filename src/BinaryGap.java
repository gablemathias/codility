public class BinaryGap {
    // Implement your solution here
    // Return the longest binary gap representation of a given N

    // Convert N to its binary representation
    // Loop through the integers that can be chars
    // Count each zero until we find another one
    // if the next value is 1, stop counting
    // if the next value is null, stop the function

    /*
        Integer actualCounter = 0;
        Integer finalCounter = 0;

        Examples: 32 => 100000, return 0, no gaps
                  9  => 1001, return 2
                  527=> 100001001, return 4, longest gap.

        Functions:
            Integer.toBinaryString(numberToBeConverted);


        Convert N to binary and convert to chars
        Start the loop
            if actual value is 0 (zero), go to next value;
            else if actual value is null, stop loop;
            else if the actual value is 1, start counting the zeros
                if actual value is null stop loop;
                if actual value is 0, increment counter;
                if actual value is 1:
                    compare actualCounter and finalCounter
                    if actual > final, final = actual;
                    else nothing;
                    then we reset the actual Counter;
    */

    public static void main(String[] args) {
        int[] ns = {561892,74901729,1376796946};

        for(int number : ns) {
            String[] binary = Integer.toBinaryString(number).split("");
            System.out.println(binaryGap(binary));
        }

        int[] nm = {1014,15,32,1,5,6};

        for(int number : nm) {
            String[] binary = Integer.toBinaryString(number).split("");
            System.out.println(binaryGap(binary));
        }
    }

    private static int binaryGap(String[] binary) {
        int index = 0;
        int finalCounter = 0;

        while(index + 1 < binary.length) {
            int actualCounter = 0;
            String actual = binary[index];
            if(actual.equals("1")) {
                while(index + 1 < binary.length) {
                    if (binary[index+1].equals("0")) {
                        actualCounter++;
                        index++;
                    } else {
                        if(actualCounter > finalCounter) {
                            finalCounter = actualCounter;
                        }
                        break;
                    }
                }
            }
            index++;
        }

        return finalCounter;
    }
}
