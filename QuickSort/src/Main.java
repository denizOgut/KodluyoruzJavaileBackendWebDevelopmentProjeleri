public class Main {
    public static void main(String[] args) {
        int array[] = {15, 22, 3, 88, 37, 67, 7, 44};
        for (Integer i : array) {
            System.out.print(i + " ");
            QuickSort.quickSort(array, 0, array.length - 1);
            System.out.println(" ");
            for (Integer a : array) {
                System.out.print(a + " ");

            }


        }
    }
}
