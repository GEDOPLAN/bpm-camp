package de.gedoplan.showcase.bpm.ui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.RepositoryService;

@Named
@RequestScoped
public class ProcessPresenter {
    
    @Inject
    RepositoryService repositoryService;
    
    public String getProcessName(String procDefKey) {
        return repositoryService.createProcessDefinitionQuery().processDefinitionKey(procDefKey).singleResult().getName();
    }

}
