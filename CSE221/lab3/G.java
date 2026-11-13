import java.io.*;
import java.util.StringTokenizer;
public class G {

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
        int[] pre=new int[n];

        for(int i=0;i<n;i++){
            pre[i]=Integer.parseInt(st.nextToken());
        }

        int[] left=new int[n];
        int[] right=new int[n];
        int[] start=new int[n];
        int[] result=new int[n];

        int top=0;
        int idx=0;

        left[top]=0;
        right[top]=n-1;
        start[top]=0;

        while(top>=0){

            int l=left[top];
            int r=right[top];
            int s=start[top];
            top--;

            int root=pre[s];
            int mid=pos[root];
            int count=mid-l;

            result[idx]=root;
            idx++;

            if(l<mid){
                top++;
                left[top]=l;
                right[top]=mid-1;
                start[top]=s+1;
            }

            if(mid<r){
                top++;
                left[top]=mid+1;
                right[top]=r;
                start[top]=s+count+1;
            }
        }

        for(int i=n-1;i>=0;i--){
            pw.print(result[i]+" ");
        }

        pw.println();
        pw.flush();
    }

}