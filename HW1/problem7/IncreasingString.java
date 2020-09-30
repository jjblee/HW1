import java.util.Scanner;
public class IncreasingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        printLongestIncreasingSubstringLength(inputString);
        sc.close();
    }

    public static void printLongestIncreasingSubstringLength(String inputString) {
        int[] arr = new int[200];
        int a, b= 0;
        for (int i =0; i < inputString.length()-1; i++) {
            if (inputString.charAt(i) - 'a' >= inputString.charAt(i + 1) - 'a') {
                a=i+1;
                arr[i]=a-b;
                b=i+1;
            }
        }
        arr[inputString.length()-1]=inputString.length()-b;

        int max=Integer.MIN_VALUE;
        for(int i=0; i<200; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
}