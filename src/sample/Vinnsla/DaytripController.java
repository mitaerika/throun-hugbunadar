package sample.Vinnsla;

public class DaytripController {

    /*
    Tekur inn Daytrip fylki, ásamt boolean breytu og flokkar eftir verði. Boolean breytan ákvarðar hvort það er flokkað hækkandi eða lækkandi.
     */
        public Daytrip[] sortByPrice(Daytrip[] listi, Boolean uppEdaNidur) {

            int low = 0;
            int high = listi.length;
            sortPrice(listi, low, high, uppEdaNidur);
            return listi;

    }
    /*
    Notað af sortPrice til að flokka verð
     */
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
    /*
    Notað af sortPrice til að flokka verð
     */
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
    /*
    Endurkvæmt fylki sem flokkar eftir verði.
     */
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
    /*
Tekur inn Daytrip fylki, ásamt boolean breytu og flokkar eftir rating. Boolean breytan ákvarðar hvort það er flokkað hækkandi eða lækkandi.
 */
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
    /*
Tekur inn Daytrip fylki, ásamt boolean breytu og flokkar eftir tíma. Boolean breytan ákvarðar hvort það er flokkað hækkandi eða lækkandi.
 */
    public Daytrip[] sortByTime(Daytrip[] listi, Boolean uppEdaNidur) {

        int low = 0;
        int high = listi.length;
        sortPrice(listi, low, high, uppEdaNidur);
        return listi;

    }

    public void sortTime(Daytrip[] listi, int low, int high, Boolean uppEdaNidur) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi;
            if(uppEdaNidur) {pi = sortByTimeRecursiveUpp(listi, low, high);}
            else{pi = sortByTimeRecursiveNidur(listi, low, high);}


            // Recursively sort elements before
            // partition and after partition
            sortTime(listi, low, pi-1, uppEdaNidur);
            sortTime(listi, pi+1, high, uppEdaNidur);
        }
    }

    private int sortByTimeRecursiveNidur(Daytrip[] listi, int low, int high) {
        long pivot = listi[high].getStartTime().getTimeInMillis();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getStartTime().getTimeInMillis() >= pivot)
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

    private int sortByTimeRecursiveUpp(Daytrip[] listi, int low, int high) {
        long pivot = listi[high].getStartTime().getTimeInMillis();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (listi[j].getStartTime().getTimeInMillis() <= pivot)
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
