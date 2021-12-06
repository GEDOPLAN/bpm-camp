package de.gedoplan.showcase.bpm.ui;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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

    private ResourceBundle bundle;
    
    @PostConstruct
    void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        bundle = facesContext.getApplication().getResourceBundle(facesContext, "ui");
    }

    public List<ProcessDefinition> getProcesses() {
        return repositoryService.createProcessDefinitionQuery().active().list();
    }

    public String getStartButtonText(ProcessDefinition processDefinition) {
        return bundle.getString("start.button.text." + processDefinition.getKey());
    }

    public String startProcess(ProcessDefinition processDefinition) {
        return "start-" + processDefinition.getKey();
    }

}
