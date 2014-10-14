package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output;

import fr.unice.polytech.soa1.camillie.fedps.business.Quote;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType
public class QuotesList extends CustomerJobResult {

    private List<Quote> quotes;
    private int number;

    public QuotesList() {
        quotes = new ArrayList<Quote>();
    }

    @XmlElementWrapper(name = "quotes")
    @XmlElement(name = "quote")
    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
        this.number = quotes.size();
    }

    @XmlAttribute(name = "nbQuotes")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void add(Quote quote) {
        if (quote != null) {
            this.quotes.add(quote);
            number++;
        }
    }
}
