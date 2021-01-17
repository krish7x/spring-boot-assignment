package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private String slno;

    private String corporate_name;

    private String payment_date;

    private String from_account;

    private String to_account;

    private String amount;

    private String payment_type;

    public String getSlno() {return slno;}
    public void setSlno(String slno) {this.slno = slno;}

    public String getCorporate_name() {return corporate_name;}
    public void setCorporate_name(String corporate_name) {this.corporate_name = corporate_name;}

    public String getPayment_date() {return payment_date;}
    public void setPayment_date(String corporate_name) {this.payment_date = payment_date;}

    public String getFrom_account() {return from_account;}
    public void setFrom_account(String from_account) {this.from_account = from_account;}

    public String getTo_account() {return to_account;}
    public void setTo_account(String to_account) {this.to_account = to_account;}

    public String getAmount() {return amount;}
    public void setAmount(String amount) {this.amount = amount;}

    public String getPayment_type() {return payment_type;}
    private void setPayment_type(String payment_type) {this.payment_type = payment_type;}
}
