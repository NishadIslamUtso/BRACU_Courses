import java.io.*;
import java.util.StringTokenizer;
public class F {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] left=new int[n];
        int[] right=new int[n];
        int top=0;

        left[top]=0;
        right[top]=n-1;

        while(top>=0){

            int l=left[top];
            int r=right[top];
            top--;

            int mid=(l+r)/2;
            pw.print(arr[mid]+" ");

            if(mid<r){
                top++;
                left[top]=mid+1;
                right[top]=r;
            }

            if(l<mid){
                top++;
                left[top]=l;
                right[top]=mid-1;
            }
        }

        pw.println();
        pw.flush();
    }

}