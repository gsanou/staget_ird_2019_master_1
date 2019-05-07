package my_Cvterm;

public class Cv_Terms {
private String cvterm_uri;
private String uniquename;
private Cv vocab_origine;
//private Phenotype phenotype;
//private Phene phene;
//private Entity entity;
//private Quality quality;


public Cv_Terms() {}

public Cv_Terms(String cvt, String name, Cv vocab ) {
	this.setCvterm_uri(cvt);
	this.setUniquename(name);
	this.setVocab_origine(vocab);
}

public String getCvterm_uri() {
	return cvterm_uri;
}


public void setCvterm_uri(String cvterm_uri) {
	this.cvterm_uri = cvterm_uri;
}


public String getUniquename() {
	return uniquename;
}


public void setUniquename(String uniquename) {
	this.uniquename = uniquename;
}


public Cv getVocab_origine() {
	return vocab_origine;
}


public void setVocab_origine(Cv vocab_origine) {
	this.vocab_origine = vocab_origine;
}

@Override
public String toString() {
	return "Cv_Terms [cvterm_uri=" + cvterm_uri + ", name=" + uniquename + ", vocab_origine=" + vocab_origine.getNamespace()
			+ "]";
}

}
