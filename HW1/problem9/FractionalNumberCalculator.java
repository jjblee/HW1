import java.util.Scanner;
public class FractionalNumberCalculator {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String equation=sc.nextLine();
        printCalculationResult(equation);
        sc.close();
    }

    public static void printCalculationResult(String equation) {
        String[] arr=equation.split(" ");
        int a,b,c,d;
        if(arr[0].contains("/")){
            String[] first=arr[0].split("/");
            b=Integer.parseInt(first[0]);
            a=Integer.parseInt(first[1]);
        } else{
            a=1;
            b=Integer.parseInt(arr[0]);
        }
        if(arr[2].contains("/")){
            String[] second=arr[2].split("/");
            d=Integer.parseInt(second[0]);
            c=Integer.parseInt(second[1]);
        } else{
            c=1;
            d=Integer.parseInt(arr[2]);
        }

        switch (arr[1]) {
            case "+":
                FractionalNumber x = new FractionalNumber(b * c + a * d, a * c);
                x.gcd();
                break;
            case "-":
                FractionalNumber y = new FractionalNumber(b * c - a * d, a * c);
                y.gcd();
                break;
            case "*":
                FractionalNumber z = new FractionalNumber(b * d, a * c);
                z.gcd();
                break;
            case "/":
                FractionalNumber w = new FractionalNumber(b * c, a * d);
                w.gcd();
                break;
            }
        }

    }

class FractionalNumber {
    private int numerator;
    private int denominator;

    FractionalNumber(int numerator, int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }
    public void gcd(){
        int gcd, big, small;
        if(numerator<0){
            gcd=Math.min(-numerator,denominator);
            small=Math.min(-numerator,denominator);
            big=Math.max(-numerator,denominator);
        } else{
            gcd=Math.min(numerator,denominator);
            small=Math.min(numerator,denominator);
            big=Math.max(numerator,denominator);
        }
        while(gcd>=1){
            if(big%gcd==0&&small%gcd==0){
                numerator/=gcd;
                denominator/=gcd;
                if(denominator==1){
                    System.out.println(numerator);
                } else{
                    System.out.printf("%d/%d\n",numerator,denominator);
                }
                break;
            } else{
                gcd-=1;
            }
        }
    }
}