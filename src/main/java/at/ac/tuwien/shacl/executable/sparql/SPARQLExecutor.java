package at.ac.tuwien.shacl.executable.sparql;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.shared.JenaException;

public class SPARQLExecutor {
	
	public RDFNode executeAsSingleValue(String executable, Model model) {
		QueryExecution exec = QueryExecutionFactory.create(executable, model);
		return this.executeAsSingleValue(exec, executable);
	}

	public RDFNode executeAsSingleValue(String executable, Dataset dataset) {
		QueryExecution exec = QueryExecutionFactory.create(executable, dataset);
		return this.executeAsSingleValue(exec, executable);
	}
	
	public RDFNode executeAsSingleValue(String query, Model model, Map<String, RDFNode> variables) {
		QueryExecution exec = QueryExecutionFactory.create(query, model, this.createBindings(variables));
		return this.executeAsSingleValue(exec, query);
	}

	public RDFNode executeAsSingleValue(String query, Dataset dataset, Map<String, RDFNode> variables) {
		QueryExecution exec = QueryExecutionFactory.create(query, dataset, this.createBindings(variables));
		return this.executeAsSingleValue(exec, query);
	}
	
	private RDFNode executeAsSingleValue(QueryExecution exec, String query) {
		try {
			System.out.println(exec.getQuery());
			if(this.isAskQuery(query)) {
				boolean res = exec.execAsk();
				return ResourceFactory.createTypedLiteral(res);
			} else if(this.isSelectQuery(query)) {
				ResultSet result = exec.execSelect();
				return result.next().get("result");
			} else {
				//TODO create custom exception
				throw new JenaException("not the right query type");
			}
		} finally {
			exec.close();
		}
	}
	
	public Map<String, RDFNode> executeAsMultipleValues(String executable, Model model) {
		QueryExecution exec = QueryExecutionFactory.create(executable, model);
		return this.executeAsMultipleValues(exec, executable);
	}

	public Map<String, RDFNode> executeAsMultipleValues(String executable, Dataset dataset) {
		QueryExecution exec = QueryExecutionFactory.create(executable, dataset);
		return this.executeAsMultipleValues(exec, executable);
	}
	
	public Map<String, RDFNode> executeAsMultipleValues(String query, Model model, Map<String, RDFNode> variables) {
		QueryExecution exec = QueryExecutionFactory.create(query, model, this.createBindings(variables));
		return this.executeAsMultipleValues(exec, query);
	}

	public Map<String, RDFNode> executeAsMultipleValues(String query, Dataset dataset, Map<String, RDFNode> variables) {
		QueryExecution exec = QueryExecutionFactory.create(query, dataset, this.createBindings(variables));
		return this.executeAsMultipleValues(exec, query);
	}
	
	private Map<String, RDFNode> executeAsMultipleValues(QueryExecution exec, String query) {
		try {
			if(this.isSelectQuery(query)) {
				ResultSet result = exec.execSelect();
				
				List<QuerySolution> list = ResultSetFormatter.toList(result);

				HashMap<String, RDFNode> variables = new HashMap<String, RDFNode>();
				System.out.println("query executed");
				System.out.println("list: "+list);
				if(list.size() > 0) {
					Iterator<String> it = list.get(0).varNames();
					
					while(it.hasNext()) {
						String varName = it.next();
						variables.put(varName, list.get(0).get(varName));
					}
				}
				
				return variables;
			} else {
				throw new JenaException("not the right query type");
			}
		} finally {
			exec.close();
		}
	}

	public boolean isAskQuery(String query) {
		Query q = QueryFactory.create(query);
		return q.isAskType();
	}
	
	public boolean isSelectQuery(String query) {
		Query q = QueryFactory.create(query);
		return q.isSelectType();
	}

	private QuerySolutionMap createBindings(Map<String, RDFNode> variables) {
		QuerySolutionMap bindings = new QuerySolutionMap();
		
		for(Map.Entry<String, RDFNode> var : variables.entrySet()) {
			System.out.println("var: "+var.getKey() + " "+var.getValue());
			bindings.add(var.getKey(), var.getValue());
		}
		
		System.out.println("bindings: "+bindings);
		
		return bindings;
	}
}
