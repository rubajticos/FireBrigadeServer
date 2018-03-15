package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper implements Mapper<User, UserDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User DtoToEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO EntityToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
