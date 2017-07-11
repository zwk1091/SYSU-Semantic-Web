import java.io.*;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;
/**
 * Created by 焜 on 2017/7/10.
 */
public class RioRead {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(new File("src/main/resources/foaf.ttl"));

        RDFParser rdfParser = Rio.createParser(RDFFormat.TURTLE);

        Model model = new LinkedHashModel();
        rdfParser.setRDFHandler(new StatementCollector(model));

        rdfParser.parse(inputStream, "http://example.org/");

        FileOutputStream out = new FileOutputStream("src/main/resources/foaf.xml");
            Rio.write(model, out, RDFFormat.RDFXML);
    }
}
