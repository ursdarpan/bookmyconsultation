package com.upgrad.bookmyconsultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDTO {
    private String id;
    private String appointmentId;
    private String doctorId;
    private int rating;
    private String comments;
}
