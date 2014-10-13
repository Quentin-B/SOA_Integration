package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "box")
@XmlSeeAlso(Parcel.class)
public class Box {

    protected float height;
    protected float width;
    protected float depth;
    protected float weight;

    public Box(){}

    public Box(float width, float height, float depth, float weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @XmlElement(name="height")
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @XmlElement(name="width")
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @XmlElement(name="depth")
    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    @XmlElement(name="weight")
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
