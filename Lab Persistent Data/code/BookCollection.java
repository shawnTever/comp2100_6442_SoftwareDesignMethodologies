import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

// you need to import some xml libraries

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// import any standard library if needed
import com.google.gson.Gson;

/**
 * A book collection holds 0 or more books in a collection.
 */
public class BookCollection {
	private List<Book> books;

	/**
	 * Creates a new collection with no books by default.
	 */
	public BookCollection() {
		this.books = new ArrayList<Book>();
	}

	/**
	 * Creates a new book collection with the specified list of books pre-defined.
	 *
	 * @param books A books list.
	 */
	public BookCollection(List<Book> books) {
		this.books = books;
	}

	/**
	 * Returns the current list of books stored by this collection.
	 *
	 * @return A (mutable) list of books.
	 */
	public List<Book> getList() {
		return books;
	}

	/**
	 * Sets the list of books in this collection to the specified value.
	 */
	public void setList(List<Book> books) {
		this.books = books;
	}

	/**
	 * A simple human-readable toString implementation. Not particularly useful to
	 * save to disk.
	 *
	 * @return A human-readable string for printing
	 */
	@Override
	public String toString() {
		return this.books.stream().map(book -> " - " + book.display() + "\n").collect(Collectors.joining());
	}

	/**
	 * Saves this collection to the specified "bespoke" file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToBespokeFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in a bespoke format and should match the
		// load function.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)))
		{
			for (Book book : books) {
				String bookInformation = book.title + ";" + book.authorName + ";" +
						book.yearReleased + ";" + book.bookGenre;
				bw.write(bookInformation);
				bw.newLine();
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Saves this collection to the specified JSON file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToJSONFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in a JSON format and should match the load function.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter fw = new FileWriter(file)){
			gson.toJson(books, fw);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Saves this collection to the specified XML file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToXMLFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in an XML format and should match the
		// load function.
		File f = new File(String.valueOf(file));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();

			Element rootElement = d.createElement("Books");
			d.appendChild(rootElement);

			for(Book book : books)
			{
				Element bookElement = d.createElement("Book");
				bookElement.setAttribute("title", book.title);//<Person id="1">..

				Element authorNameElement = d.createElement("authorName");
				authorNameElement.appendChild(d.createTextNode(book.authorName));
				bookElement.appendChild(authorNameElement);

				Element yearReleasedElement = d.createElement("yearReleased");
				yearReleasedElement.appendChild(d.createTextNode(Integer.toString(book.yearReleased)));
				bookElement.appendChild(yearReleasedElement);

				Element bookGenreElement = d.createElement("bookGenre");
				bookGenreElement.appendChild(d.createTextNode(book.bookGenre.display()));
				bookElement.appendChild(bookGenreElement);

				rootElement.appendChild(bookElement);
			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(d);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Load a pre-existing book collection from a "bespoke" file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromBespokeFile(File file) {
		// TODO: Implement this function yourself.
		BookCollection bookCollection= new BookCollection();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String record;
			while((record = br.readLine()) != null)
			{
				String[] tokens = record.split(";");
				Book book = new Book(tokens[0], tokens[1],
						Integer.parseInt(tokens[2]), BookGenre.valueOf(tokens[3]));
				bookCollection.books.add(book);
			}

		}catch(IOException e)
		{
			e.printStackTrace();
		}

			return bookCollection;
	}

	/**
	 * Load a pre-existing book collection from a JSON file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromJSONFile(File file) {
		// TODO: Implement this function yourself.
		Gson gson = new Gson();
		JsonReader jsonReader = null;
		BookCollection bookCollection = new BookCollection();
		final Type CUS_LIST_TYPE = new TypeToken<List<Book>>() {}.getType();
		//or TypeToken.getParameterized(ArrayList.class, PersonJSON.class).getType();

		try{
			jsonReader = new JsonReader(new FileReader(file));
		}catch (Exception e) {
			e.printStackTrace();
		}
		bookCollection.books = gson.fromJson(jsonReader, CUS_LIST_TYPE);
		return bookCollection;
	}

	/**
	 * Load a pre-existing book collection from an XML file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromXMLFile(File file) {
		// TODO: Implement this function yourself.
		File f = new File(String.valueOf(file));
		//create a DocumentBuilder instance: DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//list
		List<Book> lb = new ArrayList<>();
		BookCollection bookCollection = new BookCollection();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(f);
			d.getDocumentElement().normalize();

			NodeList nl = d.getElementsByTagName("Book");

			for(int i = 0; i < nl.getLength(); i++)
			{
				Node n = nl.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) n;
					String title = element.getAttribute("title");
					String authorName = element.getElementsByTagName("authorName").item(0).getTextContent();
					Integer yearReleased = Integer.parseInt(element.getElementsByTagName("yearReleased").item(0).getTextContent());
					String bookGenreString = element.getElementsByTagName("bookGenre").item(0).getTextContent();
					BookGenre[] bG = BookGenre.class.getEnumConstants();
					Map<String, BookGenre> bookMap = new HashMap<>();
					for (BookGenre bg : bG) {
						bookMap.put(bg.name, bg);
					}
					Book book = new Book(title, authorName, yearReleased, bookMap.get(bookGenreString));
					lb.add(book);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		bookCollection.books = lb;
		return bookCollection;
	}
}
