package com.mycompany.app;

public class App {

    public static String[] encrypt(int[] arr1, int[] arr2, String[] sArray, int key0) {
        
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i] % 128;
        }

        for(int i = 0; i < arr2.length; i++) {
            sum2 += arr2[i] % 128;
        }

        int key1 = sum1 / arr1.length;
        int key2 = sum2 / arr2.length;

        int masterKey = (key0 % 128) + key1 + key2;
        
        String coded[] = new String[sArray.length];

        if(masterKey == 0) {
        	for(int i = 0; i < sArray.length; i++) {
        		coded[i] = sArray[i];
        	}
        	return coded;
        }

        String tmp, tmpCoded;
        char c;

        for(int i = 0; i < sArray.length; i++) {
        	tmpCoded = "";
            tmp = sArray[i];
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
}
