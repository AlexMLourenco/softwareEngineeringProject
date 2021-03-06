/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esp11.app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author manuel
 */
//@Component
@RestController
public class ApiController {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RepositoryGPS repositorygps;
    @Autowired
    private RepositoryENV repositoryenv;
    @Autowired
    private RepositoryHR repositoryhr;
    @Autowired
    private RepositoryAlarm repositoryalarms;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public String str = "";
    public final String origin_production = "http://192.168.160.103:11300";
    public final String origin_dev = "http://localhost:3000";

    String[] array = {"a1","a2","vr12"};
    @GetMapping("/version")
    public String version() throws JsonProcessingException {
        return "1.0";
    }
    
    @CrossOrigin(origins = origin_production)
    @GetMapping("/fighters/gps")
    public String fightersLocation() throws JsonProcessingException {
        /*
        Team f = restTemplate.getForObject(
        "https://opensky-network.org/api/states/all", Team.class);
        String[][] flights;
        flights = f.getString();
        int c = 0;
        for (int i = 0; i < 100; i++) {
        Plane p = new Plane(f.getTime(),flights[i][2],flights[i][0],flights[i][5], flights[i][6]);
        repository.save(p);
        if (p.getCountry().equals("Canada")){
        c++;
        }
        planes[i] = p;
        }
        log.info("count" + c);
        kafkaTemplate.send("flights", "Adicionados "+ planes.length + " novos registos de voos. Sendo "+ c+ " com origem no Canada." );
        model.addAttribute("planes", planes);
        log.info("Flights in repository:");
         */
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<String>();
        
        for (int i = 0; i < array.length;i++) {
            
            List<FighterGPS> list = repositorygps.findByName(array[i]);
            
            if(list.size() > 0){
                FighterGPS last = list.get(list.size() - 1); 
                actual.add(mapper.writeValueAsString(last));
            }
            //else{
             //   actual[i] = "{}";
            //}   
        }
       
        Object[] array = actual.toArray();
        String strr = Arrays.toString(array); 
        
        return strr;
    }
    @CrossOrigin(origins = origin_production)
    @GetMapping("/fighters/env")
    public String fightersEnvironment() throws JsonProcessingException {
       
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<String>();
        
        for (int i = 0; i < array.length;i++) {
            
            List<FighterENV> list = repositoryenv.findByName(array[i]);
            
            if(list.size() > 0){
                FighterENV last = list.get(list.size() - 1); 
                actual.add(mapper.writeValueAsString(last));
                
            }
            
        }
       
        Object[] array = actual.toArray();
        String strr = Arrays.toString(array); 
        
        return strr;
    }
    @CrossOrigin(origins = origin_production)
    @GetMapping("/fighters/hr")
    public String fightersHeartRate() throws JsonProcessingException {
       
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<String>();
        
        for (int i = 0; i < array.length;i++) {
            
            List<FighterHR> list = repositoryhr.findByName(array[i]);
            
            if(list.size() > 0){
                FighterHR last = list.get(list.size() - 1); 
                actual.add(mapper.writeValueAsString(last));
                
            }
            
        }
       
        Object[] array = actual.toArray();
        String strr = Arrays.toString(array); 
        
        return strr;
    }
    
    @CrossOrigin(origins = origin_production)
    @GetMapping("/alarms/last")
    public String alarmsLast() throws JsonProcessingException {
       
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<String>();
        
        for (int i = 0; i < array.length;i++) {
            
            List<FighterENV> list = repositoryenv.findByName(array[i]);
            List<FighterHR> list2 = repositoryhr.findByName(array[i]);
            alarm a = new alarm(array[i]);
            a.setType("CO");
            a.setState("false");
            alarm b = new alarm(array[i]);
            b.setType("HR");
            b.setState("false");
            if(list.size() > 0){
                FighterENV last = list.get(list.size() - 1);
                
                a.setDate(last.getDate());
                
                a.setValue(last.getCo());
                if (Integer.parseInt(last.getCo()) >= 25){
 
                    a.setState("true");
                   
                }
                
                
               
            }
            actual.add(mapper.writeValueAsString(a));
            if(list2.size() > 0){
                FighterHR last2 = list2.get(list2.size() - 1);
                
                b.setDate(last2.getDate());
                
                b.setValue(last2.getHr());
                if (Double.parseDouble(last2.getHr()) >= 100.0){
                   b.setState("true");
                }
                
            }    
            actual.add(mapper.writeValueAsString(b));
        }
       
        Object[] array = actual.toArray();
        String strr = Arrays.toString(array); 
        
        return strr;
    }
    @CrossOrigin(origins = origin_production)
    @GetMapping("/alarms/all")
    public String alarmsAll() throws JsonProcessingException {
       
        ObjectMapper mapper = new ObjectMapper();
        Iterable<alarm> ff = repositoryalarms.findAll();
        alarm[] fs = Iterables.toArray(ff, alarm.class);
        String[] alarm = new String[fs.length];
        for(int i =0; i < fs.length;i++){
            alarm[i] = mapper.writeValueAsString(fs[i]);
        }
        String strr = Arrays.toString(alarm);
        return strr;
    }
    @CrossOrigin(origins = origin_production)
    @GetMapping("/fighters/all")
    public String fightersINFO() throws JsonProcessingException {
       
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<>();
        
        for (int i = 0; i < array.length;i++) {
            List<FighterGPS> gps = repositorygps.findByName(array[i]);
            List<FighterENV> env = repositoryenv.findByName(array[i]);
            List<FighterHR> hr = repositoryhr.findByName(array[i]);
            
            if(gps.size() > 0){
                
                MessageFormat fighter = new MessageFormat();           
                FighterGPS lastgps = gps.get(gps.size() - 1);  
                fighter.setID(array[i]);
                fighter.setGPS(lastgps);

                if(env.size() > 0){
                    FighterENV lastenv = env.get(env.size() - 1);
                      
                    fighter.setENV(lastenv);
                }
                if(hr.size() > 0){
                    FighterHR lasthr = hr.get(hr.size() - 1);
                    fighter.setHR(lasthr);
                }   
                actual.add(mapper.writeValueAsString(fighter));
            }   
        }
        Object[] arr2 = actual.toArray();
        String send = Arrays.toString(arr2); 
        
        return send;
    }
    
    @GetMapping("/fighters/gpsInfo")
    public String fightersGPS() throws JsonProcessingException {
    
        
        ObjectMapper mapper = new ObjectMapper();
        Iterable<FighterGPS> ff = repositorygps.findAll();//.forEach(x -> log.info(x.toString()));
        FighterGPS[] fs = Iterables.toArray(ff, FighterGPS.class);
        String[] gps = new String[fs.length];
        for(int i =0; i < fs.length;i++){
            gps[i] = mapper.writeValueAsString(fs[i]);
        }
        String strr = Arrays.toString(gps);
        return strr;
    }
    
    @GetMapping("/fighters/hrInfo")
    public String fightersHR() throws JsonProcessingException {
    
        ObjectMapper mapper = new ObjectMapper();
        Iterable<FighterHR> ff = repositoryhr.findAll();//.forEach(x -> log.info(x.toString()));
        FighterHR[] fs = Iterables.toArray(ff, FighterHR.class);
        String[] hr = new String[fs.length];
        for(int i =0; i < fs.length;i++){
            hr[i] = mapper.writeValueAsString(fs[i]);
        }
        String strr = Arrays.toString(hr);
        return strr;    
    }
    
    @GetMapping("/fighters/envInfo")
    public String fightersENV() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Iterable<FighterENV> ff = repositoryenv.findAll();//.forEach(x -> log.info(x.toString()));
        FighterENV[] fs = Iterables.toArray(ff, FighterENV.class);
        String[] env = new String[fs.length];
        for(int i =0; i < fs.length;i++){
            env[i] = mapper.writeValueAsString(fs[i]);
        }
        String strr = Arrays.toString(env);
        return strr;
        
    }

    @CrossOrigin(origins = origin_production)
    @GetMapping("/dashboard")
    public String dashBoard() throws JsonProcessingException {
  
        ObjectMapper mapper = new ObjectMapper();
        List<String> actual = new ArrayList<>();
        for (int i = 0; i < array.length;i++) {
            
            List<FighterENV> env = repositoryenv.findByName(array[i]);
            FighterENV[] arrayEnv = new FighterENV[env.size()];
            arrayEnv = env.toArray(arrayEnv);
            List<FighterENV> tmpE = new ArrayList<>();
            int tmp = 0;
            for(int j = 0; j < env.size()-1;j++){
                int date = Integer.parseInt(arrayEnv[j].getDate());
                if(date >= tmp){
                    tmp = date + 300;
                    tmpE.add(arrayEnv[j]);
                }
            }
            List<FighterHR> hr = repositoryhr.findByName(array[i]);
            FighterHR[] arrayHr = new FighterHR[hr.size()];
            arrayHr = hr.toArray(arrayHr);
            List<FighterHR> tmpH = new ArrayList<>();
            tmp = 0;
            for(int j = 0; j < hr.size()-1;j++){
                int date = Integer.parseInt(arrayHr[j].getDate());
                if(date >= tmp){
                    tmp = date + 300;
                    tmpH.add(arrayHr[j]);
                }
            }
            HashMap<String, Object> board = new HashMap<String, Object>();
            
            board.put("env", tmpE);
            board.put("hr", tmpH);
            board.put("id", array[i]);
            actual.add(mapper.writeValueAsString(board));
        }
        Object[] arr2 = actual.toArray();
        String send = Arrays.toString(arr2); 
        
        return send;
        /*
        Iterable<FighterENV> ff = repositoryenv.findAll();//.forEach(x -> log.info(x.toString()));
        FighterENV[] fs = Iterables.toArray(ff, FighterENV.class);
        
        
        Iterable<FighterHR> f = repositoryhr.findAll();//.forEach(x -> log.info(x.toString()));
        FighterHR[] fs2 = Iterables.toArray(f, FighterHR.class);
        
        HashMap<String, Object> board = new HashMap<String, Object>();
        board.put("env", fs);
        board.put("hr", fs2);
        return mapper.writeValueAsString(board);
*/
    }
    
    @KafkaListener(topics = "esp11_gps", groupId = "team")
    public void listenGPS(String message) throws JsonProcessingException {
        
        JSONObject jsonObject = new JSONObject(message);
        Gson gson = new Gson();
        FighterGPS t = gson.fromJson(jsonObject.toString(), FighterGPS.class);
        //System.out.println("Received Messasge: " + t.getDate());
        //System.out.println("date: " + String.format ("%d", (int)Double.parseDouble(t.getDate())));
        t.setDate(String.format ("%d", (int)Double.parseDouble(t.getDate())));
        repositorygps.save(t);

    }
    
    @KafkaListener(topics = "esp11_hr", groupId = "team")
    public void listenHR(String message) throws JsonProcessingException {
        
        JSONObject jsonObject = new JSONObject(message);
        Gson gson = new Gson();
        FighterHR t = gson.fromJson(jsonObject.toString(), FighterHR.class);
        t.setDate(String.format ("%d", (int)Double.parseDouble(t.getDate())));
        //t.setHR(String.format ("%.1f",Double.parseDouble(t.getHr())).replace(',', '.'));
        repositoryhr.save(t);
    }
 
    @KafkaListener(topics = "esp11_env", groupId = "team")
    public void listenENV(String message) throws JsonProcessingException {
        
        JSONObject jsonObject = new JSONObject(message);
        Gson gson = new Gson();
        FighterENV t = gson.fromJson(jsonObject.toString(), FighterENV.class);
        t.setDate(String.format ("%d", (int)Double.parseDouble(t.getDate())));
        
        repositoryenv.save(t);   
    }
}
