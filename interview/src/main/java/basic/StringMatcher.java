package basic;

public class StringMatcher {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "llh";
        System.out.println(match(str1, str2));


    }
    public static int match(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i = 0;
        int j = 0;
        while(i < str1.length() && j < str2.length()){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - (j-1);
                j=0;
            }
        }

        if (j == str2.length()){
            return i - j;
        }else {
            return -1;
        }
    }
}
