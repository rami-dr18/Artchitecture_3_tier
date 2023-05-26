package Model;
public class Ordonnace {

	protected String id;
	protected String nomp;
	protected String prenomp;
	protected String nommedicament;
	protected String dosagemedicament;
	protected String cinp;
	public Ordonnace(String id, String nomp, String prenomp, String nommedicament, String dosagemedicament,
			String cinp) {
		super();
		this.id = id;
		this.nomp = nomp;
		this.prenomp = prenomp;
		this.nommedicament = nommedicament;
		this.dosagemedicament = dosagemedicament;
		this.cinp = cinp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomp() {
		return nomp;
	}
	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
	public String getPrenomp() {
		return prenomp;
	}
	public void setPrenomp(String prenomp) {
		this.prenomp = prenomp;
	}
	public String getNommedicament() {
		return nommedicament;
	}
	public void setNommedicament(String nommedicament) {
		this.nommedicament = nommedicament;
	}
	public String getDosagemedicament() {
		return dosagemedicament;
	}
	public void setDosagemedicament(String dosagemedicament) {
		this.dosagemedicament = dosagemedicament;
	}
	public String getCinp() {
		return cinp;
	}
	public void setCinp(String cinp) {
		this.cinp = cinp;
	}
	
	
}