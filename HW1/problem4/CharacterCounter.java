import java.util.Scanner;
public class CharacterCounter {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        countCharacter(str);
        sc.close();
    }
    public static void countCharacter(String str) {
        int[] arr=new int[26];
        for(int i=0; i<str.length(); i++){
            char alphabet=str.charAt(i);
            arr[alphabet-97]++;
        }
        for(int j=0; j<arr.length; j++){
            if(arr[j]!=0){
                printCount((char)(j+'a'), arr[j]);
            }
        }

    }

    private static void printCount(char character, int count) {
        System.out.printf("%c: %d times\n", character, count);
    }
}