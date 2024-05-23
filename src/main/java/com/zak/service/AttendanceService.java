package com.zak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zak.entity.Attendance;
import com.zak.repository.AttendanceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
	
    @Autowired
    private AttendanceRepository repository;

    public List<Attendance> getAllAttendances() {
        return repository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return repository.findById(id);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }
}
