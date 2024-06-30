package test;

public class Addition {
    public int  mySum(int a, int b){
        return a+b;
    }
    public static int  myMax(int [] array){
        int max=Integer.MIN_VALUE;
        for (int number:array) {
            max = number>max ? number:max;
        }
        return max;
    }
    public  static  String reverseWord(String str){
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
}
