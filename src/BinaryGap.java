public class BinaryGap {
    // Return the longest binary gap representation of a given N
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
    private int i = 0;
    private int finalCounter = 0;
    private int size;
    private String[] binary;

    private BinaryGap(String[] binary) {
        this.binary = binary;
        this.size = binary.length;
    }

    public static void main(String[] args) {
        int[] ns = {561892,74901729,1376796946,1014};

        for(int number : ns) {
            String[] binary = Integer.toBinaryString(number).split("");
            System.out.printf(" %s ", new BinaryGap(binary).binaryGap());
        }
    }

    private int binaryGap() {
        while(i + 1 < size) {
            int actualCounter = 0;
            if(binary[i].equals("1")) {
                calculateGap(actualCounter);
            }
            i++;
        }

        return finalCounter;
    }

    private void calculateGap(int actualCounter) {
        while(i + 1 < size) {
            if (binary[i+1].equals("0")) {
                actualCounter++;
                i++;
            } else {
                if(actualCounter > finalCounter)
                    finalCounter = actualCounter;
                break;
            }
        }
    }
}
