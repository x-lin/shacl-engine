package at.ac.tuwien.shacl.model;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class HasValue implements PropertyConstraint {
	private Resource focusNode;
	
	private Resource predicate;
	
	private RDFNode hasValueNode;
	
	public HasValue(Resource focusNode, Resource predicate, RDFNode hasValueNode) {
		this.focusNode = focusNode;
		this.predicate = predicate;
		this.hasValueNode = hasValueNode;
	}
	
	public Resource getFocusNode() {
		return focusNode;
	}

	public void setFocusNode(Resource focusNode) {
		this.focusNode = focusNode;
	}

	public Resource getPredicate() {
		return predicate;
	}

	public void setPredicate(Resource predicate) {
		this.predicate = predicate;
	}

	public RDFNode getHasValueNode() {
		return hasValueNode;
	}

	public void setHasValueNode(RDFNode hasValueNode) {
		this.hasValueNode = hasValueNode;
	}
}
