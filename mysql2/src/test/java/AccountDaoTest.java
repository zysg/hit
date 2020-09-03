import com.htsc.dao.IAccountDao;
import com.htsc.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountDaoTest {
    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession(true);
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void testFindAll() {
        List<AccountUser> accountUsers = accountDao.findAll();
        Assert.assertEquals(3, accountUsers.size());

        for(AccountUser accountUser : accountUsers) {
            System.out.println(accountUser.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        //session.commit();
        session.close();
        in.close();
    }
}
