package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
public class Address {


    private String line1;
    private String line2;
    private String zip;
    private String city;
    private Kind kind;

    public Address(String line1, String line2, String zip, String city, Kind kind) {

        this.line1 = line1;
        this.line2 = line2;
        this.zip = zip;
        this.city = city;
        this.kind = kind;
    }





    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public JSONObject toJSON()
    {
        JSONObject jso = new JSONObject();
        jso.put("line1",line1);
        jso.put("line2",line2);
        jso.put("zip",zip);
        jso.put("city",city);
        jso.put("kind",kind);
        return jso;
    }
}
