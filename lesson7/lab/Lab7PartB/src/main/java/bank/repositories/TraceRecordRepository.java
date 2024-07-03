package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.TraceRecord;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TraceRecordRepository extends JpaRepository<TraceRecord, Long> {
    default void saveTraceRecord(TraceRecord traceRecord) {
        save(traceRecord);
    }
}