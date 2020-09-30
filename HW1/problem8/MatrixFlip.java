import java.util.Scanner;
public class MatrixFlip {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String size=sc.nextLine();
        String[] nm=size.split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);

        String[] row=new String[n];
        for(int i=0; i<n; i++){
            row[i]=sc.next();
        }

        char[][] matrix=new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j]=row[i].charAt(j);
            }
        }
        printFlippedMatrix(matrix);
        sc.close();
    }

    public static void printFlippedMatrix(char[][] matrix) {
        for(int i=matrix.length-1; i>=0; i--){
            for(int j=matrix[i].length-1; j>=0; j--){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}