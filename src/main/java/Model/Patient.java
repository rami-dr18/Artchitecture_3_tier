package Model;
public class Patient {
protected String cin;
protected String nom;
protected String prenom;
protected String adresse;
protected String tel;
protected String age;
public Patient(String cin, String nom, String prenom, String adresse, String tel, String age2) {
super();
this.cin = cin;
this.nom = nom;
this.prenom = prenom;
this.adresse = adresse;
this.tel = tel;
this.age = age2;
}
public Patient(String cin, String nom, String prenom, String tel) {
super();
this.cin = cin;
this.nom = nom;
this.prenom = prenom;
this.tel = tel;
}
public String getCin() {
return cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public void setCin(String cin) {
this.cin = cin;
}
//compléter les autres méthodes
}