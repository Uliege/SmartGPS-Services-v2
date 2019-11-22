/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uliege.uce.smartgps.decode.main;

import be.uliege.uce.smartgps.decode.entities.Position;
import be.uliege.uce.smartgps.decode.entities.Sensor;
import be.uliege.uce.smartgps.decode.utilities.Constants;
import be.uliege.uce.smartgps.decode.utilities.FileCustom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author GMoncayo
 */
public class Main2 {

    public static void main(String[] args) {

        List<Position> positions = Main.selectPosition(Constants.selectPositionsDevice);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat(Constants.formatDate)
                .create();

        for (Position item : positions) {
            //item.setSensor(gson.fromJson(item.getJson(), Sensor.class));
            try {
                item.setSensor(gson.fromJson(item.getJson(), Sensor.class));
            } catch (com.google.gson.JsonSyntaxException e) {
                try {
                    Gson gsonAux = new GsonBuilder()
                            .setPrettyPrinting()
                            .setDateFormat(Constants.formatDate1)
                            .create();
                    item.setSensor(gsonAux.fromJson(item.getJson(), Sensor.class));
                } catch (com.google.gson.JsonSyntaxException e1) {
                    Gson gsonAux = new GsonBuilder()
                            .setPrettyPrinting()
                            .setDateFormat(Constants.formatDateAux)
                            .create();
                    item.setSensor(gsonAux.fromJson(item.getJson(), Sensor.class));
                }
            }
            item.setJson(null);
        }

        FileCustom file = new FileCustom();
        String nomArchivo = "device1036";
        //if (file.writeFile(new Gson().toJson(positions), nomArchivo)) {
        if (file.writeFile(new GsonBuilder().setDateFormat(Constants.formatDateExport).create().toJson(positions), nomArchivo)) {
            //System.out.println(gson.toJson(positions));
        }

        System.out.println("Generación Archivos OK!!");

    }

}
