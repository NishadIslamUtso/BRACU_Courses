import java.io.*;
import java.util.StringTokenizer;
public class E {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t= Integer.parseInt(br.readLine());

        for(int k=0;k<t;k++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            long a=Long.parseLong(st.nextToken());
            long n=Long.parseLong(st.nextToken());
            long m=Long.parseLong(st.nextToken());

            long val=a%m;
            long sum=a%m;
            long last=1%m;
            long result=0;

            while(n>0){

                if(n%2==1){
                    result=(result+last*sum)%m;
                    last=(last*val)%m;
                }

                sum=(sum+val*sum)%m;
                val=(val*val)%m;
                n=n/2;
            }

            pw.println(result);
        }

        pw.flush();
    }

}