/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

/**
 *
 * @author Christian
 */
public class BugLoader extends QueryCaseLoader{
    
   public BugLoader(){
       loadBug1();
       loadBug2();
       loadBug3small1();
       loadBug3small2();
       loadBug3small3();
       loadBug3small4();
       loadBug3Med1();
       loadBug3Med2();
       loadBug3();
   }
   
   private void loadBug1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug1";
        queryCase.name = "Bug Query 1";
        queryCase.originalQuery = "SELECT ?var1 {    \n"
                + "	SELECT ?var1 {\n"
                + "		?s ?p ?var1\n"
                + "	}\n"
                + "}";
        queries.put(queryCase.key, queryCase);
   }

   private void loadBug2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug2";
        queryCase.name = "Bug Query 2";
        queryCase.originalQuery = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "SELECT DISTINCT ?item   WHERE \n"
                + "{\n \n"
                + "    {        \n"
                + "        SELECT DISTINCT ?item ?doi \n"
                + "                 (GROUP_CONCAT(DISTINCT ?equiv_target ; SEPARATOR=' , ') AS ?target_uris) \n"
                + "                 (GROUP_CONCAT(DISTINCT ?target_name ; SEPARATOR=' , ') AS ?target_names)  {\n"
                + "             GRAPH <http://www.conceptwiki.org> {\n"
                + "                  ?cw_uri skos:prefLabel ?compound_name.\n"
                + "             }\n"
                + "        } GROUP BY ?item ?equiv_target ?doi ?target_name\n"
                + "} } ORDER BY ?item LIMIT 10 OFFSET 0";
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadBug3small1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3s1";
        queryCase.name = "Bug Query 3 small1";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         { {\n"
                + "             GRAPH <http://www.conceptwiki.org> {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "             }\n"
                + "         } } "
                + "         GROUP BY ?item \n"
                + "         ORDER BY ?item   \n"
                + "         LIMIT 10  \n"
                + "         OFFSET 0 \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

       private void loadBug3small2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3s2";
        queryCase.name = "Bug Query 2 small2";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                 + "        WHERE {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name ;\n"
                + "         } \n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         WHERE { {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "         } } "
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

  private void loadBug3small3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3s3";
        queryCase.name = "Bug Query 3 small3";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                 + "        WHERE {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name ;\n"
                + "         } \n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         WHERE { {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "         } } "
                + "         LIMIT 10  \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

  private void loadBug3small4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3s4";
        queryCase.name = "Bug Query 3 small4";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                + "        WHERE {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name ;\n"
                + "         } \n"
                + "         GROUP BY ?drug_name ?db_uri\n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         WHERE { {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "         } } "
                + "         GROUP BY ?item \n"
                + "         ORDER BY ?item   \n"
                + "         LIMIT 10  \n"
                + "         OFFSET 0 \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

   private void loadBug3Med1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3med1";
        queryCase.name = "Bug Query 3 med1";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                + "             (GROUP_CONCAT(DISTINCT ?drugType ; SEPARATOR=' , ') AS ?drugTypes) \n"
                + "         {\n"
                + "             GRAPH <http://linkedlifedata.com/resource/drugbank> {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name .\n"
                + "             }\n"
                + "         } GROUP BY ?drug_name ?db_uri\n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         { {\n"
                + "             GRAPH <http://www.conceptwiki.org> {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "             }\n"
                + "         } } "
                + "         LIMIT 10  \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadBug3Med2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bugmed23";
        queryCase.name = "Bug Query 3 med2";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                + "             (GROUP_CONCAT(DISTINCT ?drugType ; SEPARATOR=' , ') AS ?drugTypes) \n"
                + "         {\n"
                + "             GRAPH <http://linkedlifedata.com/resource/drugbank> {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name .\n"
                + "             }\n"
                + "         } GROUP BY ?drug_name ?db_uri\n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item \n"
                + "         { {\n"
                + "             GRAPH <http://www.conceptwiki.org> {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "             }\n"
                + "             GRAPH <http://www.chemspider.com> {\n"
                + "        	        ?cs_uri chemspider:smiles ?smiles .\n"
                + "             }\n"
                + "         } } "
                + "         GROUP BY ?item \n"
                + "         ORDER BY ?item   \n"
                + "         LIMIT 10  \n"
                + "         OFFSET 0 \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

   private void loadBug3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Bug3";
        queryCase.name = "Bug Query 3";
        queryCase.originalQuery = "PREFIX ops: <http://www.openphacts.org/api#>\n"
                + "PREFIX chembl: <http://rdf.farmbio.uu.se/chembl/onto/#>\n"
                + "PREFIX chembl-ops: <http://www.openphacts.org/chembl/onto/#>\n"
                + "PREFIX cito: <http://purl.org/spar/cito/>\n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/>\n"
                + "PREFIX void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX chemspider: <http://rdf.chemspider.com/#>\n"
                + "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
                + "PREFIX cheminf: <http://semanticscience.org/ontology/cheminf.owl/>\n"
                + "PREFIX qudt: <http://qudt.org/1.1/schema/qudt#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX sio: <http://semanticscience.org/resource/>\n"
                + "CONSTRUCT { \n"
                + "     [] ops:input <http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5> .\n"
                + "     ?item chembl:forMolecule ?equiv_compound ;\n"
                + "         chembl:type ?std_type ;\n"
                + "         chembl:relation ?relation ;\n"
                + "         chembl:standardValue ?std_value ;\n"
                + "         chembl:standardUnits ?std_unit ;\n"
                + "         chembl-ops:normalisedValue ?activity_value ;\n"
                + "         chembl:onAssay ?equiv_assay ;\n"
                + "         cito:citesAsDataSource ?doi ;\n"
                + "         bibo:pmid ?pmid ;\n"
                + "     void:inDataset <http://data.kasabi.com/dataset/chembl-rdf> .\n"
                + "     ?equiv_assay chembl:hasTarget _:b1 ;\n"
                + "         chembl:organism ?assay_organism ;\n"
                + "         chembl:hasDescription ?assay_description  ;\n"
                + "         void:inDataset <http://data.kasabi.com/dataset/chembl-rdf> .\n"
                + "     _:b1 ops:concatenatedURIs ?target_uris ;\n"
                + "         dc:title ?target_names ;\n"
                + "     ops:target_organisms ?target_organisms . \n"
                + "     ?equiv_compound skos:exactMatch ?cw_uri .\n"
                + "     ?cw_uri skos:prefLabel ?compound_name ;\n"
                + "         void:inDataset <http://www.conceptwiki.org/> .\n"
                + "     ?equiv_compound skos:exactMatch ?cs_uri .\n"
                + "     ?cs_uri chemspider:smiles ?smiles ;\n"
                + "         chemspider:inchi ?inchi ;\n"
                + "         chemspider:inchikey ?inchiKey;\n"
                + "         ops:ro5_violations ?num_ro5_violations ;\n"
                + "         void:inDataset <http://rdf.chemspider.com/> .\n"
                + "     ?equiv_compound ?bNode1 ?molweight ;\n"
                + "         void:inDataset <http://data.kasabi.com/dataset/chembl-rdf> .\n"
                + "     ?equiv_compound skos:exactMatch ?db_uri .\n"
                + "     ?db_uri drugbank:drugType ?drugTypes ;\n"
                + "         drugbank:genericName ?drug_name ;\n"
                + "         void:inDataset <http://linkedlifedata.com/resource/drugbank>   \n"
                + "}  \n"
                + "WHERE { \n"
                + "     { {\n"
                + "         SELECT DISTINCT ?db_uri ?drug_name \n"
                + "             (GROUP_CONCAT(DISTINCT ?drugType ; SEPARATOR=' , ') AS ?drugTypes) \n"
                + "         {\n"
                + "             GRAPH <http://linkedlifedata.com/resource/drugbank> {\n"
                + "                 ?db_uri drugbank:genericName ?drug_name ;\n"
                + "                     drugbank:drugType ?drugType_uri .\n"
                + "                 ?drugType_uri rdfs:label ?drugType.\n"
                + "             }\n"
                + "         } GROUP BY ?drug_name ?db_uri\n"
                + "     } }\n"
                + "     {\n"
                + "         SELECT DISTINCT ?item ?doi ?pmid ?equiv_compound ?std_type ?relation ?std_value \n"
                + "             ?std_unit ?activity_value ?equiv_assay ?assay_organism \n"
                + "             ?bNode1 ?molweight ?assay_description ?cw_uri ?compound_name ?cs_uri ?smiles ?inchi \n"
                + "             ?inchiKey ?num_ro5_violations \n"
                + "             (GROUP_CONCAT(DISTINCT ?equiv_target ; SEPARATOR=' , ') AS ?target_uris) \n"
                + "             (GROUP_CONCAT(DISTINCT ?target_name ; SEPARATOR=' , ') AS ?target_names) \n"
                + "             (GROUP_CONCAT(DISTINCT ?target_organism ; SEPARATOR=' , ') AS ?target_organisms) \n"
                + "         { {\n"
                + "             GRAPH <http://www.conceptwiki.org> {\n"
                + "                	?cw_uri skos:prefLabel ?compound_name.\n"
                + "             }\n"
                + "             GRAPH <http://www.chemspider.com> {\n"
                + "        	        ?cs_uri chemspider:smiles ?smiles ;\n"
                + "	                        chemspider:inchi ?inchi ;\n"
                + "                        	chemspider:inchikey ?inchiKey .\n"
                + "                	OPTIONAL { [] obo:IAO_0000136 ?cs_uri ;\n"
                + "        	                a cheminf:CHEMINF_000367;\n"
                + "	                        qudt:numericValue ?num_ro5_violations . }\n"
                + "             }\n"
                + "             GRAPH <http://data.kasabi.com/dataset/chembl-rdf> {\n"
                + "                 ?item chembl:forMolecule ?chembl_uri ;\n"
                + "                 	chembl:onAssay ?assay_uri .\n"
                + "                 ?chembl_uri owl:equivalentClass ?equiv_compound .\n"
                + "                 ?equiv_compound sio:CHEMINF_000200 [] . \n"
                + "                 ?assay_uri owl:equivalentClass ?equiv_assay .\n"
                + "                 OPTIONAL { \n"
                + "                     ?assay_uri chembl:hasTarget ?target_uri .\n"
                + "                     ?target_uri owl:equivalentClass ?equiv_target \n"
                + "                     OPTIONAL { ?target_uri dc:title ?target_name }"
                + "                     OPTIONAL { ?target_uri chembl:organism ?target_organism }\n"
                + "                 }\n"
                + "                 OPTIONAL { ?assay_uri chembl:organism ?assay_organism }\n"
                + "                 OPTIONAL { ?assay_uri chembl:hasDescription ?assay_description }\n"
                + "                 OPTIONAL { ?item chembl:type ?std_type } \n"
                + "                 OPTIONAL { ?item chembl:relation ?relation }\n"
                + "                 OPTIONAL { ?item chembl:standardValue ?std_value }\n"
                + "                 OPTIONAL { ?item chembl:standardUnits ?std_unit }\n"
                + "                 OPTIONAL { ?item chembl-ops:normalisedValue ?activity_value}\n"
                + "                 OPTIONAL { ?item cito:citesAsDataSource ?doi_internal .\n"
                + "                     OPTIONAL {?doi_internal owl:sameAs ?doi }\n"
                + "                     OPTIONAL { ?doi_internal bibo:pmid ?pmid }\n"
                + "                 }\n"
                + "                 OPTIONAL { ?chembl_uri sio:CHEMINF_000200 ?bNode1 .\n"
                + "                     ?bNode1 a sio:CHEMINF_000198 ;\n"
                + "                         sio:SIO_000300 ?molweight. \n"
                + "                 }\n"
                + "             }\n"
                + "         } } "
                + "         GROUP BY ?item ?equiv_compound ?doi ?pmid ?equiv_assay ?assay_organism ?assay_description \n"
                + "             ?std_type ?relation ?std_value ?std_unit ?bNode1 ?molweight ?activity_value ?cw_uri \n"
                + "             ?compound_name ?cs_uri ?smiles ?inchi ?inchiKey ?num_ro5_violations  \n"
                + "         ORDER BY ?item   \n"
                + "         LIMIT 10  \n"
                + "         OFFSET 0 \n"
                + "     } "
                + "}\n";
        queries.put(queryCase.key, queryCase);
   }

}
