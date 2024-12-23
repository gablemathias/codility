import java.util.LinkedList;

// Rotating an array
// Remove the last element, the one before it is the new last
// Insert the element as being the new first element

// Task Score and Correctness 100%

public class Rotating {
    public static void main(String[] args) {
        int[] anArray = {1,2,3,4};
        int times = 4;

        LinkedList<Integer> rotated = rotate(convertToLinkedList(anArray), times);

        System.out.println(rotated);

    }

    public static LinkedList<Integer> convertToLinkedList(int[] array) {
        LinkedList<Integer> llist = new LinkedList<>();
        for (int value : array) {
            llist.addLast(value);
        }
        return llist;
    }

    public static LinkedList<Integer> rotate(LinkedList<Integer> llist, int N) {
        for (int i = 1; i <= N; i++) {
            llist.addFirst(llist.removeLast());
        }
        return llist;
    }

    public static int[] convertToIntArray(LinkedList<Integer> llist) {
        int[] converted = new int[llist.size()];

        for (int i = 0; i < llist.size(); i++) {
            converted[i] = llist.get(i);
        }

        return converted;
    }
}
