public class QuickSort {

    static int partition(int array[], int start, int end)
    {
        int pivot = array[end];
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {

            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return (i + 1);
    }

     static void quickSort(int array[], int start, int end)
    {
        if (start < end)
        {
            int p = partition(array, start, end);
            quickSort(array, start, p - 1);
            quickSort(array, p + 1, end);
        }
    }

}
