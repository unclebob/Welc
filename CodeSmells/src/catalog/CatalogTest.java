////////////////////////////////////////////////
// PATH 1
////////////////////////////////////////////////
package catalog;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

	private Catalog catalog;

	@Before
	public void setUp() {
		catalog = new Catalog();
		catalog.add("Hammer – 10 lb");
		catalog.add("shirt – XL – blue");
		catalog.add("shirt – L – green");
		catalog.add("Halloween candle – orange");
		catalog.add("Halloween candy – gum");
	}

	@Test
	public void testSimpleQuery() {
		List<String> list = catalog.itemsMatching("shirt");
		assertEquals(2, list.size());

		// An additional test
		Query query = new OrQuery(new StringQuery("shirt"), new StringQuery(
				"Halloween"));
		list = catalog.itemsMatching(query);
		assertEquals(4, list.size());
	}
	//
	//
	// ////////////////////////////////////////////////
	// // PATH 2
	// ////////////////////////////////////////////////
	//
	// Query query = new Query("shirt");
	// List list = query.matchesIn(catalog);
	// assertEquals(2, list.size());

}