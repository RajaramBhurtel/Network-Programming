public class Overrides {
    public static void main(String[] args) {
        Overrides a = new Overrides();
        a.x = "Sunil";
        Overrides b = new Overrides();
        b.x = "Sunil";
        System.out.println("For a");
        System.out.println(a.toString());
        System.out.println(a.hashCode());

        System.out.println("\nFor b");
        System.out.println(b.toString());
        System.out.println(b.hashCode());

        System.out.println("\nEquals : " + a.equals(b));
    }

    public String x = "abc";

    @Override
    public String toString() {
        return x + " from abc class";
    }

    @Override
    public int hashCode() {
        return x.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        Overrides obj = (Overrides) o;
        return obj.x == this.x;
    }
}
