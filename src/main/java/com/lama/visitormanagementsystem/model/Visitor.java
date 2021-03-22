package com.lama.visitormanagementsystem.model;

import com.lama.visitormanagementsystem.HostPosition;
import com.lama.visitormanagementsystem.VisitReason;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.google.protobuf.Timestamp;
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
    private String visitTimeDate;

    @Column
    private String mobileNumber;

    @Column
    private HostPosition hostName;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public VisitReason getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(VisitReason visitReason) {
        this.visitReason = visitReason;
    }

    public String getVisitTimeDate() {
        return visitTimeDate;
    }

    public void setVisitTimeDate(String visitTimeDate) {
        this.visitTimeDate = visitTimeDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public HostPosition getHostName() {
        return hostName;
    }

    public void setHostName(HostPosition hostName) {
        this.hostName = hostName;
    }
}
