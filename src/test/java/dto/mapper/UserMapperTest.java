package dto.mapper;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserMapperTest {

    private UserMapper userMapper = new UserMapper();


    @Test
    public void entityToDtoTest() {

        User user = new User();
        user.setUserId(1);
        user.setUsername("test");
        user.setPassword("password");

        UserDTO userDTO = userMapper.EntityToDto(user);

        Assert.assertEquals((Integer) user.getUserId(), userDTO.getId());
        Assert.assertEquals(user.getUsername(), userDTO.getUsername());
        Assert.assertEquals(user.getPassword(), userDTO.getPassword());
    }

    @Test
    public void DtoToEntityTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUsername("ttt");
        userDTO.setPassword("pass");

        User user = userMapper.DtoToEntity(userDTO);

        Assert.assertEquals(userDTO.getId(), (Integer) user.getUserId());
        Assert.assertEquals(userDTO.getUsername(), user.getUsername());
        Assert.assertEquals(userDTO.getPassword(), user.getPassword());
    }
}
