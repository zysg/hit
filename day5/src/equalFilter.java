public class equalFilter extends Filter {

    public equalFilter(String a,String b) {
        super(a,b);
    }

    @Override
    public String printsql(){
        return a+" = "+b;
    }
}
