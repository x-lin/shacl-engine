package at.ac.tuwien.shacl.sparql;

import java.util.Map;

import at.ac.tuwien.shacl.util.SparqlUtil;

import com.fasterxml.jackson.databind.node.ValueNode;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class QueryBuilder {
	private String queryString;
	private QuerySolutionMap bindings;
	
	public QueryBuilder(String queryString, Map<String, String> prefixes) {
		this.queryString = queryString;
		this.bindings = new QuerySolutionMap();
		this.addPrefixes(prefixes);
	}
	
	public void addPrefixes(Map<String, String> prefixes) {
		String prefs = "";
		for(Map.Entry<String,String> p : prefixes.entrySet()) {
			prefs = prefs + "\n" + "PREFIX " + p.getKey() + ": <" + p.getValue() + ">";
		}
		queryString = prefs + "\n" + queryString;
	}
	
	public String getQueryString() {
		return queryString;
	}
	
	public void addBindings(Map<String, Resource> bindings) {
		for(Map.Entry<String, Resource> b : bindings.entrySet()) {
			this.bindings.add(b.getKey(), b.getValue());
		}
	}
	
	public void addBinding(String name, RDFNode node) {
		this.bindings.add(name, node);
	}
	
	public QuerySolutionMap getBindings() {
		System.out.println("bindings: "+bindings);
		return this.bindings;
	}

	public void addThisBinding(Resource thiz) {
		bindings.add("this", thiz);
	}
	
	public void addShapesGraphBinding(RDFNode graph) {
		bindings.add("shapesGraph", graph);
	}
	
	public void addCurrentShapeBinding(Resource shape) {
		bindings.add("currentShape", shape);
	}
	
	public void addPreBinding(Resource thiz, Resource shapesGraph, Resource currentShape) {
		this.addThisBinding(thiz);
		this.addShapesGraphBinding(shapesGraph);
		this.addCurrentShapeBinding(currentShape);
	}
}
