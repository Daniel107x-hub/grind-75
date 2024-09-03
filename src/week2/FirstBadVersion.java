package week2;

public class FirstBadVersion {
    private static final int BAD_VERSION = 1702766719;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n){
        int left = 1;
        int right = n;
        while(left < right){
            int middle = (int)(((long)left + (long)right) / 2);
            if(isBadVersion(middle)) right = middle;
            else left = middle + 1;
        }
        return right;
    }

    public static boolean isBadVersion(int n){
        if(n < 1) throw new IllegalArgumentException();
        return n >= BAD_VERSION;
    }
}
