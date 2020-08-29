public class containsFilter extends Filter {

    public containsFilter(String a,String b) {
        super(a,b);
    }

    @Override
    public String printsql(){
        return a+" CONTAINS "+b;
    }
}
