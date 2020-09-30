import java.util.Scanner;
public class NumberCounter {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       String str0=sc.next();
       String str1=sc.next();
       String str2=sc.next();
       countNumbers(str0,str1,str2);
       sc.close();
    }

    public static void countNumbers(String str0, String str1, String str2) {
        int x=Integer.parseInt(str0);
        int y=Integer.parseInt(str1);
        int z=Integer.parseInt(str2);
        String multi=Integer.toString(x*y*z);

        int[] arr=new int[10];
        for(int i=0; i<multi.length(); i++){
            char ch=multi.charAt(i);
            arr[ch-'0']++;
        }

        for(int j=0; j<arr.length; j++){
            if(arr[j]!=0){
                printNumberCount(j, arr[j]);
            }
        }
    }

    private static void printNumberCount(int number, int count) {
        System.out.printf("%d: %d times\n", number, count);
    }
}
