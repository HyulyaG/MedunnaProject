package utilities;

import pojos.Appointment;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void saveAppointData(Appointment appointment){

        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(appointment+"\n");


            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void saveNegativeData(Appointment appointment){

        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_negative_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(appointment+"\n");


            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }



}
