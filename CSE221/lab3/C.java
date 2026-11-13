import java.io.*;
import java.util.StringTokenizer;
public class C {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());

        long result=1;
        a=a%107;

        while(b>0){

            if(b%2==1){
                result=(result*a)%107;
            }

            a=(a*a)%107;
            b=b/2;
        }

        pw.println(result);
        pw.flush();
    }

}