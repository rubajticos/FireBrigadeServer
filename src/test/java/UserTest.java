import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {


    @Test
    public void createUserTest() {
        User us = new User();
        us.setUserId(1);
        us.setUsername("testUser");
        us.setPassword("testPassword");

        FireBrigade fb = new FireBrigade();
        fb.setIdFireBrigade(1);
        fb.setName("testFirebrigade");

        us.setFireBrigade(fb);

        Assert.assertNotNull(us.getUsername());
        Assert.assertNotNull(us.getPassword());
        Assert.assertNotNull(us.getUserId());
        Assert.assertNotNull(us.getFireBrigade());

    }
}
