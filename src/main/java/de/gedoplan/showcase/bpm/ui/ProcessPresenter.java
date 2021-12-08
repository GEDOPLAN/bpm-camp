package de.gedoplan.showcase.bpm.ui;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.history.HistoricProcessInstance;

@Named
@RequestScoped
public class ProcessPresenter {
    
    @Inject
    RepositoryService repositoryService;

    @Inject
    private HistoryService historyService;
    
    public String getProcessName(String procDefKey) {
        return repositoryService.createProcessDefinitionQuery().processDefinitionKey(procDefKey).singleResult().getName();
    }

    public List<HistoricProcessInstance> getHistory() {
        return historyService.createHistoricProcessInstanceQuery().processDefinitionKey("issueManagement").list();
    }
    
    public String getInfo(String procInstId) {
        var infoText = new StringBuilder();
        var variables = historyService.createHistoricVariableInstanceQuery().processInstanceId(procInstId).list();
        variables.stream().filter(variable -> variable.getName().equals("description"))
                .findFirst().ifPresent(variable -> infoText.append(variable.getValue()));
        infoText.append(" (");
        variables.stream().filter(variable -> variable.getName().equals("place"))
                .findFirst().ifPresent(variable -> infoText.append(variable.getValue()));
        infoText.append(")");
        variables.stream().filter(variable -> variable.getName().equals("notes"))
                .findFirst().ifPresent(variable -> infoText.append(" - ").append(variable.getValue()));
        return infoText.toString();
    }

}
