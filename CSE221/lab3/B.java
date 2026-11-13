import java.io.*;
import java.util.*;
public class B {

    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Integer[] pos=new Integer[n];
        for(int i=0;i<n;i++){
            pos[i]=i;
        }

        Arrays.sort(pos,(a,b)->Integer.compare(arr[b],arr[a]));

        Integer[] query=new Integer[n];
        int q=0;

        for(int j=0;j<n;j++){
            if(1L*arr[j]*arr[j]<1000000){
                query[q]=j;
                q++;
            }
        }

        Arrays.sort(query,0,q,(a,b)->Long.compare(1L*arr[b]*arr[b],1L*arr[a]*arr[a]));

        int size=(int)Math.sqrt(n)+1;
        int blocks=(n+size-1)/size;
        int[] block=new int[blocks];
        boolean[] active=new boolean[n];

        long inv=0;
        int idx=0;

        for(int k=0;k<q;k++){

            int j=query[k];
            long sq=1L*arr[j]*arr[j];

            while(idx<n && arr[pos[idx]]>sq){
                int p=pos[idx];
                active[p]=true;
                block[p/size]++;
                idx++;
            }

            int full=j/size;
            long count=0;

            for(int i=0;i<full;i++){
                count+=block[i];
            }

            int start=full*size;
            for(int i=start;i<j;i++){
                if(active[i]){
                    count++;
                }
            }

            inv+=count;
        }

        pw.println(inv);
        pw.flush();
    }

}