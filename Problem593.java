import java.util.Scanner;
public class Problem593 {
    private static int[] nmuestras= new int[100002];

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.nextInt()!=0){
            String line = sc.next();
            nmuestras[0]= 0;
            for(int i =1 ;i<=line.length();i++){
                nmuestras[i]= nmuestras[i-1]-(line.charAt(i-1)-'0');
            }

            System.out.println(lotes(1, line.length())+1);
        }

    }
    public static int lotes(int start ,int end){
        if(nmuestras[end]-nmuestras[start-1]==0 || start==end ){ return 0; }
        if(nmuestras[end]-nmuestras[start-1]==end-start+1  ){ return 2*(end-start+1)-2 ; }
        int middle = start + (end-start)/2;
        return lotes(start,middle)+lotes(middle+1,end) +2 ;
    }
}