public class test {
    static int res = 1;
    public static void main(String[] args) {

        System.out.println(recursion(1));
    }

    private static int recursion(int i) {
        if(i == 100)
            return 100;

        return i + recursion(i+1);
    }

}
