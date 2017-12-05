package se.kilathaar.concordion;

import org.concordion.api.ConcordionResources;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@RunWith(ConcordionRunner.class)
@Extensions({CustomCSS.class, EmbedExtension.class})
@ConcordionResources(includeDefaultStyling = false, value = {"/custom.css"})
public class CustomCSSFixture {

	public String readCSS() throws FileNotFoundException {
		String path = "src/test/resources/custom.css";
		BufferedReader reader = new BufferedReader(new FileReader(Paths.get(path).toFile()));
		return reader
			.lines()
			.collect(Collectors.joining("<br/>", "", ""));
	}

	public boolean returnTrue() {
		return true;
	}

	public boolean returnFalse() {
		return false;
	}
}
