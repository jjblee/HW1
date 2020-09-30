import java.util.Scanner;
public class PrimeNumbers {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printPrimeNumbers(n);
        sc.close();
    }

    public static void printPrimeNumbers(int n) {
        int[] arr=new int[n];

        int i=0;
        int j=2;
        while(true){
            if(i==n){
                for (int el:arr) {
                    System.out.print(el+" ");
                }
                break;
            }
            int count=0;
            for(int k=2; k<=j; k++){
                if(j%k==0){
                    count+=1;
                }
            }
            if(count==1){
                arr[i]=j;
                i+=1;
            }
            j+=1;
        }


    }
}
