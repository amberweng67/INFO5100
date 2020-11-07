import java.util.Random;

class Summation implements Runnable {
    private long sum = 0;
    private int[] arr;
    private int low;
    private int high;

    public Summation(int[] arr, int low, int high ) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        for (int j = low; j < high; j++) {
            sum += this.arr[j];
        }
    }

    public long getSum() {
        return this.sum;
    }
}

public class SumValue {
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        long sum = 0;
        int threadNumber = 4;
        Summation[] summations = new Summation[threadNumber];
        int length = arr.length / threadNumber;
        for (int i = 0; i < summations.length; i++) {
            summations[i] = new Summation(arr, length * i, length * (i + 1));
            summations[i].run();
        }

        for (Summation summation : summations) {
            sum += summation.getSum();
        }
        return sum;
    }

    static long regularSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
        sum = regularSum(arr);
        System.out.println("regularSum: " + sum);
    }
}
