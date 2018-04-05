package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserMapper implements Mapper<User, UserDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User dtoToEntity(UserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        return user;
    }

    @Override
    public List<User> dtoListToEntityList(List<UserDTO> dtoList) {
        List<User> entityList = new ArrayList<>();
        dtoList.forEach(userDto -> entityList.add(dtoToEntity(userDto)));
        return entityList;
    }

    @Override
    public UserDTO entityToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public List<UserDTO> entityListToDtoList(List<User> entityList) {
        List<UserDTO> dtoList = new ArrayList<>();
        entityList.forEach(user -> dtoList.add(entityToDto(user)));
        return dtoList;
    }

}
