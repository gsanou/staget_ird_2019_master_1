package my_Cvterm;

import java.util.ArrayList;

public class Entity {
	//private Phene phene;
	private ArrayList <Cv_Terms> decritPar = new ArrayList <> ();
	
	
	public Entity() {}
	
	public ArrayList <Cv_Terms> getDescription() {
		return decritPar;
		}

	public void addTerms(Cv_Terms t) {
		if (!decritPar.contains(t)) {
			decritPar.add(t);	
		}
	}
	
	public void printEntity() {
		for (int i =0; i<decritPar.size(); ++i) {
			System.out.println(decritPar.get(i).getCvterm_uri());
		}
	}

	@Override
	public String toString() {
		return "Entity [isDescribeBy=" + decritPar + "]";
	}

}
