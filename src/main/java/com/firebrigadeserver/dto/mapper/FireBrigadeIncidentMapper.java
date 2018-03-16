package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FireBrigadeIncidentDTO;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FireBrigadeIncidentMapper implements Mapper<FirebrigadeIncident, FireBrigadeIncidentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public FirebrigadeIncident dtoToEntity(FireBrigadeIncidentDTO dto) {
        return null;
    }

    private Date convertStringToDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }

    @Override
    public List<FirebrigadeIncident> dtoListToEntityList(List<FireBrigadeIncidentDTO> dtoList) {
        return null;
    }

    @Override
    public FireBrigadeIncidentDTO entityToDto(FirebrigadeIncident entity) {
        FireBrigadeIncidentDTO fireBrigadeIncidentDTO = modelMapper.map(entity, FireBrigadeIncidentDTO.class);
        fireBrigadeIncidentDTO.setFirebrigadeId(entity.getFireBrigade().getIdFireBrigade());
        fireBrigadeIncidentDTO.setIndcidentId(entity.getIncident().getId());
        fireBrigadeIncidentDTO.setDate(convertDateToString(entity.getDateTimeOfAlarm()));

        return fireBrigadeIncidentDTO;
    }

    private String convertDateToString(Date date) {
        return dateFormat.format(date).toString();
    }

    @Override
    public List<FireBrigadeIncidentDTO> entityListToDtoList(List<FirebrigadeIncident> entityList) {
        List<FireBrigadeIncidentDTO> fireBrigadeIncidentDTOS = new ArrayList<>();
        for (FirebrigadeIncident f : entityList) {
            FireBrigadeIncidentDTO fireBrigadeIncidentDTO = entityToDto(f);
            fireBrigadeIncidentDTOS.add(fireBrigadeIncidentDTO);
        }
        return fireBrigadeIncidentDTOS;
    }
}
