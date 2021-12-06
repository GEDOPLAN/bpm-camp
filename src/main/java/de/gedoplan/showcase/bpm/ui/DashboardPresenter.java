package de.gedoplan.showcase.bpm.ui;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;

@Named
@ViewScoped
public class DashboardPresenter implements Serializable {

    @Inject
    RepositoryService repositoryService;

    public List<ProcessDefinition> getProcesses() {
        return repositoryService.createProcessDefinitionQuery().active().list();
    }

}
