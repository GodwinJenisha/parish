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
        if (auditoriumRepository.existsByEventDateAndEventTimeAndStatusNot(auditoriumModel.getEventDate(), auditoriumModel.getEventTime(), "D")) {
            throw new DuplicateBookingException("A booking already exists for the provided date and time.");
        }

        // If event time is Full Day
        if (auditoriumModel.getEventTime().equalsIgnoreCase("Full Day")) {
            // Check if any bookings exist for the entire day
            if (auditoriumRepository.existsByEventDateAndStatusNot(auditoriumModel.getEventDate(), "D")) {
                throw new IllegalStateException("Cannot add booking for Full Day as the day is already fully booked.");
            }
            // Check if any other event time bookings exist for the day
            if (auditoriumRepository.existsByEventDateAndEventTimeNotAndStatusNot(auditoriumModel.getEventDate(), "Full Day", "D")) {
                throw new IllegalStateException("Cannot add Full Day booking as other bookings exist for the day.");
            }
        } else {
            // If event time is not Full Day, check if Full Day booking exists for that day
            if (auditoriumRepository.existsByEventDateAndEventTimeAndStatusNot(auditoriumModel.getEventDate(), "Full Day", "D")) {
                throw new IllegalStateException("Cannot add booking as Full Day booking already exists for the day.");
            }
        }

        // If no duplicate booking and no full day booking, proceed with creating the auditorium
        AuditoriumEntity auditoriumEntity = modelMapper.map(auditoriumModel, AuditoriumEntity.class);
        auditoriumEntity = auditoriumRepository.save(auditoriumEntity);
        return modelMapper.map(auditoriumEntity, AuditoriumModel.class);
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
        // Check if a booking already exists for the provided eventDate and eventTime
        if (auditoriumRepository.existsByEventDateAndEventTimeAndStatusNotAndIdNot(auditoriumModel.getEventDate(), auditoriumModel.getEventTime(), "D", auditoriumId)) {
            throw new DuplicateBookingException("A booking already exists for the provided date and time.");
        }

        // If event time is Full Day
        if (auditoriumModel.getEventTime().equalsIgnoreCase("Full Day")) {
            // Check if any bookings exist for the entire day
            if (auditoriumRepository.existsByEventDateAndStatusNotAndIdNot(auditoriumModel.getEventDate(), "D", auditoriumId)) {
                throw new IllegalStateException("Cannot update booking for Full Day as the day is already fully booked.");
            }
            // Check if any other event time bookings exist for the day
            if (auditoriumRepository.existsByEventDateAndEventTimeNotAndStatusNotAndIdNot(auditoriumModel.getEventDate(), "Full Day", "D", auditoriumId)) {
                throw new IllegalStateException("Cannot update Full Day booking as other bookings exist for the day.");
            }
        } else {
            // If event time is not Full Day, check if Full Day booking exists for that day
            if (auditoriumRepository.existsByEventDateAndEventTimeAndStatusNotAndIdNot(auditoriumModel.getEventDate(), "Full Day", "D", auditoriumId)) {
                throw new IllegalStateException("Cannot update booking as Full Day booking already exists for the day.");
            }
        }

        // If no duplicate booking and no full day booking, proceed with updating the auditorium
        AuditoriumEntity auditoriumEntity = modelMapper.map(auditoriumModel, AuditoriumEntity.class);
        auditoriumEntity.setId(auditoriumId);
        auditoriumEntity = auditoriumRepository.save(auditoriumEntity);
        return modelMapper.map(auditoriumEntity, AuditoriumModel.class);
    }


    public void deleteAuditorium(Long auditoriumId){
        auditoriumRepository.deleteById(auditoriumId);
    }

//    public List<AuditoriumModel> getEventsForDate(LocalDate eventDate) {
//        return auditoriumRepository.findByEventDate(eventDate).stream()
//                .map(entity -> modelMapper.map(entity, AuditoriumModel.class))
//                .collect(Collectors.toList());
//    }
}