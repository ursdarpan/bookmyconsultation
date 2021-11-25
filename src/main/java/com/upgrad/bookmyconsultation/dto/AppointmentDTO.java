package com.upgrad.bookmyconsultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {
    private String appointmentId;
    private String doctorId;
    private String doctorName;
    private String userId;
    private String userName;
    private String userEmailId;
    private String timeSlot;
    private String status;
    private String appointmentDate;
    private String createdDate;
    private String symptoms;
    private String priorMedicalHistory;
}
