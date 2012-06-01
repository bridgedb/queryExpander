/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.cs.openphacts.queryexpander;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;
import uk.ac.man.cs.openphacts.queryexpander.mapper.BridgeDBMapper;
import uk.ac.man.cs.openphacts.queryexpander.queryLoader.Ops1_1QueryLoader;
import uk.ac.man.cs.openphacts.queryexpander.queryLoader.QueryCaseLoader;
import uk.ac.man.cs.openphacts.queryexpander.queryLoader.SparqlLoader;

/**
 *
 * @author Christian
 */
public class QueryExpanderWsServer {
    
    private QueryExpander queryExpander;
    
    public QueryExpanderWsServer() throws QueryExpansionException{
        BridgeDBMapper imsMapper = BridgeDBFactory.getBridgeDBMapper();
        queryExpander = new QueryExpanderImpl(imsMapper);
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response welcomeMessage() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        sb.append("<head>\n");
        sb.append("<title>Manchester OpenPhacts Query Expander</title></head>\n");
        sb.append("<FRAMESET rows=\"150, 200\">\n");
        sb.append("<FRAME src=\"QueryExpander/top\" name=\"topFrame\">\n");
        sb.append("<FRAME src=\"QueryExpander/examples\" name =\"bottomFrame\">\n");
        sb.append("</FRAMESET>\n");
        sb.append("<NOFRAMES>");
        sb.append("<P>this page requires frames! Trust Me!");
        sb.append("</NOFRAMES>\n");
        sb.append("</FRAMESET>\n");
        sb.append("</html>");
        return Response.ok(sb.toString(), MediaType.TEXT_HTML).build();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/top") 
    public Response topFrame(@QueryParam("query") @DefaultValue("SELECT *\nWHERE { \n?s ?p ?o\n}") String query) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        sb.append("<body>\n");
        sb.append("<FORM METHOD=GET ACTION=\"expand\" Target=\"bottomFrame\" >\n");
        sb.append("<h2>Enter your query here:</H2>\n");
        sb.append("<TEXTAREA NAME=query ROWS=15 COLS=100>\n");
        sb.append(query);
        sb.append("\n");
        sb.append("</TEXTAREA>\n");
        sb.append("<TEXTAREA NAME=parameter ROWS=10 COLS=20>\n");
        sb.append("</TEXTAREA>\n");
        sb.append("<TEXTAREA NAME=inputURI ROWS=5 COLS=20>\n");
        sb.append("</TEXTAREA>\n");
        sb.append("<BR>\n");
        sb.append("<INPUT TYPE=submit VALUE=\"Expand this query\">\n");
        sb.append("</FORM>\n");
        sb.append("</body>\n");
        sb.append("</html>");
        return Response.ok(sb.toString(), MediaType.TEXT_HTML).build();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/examples") 
    public Response exampleFrame() {
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        appendToggler(sb);
        sb.append("<body onload=\"hideDetails()\">\n");
        sb.append("<h2>Groups of Examples:</H2>\n");  
        sb.append("<H2 onclick=\"toggleItem('ops')\" style=\"color:blue;\"> <u>Queries used in Open Phacts</u></H2>\n");
        loaderExamples(sb, new Ops1_1QueryLoader(), "ops");
        sb.append("<H2 onclick=\"toggleItem('sparql')\" style=\"color:blue;\"> <u>Queries found in Sparql 1.1 specifications</u></H2>\n");
        loaderExamples(sb, new SparqlLoader(), "sparql");
        sb.append("</body>");
        sb.append("</html>");
        return Response.ok(sb.toString(), MediaType.TEXT_HTML).build();
    }

    private void appendToggler(StringBuilder sb){
        sb.append("<head>\n");
        sb.append("<title> New Document </title>\n");
        sb.append("<script language=\"javascript\">\n");
        sb.append("function getItem(id)\n");
        sb.append("{\n");
        sb.append("    var itm = false;\n");
        sb.append("    if(document.getElementById)\n");
        sb.append("        itm = document.getElementById(id);\n");
        sb.append("    else if(document.all)\n");
        sb.append("        itm = document.all[id];\n");
        sb.append("     else if(document.layers)\n");
        sb.append("        itm = document.layers[id];\n");
        sb.append("    return itm;\n");
        sb.append("}\n\n");
        sb.append("function toggleItem(id)\n");
        sb.append("{\n");
        sb.append("    itm = getItem(id);\n");
        sb.append("    if(!itm)\n");
        sb.append("        return false;\n");
        sb.append("    if(itm.style.display == 'none')\n");
        sb.append("        itm.style.display = '';\n");
        sb.append("    else\n");
        sb.append("        itm.style.display = 'none';\n");
        sb.append("    return false;\n");
        sb.append("}\n\n");
        sb.append("function hideDetails()\n");
        sb.append("{\n");
        sb.append("     toggleItem('ops')\n");
        sb.append("     toggleItem('sparql')\n");
        sb.append("     return true;\n");
        sb.append("}\n\n");
        sb.append("</script>\n");
        sb.append("</head>\n");
        sb.append("\n");
    }

    public void loaderExamples(StringBuilder sb, QueryCaseLoader loader, String group) {
        sb.append("<ul id =\"");
        sb.append(group);
        sb.append("\" >\n");
        Set<String> queryKeys = loader.keySet();
        for (String queryKey:queryKeys){
            sb.append("<li><a href=\"top?query=");
            sb.append(URLEncoder.encode(loader.getOriginalQuery(queryKey)));
            sb.append("\" target=\"topFrame\">");
            sb.append(loader.getQueryName(queryKey));
            sb.append("</a></li>\n");
        }
    	sb.append("</ul>");
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/expand") 
    public ExpanderBean expandXML(@QueryParam("query") String query,
            @QueryParam("parameter") List<String> parameters ,            
            @QueryParam("inputURI") String inputURI) throws QueryExpansionException{
        ExpanderBean result = new ExpanderBean();
        result.setOrginalQuery(query);
        result.setExpandedQuery(checkAndExpand(query, parameters, inputURI));
        return result;
    }

    private String checkAndExpand(String query, List<String> parameters, String inputURI) throws QueryExpansionException{
        if (query == null){
            throw new QueryExpansionException ("query paramater is missing!");
        }
        URI check = null;
        if (parameters.isEmpty()){
            if (inputURI != null && !inputURI.isEmpty()) {
                throw new QueryExpansionException ("parameter \"parameter\" is missing! " + parameters);
            }
            
        } else {
            if (inputURI != null && !inputURI.isEmpty()){
                throw new QueryExpansionException ("inputURI is missing! With parameters of size " + parameters.size() );
            }
            check = new URIImpl(inputURI);
        }       
        return queryExpander.expand(query, parameters, inputURI);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/expandXML") 
    public ExpanderBean expandAsXML(@QueryParam("query") String query,
            @QueryParam("parameter") List<String> parameters ,            
            @QueryParam("inputURI") String inputURI) throws QueryExpansionException{
        return expandXML(query, parameters, inputURI);
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/expand") 
    public Response expandHtml(@QueryParam("query") String query,
            @QueryParam("parameter") List<String> parameters,            
            @QueryParam("inputURI") String inputURI)throws QueryExpansionException{
        String result = checkAndExpand(query, parameters, inputURI);
        System.out.println(result);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        appendToggler(sb);
        sb.append("<body>\n");
        sb.append("<a href=\"examples\">Return to example Index.</a>\n");
        sb.append("<a href=\"expandXML?query=");
        sb.append(URLEncoder.encode(query));
        sb.append("\">View Xml/Jason result</a>\n");
        sb.append("<h2>Expanded Query</H2>\n"); 
        sb.append("<textarea ROWS=15 COLS=100>");
        sb.append(result);
        sb.append("</textarea>");
        sb.append("</body>");
        sb.append("</html>");
        return Response.ok(sb.toString(), MediaType.TEXT_HTML).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/URISpacesPerGraph") 
    public List<URISpacesInGraphBean> URISpacesPerGraphAsXML() throws QueryExpansionException{
        Map<String, Set<String>> URISpacesPerGraph = queryExpander.getURISpacesPerGraph();
        ArrayList<URISpacesInGraphBean> results = new ArrayList<URISpacesInGraphBean>();
        for (String graph:URISpacesPerGraph.keySet()){
           results.add(new URISpacesInGraphBean(graph, URISpacesPerGraph.get(graph)));
        }
        return results;
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/URISpacesPerGraph") 
    public Response URISpacesPerGraphAsHtml() throws QueryExpansionException{
        Map<String, Set<String>> URISpacesPerGraph = queryExpander.getURISpacesPerGraph();
        
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        appendToggler(sb);
        sb.append("<head>");
        sb.append("<title>Manchester OpenPhacts Query Expander</title></head>\n");
        sb.append("<body>\n");
        sb.append("<a href=\"/QueryExpander\">Return to Main Page.</a>\n");
        sb.append("<h2>URISpaces Per Graph</H2>\n"); 
        sb.append("<p>");
        sb.append("<table border=\"1\">");
        sb.append("<tr>");
        sb.append("<th>Graph</th>");
        sb.append("<th>NameSpace</th>");
        sb.append("</tr>");
        for (String graph:URISpacesPerGraph.keySet()){
             for (String URISpace:URISpacesPerGraph.get(graph)){
                sb.append("<tr>");
                sb.append("<td>");
                sb.append(graph);
                sb.append("</td>");
                sb.append("<td>");
                sb.append(URISpace);
                sb.append("</td>");
                sb.append("</tr>");
             }
            sb.append("<tr>");
            sb.append("</tr>");
        }
        sb.append("</body>");
        sb.append("</html>");
        return Response.ok(sb.toString(), MediaType.TEXT_HTML).build();
    }
}
