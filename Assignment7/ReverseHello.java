public class ReverseHello implements Runnable {
    private final int num;
    public ReverseHello(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (this.num == 50) {
            System.out.format("Hello from Thread %d!\n", this.num);
        } else {
            ReverseHello reverseHello = new ReverseHello(this.num + 1);
            reverseHello.run();
            System.out.format("Hello from Thread %d!\n", this.num);
        }
    }

    public static void main(String[] args) {
        ReverseHello reverseHello = new ReverseHello(1);
        reverseHello.run();
    }
}
