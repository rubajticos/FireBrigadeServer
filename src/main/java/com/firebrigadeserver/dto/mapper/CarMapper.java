package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.CarDTO;
import com.firebrigadeserver.entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarMapper implements Mapper<Car, CarDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Car dtoToEntity(CarDTO dto) {
        Car car = modelMapper.map(dto, Car.class);
        return car;
    }

    @Override
    public List<Car> dtoListToEntityList(List<CarDTO> dtoList) {
        List<Car> entityList = new ArrayList<>();
        dtoList.forEach(carDTO -> entityList.add(dtoToEntity(carDTO)));
        return entityList;
    }

    @Override
    public CarDTO entityToDto(Car entity) {
        CarDTO carDTO = modelMapper.map(entity, CarDTO.class);
        return carDTO;
    }

    @Override
    public List<CarDTO> entityListToDtoList(List<Car> entityList) {
        List<CarDTO> dtoList = new ArrayList<>();
        entityList.forEach(firefighter -> dtoList.add(entityToDto(firefighter)));
        return dtoList;
    }


}
