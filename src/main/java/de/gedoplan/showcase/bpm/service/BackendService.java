package de.gedoplan.showcase.bpm.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.cdi.BusinessProcess;

@Named
@RequestScoped
public class BackendService {
    
    @Inject
    BusinessProcess businessProcess;

    public String findTechnician() {
        String place = (String) businessProcess.getVariableTyped("place").getValue();
        if (place.equals("Sanitärgebäude 1") || place.equals("Außengelände Bereich A")) {
            return "mike";
        }
        return "george";
    }

}
