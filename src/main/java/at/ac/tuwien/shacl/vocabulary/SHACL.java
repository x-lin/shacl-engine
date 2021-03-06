package at.ac.tuwien.shacl.vocabulary;

import java.io.InputStream;

import at.ac.tuwien.shacl.util.Config;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

/**
 * The SHACL vocabulary. Note that some parts might be outdated as this class is only
 * a snapshot of the changing SHACL specification.
 * 
 * @author xlin
 *
 */
public class SHACL {

    public final static String BASE_URI = "http://www.w3.org/ns/shacl";
    
    public final static String NAME = "SHACL";

    public final static String NS = BASE_URI + "#";

    public final static String PREFIX = "sh";
    
    public final static Property final_ = ResourceFactory.createProperty(NS + "final");
    
    public final static Property entailment = ResourceFactory.createProperty(NS + "entailment");
    
    public final static Resource ClosedShapeConstraint = ResourceFactory.createResource(NS + "ClosedShapeConstraint");
    
    public final static Resource ShapeClass = ResourceFactory.createResource(NS + "ShapeClass");
    
    public final static Resource ResultAnnotation = ResourceFactory.createResource(NS + "ResultAnnotation");
    
    public final static Property resultAnnotation = ResourceFactory.createProperty(NS + "resultAnnotation");
    
    public final static Property severity = ResourceFactory.createProperty(NS + "severity");
    
    public final static Property object = ResourceFactory.createProperty(NS + "object");

    public final static Property subject = ResourceFactory.createProperty(NS + "subject");
    
    public final static Property private_ = ResourceFactory.createProperty(NS + "private");

    public final static Property datatype = ResourceFactory.createProperty(NS + "datatype");

    public final static Property hasDatatype = ResourceFactory.createProperty(NS + "hasDatatype");
    
    public final static Resource Constraint = ResourceFactory.createResource(NS + "Constraint");

    public final static Resource OrConstraint = ResourceFactory.createResource(NS + "OrConstraint");

    public final static Resource AbstractRule = ResourceFactory.createResource(NS + "AbstractRule");

    public final static Resource Argument = ResourceFactory.createResource(NS + "Argument");

    public final static Resource BlankNode = ResourceFactory.createResource(NS + "BlankNode");

    public final static Resource NativeConstraint = ResourceFactory.createResource(NS + "NativeConstraint");

    public final static Resource SPARQLRule = ResourceFactory.createResource(NS + "SPARQLRule");

    public final static Resource ConstraintTemplate = ResourceFactory.createResource(NS + "ConstraintTemplate");

    public final static Resource TemplateConstraint = ResourceFactory.createResource(NS + "TemplateConstraint");

    public final static Resource ConstraintViolation = ResourceFactory.createResource(NS + "ConstraintViolation");

    public final static Resource Error = ResourceFactory.createResource(NS + "Error");

    public final static Resource FatalError = ResourceFactory.createResource(NS + "FatalError");

    public final static Resource Function = ResourceFactory.createResource(NS + "Function");

    public final static Resource Functions = ResourceFactory.createResource(NS + "Functions");

    public final static Resource Graph = ResourceFactory.createResource(NS + "Graph");

    public final static Resource GraphConstraintCheckingTestCase = ResourceFactory.createResource(NS + "GraphConstraintCheckingTestCase");

    public final static Resource InversePath = ResourceFactory.createResource(NS + "InversePath");

    public final static Resource InversePropertyConstraint = ResourceFactory.createResource(NS + "InversePropertyConstraint");

    public final static Resource IRI = ResourceFactory.createResource(NS + "IRI");

    public final static Resource Literal = ResourceFactory.createResource(NS + "Literal");

    public final static Resource Module = ResourceFactory.createResource(NS + "Module");

    public final static Resource OptionalPropertyConstraint = ResourceFactory.createResource(NS + "OptionalPropertyConstraint");

    public final static Resource PropertyConstraint = ResourceFactory.createResource(NS + "PropertyConstraint");

    public final static Resource ResourceConstraintCheckingTestCase = ResourceFactory.createResource(NS + "ResourceConstraintCheckingTestCase");

    public final static Resource Rule = ResourceFactory.createResource(NS + "Rule");

    public final static Resource RuleTemplate = ResourceFactory.createResource(NS + "RuleTemplate");

    public final static Resource RuleTemplates = ResourceFactory.createResource(NS + "RuleTemplates");

    public final static Resource Shape = ResourceFactory.createResource(NS + "Shape");

    public final static Resource Template = ResourceFactory.createResource(NS + "Template");

    public final static Resource Templates = ResourceFactory.createResource(NS + "Templates");

    public final static Resource TestCase = ResourceFactory.createResource(NS + "TestCase");

    public final static Resource UnionConstraintTemplate = ResourceFactory.createResource(NS + "UnionConstraintTemplate");

    public final static Resource Warning = ResourceFactory.createResource(NS + "Warning");

    public final static Property abstract_ = ResourceFactory.createProperty(NS + "abstract");

    public final static Property allowedValues = ResourceFactory.createProperty(NS + "allowedValues");

    public final static Property argument = ResourceFactory.createProperty(NS + "argument");

    public final static Property cachable = ResourceFactory.createProperty(NS + "cachable");

    public final static Property check = ResourceFactory.createProperty(NS + "check");

    public final static Property checkAll = ResourceFactory.createProperty(NS + "checkAll");

    public final static Property constraint = ResourceFactory.createProperty(NS + "constraint");

    public final static Property constraintViolations = ResourceFactory.createProperty(NS + "constraintViolations");

    public final static Property defaultValue = ResourceFactory.createProperty(NS + "defaultValue");

    public final static Property defaultValueType = ResourceFactory.createProperty(NS + "defaultValueType");

    public final static Resource eval = ResourceFactory.createResource(NS + "eval");

    public final static Property graph = ResourceFactory.createProperty(NS + "graph");

    public final static Resource hasShape = ResourceFactory.createResource(NS + "hasShape");

    public final static Resource hasType = ResourceFactory.createResource(NS + "hasType");

    public final static Property hasValue = ResourceFactory.createProperty(NS + "hasValue");
    
    public final static Property ignore = ResourceFactory.createProperty(NS + "ignore");

    public final static Property include = ResourceFactory.createProperty(NS + "include");

    public final static Property inverse = ResourceFactory.createProperty(NS + "inverse");

    public final static Property inverseProperty = ResourceFactory.createProperty(NS + "inverseProperty");

    public final static Resource invoke = ResourceFactory.createResource(NS + "invoke");

    public final static Property label = ResourceFactory.createProperty(NS + "label");

    public final static Property labelTemplate = ResourceFactory.createProperty(NS + "labelTemplate");

    public final static Property level = ResourceFactory.createProperty(NS + "level");

    public final static Property library = ResourceFactory.createProperty(NS + "library");

    public final static Property maxCount = ResourceFactory.createProperty(NS + "maxCount");

    public final static Property member = ResourceFactory.createProperty(NS + "member");

    public final static Property message = ResourceFactory.createProperty(NS + "message");

    public final static Property minCount = ResourceFactory.createProperty(NS + "minCount");

    public final static Property nodeShape = ResourceFactory.createProperty(NS + "nodeShape");

    public final static Property nodeKind = ResourceFactory.createProperty(NS + "nodeKind");

    public final static Resource objectCount = ResourceFactory.createResource(NS + "objectCount");

    public final static Property optional = ResourceFactory.createProperty(NS + "optional");

    public final static Property path = ResourceFactory.createProperty(NS + "path");

    public final static Property predicate = ResourceFactory.createProperty(NS + "predicate");

    public final static Property property = ResourceFactory.createProperty(NS + "property");

    public final static Resource propertyLabel = ResourceFactory.createResource(NS + "propertyLabel");

    public final static Property querySemanticsGraph = ResourceFactory.createProperty(NS + "querySemanticsGraph");

    public final static Property returnType = ResourceFactory.createProperty(NS + "returnType");

    public final static Property root = ResourceFactory.createProperty(NS + "root");

    public final static Property rule = ResourceFactory.createProperty(NS + "rule");

    public final static Property scopeClass = ResourceFactory.createProperty(NS + "scopeClass");

    public final static Property shape1 = ResourceFactory.createProperty(NS + "shape1");

    public final static Property shape2 = ResourceFactory.createProperty(NS + "shape2");

    public final static Property source = ResourceFactory.createProperty(NS + "source");

    public final static Property sparql = ResourceFactory.createProperty(NS + "sparql");

    public final static Property value = ResourceFactory.createProperty(NS + "value");

    public final static Property valueShape = ResourceFactory.createProperty(NS + "valueShape");

    public final static Property valueClass = ResourceFactory.createProperty(NS + "valueClass");

    public final static Property violation = ResourceFactory.createProperty(NS + "violation");

    public final static Resource walkObjects = ResourceFactory.createResource(NS + "walkObjects");

    public final static Resource walkSubjects = ResourceFactory.createResource(NS + "walkSubjects");

	public final static Property optionalWhenInherited = ResourceFactory.createProperty(NS + "optionalWhenInherited");

	public final static Property scopeShape = ResourceFactory.createProperty(NS + "scopeShape");

    public static String getURI() {
        return NS;
    }
    
    private static Model model;
    
    public static Model getModel() {
    	if(model == null) {
    		model = ModelFactory.createDefaultModel();
        	InputStream in = SHACL.class.getResourceAsStream("/"+Config.SHACL_METAMODEL_FILE_LOCATION);
        	model.read(in, "", "TURTLE");
    	}

		return model;
    }
}
