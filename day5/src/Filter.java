public abstract class Filter {

    protected String a;
    protected String b;

    public Filter(String a,String b) {
        this.a=a;
        this.b=b;
    }

   public abstract String printsql();
}
