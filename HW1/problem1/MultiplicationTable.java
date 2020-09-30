import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("숫자 입력: ");
        int n=sc.nextInt();
        printMultiplicationTable(n);
        sc.close();
    }

    public static void printMultiplicationTable(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                printOneMultiplication(i,j,i*j);
            }
        }
    }

    private static void printOneMultiplication(int a, int b, int c) {
        System.out.printf("%d times %d = %d\n", a, b, c);
    }
}