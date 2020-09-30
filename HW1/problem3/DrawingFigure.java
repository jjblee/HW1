import java.util.Scanner;
public class DrawingFigure {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        drawFigure(n);
        sc.close();
    }
    public static void drawFigure(int n) {
        for(int i=1; i<=n; i++ ){
            for(int j=1; j<=20-4*(i-1); j++){
                System.out.print('/');
            }
            for(int j=1; j<=8*(i-1); j++){
                System.out.print('*');
            }
            for(int j=1; j<=20-4*(i-1); j++){
                System.out.print('\\');
            }
            System.out.println();
        }
    }
}
