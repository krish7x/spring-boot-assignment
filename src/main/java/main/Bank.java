package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer slno;

    private String corporate_name;

    private String payment_date;

    private Integer from_account;

    private Integer to_account;

    private Integer amount;

    private String payment_type;

    public Integer getSlno() {return slno;}
    public void setSlno(Integer slno) {this.slno = slno;}

    public String getCorporate_name() {return corporate_name;}
    public void setCorporate_name(String corporate_name) {this.corporate_name = corporate_name;}

    public String getPayment_date() {return payment_date;}
    public void setPayment_date(String corporate_name) {this.payment_date = payment_date;}

    public Integer getFrom_account() {return from_account;}
    public void setFrom_account(Integer from_account) {this.from_account = from_account;}

    public Integer getTo_account() {return to_account;}
    public void setTo_account(Integer to_account) {this.to_account = to_account;}

    public Integer getAmount() {return amount;}
    public void setAmount(Integer amount) {this.amount = amount;}

    public String getPayment_type() {return payment_type;}
    private void setPayment_type(String payment_type) {this.payment_type = payment_type;}
}
