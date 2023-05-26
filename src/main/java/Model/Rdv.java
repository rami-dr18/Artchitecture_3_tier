package Model;

public class Rdv {
	protected String id;
	protected String daterdv;
	protected String cinp;
	public Rdv(String id, String daterdv, String cinp) {
		super();
		this.id = id;
		this.daterdv = daterdv;
		this.cinp = cinp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDaterdv() {
		return daterdv;
	}
	public void setDaterdv(String daterdv) {
		this.daterdv = daterdv;
	}
	public String getCinp() {
		return cinp;
	}
	public void setCinp(String cinp) {
		this.cinp = cinp;
	}
	
}
