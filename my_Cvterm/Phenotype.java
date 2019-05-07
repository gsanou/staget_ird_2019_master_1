package my_Cvterm;

import java.util.ArrayList;

public class Phenotype {
	private String rdfs_label;
	private ArrayList <Taxon> taxons = new ArrayList <> ();
	private ArrayList <Cv_Terms> decritPar = new ArrayList <> ();
	private ArrayList <Phene> phenes = new ArrayList<> ();
	
	public Phenotype() {}
	
	public Phenotype (String r) {
		this.setRdfs_label(r);
	}

	public String getRdfs_label() {
		return rdfs_label;
	}

	public void setRdfs_label(String rdfs_label) {
		this.rdfs_label = rdfs_label;
	}
	public ArrayList <Cv_Terms> getDescription() {
		return decritPar;
		}

	public void addTerms(Cv_Terms t) {
		if (!decritPar.contains(t)) 
		{
			decritPar.add(t);	
		}
	}
	
	public ArrayList <Taxon> getTaxon() {
		return taxons;
		}

	public void addTaxons(Taxon t) {
		if (!taxons.contains(t)) {
			taxons.add(t);	
		}
	}
	
	public ArrayList <Phene> getPhene() {
		return phenes;
		}

	public void addPhene(Phene p) {
		if (!phenes.contains(p)) 
		{
			phenes.add(p);
		}
	}
	
	
	public void printPhenotype() {
		String s= rdfs_label;
		if (!phenes.isEmpty()) {
			 s+= " isDescribedBy ";
			for (int i =0; i<decritPar.size(); ++i) {
				s+= decritPar.get(i) ;
			}
		}
//		if (!decritPar.isEmpty()) {
//		for (int j =0 ; j < phenes.size(); ++j) {
//			s+= " isComposedwith " +phenes.get(j).getPhene_label();
//		}
//		}
		
		
		if (!taxons.isEmpty()) {
			s+= " isAphenotypeOf ";
			for (int i =0 ; i<taxons.size() ; ++i) {
				s+= taxons.get(i).getTaxon_name();
			}
		}
		else {
			s+= "  no taxons yet  ";
		}
		System.out.println(s);
		
	}

	@Override
	public String toString() {
		return "Phenotype [label=" + rdfs_label + ", taxons=" + taxons + ", decritPar=" + decritPar + "]"; //+ ", phenes="
				//+ phenes + "]";
	}
}
