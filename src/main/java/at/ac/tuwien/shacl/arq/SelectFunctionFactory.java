package at.ac.tuwien.shacl.arq;

import at.ac.tuwien.shacl.registry.ModelRegistry;
import at.ac.tuwien.shacl.registry.SHACLMetaModelRegistry;
import at.ac.tuwien.shacl.sparql.QueryBuilder;
import at.ac.tuwien.shacl.sparql.SPARQLQueryExecutor;
import at.ac.tuwien.shacl.validation.SHACLValidator;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.Function;
import com.hp.hpl.jena.sparql.function.FunctionBase2;
import com.hp.hpl.jena.sparql.function.FunctionFactory;

public class SelectFunctionFactory extends FunctionBase2 implements FunctionFactory {
	String uri;
	
	@Override
	public Function create(String uri) {
		this.uri = uri;
		return this;
	}

	@Override
	public NodeValue exec(NodeValue arg0, NodeValue arg1) {
		RDFNode result = null;
		
		if(SHACLMetaModelRegistry.getInstance().getFunction(uri)!= null) {
			QueryBuilder qb = new QueryBuilder(SHACLMetaModelRegistry.getInstance().getFunction(uri).getExecutableBody(),
					ModelRegistry.getCurrentModel().getNsPrefixMap());

			//System.out.println("prefixes:"+SHACLValidator.model.getNsPrefixMap());
			//TODO not working
			qb.addBinding("arg1", ResourceFactory.createResource(arg0.toString()));
			qb.addBinding("arg2", ResourceFactory.createResource(arg1.toString()));
			
			//TODO try to find a way to make things work with bindings instead
			String queryString = qb.getQueryString();
			queryString = queryString.replaceAll("\\?arg1", arg0.toString());
			queryString = queryString.replaceAll("\\?arg2", arg1.toString());
			result = SPARQLQueryExecutor.execSelect(queryString, ModelRegistry.getCurrentModel(), qb.getBindings());
		}

		return NodeValue.makeNode(result.asNode());
	}
}
