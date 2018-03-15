package dto.mapper;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    private UserMapper userMapper = new UserMapper();


    @Test
    public void entityToDtoTest() {

        User user = new User();
        user.setUserId(1);
        user.setUsername("test");
        user.setPassword("password");

        UserDTO userDTO = userMapper.entityToDto(user);

        Assert.assertEquals((Integer) user.getUserId(), userDTO.getUserId());
        Assert.assertEquals(user.getUsername(), userDTO.getUsername());
        Assert.assertEquals(user.getPassword(), userDTO.getPassword());
    }

    @Test
    public void entityToDtoNotNullTest() {

        User user = new User();
        user.setUserId(1);
        user.setUsername("test");
        user.setPassword("password");

        Assert.assertNotNull(userMapper.entityToDto(user));

    }

    @Test
    public void entityListToDtoListTest() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUsername("test" + i);
            user.setPassword("password" + i);
            users.add(user);
        }

        List<UserDTO> dtoUsers = userMapper.entityListToDtoList(users);

        for (int i = 0; i < dtoUsers.size(); i++) {
            Assert.assertEquals((Integer) users.get(i).getUserId(), dtoUsers.get(i).getUserId());
            Assert.assertEquals(users.get(i).getUsername(), dtoUsers.get(i).getUsername());
            Assert.assertEquals(users.get(i).getPassword(), dtoUsers.get(i).getPassword());
        }

    }

    @Test
    public void DtoToEntityTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUsername("ttt");
        userDTO.setPassword("pass");

        User user = userMapper.dtoToEntity(userDTO);

        Assert.assertEquals(userDTO.getUserId(), (Integer) user.getUserId());
        Assert.assertEquals(userDTO.getUsername(), user.getUsername());
        Assert.assertEquals(userDTO.getPassword(), user.getPassword());
    }

    @Test
    public void dtoListToEntityListTest() {
        List<UserDTO> dtoUsers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(1);
            userDTO.setUsername("ttt");
            userDTO.setPassword("pass");
            dtoUsers.add(userDTO);
        }

        List<User> entityUsers = userMapper.dtoListToEntityList(dtoUsers);

        for (int i = 0; i < entityUsers.size(); i++) {
            Assert.assertEquals(dtoUsers.get(i).getUserId(), (Integer) entityUsers.get(i).getUserId());
            Assert.assertEquals(dtoUsers.get(i).getUsername(), entityUsers.get(i).getUsername());
            Assert.assertEquals(dtoUsers.get(i).getPassword(), entityUsers.get(i).getPassword());
        }


    }
}
