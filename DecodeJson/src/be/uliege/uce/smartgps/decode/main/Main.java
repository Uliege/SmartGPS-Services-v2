package be.uliege.uce.smartgps.decode.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.uliege.uce.smartgps.decode.conection.ConectionDataBase;
import be.uliege.uce.smartgps.decode.entities.Position;
import be.uliege.uce.smartgps.decode.entities.Sensor;
import be.uliege.uce.smartgps.decode.utilities.Constants;
import be.uliege.uce.smartgps.decode.utilities.FileCustom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        int secuencial = 1;
        int begin = 1;
        int end = Constants.numFilas;
        int maxNumberPositions = selectMaxNumberPositions(Constants.maxNumberPositions);
        System.out.println(maxNumberPositions);

        while (true) {

            List<Position> positions = selectPosition(Constants.selectPositions, begin, end);

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
            //String nomArchivo = "data" + secuencial + "-"+rangoInferior+"-"+rangoSuperior;
            String nomArchivo = "data" + secuencial;
            //if (file.writeFile(new Gson().toJson(positions), nomArchivo)) {
            if (file.writeFile(new GsonBuilder().setDateFormat(Constants.formatDateExport).create().toJson(positions), nomArchivo)) {
                //System.out.println(gson.toJson(positions));
            }
            
            if (end > maxNumberPositions) {
                break;                
            }else{
                secuencial++;
                begin = end + 1;
                end += Constants.numFilas;
            }

        }

        System.out.println("Generación Archivos OK!!");

    }

    public static List<Position> selectPosition(String sql, int rangoInferior, int rangoSuperior) {
        try {
            List<Position> retorno = new ArrayList<>();
            ConectionDataBase mysql = new ConectionDataBase();
            Connection conn = mysql.conectionMySQL();
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, rangoInferior);
            prst.setInt(2, rangoSuperior);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                int dspId = rs.getInt("DSP_ID");
                String json = rs.getString("PSC_JSON");
                java.sql.Timestamp fecha = rs.getTimestamp("PSC_FECHA");
                retorno.add(new Position(dspId, json, fecha));
            }
            return retorno;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static List<Position> selectPosition(String sql) {
        try {

            List<Position> retorno = new ArrayList<>();

            ConectionDataBase mysql = new ConectionDataBase();
            Connection conn = mysql.conectionMySQL();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                int dspId = rs.getInt("DSP_ID");
                String json = rs.getString("PSC_JSON");
                java.sql.Timestamp fecha = rs.getTimestamp("PSC_FECHA");
                retorno.add(new Position(dspId, json, fecha));
            }
            return retorno;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static int selectMaxNumberPositions(String sql) {
        try {

            int numRows = 0;
            ConectionDataBase mysql = new ConectionDataBase();
            Connection conn = mysql.conectionMySQL();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                numRows = rs.getInt(1);
            }

            return numRows;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

}
