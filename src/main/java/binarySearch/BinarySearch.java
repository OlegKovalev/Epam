package main.java.binarySearch;

public class BinarySearch {

    public static <T extends Comparable<T>> int binarySearch(T[] array, T element) {
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
            int centre = (end + start) / 2;
            int comparedResult = element.compareTo(array[centre]);
            if (comparedResult < 0) {
                end = centre - 1;
            } else if (comparedResult > 0) {
                start = centre + 1;
            } else {
                return centre;
            }
        }
        return -1;
    }
}
