// Strings.java
// Sort an array of strings using Sorting

public class Strings {
    public static void main(String[] args) {
        String[] words = {"Zebra", "Apple", "Monkey", "Ball", "Cat"};

        System.out.println("Original array:");
        for (String w : words)
            System.out.print(w + " ");
        System.out.println();

        // pakai insertionSort descending
        Sorting.insertionSort(words);

        System.out.println("Sorted array (descending):");
        for (String w : words)
            System.out.print(w + " ");
        System.out.println();
    }
}
