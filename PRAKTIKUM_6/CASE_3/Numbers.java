// Numbers.java
// Sort an array of integers using Sorting

public class Numbers {
    public static void main(String[] args) {
        // gunakan Integer[] (bukan int[])
        Integer[] numbers = {34, 67, 23, 1, 89, 2, 77};

        System.out.println("Original array:");
        for (Integer n : numbers)
            System.out.print(n + " ");
        System.out.println();

        // pakai insertionSort (descending)
        Sorting.insertionSort(numbers);

        System.out.println("Sorted array (descending):");
        for (Integer n : numbers)
            System.out.print(n + " ");
        System.out.println();
    }
}
