package com.recouvrex.process.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="task")
public class Task extends BaseEntity{

    private LocalDateTime startDate;
    private LocalDateTime enDate;
    private LocalDateTime createdOn;
    private LocalDateTime ScheduledTo;
    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case cas;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
   /* @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;*/
    private String taskObject;

}
