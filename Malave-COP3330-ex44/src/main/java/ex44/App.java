package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 44 Solution
 *  Copyright 2021 Jose Malave
 */


import java.util.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.sun.tools.javac.parser.ReferenceParser;

import java.io.*;

//this one had me stuck, I took in the neccesary classes from the github link to help me.
//but when every i tried to use various example to help me with the actual coding process,
//It kept givin me errors, particularly the Json object
public class App
{
    public static void main( String[] args )
    {
        //call the JsonParser first
        JsonParser parser = new JsonParser();

        try{
            //open the json file with object
            Object obj = parser.parse(new FileReader("exercise44_input.json"));

            JsonArray empList = (JsonArray) obj;
            System.out.println( empList );
            empList.forEach(emp->parseEmpObj((JsonObject) emp));
        }

        //have catch statements ready to catch the errors
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

    }
//seperate method that was supposed to read in all of the data
    private static void parseEmpObj(JsonObject emp)
    {
        JsonObject empObj = (JsonObject) emp.get("products");
        String name = (String) empObj.get("name");
        String price = (String) empObj.get("price");
        String quantity = (String) empObj.get("quantity");
    }
}
