import com.htsc.dao.IUserDao;
import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVolds;
import com.htsc.domain.Role;
import com.htsc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private IUserDao userDao;
    private InputStream in;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void testFindone() {
        User user = userDao.findByID(41);
        System.out.println(user);
        Assert.assertEquals("张三",user.getUserName());
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("华泰");
        user.setUserAddress("南京市江宁区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        int affectedRows = userDao.saveUser(user);
        Assert.assertEquals(1, affectedRows);

        User saveUser = userDao.findByID(user.getUserId());
        Assert.assertEquals("华泰",saveUser.getUserName());
    }

    @Test
    public void testUpdate() {
        int id=41;
        User user = userDao.findByID(id);
        user.setUserAddress("宣城市宣州区");
        int res = userDao.updateUser(user);

        User saveUser = userDao.findByID(id);
        Assert.assertEquals("宣城市宣州区", user.getUserAddress());

        System.out.println(user.getRefAddress());
        System.out.println(saveUser.getRefAddress());
    }

    @Test
    public void testDelete() {
        int res = userDao.deleteUser(52);

        Assert.assertEquals(1,res);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");

        Assert.assertEquals(2, users.size());

        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCount() {
        int res = userDao.count();

        Assert.assertEquals(7,res);
    }

    @Test
    public void testQueryByVo() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");

        List<User> users = userDao.findByVo(vo);
        Assert.assertEquals(1,users.size());
    }

    @Test
    public void testQueryByVo_withoutAddress() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress(null);

        List<User> users = userDao.findByVo(vo);
        Assert.assertEquals(2,users.size());
    }

    @Test
    public void testFindlnlds() {
        QueryVolds volds = new QueryVolds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(45);
        ids.add(46);
        volds.setIds(ids);

        List<User> users = userDao.findlnlds(volds);

        Assert.assertEquals(4,users.size());
    }

    @After
    public void tearDown() throws Exception {
        //session.commit();
        session.close();
        in.close();
    }
}
