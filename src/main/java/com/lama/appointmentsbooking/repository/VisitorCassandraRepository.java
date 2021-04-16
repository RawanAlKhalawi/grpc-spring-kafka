package com.lama.appointmentsbooking.repository;

import com.lama.appointmentsbooking.model.Visitor;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitorCassandraRepository extends CassandraRepository<Visitor, UUID> {
}
