public class JobFairOptimized {

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
        int currentElement;
        for (int i = 1; i < size; i ++) {
            currentElement = array[i];
            if (currentElement > max) {
                max = currentElement;
            }
            if (currentElement < min) {
                min = currentElement;
            }
        }
        int countLength = max - min + 1;
        int[] count = new int[countLength];

        // Store the count of each element
        for (int i = 0; i < size; i ++) {
            count[array[i] - min] ++;
        }

        // Store the cumulative count of each array
        int lastElement = count[0];
        for (int i = 1; i < countLength; i ++) {
            lastElement = (count[i] += lastElement);
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        int arrayI;
        for (int i = size - 1; i >= 0; i --) {
            arrayI = array[i];
            output[count[arrayI - min] - 1] = arrayI;
            count[arrayI - min] --;
        }

        // Copy elements into original array
        for (int i = 0; i < size; i ++) {
            array[i] = output[i];
        }
    }
}
