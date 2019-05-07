package my_Cvterm;

import java.util.ArrayList;

public class Cv {
private String namespace;
private ArrayList <Cv_Terms> terms = new ArrayList <> ();

public Cv() {}

public Cv(String n) {
	this.setNamespace(n);
}

public String getNamespace() {
	return namespace;
}

public void setNamespace(String namespace) {
	this.namespace = namespace;
}

public ArrayList <Cv_Terms> getTerms() {
	return terms;
	}

public void addTerms(Cv_Terms t) {
	if (!terms.contains(t)) {
		terms.add(t);	
	}
}

//@Override
//public String toString() {
//	return "Cv [namespace=" + namespace + ", terms=" + terms + "]";
//}

}
