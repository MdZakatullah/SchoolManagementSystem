package com.zak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zak.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}