import java.io.*;
import java.util.StringTokenizer;
public class D {

    public static void multiply(long[] a,long[] b,long[] temp){

        long mod=1000000007;

        temp[0]=(a[0]*b[0]+a[1]*b[2])%mod;
        temp[1]=(a[0]*b[1]+a[1]*b[3])%mod;
        temp[2]=(a[2]*b[0]+a[3]*b[2])%mod;
        temp[3]=(a[2]*b[1]+a[3]*b[3])%mod;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t= Integer.parseInt(br.readLine());

        for(int k=0;k<t;k++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            long[] arr=new long[4];

            for(int i=0;i<4;i++){
                arr[i]=Long.parseLong(st.nextToken());
            }

            long x=Long.parseLong(br.readLine());

            long[] result={1,0,0,1};
            long[] temp=new long[4];

            while(x>0){

                if(x%2==1){
                    multiply(result,arr,temp);

                    long[] swap=result;
                    result=temp;
                    temp=swap;
                }

                multiply(arr,arr,temp);

                long[] swap=arr;
                arr=temp;
                temp=swap;

                x=x/2;
            }

            pw.println(result[0]+" "+result[1]);
            pw.println(result[2]+" "+result[3]);
        }

        pw.flush();
    }

}