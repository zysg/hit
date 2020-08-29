public class notequalFilter extends Filter {

    public notequalFilter(String a, String b) {
        super(a, b);
    }

    @Override
    public String printsql(){
        return a+" <> "+b;
    }
}
