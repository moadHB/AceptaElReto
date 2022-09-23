import java.util.Scanner;
public class Problem593TreadsRecursive {
    private static int answer;
    private static int[] nmuestras;
    private static String line;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.nextInt()!=0 && sc.hasNext()) {
            answer=1;
            nmuestras= new int[100002];
            line = sc.next();
            nmuestras[0] = 0;
            for (int i = 1; i <= line.length(); i++) {
                nmuestras[i] = nmuestras[i - 1] - (line.charAt(i - 1) - '0');
            }
            Thread thread = new Thread(new Inner(1, (line.length()) , 1));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(answer);
        }
        Thread.currentThread().interrupt();
    }
    private static class Inner extends Thread {
        private int start;
        private int end;
        private int myID;
        public Inner(int start, int end, int myID) {
            this.start = start;
            this.end = end;
            this.myID= myID;
        }
        @Override
        public void run() {
            if (line.length()*2-1 >= myID) {
                if((nmuestras[end]-nmuestras[start-1])==0 || start==end ){
                    answer+= 0;
                }else if((nmuestras[end]-nmuestras[start-1])==(end-start+1)  ){
                    answer+= 2*(end-start+1)-2 ;
                }else{
                    int middle = start + (end-start)/2;
                    answer+=2;
                    Thread thread1 = new Thread(new Inner(start,middle, myID*2));
                    Thread thread2 = new Thread(new Inner(middle+1,end, myID*2+1));
                    thread1.start();
                    thread2.start();
                    try {
                        thread1.join();
                        thread2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                Thread.currentThread().interrupt();
            }
        }
    }
}