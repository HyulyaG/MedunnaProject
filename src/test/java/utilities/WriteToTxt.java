package utilities;

import pojos.Appointment;
import pojos.AppointmentApi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {

    public static void saveAppointGetData(AppointmentApi appointmentList){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_get_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointmentList +"\n");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


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


    public static void saveAppointmentCreation(AppointmentApi appointmentApi){
        try{

            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_post_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointmentApi+"\n");
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void save_Ids(List<Object> Ids){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_id_data"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Object eachSSN: Ids) {
                writer.append(eachSSN + ",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveRegistrantData(List<Object> SSNIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Object eachSSN: SSNIds) {
                writer.append(eachSSN + ",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}



