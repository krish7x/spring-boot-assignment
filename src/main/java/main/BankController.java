package main;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.HashMap;

@Controller
public class BankController {
    @Autowired

    private BankRepository bankRepository;

    @GetMapping(path = "/run")
    public void addDetails(){
        JSONArray jsonArray = new JSONArray();
        for(String id : MainApplication.payment_details.keySet()){
            HashMap userDetails;
            userDetails = MainApplication.payment_details.get(id);
            System.out.println(userDetails);
            JSONObject json = new JSONObject(userDetails);
            jsonArray.put(json);
        }

            System.out.println(jsonArray);


    }
}
