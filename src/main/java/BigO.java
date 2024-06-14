import lombok.Data;

@Data
public class BigO {

    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;


    public static void main(String[] args) {
        BigO test1 = new BigO(10000);
        test1.generateRandomArray();

        BigO test2 = new BigO(20000);
        test2.generateRandomArray();

        BigO test3 = new BigO(20000000);
        test3.generatedOrderedArray();

        test3.binarySearch( 1052);

    }

    public BigO(int size){
        arraySize = size;
        theArray = new int[size];
    }

    public void generateRandomArray(){
        for (int i = 0; i < arraySize; i++){
            theArray[i] = (int) ((Math.random() * 1000) + 10);
        }
        itemsInArray = -1;
    }

    public void generatedOrderedArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = i;
        }
        itemsInArray = -1;
    }

    public void addItemToArray(int newItem){
        theArray[itemsInArray++] = newItem;
    }


    // Linear N
    public void linearSearch(int value){
        System.out.println("Searching for: " +  value + " in a haystack of: " + arraySize);

        boolean found = false;
        String indexWithValue = "";

        startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == value){
                found = true;
                indexWithValue += i + "";
            }

        }
        endTime = System.currentTimeMillis();
        System.out.println("Value found: " + found);
        System.out.println("Linear Time took: "  + (endTime - startTime) + "ms");
    }

    // O (N^2)
    public void bubbleSort(){
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arraySize -1 ; i++) {
            for (int j = 0; j < arraySize - i - 1;  j++) {
                if(theArray[j] >  theArray[j+i]){
                    swapValues(j , j+1);
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Linear Time took: "  + (endTime - startTime) + "ms");
    }

    public void binarySearch(int value){
        startTime = System.currentTimeMillis();
        int low = 0;
        int high = arraySize - 1;
        int rounds = 0;

        while(low < high){
            int middle = (high + low) / 2;
            if(theArray[middle] < value){
                low = middle + 1;
            }
            else if(theArray[middle] > value){
                high = middle -1;
            } else {
                System.out.println("Found value in Index: " + middle);
                low = high + 1;
            }
            rounds++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search Time took: "  + (endTime - startTime) + "ms");
    }

    private void swapValues(int j, int i) {
        int swap = theArray[j];
        theArray[j] = theArray[i];
        theArray[j] = swap;
    }
}
