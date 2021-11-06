public class JobFairDebugged {

    void doSomething(int array[]) { // Performs counting search
        if (array == null) {
            return;
        }
        int size = array.length;
        int[] output = new int[size];

        // Find the largest and the smallest element of the array
        if (size == 0) {
            return;
        }
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < size; i ++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int countLength = max - min + 1;
        int[] count = new int[countLength];

        // Initialize count array with all zeros
        int k = 0;
        while (k < countLength) {
            count[k] = 0;
            k ++;
        }

        // Store the count of each element
        for (int i = 0; i < size; i ++) {
            count[array[i] - min] ++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i < countLength; i ++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array,
        // and place the elements in output array
        for (int i = size - 1; i >= 0; i --) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min] --;
        }

        // Copy elements into original array
        for (int i = 0; i < size; i ++) {
            array[i] = output[i];
        }
    }

}
