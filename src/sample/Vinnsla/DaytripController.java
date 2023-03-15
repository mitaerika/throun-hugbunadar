package sample.Vinnsla;

public class DaytripController {
        public Daytrip[] sortByPrice(Daytrip[] listi) {
            int low = 0;
            int high = listi.length;
            sort(listi, low, high);
            return listi;

    }
    public int sortByPriceRecursive(Daytrip[] listi, int low, int high) {
        int pivot = listi[high].getPrice();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getPrice() <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = listi[i].getPrice();
                listi[i].setPrice(listi[j].getPrice());
                listi[j].setPrice(temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = listi[i+1].getPrice();
        listi[i+1].setPrice(listi[high].getPrice());
        listi[high].setPrice(temp);

        return i+1;

    }
    public void sort(Daytrip[] listi, int low, int high) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = sortByPriceRecursive(listi, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(listi, low, pi-1);
            sort(listi, pi+1, high);
        }
    }
}
