package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AuditoriumEntity;
import com.newwayus.parishpro.exception.DuplicateBookingException;
import com.newwayus.parishpro.model.AuditoriumModel;
import com.newwayus.parishpro.repository.AuditoriumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditoriumService {


    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AuditoriumModel createAuditorium(AuditoriumModel auditoriumModel) {
        // Check if a booking already exists for the provided eventDate and eventTime
        if (auditoriumRepository.existsByEventDateAndEventTime(auditoriumModel.getEventDate(), auditoriumModel.getEventTime())) {
            throw new DuplicateBookingException("A booking already exists for the provided date and time.");
        }

        // If no duplicate booking, proceed with creating the auditorium
        AuditoriumEntity auditoriumEntity = modelMapper.map(auditoriumModel, AuditoriumEntity.class);
        auditoriumEntity = auditoriumRepository.save(auditoriumEntity);
        return modelMapper.map(auditoriumEntity, AuditoriumModel.class);
    }

    private boolean isDuplicateBooking(AuditoriumModel auditoriumModel) {
        // Query the database to check for existing bookings with the same event time on the selected date
        LocalDate eventDate = auditoriumModel.getEventDate();
        String eventTime = auditoriumModel.getEventTime();
        return auditoriumRepository.existsByEventDateAndEventTime(eventDate, eventTime);
    }

    public List<AuditoriumModel> getAllAuditorium(){
        return auditoriumRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, AuditoriumModel.class))
                .collect(Collectors.toList());
    }

    public AuditoriumModel getAuditoriumById(Long auditoriumId){
        return auditoriumRepository.findById(auditoriumId)
                .map(entity -> modelMapper.map(entity, AuditoriumModel.class))
                .orElse(null);
    }

    public AuditoriumModel updateAuditorium(Long auditoriumId, AuditoriumModel auditoriumModel){
        AuditoriumEntity auditoriumEntity = modelMapper.map(auditoriumModel, AuditoriumEntity.class);
        auditoriumEntity.setId(auditoriumId);
        auditoriumEntity = auditoriumRepository.save(auditoriumEntity);
        return modelMapper.map(auditoriumEntity, AuditoriumModel.class);
    }

    public void deleteAuditorium(Long auditoriumId){
        auditoriumRepository.deleteById(auditoriumId);
    }
}