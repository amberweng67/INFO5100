public class Assignment3Reverse {
    public String reverse(String s) {
        String[] sa = s.split(" ");
        sa = this.reverseArray(sa);
        return String.join(" ", sa);
    }

    public String[] reverseArray(String[] a) {
        int i = 0;
        int j = a.length - 1;
        while(i < j) {
            String tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        return a;
    }

    public static void main(String[] args) {
        Assignment3Reverse test = new Assignment3Reverse();
        String s = "The sky is blue";
        String ans = test.reverse(s);
        System.out.println(ans);
    }
}
