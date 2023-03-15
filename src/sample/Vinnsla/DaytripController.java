package sample.Vinnsla;

public class DaytripController {
        public Daytrip[] sortByPrice(Daytrip[] listi, Boolean uppEdaNidur) {

            int low = 0;
            int high = listi.length;
            sortPrice(listi, low, high, uppEdaNidur);
            return listi;

    }
    public int sortByPriceRecursiveUpp(Daytrip[] listi, int low, int high) {
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
                Daytrip temp = listi[i];
                listi[i] = listi[j];
                listi[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Daytrip temp = listi[i+1];
        listi[i+1] = listi[high];
        listi[high] = temp;

        return i+1;

    }
    public int sortByPriceRecursiveNidur(Daytrip[] listi, int low, int high) {
        int pivot = listi[high].getPrice();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getPrice() >= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                Daytrip temp = listi[i];
                listi[i] = listi[j];
                listi[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Daytrip temp = listi[i+1];
        listi[i+1] = listi[high];
        listi[high] = temp;

        return i+1;

    }
    public void sortPrice(Daytrip[] listi, int low, int high, Boolean uppEdaNidur) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi;
            if(uppEdaNidur) {pi = sortByPriceRecursiveUpp(listi, low, high);}
            else{pi = sortByPriceRecursiveNidur(listi, low, high);}


            // Recursively sort elements before
            // partition and after partition
            sortPrice(listi, low, pi-1, uppEdaNidur);
            sortPrice(listi, pi+1, high, uppEdaNidur);
        }
    }
    public Daytrip[] sortByRating(Daytrip[] listi, Boolean uppEdaNidur) {

        int low = 0;
        int high = listi.length;
        sortRating(listi, low, high, uppEdaNidur);
        return listi;
    }

    private void sortRating(Daytrip[] listi, int low, int high, Boolean uppEdaNidur) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi;
            if(uppEdaNidur) {pi = sortByRatingRecursiveUpp(listi, low, high);}
            else{pi = sortByRatingRecursiveNidur(listi, low, high);}


            // Recursively sort elements before
            // partition and after partition
            sortRating(listi, low, pi-1, uppEdaNidur);
            sortRating(listi, pi+1, high, uppEdaNidur);
        }
    }

    private int sortByRatingRecursiveNidur(Daytrip[] listi, int low, int high) {
        int pivot = listi[high].getRating();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getRating() >= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                Daytrip temp = listi[i];
                listi[i] = listi[j];
                listi[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Daytrip temp = listi[i+1];
        listi[i+1] = listi[high];
        listi[high] = temp;

        return i+1;

    }

    private int sortByRatingRecursiveUpp(Daytrip[] listi, int low, int high) {
        int pivot = listi[high].getRating();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getRating() <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                Daytrip temp = listi[i];
                listi[i] = listi[j];
                listi[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Daytrip temp = listi[i+1];
        listi[i+1] = listi[high];
        listi[high] = temp;

        return i+1;

    }


}
