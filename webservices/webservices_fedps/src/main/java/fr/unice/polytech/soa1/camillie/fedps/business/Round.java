package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@XmlType
@XmlRootElement(name = "round")
public class Round {

    private String id;
    private List<Step> steps;

    public Round(){
        steps = new ArrayList<Step>();
    }

    public Round(List<Step> steps){
        this.steps=steps;
    }

    @XmlElementWrapper(name = "steps")
    @XmlElement(name = "step")
    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void addStep(Step step){
        steps.add(step);
    }

    public Optional<Step> getStep(int id){
        return steps.stream().filter(r -> r.getNumber()==id).findFirst();
    }
}
