package com.reunico.demo.rep;


import com.reunico.demo.domain.TaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskResultRepositoty extends JpaRepository<TaskResult, Long> {
}
