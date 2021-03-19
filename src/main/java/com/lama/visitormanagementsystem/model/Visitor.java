package com.lama.visitormanagementsystem.model;

import com.lama.visitormanagementsystem.HostPosition;
import com.lama.visitormanagementsystem.VisitReason;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Visitor {

    @PrimaryKey
    private UUID uuid = UUID.randomUUID();

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private VisitReason visitReason;

    @Column
    private Timestamp visitTimeDate;

    @Column
    private String mobileNumber;

    @Column
    private HostPosition hostName;
}
