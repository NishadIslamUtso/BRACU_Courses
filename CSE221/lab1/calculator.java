import java.util.Scanner;
public class calculator{
  public static void main(String[]args){
    
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    
    for(int i=0;i<t;i++){
      sc.next();
      long x=sc.nextInt();
      char m=sc.next().charAt(0);
      long y=sc.nextInt();
      
      if(m=='+'){
        System.out.println(x+y);
      }
      else if(m=='-'){
        System.out.println(x-y);
      }
      else if(m=='*'){
        System.out.println(x*y);
      }
      else if(m=='/'){
        System.out.println((double)x/y);
      }
      else if(m=='%'){
        System.out.println(x%y);
      }
      else if(m=='&'){
        System.out.println(x&y);
      }
      else if(m=='|'){
        System.out.println(x|y);
      }
      else if(m=='^'){
        System.out.println(x^y);
      }
      else if(m=='<'){
        System.out.println(x<<y);
      }
      else if(m=='>'){
        if(y>=64){
          System.out.println(0);
        }
        else{
          System.out.println(x>>y);
        }
      }
    }
  }
}