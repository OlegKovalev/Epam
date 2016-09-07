package binarySearch;

public class BinarySearch {

    public <T extends Comparable<T>> int binarySearch(T array[], T element) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int centre = (end + start) / 2;
            int compareResult = element.compareTo(array[centre]);
            if (compareResult < 0) {
                end = centre - 1;
            } else  {
                if (compareResult > 0) {
                    start = centre + 1;
                }
                    return centre;
            }
        }
        return -1;
    }
}
