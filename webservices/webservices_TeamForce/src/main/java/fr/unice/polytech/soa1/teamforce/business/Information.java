package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;

/**
 * Created by suparjam on 08/10/2014.
 */
public class Information {
    private String callDate;
    private String question;
    private String answer;

    public Information(String callDate, String question, String answer) {
        this.callDate = callDate;
        this.question = question;
        this.answer = answer;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public JSONObject toJSON(){
        JSONObject jso = new JSONObject();
        jso.put("callDate",callDate);
        jso.put("question",question);
        jso.put("answer",answer);
        return jso;
    }
}
