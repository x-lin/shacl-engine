package at.ac.tuwien.shacl.sparql;

import com.hp.hpl.jena.sparql.expr.NodeValue;


/**
 * This function implements sh:hasShape
 * Since the SHACL definition contains no current SPARQL definition of sh:hasShape,
 * a custom function is defined here.
 * This function will be removed, once a SPARQL definition is published.
 * 
 * @author xlin
 *
 */
public class HasShapeFunction {
	public static boolean hasShape() {
		//just a dummy function, remove when real method (see below) is implemented
		boolean hasShape = false;
		
		return hasShape;
	}
	
	/*
	 * The function sh:hasShape returns true if	a given node (?arg1) matches a given shape (?arg2). 
	   The return type of this function is xsd:boolean.

		Argument	Value type	Description
		?arg1	Any IRI or blank node	The node to validate
		?arg2	sh:Shape or rdfs:Class	The shape to match against
		?arg3	rdfs:Resource	The URI of the current shapes graph (variable ?shapesGraph in constraints)
	
		This function must perform constraint validation equivalent to the validateNodeAgainstShape operation. 
		The function must return true if the operation returns no error-level constraint violations, 
		false if any error-level constraint violations exist.
	 */
	public static boolean hasShape(NodeValue arg1, NodeValue arg2, NodeValue arg3) {
		//TODO implement hasShape
		boolean hasShape = false;
				
		return hasShape;		
	}
}
