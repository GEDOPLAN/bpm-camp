package de.gedoplan.showcase.bpm.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;

@Named
@ViewScoped
public class TaskListPresenter implements Serializable {
    
    @Inject
    private TaskService taskService;

    public List<Task> getTasks() {
        var principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        return taskService.createTaskQuery().taskAssignee(principal.getName()).list();
    }

    public String getVariable(Task task, String variable) {
        return (String) taskService.getVariableTyped(task.getId(), variable).getValue();
    }

}
