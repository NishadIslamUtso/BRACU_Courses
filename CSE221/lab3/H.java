import java.io.*;
import java.util.StringTokenizer;
public class H {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] pos=new int[n+1];

        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            pos[a]=i;
        }

        st=new StringTokenizer(br.readLine());
        int[] post=new int[n];

        for(int i=0;i<n;i++){
            post[i]=Integer.parseInt(st.nextToken());
        }

        int[] left=new int[n];
        int[] right=new int[n];
        int[] end=new int[n];
        int top=0;

        left[top]=0;
        right[top]=n-1;
        end[top]=n-1;

        while(top>=0){

            int l=left[top];
            int r=right[top];
            int e=end[top];
            top--;

            int root=post[e];
            int mid=pos[root];
            int count=r-mid;

            pw.print(root+" ");

            if(mid<r){
                top++;
                left[top]=mid+1;
                right[top]=r;
                end[top]=e-1;
            }

            if(l<mid){
                top++;
                left[top]=l;
                right[top]=mid-1;
                end[top]=e-count-1;
            }
        }

        pw.println();
        pw.flush();
    }

}