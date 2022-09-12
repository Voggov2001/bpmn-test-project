package com.reunico.demo.camunda;

import com.reunico.demo.domain.TaskResult;
import com.reunico.demo.enums.TypeTask;
import com.reunico.demo.rep.TaskResultRepositoty;
import lombok.Data;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Data
public class ServiceTask implements JavaDelegate {


    private int postValue;

    @Autowired
    private final TaskResultRepositoty resultRepositoty;

    public ServiceTask(TaskResultRepositoty resultRepositoty) {
        this.resultRepositoty = resultRepositoty;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TaskResult result = null;
        postValue = (int) delegateExecution.getVariable("postValue");
        int randomData = (int) (Math.random() * 100);

        if (postValue + randomData >= 100) {
            result = createResult(postValue, randomData, TypeTask.TASK_A);

        } else if (postValue + randomData < 100) {
            result = createResult(postValue, randomData, TypeTask.TASK_B);
        }
        if (result.getPostValue() == null) {
            throw new NullPointerException();
        } else {
            delegateExecution.setVariable("postValue", result.getPostValue());
            delegateExecution.setVariable("randomData", result.getRandomData());
            delegateExecution.setVariable("sumValues", result.getSumPVandRandD());
            delegateExecution.setVariable("typeTask", result.getTypeTask().getName());

        }
    }

    @Transactional
    TaskResult createResult(int postValue, int randomData, TypeTask typeTask) {
        TaskResult result = TaskResult.builder()
                .postValue(postValue)
                .randomData(randomData)
                .sumPVandRandD(postValue + randomData)
                .typeTask(typeTask)
                .build();
        resultRepositoty.save(result);
        System.out.println(result.getId());
        return result;

    }
}
