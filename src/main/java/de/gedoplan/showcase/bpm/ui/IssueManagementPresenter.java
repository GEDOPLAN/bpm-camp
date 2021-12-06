package de.gedoplan.showcase.bpm.ui;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@RequestScoped
public class IssueManagementPresenter {
    
    public List<SelectItem> getPlacesAsSelectItems() {
        var items = new ArrayList<SelectItem>();
        items.add(new SelectItem("Sanitärgebäude 1"));
        items.add(new SelectItem("Sanitärgebäude 2"));
        items.add(new SelectItem("Außengelände Bereich A"));
        items.add(new SelectItem("Außengelände Bereich B"));
        items.add(new SelectItem("Zufahrt Campingplatz"));
        return items;
    }

}
