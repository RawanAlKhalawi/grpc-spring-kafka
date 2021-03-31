package com.lama.visitormanagementsystem.repository;

import com.lama.visitormanagementsystem.model.Visitor;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface VisitorRepository extends CassandraRepository<Visitor, UUID> {
}
