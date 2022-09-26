import java.util.Scanner;
public class Problem610 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int veces = sc.nextInt();
        for(int i=0;i<veces;i++){
            boolean peterlive = true , starklive = true;
            int n= sc.nextInt(), s= sc.nextInt(), p= sc.nextInt(), k = sc.nextInt();
            if(n<2 || n>1000) { continue; }
            if(s<1 || s>n || s==p ) { continue; }
            if(p<1 || p>n) { continue; }
            if(k<0 || k>20){ continue; }
            String[] rueda= new String[n];
            for(int j=0;j<n;j++){
                rueda[j]= (j+1==p)?"p":(j+1==s)?"s":"x";
            }
            int counter=0;
            do{
                counter+=k;
                counter = (counter>= rueda.length)? (counter-((counter/rueda.length)*rueda.length)) : counter;
                starklive=(rueda[counter]=="s")? false : starklive;
                peterlive=(rueda[counter]=="p")? false : peterlive;
                rueda=removeElement(rueda, counter);
            }while(rueda.length>n/2);
            if(!peterlive && starklive ){
                System.out.println("No quiero irme, Sr. Stark!");
            }else if(peterlive && !starklive){
                System.out.println("No quiero irme, Peter!");
            }else{
                System.out.println("No hay abrazo");
            }
        }
    }
    public static String[] removeElement(String[] arr, int index) {
        String[] result = new String[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        if (arr.length != index) {
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        }
        return result;
    }
}