package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {

    public static String[] encrypt(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<String> sArray, int key0) {
        
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < arr1.size(); i++) {
            sum1 += arr1.get(i) % 128;
        }

        for(int i = 0; i < arr2.size(); i++) {
            sum2 += arr2.get(i) % 128;
        }

        int key1 = sum1 / arr1.size();
        int key2 = sum2 / arr2.size();

        int masterKey = (key0 % 128) + key1 + key2;
        
        String coded[] = new String[sArray.size()];

        if(masterKey == 0) {
        	for(int i = 0; i < sArray.size(); i++) {
        		coded[i] = sArray.get(i);
        	}
        	return coded;
        }

        String tmp, tmpCoded;
        char c;

        for(int i = 0; i < sArray.size(); i++) {
        	tmpCoded = "";
            tmp = sArray.get(i);
            if(tmp == null)
                coded[i] = null;
            else {
                for(int j = 0; j < tmp.length(); j++) {
                    c = (char)(((int)tmp.charAt(j) + masterKey) / 2);
                    tmpCoded += c;
                }
                coded[i] = tmpCoded;
            }
        }
        return coded;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            /*java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String input2 = req.queryParams("input2").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(input2);

            boolean result = App.search(inputList, input2AsInt);
            */

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            ArrayList<Integer> inputList1 = new ArrayList<>();
            while(sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }
            sc1.close();

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            ArrayList<Integer> inputList2 = new ArrayList<>();
            while(sc2.hasNext()) {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            sc2.close();

            String input3 = req.queryParams("input3");
            java.util.Scanner sc3 = new java.util.Scanner(input3);
            ArrayList<String> stringInputList = new ArrayList<>();
            while(sc3.hasNext()) {
                String value = sc3.nextLine();
                stringInputList.add(value);
            }
            sc3.close();

            String input4 = req.queryParams("input4");
            java.util.Scanner sc4 = new java.util.Scanner(input4);
            sc4.useDelimiter("[;\r\n]+");
            int intInput = Integer.parseInt(sc4.next().replaceAll("\\s",""));
            sc4.close();

            String[] result = App.encrypt(inputList1, inputList2, stringInputList, intInput);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
                Map map = new HashMap();
                map.put("result", "not computed yet!");
                return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
