import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generate {

    private String a;
    private String b;
    private List sql;

    public Generate() {
        this.sql = new ArrayList();
    }

    public void createSubSql(String a, String b, String op) {
        Filter ft;
        switch (op) {
            case "equal":
                ft =new equalFilter(a,b);
                break;
            case "notequal":
                ft=new notequalFilter(a,b);
                break;
            case "contains":
                ft=new containsFilter(a,b);
                break;
            default:
                ft = null;
                break;
        }
        sql.add(ft.printsql());
    }

    public void createSubSql(String a, String b, String op,String str) {
        sql.add(" ");
        sql.add(str);
        sql.add(" ");
        createSubSql(a, b, op);
    }

    public String generateSql() {
        String s = "Select * from table where ";
        for(Iterator i = sql.iterator(); i.hasNext(); ) {
            s+=i.next();
        }
        return s;
    }
}
