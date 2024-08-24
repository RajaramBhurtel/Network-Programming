// 4! = 4*3*2*1 =24
// 5! = 5*4*3*2*1 =120
public class factorial {
    public static void main(String[] args) {
        int i, fact =1;
        int n=5;
        for(i=1;i<=n;i++){
            fact =fact*i;
        }
        System.out.println("Factorial :" +fact );
    }
}
