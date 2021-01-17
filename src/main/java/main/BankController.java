package main;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;


//import java.util.HashMap;

//@Controller
public class BankController {
    //@Autowired

    private BankRepository bankRepository;

//    @GetMapping(path = "/run")
    public void addDetails() {
//        JSONArray jsonArray = new JSONArray();
//        for(String id : MainApplication.payment_details.keySet()){
//            HashMap userDetails;
//            userDetails = MainApplication.payment_details.get(id);
//            JSONObject json = new JSONObject(userDetails);
//            jsonArray.put(json);
//        }
//
//        System.out.println("\n\n Values stored as Json Array\n");
//        try {
//           for(int i = 0; i < jsonArray.length(); i++) {
//               System.out.println(jsonArray.get(i));
//           }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        Bank bank = new Bank();

        for(int i = 0; i < MainApplication.sl_no.size(); i++) {
            bank.setSlno(MainApplication.sl_no.get(i));
        }

        for(int i = 0; i < MainApplication.sl_no.size(); i++) {
            bank.setCorporate_name(MainApplication.corp_name);
        }

        for(int i = 0; i < MainApplication.payment_date.size(); i++) {
            bank.setPayment_date(MainApplication.payment_date.get(i));
        }

        for(int i = 0; i < MainApplication.from_account.size(); i++) {
            bank.setFrom_account(MainApplication.from_account.get(i));
        }

        for(int i = 0; i < MainApplication.to_account.size(); i++) {
            bank.setTo_account(MainApplication.to_account.get(i));
        }

        for(int i = 0; i < MainApplication.amount.size(); i++) {
            bank.setAmount(MainApplication.amount.get(i));
        }

        for(int i = 0; i < MainApplication.payment_type.size(); i++) {
           bank.setPayment_type(MainApplication.payment_type.get(i));
        }



    }
}
