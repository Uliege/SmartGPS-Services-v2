package be.uliege.uce.smartgps.decode.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class Position implements Serializable {
 
	private static final long serialVersionUID = 1L;

    private Integer dspId;
    private String json;
    private Timestamp fecha;
    private Sensor sensor;


    public Position() {
    }


	public Position(Integer dspId, String json, Timestamp fecha) {
		super();
		this.dspId = dspId;
		this.json = json;
		this.fecha = fecha;                
	}


	public Integer getDspId() {
		return dspId;
	}


	public void setDspId(Integer dspId) {
		this.dspId = dspId;
	}


	public String getJson() {
		return json;
	}


	public void setJson(String json) {
		this.json = json;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public Sensor getSensor() {
		return sensor;
	}


	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}


	@Override
	public String toString() {
		return "Position [dspId=" + dspId + ", fecha=" + fecha + ", json=" + json  + ", sensor=" + sensor.toString() + "]";
	}


	 
	
}