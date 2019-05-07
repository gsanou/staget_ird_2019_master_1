package my_Cvterm;

import java.util.ArrayList;

public class Phene {
	private String phene_label;
	private Entity entity;
	private ArrayList <Quality> qualities = new ArrayList <> (); 
	private ArrayList <Cv_Terms> decritPar = new ArrayList <> ();
	
	public Phene(){}
	
	public Phene(String p){
		this.setPhene_label(p);
	}
	
	
	public String getPhene_label() {
		return phene_label;
	}
	public void setPhene_label(String phene_label) {
		this.phene_label = phene_label;
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public ArrayList <Quality> getQuality() {
		return qualities;
		}

	public void addQuality(Quality q) {
		if (!qualities.contains(q)) {
			qualities.add(q);	
		}
	}
	
	public ArrayList <Cv_Terms> getDescription() {
		return decritPar;
		}

	public void addTerms(Cv_Terms t) {
		if (!decritPar.contains(t)) {
			decritPar.add(t);	
		}
	}
	
	
	
	public void printPhene() {
		String s =phene_label + "  IsDescribeBy  ";
		if (!decritPar.isEmpty()) {
		for (int i =0; i<decritPar.size(); ++i) 
		{
			s+= decritPar.get(i).getCvterm_uri();
			
			}
		System.out.println(s);
		}
	}

	@Override
	public String toString() {
		return "Phene [phene_label=" + phene_label + ", entity=" + entity + ", qualities=" + qualities + ", decritPar="
				+ decritPar + "]";
	}
	
}
