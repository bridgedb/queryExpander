/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cs.man.openphacts.queryexpander;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *     //http://www.w3.org/TR/2012/WD-sparql11-query-20120105/

 * @author Christian
 */
public class QueryCaseLoader {

    private static class QueryCase {
        private String name;
        private String originalQuery;
        private String key;
        private String noReplaceQuery;
        private String note;
        
        public QueryCase() {
        }
    }
    
    private Map<String, QueryCase> queries = new LinkedHashMap<String, QueryCase>();
    
    public QueryCaseLoader(){
        loadSparql2_1();
        loadSparql2_2();
        loadSparql2_3_1a();
        loadSparql2_3_1b();
        loadSparql2_3_2();
        loadSparql2_3_3();
        loadSparql2_4();
        loadSparql2_5a();  //CONCAT(?G, " ", ?S) AS ?name
        loadSparql2_5b(); //BIND(CONCAT(?G, " ", ?S) AS ?name)
        loadSparql3_1a();
        loadSparql3_1b();
        loadSparql3_2();
        loadSparql4_2a();
        loadSparql4_2b();
        loadSparql4_2c();
        loadSparql5_2a();
        loadSparql5_2b();
        loadSparql5_2_2a();
        loadSparql5_2_2b();
        loadSparql5_2_2c();
        loadSparql5_2_3a();
        loadSparql5_2_3b();
        loadSparql5_2_3c();
        loadSparql6_1();
        loadSparql6_2();
        loadSparql6_3();
        loadSparql7a();
        loadSparql7b();
        loadSparql7c();
        loadSparql8_1_1();
        loadSparql8_1_2();
        loadSparql8_2();
        loadSparql8_3_1a();
        loadSparql8_3_1b();
        loadSparql8_3_2a();
        loadSparql8_3_2b();
        loadSparql8_3_3a();
        loadSparql8_3_3b();
        loadSparql9_2a();
        loadSparql9_2b();
        loadSparql9_2c();
        loadSparql9_2d();
        loadSparql9_2e();
        loadSparql9_2f();
        loadSparql9_2g();
        loadSparql9_2h();
        loadSparql9_2i();
        loadSparql9_2j();
        loadSparql9_2k();
        loadSparql9_2l();
        loadSparql9_2m();
        loadSparql9_2n();
        loadSparql9_2o();
        loadSparql9_2p1();
        loadSparql9_2p2();
        loadSparql9_2q();
        loadSparql9_3a();
        loadSparql9_3b();
        loadSparql9_3c();
        loadSparql9_3d();
        loadSparql10_1a1();
        loadSparql10_1a2();
        loadSparql10_1a3();
        loadSparql10_1a4();
        loadSparql10_1b();
        loadSparql10_2a();
        loadSparql10_2b();
        loadSparql11_1a1();
        loadSparql11_1a2();
        loadSparql11_1a3();
        loadSparql11_1a4();
        loadSparql11_1a5();
        loadSparql11_2();
        loadSparql11_3();
        loadSparql11_4();
        loadSparql11_5();
        loadSparql12a1();
        loadSparql12a2();
        loadSparql13_2_1();
        loadSparql13_2_3();
        loadSparql13_3_1();
        loadSparql13_3_2();
        loadSparql13_3_3();
        loadSparql13_3_4();
        loadFederatedSparql2_1();
        loadFederatedSparql2_2();
        loadFederatedSparql2_3();
        loadFederatedSparql2_4a();
        loadFederatedSparql2_4b();
        loadFederatedSparql2_4c();
        loadFederatedSparql2_4d();
        loadFederatedSparql4();
        loadSparql15_1a();
        loadSparql15_1b();
        loadSparql15_1c();
        loadSparql15_2();
        loadSparql15_3();
        loadSparql15_3_1();
        loadSparql15_3_2();
        loadSparql15_4();
        loadSparql15_5();
        loadSparql16_1_1();
        loadSparql16_1_2a();
        loadSparql16_1_2b();
        loadSparql16_2();
        loadSparql16_2_1();
        loadSparql16_2_2a();
        loadSparql16_2_2b();
        loadSparql16_2_3();
        loadSparql16_2_4a();
        loadSparql16_2_4b();
        loadSparql16_3a();
        loadSparql16_3b();
        loadSparql16_4_1();
        loadSparql16_4_2a();
        loadSparql16_4_2b();
        loadSparql16_4_2c();
        loadSparql16_4_3();
    }
    
    private void loadSparql2_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_1";
        queryCase.name = "Sparql Specification section 2.1 Writing a Simple Query";
        queryCase.originalQuery =
              "SELECT ?title \n"
            + "WHERE { \n"
            + "    <http://example.org/book/book1> <http://purl.org/dc/elements/1.1/title> ?title .\n"
            + "}";
        queries.put(queryCase.key, queryCase);
     }

    private void loadSparql2_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_2";
        queryCase.name = "Sparql Specification section 2.2 Multiple Matches";
        queryCase.originalQuery = 
              "PREFIX foaf:   <http://xmlns.com/foaf/0.1/> \n"
            + "SELECT ?name ?mbox \n"
            + "WHERE \n"
            + "  { ?x foaf:name ?name .\n"
            + "    ?x foaf:mbox ?mbox \n"
            + "}";
        queries.put(queryCase.key, queryCase);
    }

   private void loadSparql2_3_1a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_3_1a";
        queryCase.name = "Sparql Specification section 2.3.1 Matching RDF Literals. 1st Query";
        queryCase.originalQuery = "SELECT ?v WHERE { ?v ?p \"cat\" }";
        queries.put(queryCase.key, queryCase);
     }
    
   private void loadSparql2_3_1b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_3_1b";
        queryCase.name = "Sparql Specification section 2.3.1 Matching RDF Literals 2nd query";
        queryCase.originalQuery = "SELECT ?v WHERE { ?v ?p \"cat\"@en }";
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadSparql2_3_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_3_2";
        queryCase.name = "Sparql Specification section 2.3.2 Matching Literals with Numeric Types";
        queryCase.originalQuery = "SELECT ?v WHERE { ?v ?p 42 }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql2_3_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_3_3";
        queryCase.name = "Sparql Specification section 2.3.3 Matching Literals with Arbitrary Datatypes";
        queryCase.originalQuery = "SELECT ?v WHERE { ?v ?p \"abc\"^^<http://example.org/datatype#specialDatatype> }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql2_4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_4";
        queryCase.name = "Sparql Specification section 2.4 Blank Node Labels in Query Results";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?x ?name \n"
                + "WHERE  { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql2_5a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_5a";
        queryCase.name = "Sparql Specification section 2.5 Creating Values with Expressions 1st Query";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ( CONCAT(?G, \" \", ?S) AS ?name ) \n"
                + "WHERE  { ?P foaf:givenName ?G ; foaf:surname ?S }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql2_5b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_5b";
        queryCase.name = "Sparql Specification section 2.5 Creating Values with Expressions 2ndt Query";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?name \n"
                + "WHERE  { \n"
                + "   ?P foaf:givenName ?G ; \n"
                + "      foaf:surname ?S \n"
                + "   BIND(CONCAT(?G, \" \", ?S) AS ?name)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql2_6() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql2_6";
        queryCase.name = "Sparql Specification section 2.6 Building RDF Graphs";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "PREFIX org:    <http://example.com/ns#> \n"
                + " CONSTRUCT { ?x foaf:name ?name }\n"
                + "WHERE  { ?x org:employeeName ?name }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql3_1a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql3_1a";
        queryCase.name = "Sparql Specification section 3.1 Restricting the Value of Strings 1st Query";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/> \n"
                + "SELECT  ?title \n"
                + "WHERE   { ?x dc:title ?title \n"
                + "          FILTER regex(?title, \"^SPARQL\") \n"
        + "        }";                             
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql3_1b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql3_1b";
        queryCase.name = "Sparql Specification section 3.1 Restricting the Value of Strings 2nd Query";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/> \n"
                + "SELECT  ?title \n"
                + "WHERE   { ?x dc:title ?title \n"
                + "          FILTER regex(?title, \"web\", \"i\" )  \n"
        + "        }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql3_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql3_2";
        queryCase.name = "Sparql Specification section 3.2 Restricting Numeric Values";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "WHERE   { ?x ns:price ?price .\n"
                + "          FILTER (?price < 30.5)\n"
                + "          ?x dc:title ?title . }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql4_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql4_2a";
        queryCase.name = "Sparql Specification section 4.2 Syntax for Triple Patterns 1st query\n";
        queryCase.originalQuery = "PREFIX  dc: <http://purl.org/dc/elements/1.1/> \n"
                + "SELECT  ?title \n"
                + "WHERE   { <http://example.org/book/book1> dc:title ?title }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql4_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql4_2b";
        queryCase.name = "Sparql Specification section 4.2 Syntax for Triple Patterns 2nd query\n";
        queryCase.originalQuery = "PREFIX  dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  : <http://example.org/book/>\n"
                + "SELECT  $title\n"
                + "WHERE   { :book1  dc:title  $title }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql4_2c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql4_2c";
        queryCase.name = "Sparql Specification section 4.2 Syntax for Triple Patterns 3rd query";
        queryCase.originalQuery = "BASE    <http://example.org/book/>\n"
                + "PREFIX  dc: <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT  $title\n"
                + "WHERE   { <book1>  dc:title  ?title }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2a";
        queryCase.name = "Sparql Specification section 5.2 Group Graph Patterns 1st query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name ?mbox\n"
                + "WHERE  {\n"
                + "          ?x foaf:name ?name .\n"
                + "          ?x foaf:mbox ?mbox .\n"
                + "       }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2b";
        queryCase.name = "Sparql Specification section section 5.2 Group Graph Patterns 2nd query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name ?mbox\n"
                + "WHERE  { { ?x foaf:name ?name . }\n"
                + "         { ?x foaf:mbox ?mbox . }\n"
                + "       }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_2a";
        queryCase.name = "Sparql Specification section 5.2.2 Scope of Filters 1st query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {  ?x foaf:name ?name .\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + "    FILTER regex(?name, \"Smith\")"
                + " }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_2b";
        queryCase.name = "Sparql Specification section 5.2.2 Scope of Filters 2nd query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {  FILTER regex(?name, \"Smith\")\n"
                + "    ?x foaf:name ?name .\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + " }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_2c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_2c";
        queryCase.name = "Sparql Specification section 5.2.2 Scope of Filters 3rd query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {  ?x foaf:name ?name .\n"
                + "    FILTER regex(?name, \"Smith\")\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + " }\n";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_3a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_3a";
        queryCase.name = "Sparql Specification section";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {\n"
                + "    ?x foaf:name ?name .\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_3b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_3b";
        queryCase.name = "Sparql Specification section";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {\n"
                + "    ?x foaf:name ?name . FILTER regex(?name, \"Smith\")\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql5_2_3c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql5_2_3c";
        queryCase.name = "Sparql Specification section";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?x \n"
                + "WHERE {    ?x foaf:name ?name .\n"
                + "    {}\n"
                + "    ?x foaf:mbox ?mbox .\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql6_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql6_1";
        queryCase.name = "Sparql Specification section 6.1 Optional Pattern Matching";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name ?mbox\n"
                + "WHERE  { ?x foaf:name  ?name .\n"
                + "         OPTIONAL { ?x  foaf:mbox  ?mbox }\n"
                + "       }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql6_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql6_2";
        queryCase.name = "Sparql Specification section 6.2 Constraints in Optional Pattern Matching";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "WHERE   { ?x dc:title ?title .\n"
                + "          OPTIONAL { ?x ns:price ?price . FILTER (?price < 30) }\n"
                + "        }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql6_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql6_3";
        queryCase.name = "Sparql Specification section 6.3 Multiple Optional Graph Patterns";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name ?mbox ?hpage\n"
                + "WHERE  { ?x foaf:name  ?name .\n"
                + "         OPTIONAL { ?x foaf:mbox ?mbox } .\n"
                + "         OPTIONAL { ?x foaf:homepage ?hpage }\n"
                + "       }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql7a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql7a";
        queryCase.name = "Sparql Specification section 7 Matching Alternatives 1st query";
        queryCase.originalQuery = "PREFIX dc10:  <http://purl.org/dc/elements/1.0/>\n"
                + "PREFIX dc11:  <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT ?title\n"
                + "WHERE  { { ?book dc10:title  ?title } UNION { ?book dc11:title  ?title } }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql7b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql7b";
        queryCase.name = "Sparql Specification section 7 Matching Alternatives 2nd query";
        queryCase.originalQuery = "PREFIX dc10:  <http://purl.org/dc/elements/1.0/>\n"
                + "PREFIX dc11:  <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT ?x ?y\n"
                + "WHERE  { { ?book dc10:title ?x } UNION { ?book dc11:title  ?y } }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql7c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql7a";
        queryCase.name = "Sparql Specification section 7 Matching Alternatives 3rd query";
        queryCase.originalQuery = "PREFIX dc10:  <http://purl.org/dc/elements/1.0/>\n"
                + "PREFIX dc11:  <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT ?title ?author\n"
                + "WHERE  { { ?book dc10:title ?title .  ?book dc10:creator ?author }\n"
                + "         UNION\n"
                + "         { ?book dc11:title ?title .  ?book dc11:creator ?author }\n"
                + "       }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_1_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_1_1";
        queryCase.name = "Sparql Specification section 8.1.1 Testing For the Absence of a Pattern";
        queryCase.originalQuery = "PREFIX  rdf:    <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX  foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?person\n"
                + "WHERE {\n"
                + "    ?person rdf:type  foaf:Person .\n"
                + "    FILTER NOT EXISTS { ?person foaf:name ?name }\n"
                + "}     ";   
        //Parser moves filters up which cases numbering of aanonymous variables to be different.
        queryCase.noReplaceQuery = "PREFIX  rdf:    <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX  foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?person\n"
                + "WHERE {\n"
                + "    FILTER NOT EXISTS { ?person foaf:name ?name }\n"
                + "    ?person rdf:type  foaf:Person .\n"
                + "}     ";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_1_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_1_2";
        queryCase.name = "Sparql Specification section 8.1.2 Testing For the Presence of a Pattern";
        queryCase.originalQuery = "PREFIX  rdf:    <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX  foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?person\n"
                + "WHERE {\n"
                + "    ?person rdf:type  foaf:Person .\n"
                + "    FILTER EXISTS { ?person foaf:name ?name }\n"
                + "}";                
        //Parser moves filters up which cases numbering of aanonymous variables to be different.
        queryCase.noReplaceQuery = "PREFIX  rdf:    <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX  foaf:   <http://xmlns.com/foaf/0.1/> \n"
                + "SELECT ?person\n"
                + "WHERE {\n"
                + "    FILTER EXISTS { ?person foaf:name ?name }\n"
                + "    ?person rdf:type  foaf:Person .\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_2";
        queryCase.name = "Sparql Specification section 8.2 Removing Possible Solutions";
        queryCase.originalQuery = "PREFIX :       <http://example/>\n"
                + "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT DISTINCT ?s\n"
                + "WHERE {\n"
                + "   ?s ?p ?o .\n"
                + "   MINUS {\n"
                + "      ?s foaf:givenName \"Bob\" .\n"
                + "   }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_1a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_1a";
        queryCase.name = "Sparql Specification section 8.3.1 Example: Sharing of variables 1st query";
        queryCase.originalQuery = "SELECT *\n"
                + "{ \n"
                + "  ?s ?p ?o\n"
                + "  FILTER NOT EXISTS { ?x ?y ?z }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_1b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_1b";
        queryCase.name = "Sparql Specification section 8.3.1 Example: Sharing of variables 2nd query";
        queryCase.originalQuery = "SELECT *\n"
                + "{ \n"
                + "   ?s ?p ?o \n"
                + "   MINUS \n"
                + "     { ?x ?y ?z }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_2a";
        queryCase.name = "Sparql Specification section 8.3.2 Example: Fixed pattern 1st query";
        queryCase.originalQuery = "PREFIX : <http://example/>\n"
                + "SELECT * \n"
                + "{ \n"
                + "  ?s ?p ?o \n"
                + "  FILTER NOT EXISTS { :a :b :c }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_2b";
        queryCase.name = "Sparql Specification section 8.3.2 Example: Fixed pattern 2nd query";
        queryCase.originalQuery = "PREFIX : <http://example/>\n"
                + "SELECT * \n"
                + "{ \n"
                + "  ?s ?p ?o \n"
                + "  MINUS { :a :b :c }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_3a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_3a";
        queryCase.name = "Sparql Specification section 8.3.3 Example: Inner FILTERs 1st Query";
        queryCase.originalQuery = "PREFIX : <http://example.com/>\n"
                + "SELECT * WHERE {\n"
                + "        ?x :p ?n\n"
                + "        FILTER NOT EXISTS {\n"
                + "                ?x :q ?m .\n"
                + "                FILTER(?n = ?m)\n"
                + "        }\n"
                + "}";                
        //Parser moves filters up which cases numbering of aanonymous variables to be different.
        queryCase.originalQuery = "PREFIX : <http://example.com/>\n"
                + "SELECT * WHERE {\n"
                + "        FILTER NOT EXISTS {\n"
                + "                FILTER(?n = ?m)\n"
                + "                ?x :q ?m .\n"
                + "        }\n"
                + "        ?x :p ?n\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql8_3_3b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql8_3_3b";
        queryCase.name = "Sparql Specification section 8.3.3 Example: Inner FILTERs 2nd query";
        queryCase.originalQuery = "PREFIX : <http://example/>\n"
                + "SELECT * WHERE {\n"
                + "        ?x :p ?n\n"
                + "        MINUS {\n"
                + "                ?x :q ?m .\n"
                + "                FILTER(?n = ?m)\n"
                + "        }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2a";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 1st subquery";
        queryCase.originalQuery = "PREFIX : <http://example.com/> \n"
                + "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX dc:   <http://purl.org/dc/elements/1.1/> \n"
                + "PREFIX rdfs:     <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "SELECT *\n"
                + "WHERE { :book1 dc:title|rdfs:label ?displayString }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2b";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 2nd subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows/foaf:name ?name .\n"
                + "}";       
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2c";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 3rd subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE { \n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows/foaf:knows/foaf:name ?name .\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2d() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2d";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 4th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows{2}/foaf:name ?name .\n"
                + "\n}";     
        //Removed the {2} as the anonymous name is different
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows/foaf:knows/foaf:name ?name .\n"
                + "\n}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2e() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2e";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 5th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT *\n"
                + "WHERE { ?x  foaf:mbox <mailto:alice@example> .\n"
                + "   ?x  foaf:knows [ foaf:knows [ foaf:name ?name ]]. \n"
                + "}";                
        //top is semantic sugar for below 
        //Parser also changes the order to what is below.
        //I think they are the same.
        queryCase.noReplaceQuery = "SELECT  ?x ?name\n"
                + "WHERE {\n"
                + "       ?x <http://xmlns.com/foaf/0.1/mbox> <mailto:alice@example>. \n"
                + "       _:_b <http://xmlns.com/foaf/0.1/name> ?name. \n"
                + "       _:_a <http://xmlns.com/foaf/0.1/knows> _:_b .\n"
                + "       ?x <http://xmlns.com/foaf/0.1/knows> _:_a . \n"
                + "}";
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2f() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2f";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 6th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x  foaf:mbox <mailto:alice@example> .\n"
                + "  ?x  foaf:knows ?a1 .\n"
                + "  ?a1 foaf:knows ?a2 .\n"
                + "  ?a2 foaf:name ?name .\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2g() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2g";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 7th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows/foaf:knows ?y .\n"
                + "  FILTER ( ?x != ?y )\n"
                + "  ?y foaf:name ?name \n"
                + "}";                
         queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2h() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2h";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 8th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE { ?x foaf:mbox <mailto:alice@example> }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2i() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2i";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 9th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE { <mailto:alice@example> ^foaf:mbox ?x }";  
        //Parser uninvets and this changes the const numbering
        queryCase.noReplaceQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE { ?x foaf:mbox <mailto:alice@example> }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2j() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2j";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 10th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:knows/^foaf:knows ?y .  \n"
                + "  FILTER(?x != ?y)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2k() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2k";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 11th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT * \n"
                + "WHERE {\n"
                + "  ?x foaf:mbox <mailto:alice@example> .\n"
                + "  ?x foaf:knows+/foaf:name ?name .\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2l() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2l";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 12th subquery";
        //doc has "?ancestor (ex:motherOf|ex:fatherOf)+ <#me>"
        queryCase.originalQuery = "PREFIX ex:   <http://www.example.com/>\n"
                + "SELECT * \n"
                + "WHERE { ?ancestor (ex:motherOf|ex:fatherOf)+ <http://example/me> }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2m() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2m";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 13th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX rdfs:     <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "SELECT * \n"
                + "WHERE { <http://example/thing> rdf:type/rdfs:subClassOf* ?type }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2n() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2n";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 14th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
                + "PREFIX  rdfs:     <http://www.w3.org/2000/01/rdf-schema#> \n"
                + "SELECT * \n"
                + "WHERE { ?x rdf:type/rdfs:subClassOf* ?type }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2o() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2o";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 15th subquery";
        queryCase.originalQuery = "PREFIX : <http://example.com/> \n"
                + "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdfs:     <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "SELECT * \n"
                + "WHERE { ?x ?p ?v . ?p rdfs:subPropertyOf* :property }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2p1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2p1";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 16th subquery (simplified)";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "SELECT * \n"
                + "WHERE { ?x !rdf:type ?y }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2p2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2p2";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 16th subquery";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "SELECT * \n"
                + "WHERE { ?x !(rdf:type|^rdf:type) ?y }";      
        //This is done as a UNION so expander can not tell.
        //The order of inverse first is done by orignal expander
        queryCase.noReplaceQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "SELECT ?x ?y \n"
                + "WHERE { \n"
                + "     { ?y !rdf:type ?x } \n"
                + "    UNION \n"
                + "     { ?x !rdf:type ?y } \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_2q() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_2q";
        queryCase.name = "Sparql Specification section 9.2 Property Paths Examples 17th subquery";
        queryCase.originalQuery = "PREFIX : <http://example.com/>\n"
                + "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX  rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "SELECT * \n"
                + "WHERE { :list rdf:rest*/rdf:first ?element }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_3a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_3a";
        queryCase.name = "Sparql Specification section 9.3 Cycles and Duplicates 1st query";
        queryCase.originalQuery = "PREFIX :   <http://example/>\n"
                + "SELECT * \n"
                + "{  ?s :p/:q ?o . }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_3b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_3b";
        queryCase.name = "Sparql Specification section 9.3 Cycles and Duplicates 2nd query";
        queryCase.originalQuery = "PREFIX :   <http://example/>\n"
                + "SELECT * \n"
                + "{  ?s :p ?_a .\n"
                + "   ?_a :q ?o . }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_3c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_3c";
        queryCase.name = "Sparql Specification section 9.3 Cycles and Duplicates 3rd query";
        queryCase.originalQuery = "PREFIX :   <http://example/>\n"
                + "SELECT * \n"
                + "{ :x :p+ ?o }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql9_3d() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql9_3d";
        queryCase.name = "Sparql Specification section 9.3 Cycles and Duplicates 4th query";
        queryCase.originalQuery = "PREFIX :   <http://example/>\n"
                + "SELECT * \n"
                + "{ :x :p* ?o }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_1a1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_1a1";
        queryCase.name = "Sparql Specification section 10.1 BIND: Assigning to Variables 1st query very simplified";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?price \n"
                + "{  BIND (?p * ?discount AS ?price)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_1a2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_1a2";
        queryCase.name = "Sparql Specification section 10.1 BIND: Assigning to Variables 1st query simplified";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?price\n"
                + "{  BIND (?p*(1-?discount) AS ?price)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_1a3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_1a3";
        queryCase.name = "Sparql Specification section 10.1 BIND: Assigning to Variables 1st query no filter";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "{  ?x ns:price ?p .\n"
                + "   ?x ns:discount ?discount\n"
                + "   BIND (?p*(1-?discount) AS ?price)\n"
                + "   ?x dc:title ?title . \n"
                + "}";                
        //Parser moves bind up which causes numbering of aanonymous variables to be different.
        //This is different to what the sparql docs say should happen!
        queryCase.noReplaceQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "WHERE { BIND (( ?p*(\"1\"^^<http://www.w3.org/2001/XMLSchema#integer>- ?discount)) as ?price)  . \n"
                + " ?x<http://example.org/ns#price> ?p. \n"
                + " ?x<http://example.org/ns#discount> ?discount. \n"
                + " ?x<http://purl.org/dc/elements/1.1/title> ?title. \n"
                + " } ";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_1a4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_1a4";
        queryCase.name = "Sparql Specification section 10.1 BIND: Assigning to Variables 1st query";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "{  ?x ns:price ?p .\n"
                + "   ?x ns:discount ?discount\n"
                + "   BIND (?p*(1-?discount) AS ?price)\n"
                + "   FILTER(?price < 20)\n"
                + "   ?x dc:title ?title . \n"
                + "}";                
        //Parser moves filter and bind up which cases numbering of aanonymous variables to be different.
        //Note the fullstop needed after ?discount here not needed above!
        queryCase.noReplaceQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "{  \n"
                + "   FILTER(?price < 20)\n"
                + "   BIND (?p*(1-?discount) AS ?price)\n"
                + "   ?x ns:price ?p .\n"
                + "   ?x ns:discount ?discount .\n"
                + "   ?x dc:title ?title . \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_1b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_1b";
        queryCase.name = "Sparql Specification section 10.1 BIND: Assigning to Variables 2nd query";
        //Parser moves filter and bind up which cases numbering of aanonymous variables to be different.
        //Note the fullstop needed after ?discount here not needed above!
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "{  { ?x ns:price ?p .\n"
                + "     ?x ns:discount ?discount\n"
                + "     BIND (?p*(1-?discount) AS ?price)\n"
                + "   }\n"
                + "   {?x dc:title ?title . }\n"
                + "   FILTER(?price < 20)\n"
                + "}";                
        queryCase.noReplaceQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title ?price\n"
                + "{  \n"
                + "   FILTER(?price < 20)\n"
                + "   BIND (?p*(1-?discount) AS ?price)\n"
                + "   ?x ns:price ?p .\n"
                + "   ?x ns:discount ?discount .\n"
                + "   ?x dc:title ?title . \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_2a";
        queryCase.name = "Sparql Specification section 10.2 BINDINGS 1st query";
        queryCase.originalQuery = "PREFIX dc:   <http://purl.org/dc/elements/1.1/> \n"
                + "PREFIX :     <http://example.org/book/> \n"
                + "PREFIX ns:   <http://example.org/ns#> \n"
                + "SELECT ?book ?title ?price\n"
                + "{\n"
                + "   ?book dc:title ?title ;\n"
                + "         ns:price ?price .\n"
                + "}\n"
                + "BINDINGS ?book {\n"
                + " (:book1)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql10_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql10_2b";
        queryCase.name = "Sparql Specification section 10.2 BINDINGS 2nd query";
        queryCase.originalQuery = "PREFIX dc:   <http://purl.org/dc/elements/1.1/> \n"
                + "PREFIX :     <http://example.org/book/> \n"
                + "PREFIX ns:   <http://example.org/ns#> \n"
                + "SELECT ?book ?title ?price\n"
                + "{\n"
                + "   ?book dc:title ?title ;\n"
                + "         ns:price ?price .\n"
                + "}\n"
                + "BINDINGS ?book ?title {\n"
                + " (UNDEF \"SPARQL Tutorial\")\n"
                + " (:book2 UNDEF)\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_1a1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_1a";
        queryCase.name = "Sparql Specification section 11.1 Aggregate Example simplified";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (SUM(?lprice) AS ?totalPrice)\n"
                + "WHERE {\n"
                + "  ?org :affiliates ?auth .\n"
                + "  ?auth :writesBook ?book .\n"
                + "  ?book :price ?lprice .\n"
                + "}";
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadSparql11_1a2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_1a2";
        queryCase.name = "Sparql Specification section 11.1 Aggregate Example No Having";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (SUM(?lprice) AS ?totalPrice)\n"
                + "WHERE {\n"
                + "  ?org :affiliates ?auth .\n"
                + "  ?auth :writesBook ?book .\n"
                + "  ?book :price ?lprice .\n"
                + "}\n"
                + "GROUP BY ?org";                
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadSparql11_1a3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_1a3";
        queryCase.name = "Sparql Specification section 11.1 Aggregate Example";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (SUM(?lprice) AS ?totalPrice)\n"
                + "WHERE {\n"
                + "  FILTER (?lprice > 10)\n"
                + "  ?org :affiliates ?auth .\n"
                + "  ?auth :writesBook ?book .\n"
                + "  ?book :price ?lprice .\n"
                + "}\n"
                + "GROUP BY ?org\n"
               // + "HAVING (?lprice > 10)"
                + "";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_1a4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_1a4";
        queryCase.name = "Sparql Specification section 11.1 Aggregate Example simple having";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (SUM(?lprice) AS ?totalPrice)\n"
                + "WHERE {\n"
                + "  ?org :affiliates ?auth .\n"
                + "  ?auth :writesBook ?book .\n"
                + "  ?book :price ?lprice .\n"
                + "}\n"
                + "GROUP BY ?org\n"
                + "HAVING (?lprice > 10)";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_1a5() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_1a5";
        queryCase.name = "Sparql Specification section 11.1 Aggregate Example simple having";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (SUM(?lprice) AS ?totalPrice)\n"
                + "WHERE {\n"
                + "  ?org :affiliates ?auth .\n"
                + "  ?auth :writesBook ?book .\n"
                + "  ?book :price ?lprice .\n"
                + "}\n"
                + "GROUP BY ?org\n"
                + "HAVING (SUM(?lprice) > SUM(?book))";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_2";
        queryCase.name = "Sparql Specification section 11.2 GROUP BY";
        queryCase.originalQuery = "PREFIX : <http://books.example/>\n"
                + "SELECT (AVG(?y) AS ?avg)\n"
                + "WHERE {\n"
                + "  ?a :x ?x ;\n"
                + "     :y ?y .}\n\n"
                + "GROUP BY ?x";                
        queries.put(queryCase.key, queryCase);
   }
   
   private void loadSparql11_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_3";
        queryCase.name = "Sparql Specification section 11.3 HAVING";
        queryCase.originalQuery = "PREFIX : <http://data.example/>\n"
                + "SELECT (AVG(?size) AS ?asize)\n"
                + "WHERE {\n"
                + "  ?x :size ?size\n"
                + "}\n"
                + "GROUP BY ?x\n"
                + "HAVING(AVG(?size) > 10)";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_4";
        queryCase.name = "Sparql Specification section 11.4 Aggregate Projection Restrictions";
        queryCase.originalQuery = "PREFIX : <http://example.com/data/#>\n"
                + "SELECT ?x (MIN(?y) * 2 AS ?min)\n"
                + "WHERE {\n"
                + "  ?x :p ?y .\n"
                + "  ?x :q ?z .\n"
                + "} GROUP BY ?x (STR(?z))";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql11_5() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql11_5";
        queryCase.name = "Sparql Specification section 11.5 Aggregate Example (with errors)";
        queryCase.originalQuery = "PREFIX : <http://example.com/data/#>\n"
                + "SELECT ?g (AVG(?p) AS ?avg) ((MIN(?p) + MAX(?p)) / 2 AS ?c)\n"
                + "WHERE {\n"
                + "  ?g :p ?p .\n"
                + "}\n"
                + "GROUP BY ?g";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql12a1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql12a1";
        queryCase.name = "Sparql Specification section 12 Subqueries  inner query";
        //removed double prefix
        queryCase.originalQuery = "PREFIX : <http://people.example/>\n"
                + "    SELECT ?y (MIN(?name) AS ?minName)\n"
                + "    WHERE {\n"
                + "      ?y :name ?name .\n"
                + "    } GROUP BY ?y";
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql12a2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql12a2";
        queryCase.name = "Sparql Specification section 12 Subqueries";
        //removed double prefix
        queryCase.originalQuery = "PREFIX : <http://people.example/>\n"
                + "SELECT ?y ?minName\n"
                + "WHERE {\n"
                + "  :alice :knows ?y .\n"
                + "  {\n"
                + "    SELECT ?y (MIN(?pizza) AS ?minName)\n"
                + "    WHERE {\n"
                + "      ?y :name ?pizza .\n"
                + "    } GROUP BY ?y\n"
                + "  }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_2_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_2_1";
        queryCase.name = "Sparql Specification section 13.2.1 Specifying the Default Graph";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT  ?name\n"
                + "FROM    <http://example.org/foaf/aliceFoaf>\n"
                + "WHERE   { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_2_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_2_3";
        queryCase.name = "Sparql Specification section 13.2.3 Combining FROM and FROM NAMED";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT ?who ?g ?mbox\n"
                + "FROM <http://example.org/dft.ttl>\n"
                + "FROM NAMED <http://example.org/alice>\n"
                + "FROM NAMED <http://example.org/bob>\n"
                + "WHERE\n"
                + "{\n"
                + "   ?g dc:publisher ?who .\n"
                + "   GRAPH ?g { ?x foaf:mbox ?mbox }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_3_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_3_1";
        queryCase.name = "Sparql Specification section 13.3.1 Accessing Graph Names";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?src ?bobNick\n"
                + "FROM NAMED <http://example.org/foaf/aliceFoaf>\n"
                + "FROM NAMED <http://example.org/foaf/bobFoaf>\n"
                + "WHERE\n"
                + "  {\n"
                + "    GRAPH ?src\n"
                + "    { ?x foaf:mbox <mailto:bob@work.example> .\n"
                + "      ?x foaf:nick ?bobNick\n"
                + "    }\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_3_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_3_2";
        queryCase.name = "Sparql Specification section 13.3.2 Restricting by Graph IRI";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX data: <http://example.org/foaf/>\n"
                + "SELECT ?nick\n"
                + "FROM NAMED <http://example.org/foaf/aliceFoaf>\n"
                + "FROM NAMED <http://example.org/foaf/bobFoaf>\n"
                + "WHERE\n"
                + "  {\n"
                + "     GRAPH data:bobFoaf {\n"
                + "         ?x foaf:mbox <mailto:bob@work.example> .\n"
                + "         ?x foaf:nick ?nick }\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_3_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_3_3";
        queryCase.name = "Sparql Specification section ";
        queryCase.originalQuery = "PREFIX  data:  <http://example.org/foaf/>\n"
                + "PREFIX  foaf:  <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX  rdfs:  <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "SELECT ?mbox ?nick ?ppd\n"
                + "FROM NAMED <http://example.org/foaf/aliceFoaf>\n"
                + "FROM NAMED <http://example.org/foaf/bobFoaf>\n"
                + "WHERE\n"
                + "{\n"
                + "  GRAPH data:aliceFoaf\n"
                + "  {\n"
                + "    ?alice foaf:mbox <mailto:alice@work.example> ;\n"
                + "           foaf:knows ?whom .\n"
                + "    ?whom  foaf:mbox ?mbox ;\n"
                + "           rdfs:seeAlso ?ppd .\n"
                + "    ?ppd  a foaf:PersonalProfileDocument .\n"
                + "  } .\n"
                + "  GRAPH ?ppd\n"
                + "  {\n"
                + "      ?w foaf:mbox ?mbox ;\n"
                + "         foaf:nick ?nick\n"
                + "  }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadSparql13_3_4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql13_3_4";
        queryCase.name = "Sparql Specification section 13.3.4 Named and Default Graphs";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX dc:   <http://purl.org/dc/elements/1.1/>\n"
                + "SELECT ?name ?mbox ?date\n"
                + "WHERE\n"
                + "  {  ?g dc:publisher ?name ;\n"
                + "        dc:date ?date .\n"
                + "    GRAPH ?g\n"
                + "      { ?person foaf:name ?name ; foaf:mbox ?mbox }\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_1";
        queryCase.name = "Federated Sparql Specification section 2.1 Simple query to a remote SPARQL endpoint";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "FROM <http://example.org/myfoaf.rdf>\n"
                + "WHERE\n"
                + "{\n"
                + "  <http://example.org/myfoaf/I> foaf:knows ?person .\n"
                + "  SERVICE <http://people.example.org/sparql> { \n"
                + "    ?person foaf:name ?name . } \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_2";
        queryCase.name = "Federated Sparql Specification section 2.2 SPARQL query with OPTIONAL to two remote SPARQL endpoints";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?person ?interest ?known\n"
                + "WHERE\n"
                + "{\n"
                + "  SERVICE <http://people.example.org/sparql> { \n"
                + "    ?person foaf:name ?name .  \n"
                + "    OPTIONAL { \n"
                + "      ?person foaf:interest ?interest .\n"
                + "      SERVICE <http://people2.example.org/sparql> { \n"
                + "        ?person foaf:knows ?known . } }\n"
                + "  }    \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   /**
    * Warning the SILENT keyword does not appear to be supported by this OpenRDF
    */
   private void loadFederatedSparql2_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_3";
        queryCase.name = "Federated Sparql Specification section 2.3 Service Execution Failure";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE\n"
                + "{\n"
                + "  SERVICE SILENT <http://people.example.org/sparql> { \n"
                + "    <http://example.org/people15> foaf:name ?name . }\n"
                + "}";       
        queryCase.note = "Warning the SILENT keyword does not appear to be supported by this OpenRDF";
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_4a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_4a";
        queryCase.name = 
                "Federated Sparql Specification section 2.4 Interplay of SERVICE and BINDINGS (Informative) 1st query ";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?s\n"
                + "{\n"
                + "  ?s a foaf:Person .\n"
                + "  SERVICE <http://example.org/sparql> {?s foaf:knows ?o }\n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_4b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_4b";
        queryCase.name = 
                "Federated Sparql Specification section 2.4 Interplay of SERVICE and BINDINGS (Informative) 2nd query";
        queryCase.originalQuery = "PREFIX : <http://example.org/>\n"
                + "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?s\n"
                + "{\n"
                + "  ?s a foaf:Person\n"
                + "} ";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_4c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2-4c";
        queryCase.name = "Federated Sparql Specification section 2.4 Interplay of SERVICE and BINDINGS (Informative)";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX : <http://example.org/>\n"
                + "SELECT * {?s foaf:knows ?o } BINDINGS ?s { (:a) (:b) }";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql2_4d() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql2_4d";
        queryCase.name = "Federated Sparql Specification section 2.4 Interplay of SERVICE and BINDINGS (Informative)";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?s ?o\n"
                + "{\n"
                + "  ?s a foaf:Person\n"
                + "  SERVICE <http://example.org/sparql> {?s foaf:knows ?o }\n"
                + "} ";                
        queries.put(queryCase.key, queryCase);
   }

   private void loadFederatedSparql4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "FederatedSparql4";
        queryCase.name = "Federated Sparql Specification section ";
        queryCase.originalQuery = "PREFIX  void: <http://rdfs.org/ns/void#>\n"
                + "PREFIX  dc:   <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  doap: <http://usefulinc.com/ns/doap#> \n"
                + "SELECT ?service ?projectName\n"
                + "WHERE {\n"
                + "  # Find the service with subject \"remote\".\n"
                + "  ?p dc:subject ?projectSubject ;\n"
                + "     void:sparqlEndpoint ?service .\n"
                + "     FILTER regex(?projectSubject, \"remote\")\n"
                + "  # Query that service projects.\n"
                + "  SERVICE ?service {\n"
                + "     ?project  doap:name ?projectName . } \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_1a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_1a";
        queryCase.name = "Sparql Specification section 15.1 ORDER BY 1st query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE { ?x foaf:name ?name }\n"
                + "ORDER BY ?name";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_1b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_1b";
        queryCase.name = "Sparql Specification section 15.1 ORDER BY 2nd query";
        queryCase.originalQuery = "PREFIX     :    <http://example.org/ns#>\n"
                + "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE { ?x foaf:name ?name ; :empId ?emp }\n"
                + "ORDER BY DESC(?emp)";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_1c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_1c";
        queryCase.name = "Sparql Specification section 15.1 ORDER BY 3rd query";
        queryCase.originalQuery = "PREFIX     :    <http://example.org/ns#>\n"
                + "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE { ?x foaf:name ?name ; :empId ?emp }\n"
                + "ORDER BY ?name DESC(?emp)";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_2";
        queryCase.name = "Sparql Specification section 15.2 Projection";
        queryCase.originalQuery = "PREFIX foaf:       <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE\n"
                + " { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_3";
        queryCase.name = "Sparql Specification section 15.3 Duplicate Solutions";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name WHERE { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_3_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_3_1";
        queryCase.name = "Sparql Specification section 15.3.1 DISTINCT";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT DISTINCT ?name WHERE { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_3_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_3_2";
        queryCase.name = "Sparql Specification section 15.3.2 REDUCED";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT REDUCED ?name WHERE { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_4() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_4";
        queryCase.name = "Sparql Specification section 15.4 OFFSET";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT  ?name\n"
                + "WHERE   { ?x foaf:name ?name }\n"
                + "ORDER BY ?name\n"
                + "LIMIT   5\n"
                + "OFFSET  10";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql15_5() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql15_5";
        queryCase.name = "Sparql Specification section 15.5 LIMIT";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?name\n"
                + "WHERE { ?x foaf:name ?name }\n"
                + "LIMIT 20";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_1_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_1_1";
        queryCase.name = "Sparql Specification section 16.1.1 Projection";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "SELECT ?nameX ?nameY ?nickY\n"
                + "WHERE\n"
                + "  { ?x foaf:knows ?y ;\n"
                + "       foaf:name ?nameX .\n"
                + "    ?y foaf:name ?nameY .\n"
                + "    OPTIONAL { ?y foaf:nick ?nickY }\n"
                + "  }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_1_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_1_2a";
        queryCase.name = "Sparql Specification section 16.1.2 SELECT Expressions 1st query";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title (?p*(1-?discount) AS ?price)\n"
                + "{ ?x ns:price ?p .\n"
                + "  ?x dc:title ?title . \n"
                + "  ?x ns:discount ?discount \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_1_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_1_2b";
        queryCase.name = "Sparql Specification section 16.1.2 SELECT Expressions 2nd query";
        queryCase.originalQuery = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX  ns:  <http://example.org/ns#>\n"
                + "SELECT  ?title (?p AS ?fullPrice) (?fullPrice*(1-?discount) AS ?customerPrice)\n"
                + "{ ?x ns:price ?p .\n"
                + "   ?x dc:title ?title . \n"
                + "   ?x ns:discount ?discount \n"
                + "}";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2";
        queryCase.name = "Sparql Specification section 16.2 CONSTRUCT";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>\n"
                + "CONSTRUCT   { <http://example.org/person#Alice> vcard:FN ?name }\n"
                + "WHERE       { ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_1";
        queryCase.name = "Sparql Specification section 16.2.1 Templates with Blank Nodes";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>\n"
                + "CONSTRUCT { ?x  vcard:N _:v .\n"
                + "            _:v vcard:givenName ?gname .\n"
                + "            _:v vcard:familyName ?fname }\n"
                + "WHERE\n"
                + " {\n"
                + "    { ?x foaf:firstname ?gname } UNION  { ?x foaf:givenname   ?gname } .\n"
                + "    { ?x foaf:surname   ?fname } UNION  { ?x foaf:family_name ?fname } .\n"
                + " }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_2a";
        queryCase.name = "Sparql Specification section 16.2.2 Accessing Graphs in the RDF Dataset 1st query";
        queryCase.originalQuery = "CONSTRUCT { ?s ?p ?o } WHERE { GRAPH <http://example.org/aGraph> { ?s ?p ?o } . }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_2b";
        queryCase.name = "Sparql Specification section 16.2.2 Accessing Graphs in the RDF Dataset 2nd query";
        queryCase.originalQuery = "PREFIX  dc: <http://purl.org/dc/elements/1.1/>\n"
                + "PREFIX app: <http://example.org/ns#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "CONSTRUCT { ?s ?p ?o } WHERE\n"
                + " {\n"
                + "   GRAPH ?g { ?s ?p ?o } .\n"
                + "   ?g dc:publisher <http://www.w3.org/> .\n"
                + "   ?g dc:date ?date .\n"
                + "   FILTER ( app:customDate(?date) > \"2005-02-28T00:00:00Z\"^^xsd:dateTime ) .\n"
                + " }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_3";
        queryCase.name = "Sparql Specification section 16.2.3 Solution Modifiers and CONSTRUCT";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "PREFIX site: <http://example.org/stats#>\n"
                + "CONSTRUCT { [] foaf:name ?name }\n"
                + "WHERE\n"
                + "{ [] foaf:name ?name ;\n"
                + "     site:hits ?hits .\n"
                + "}\n"
                + "ORDER BY desc(?hits)\n"
                + "LIMIT 2";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_4a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_4a";
        queryCase.name = "Sparql Specification section 16.2.4 CONSTRUCT WHERE 1st query";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "CONSTRUCT WHERE { ?x foaf:name ?name } ";   
        //Sparql docs say these are the same so why worry!
        queryCase.noReplaceQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "CONSTRUCT { ?x foaf:name ?name } \n"
                + "WHERE\n"
                + "{ ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_2_4b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_2_4b";
        queryCase.name = "Sparql Specification section 16.2.4 CONSTRUCT WHERE 2nd query";
        queryCase.originalQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "CONSTRUCT { ?x foaf:name ?name } \n"
                + "WHERE\n"
                + "{ ?x foaf:name ?name }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_3a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_3a";
        queryCase.name = "Sparql Specification section 16.3 ASK 1st query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "ASK  { ?x foaf:name  \"Alice\" }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_3b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_3b";
        queryCase.name = "Sparql Specification section 16.3 ASK 2nd query";
        queryCase.originalQuery = "PREFIX foaf:    <http://xmlns.com/foaf/0.1/>\n"
                + "ASK  { ?x foaf:name  \"Alice\" ;\n"
                + "          foaf:mbox  <mailto:alice@work.example> }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_4_1() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_4_1";
        queryCase.name = "Sparql Specification section 16.4.1 Explicit IRIs";
        queryCase.originalQuery = "DESCRIBE <http://example.org/>";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_4_2a() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_4_2a";
        queryCase.name = "Sparql Specification section 16.4.2 Identifying Resources";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "DESCRIBE ?x\n"
                + "WHERE    { ?x foaf:mbox <mailto:alice@org> }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_4_2b() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_4_2b";
        queryCase.name = "Sparql Specification section 16.4.2 Identifying Resources";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "DESCRIBE ?x\n"
                + "WHERE    { ?x foaf:name \"Alice\" }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_4_2c() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_4_2c";
        queryCase.name = "Sparql Specification section 16.4.2 Identifying Resources";
        queryCase.originalQuery = "PREFIX foaf:   <http://xmlns.com/foaf/0.1/>\n"
                + "DESCRIBE ?x\n"
                + "WHERE    { ?x foaf:name \"Alice\" }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql16_4_3() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql16_4_3";
        queryCase.name = "Sparql Specification section 16.4.3 Descriptions of Resources";
        queryCase.originalQuery = "PREFIX ent:  <http://org.example.com/employees#>\n"
                + "DESCRIBE ?x WHERE { ?x ent:employeeId \"1234\" }";                
        queries.put(queryCase.key, queryCase);
   }

  private void loadSparql() {
        QueryCase queryCase = new QueryCase();
        queryCase.key = "Sparql";
        queryCase.name = "Sparql Specification section ";
        queryCase.originalQuery = "";                
        queries.put(queryCase.key, queryCase);
   }

   public Set<String> keySet(){
       return queries.keySet();
   }
   
    String getQueryName(String key) {
       return queries.get(key).name;
    }

   public String getOriginalQuery(String key){
       return queries.get(key).originalQuery;
   }

   public String getNoReplaceQuery(String key){
       if (queries.get(key).noReplaceQuery != null){
           return queries.get(key).noReplaceQuery;
       }
       return queries.get(key).originalQuery;
   }
}



