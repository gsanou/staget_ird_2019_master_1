package my_Cvterm;

public class Taxon {
	private String taxon_name;
	private String taxon_uri;
	private String taxon_rank;
	private Phenotype Phenotype;
	
	public Taxon() {}
	
	public Taxon(String tn, String tu, String tr,Phenotype p) {
		
		this.setTaxon_name(tn);
		this.setTaxon_uri(tu);
		this.setTaxon_rank(tr);
		this.Phenotype=p;
	}

	public String getTaxon_name() {
		return taxon_name;
	}

	public void setTaxon_name(String taxon_name) {
		this.taxon_name = taxon_name;
	}

	public String getTaxon_uri() {
		return taxon_uri;
	}

	public void setTaxon_uri(String taxon_uri) {
		this.taxon_uri = taxon_uri;
	}

	public String getTaxon_rank() {
		return taxon_rank;
	}

	public void setTaxon_rank(String taxon_rank) {
		this.taxon_rank = taxon_rank;
	}

	public Phenotype getPhenotype() {
		return Phenotype;
	}

	public void setPhenotype(Phenotype phenotype) {
		Phenotype = phenotype;
	}
	
	
	@Override
	public String toString() {
		String s= "Taxon [taxoon_name =" + taxon_name + ", taxon_uri=" + taxon_uri + ", taxonrank=" + taxon_rank + "\n\t ";
		if (Phenotype != null) {
			s+= "Phenotype = " + Phenotype.getRdfs_label() +"]";
		}				
		return s;
	}
	

}
