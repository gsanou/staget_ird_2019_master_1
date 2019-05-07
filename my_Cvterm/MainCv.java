package my_Cvterm;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

public class MainCv {

	public static final String NL = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		
		//Endpoint Sparql de flopo
				String service_ep = "http://semantics.senckenberg.de/sparql";
				
				//Espace de Nom utilisés: URI
				String flopo = "PREFIX  FLOPO: <http://purl.obolibrary.org/obo/FLOPO_>"+NL ;
				String  ro = "PREFIX RO:  <http://purl.obolibrary.org/obo/RO_> "+NL ;
				String  rdfs = "PREFIX rdfs:  <http://www.w3.org/2000/01/rdf-schema#> "+NL ;
				String  dwc = "PREFIX  dwc: <http://rs.tdwg.org/dwc/terms/>"+NL ;
				String  gbifvoc = "PREFIX gbifvoc:  <http://rs.gbif.org/vocabulary/gbif/rank/>"+ NL;
				String obo = "PREFIX obo: <http://purl.obolibrary.org/obo/>" + NL;
				String  rdf=   "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+ NL;
				String  owl = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" ;
				
			
				
				//Réquêtes 
				String query1 = flopo + ro + rdfs + dwc + gbifvoc + rdf + owl + obo +NL+
						"SELECT  * WHERE  {\n" + 
						" GRAPH <http://semantics.senckenberg.de/flopo> \n" + 
						"{\n" + 
						"?taxon rdfs:label ?species_name;\n" + 
						"?p ?flopo_term.\n" + 
						"?flopo_term rdfs:label ?trait;\n" + 
						" owl:equivalentClass ?bnodeEq.\n" + 
						"?bnodeEq owl:onProperty obo:BFO_0000051;\n" + 
						"owl:someValuesFrom ?bnodeSomeVal.\n" + 
						"?bnodeSomeVal owl:intersectionOf ?bnodeInter.\n" + 
						"?bnodeInter rdf:first ?po_term ;\n" + 
						"rdf:rest ?bnodeRest.\n" + 
						"?bnodeRest rdf:first ?bnodefirst.\n" + 
						"?bnodefirst owl:someValuesFrom ?pato_term;\n" + 
						"owl:onProperty RO:0000053.\n" + 
						" }\n" + 
						"}";
				
				
				
				String query2 = flopo + ro + rdfs + dwc + gbifvoc + rdf + obo +NL+
						"select distinct ?trait ?taxon_uri ?taxonRank ?species_name where{\n" + 
						"GRAPH <http://semantics.senckenberg.de/flopo> \n" + 
						"{\n" + 
						"?taxon_uri obo:TAXRANK_1000000 ?taxrank_uri;\n" + 
						"rdfs:label ?species_name;\n" + 
						" dwc:taxonRank  ?taxonRank ; \n" + 
						"RO:0002200 ?flopo_term  .\n" + 
						"?flopo_term rdfs:label ?trait. \n" + 
						"} }	";	
				
				
				
				//Resultats Requêtes
				QueryExecution qe = QueryExecutionFactory.sparqlService(service_ep, query1);
				 
				QueryExecution qe2 = QueryExecutionFactory.sparqlService(service_ep, query2);
				QuerySolution sol = null ;
				QuerySolution sol2 = null ;
				 
				 
				 
				// Creation d'objets
				Phenotype phenotype = new Phenotype ();
				Taxon taxon = new Taxon();
				Cv cv = new Cv();
				Cv_Terms cvterms= new Cv_Terms();
				Cv cv_pato = new Cv();
				Cv_Terms cvterms_pato= new Cv_Terms();
				Cv cv_po = new Cv();
				Cv_Terms cvterms_po= new Cv_Terms();
				Phene phene = new Phene ();
				Quality quality = new Quality();
				Entity entity = new Entity();
				
				
			 	for (ResultSet rs2 = qe2.execSelect(); 
						rs2.hasNext();) {
					sol2= rs2.nextSolution();
					Resource taxon_uri = sol2.getResource("taxon_uri");
					Resource taxonRank = sol2.getResource("taxonRank");
					Literal taxon_name = sol2.getLiteral("species_name");
					Literal trait = sol2.getLiteral("trait");
					
					taxon.setTaxon_uri(taxon_uri.getURI());
					taxon.setTaxon_name(taxon_name.toString());
					taxon.setTaxon_rank(taxonRank.getLocalName());
					//taxon.setPhenotype(phenotype);
					//System.out.println(taxon);
					}
				
				
				
				for (ResultSet rs = qe.execSelect(); 
						rs.hasNext();) {
					 	sol= rs.nextSolution();	 
					 	
					 	//Variables
					 	Resource flopo_term = sol.getResource("flopo_term");
						Resource pato_term = sol.getResource("pato_term");
						Resource po_term = sol.getResource("po_term");
						Literal trait = sol.getLiteral("trait");
						
						
						
						//System.out.println(trait.toString().matches("(.*)phenotype(.*)"));
						
					 	//FLOPO
					 	cv.setNamespace(flopo_term.getNameSpace());
					 	cvterms.setCvterm_uri(flopo_term.getURI());
					 	cvterms.setUniquename(trait.toString());
					 	cvterms.setVocab_origine(cv);
					 	cv.addTerms(cvterms);
					 	
					 	//PATO
					 	cv_pato.setNamespace(pato_term.getNameSpace());
					 	cvterms_pato.setCvterm_uri(pato_term.getURI());
					 	//cvterms_pato.setUniquename(trait.toString());
					 	cvterms_pato.setVocab_origine(cv_pato);
					 	cv_pato.addTerms(cvterms_pato);
					 	quality.addTerms(cvterms_pato);
					 	quality.getDescription();
					 	//quality.printQuality();
					 	
					 	//PO 
					 	cv_po.setNamespace(po_term.getNameSpace());
					 	cvterms_po.setCvterm_uri(po_term.getURI());
					 	//cvterms_po.setUniquename(trait.toString());
					 	cvterms_po.setVocab_origine(cv_po);
					 	cv_po.addTerms(cvterms_po);
					 	entity.addTerms(cvterms_po);
					 	//entity.printEntity();
					 	
					 	
					 	//Phene
					 	phene.addTerms(cvterms);
					 	phene.setEntity(entity);
					 	phene.addQuality(quality);
					 	
					 	if (trait.toString().matches("(.*)phenotype(.*)") != true) 
					 	{
					 	phene.setPhene_label(trait.toString());}
					 	//phene.printPhene();
					 	
					 	//TAXON
					 	taxon.setTaxon_name(sol2.getLiteral("species_name").toString());
					 	
					 	
					 	//Phenotype 
					 	phenotype.addPhene(phene);
					 	phenotype.addTerms(cvterms);
					 	phenotype.addTaxons(taxon);
					 	
					 	
					 	
					 	if (trait.toString().matches("(.*)phenotype(.*)") == true) {
						 	phenotype.setRdfs_label(trait.toString());
						 	}
						//phenotype.addTaxons(taxon);
					 	System.out.println(phenotype);
			 										
		}
			
					
	}
}