package de.gedoplan.showcase.bpm.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.cdi.BusinessProcess;

@Named
@ConversationScoped
public class IssueManagementPresenter implements Serializable {

    @Inject
    private BusinessProcess businessProcess;

    @Inject
    private Conversation conversation;
    
    public List<SelectItem> getPlacesAsSelectItems() {
        var items = new ArrayList<SelectItem>();
        items.add(new SelectItem("Sanitärgebäude 1"));
        items.add(new SelectItem("Sanitärgebäude 2"));
        items.add(new SelectItem("Außengelände Bereich A"));
        items.add(new SelectItem("Außengelände Bereich B"));
        items.add(new SelectItem("Zufahrt Campingplatz"));
        return items;
    }

    public String getNotes() {
        var variable = businessProcess.getVariableTyped("notes");
        if (variable != null) {
            return (String) variable.getValue();
        }
        return null;
    }

    public void setNotes(String notes) {
        businessProcess.setVariable("notes", notes);
    }

    public String abort() {
        conversation.end();
        return "stuff";
    }

}
