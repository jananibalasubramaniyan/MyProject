package DataDrivenTesting;

import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {
		
		File file=new File("./src/test/resources/sample.pdf");
		
		PDDocument doc=PDDocument.load(file);
		  
		int pages=doc.getNumberOfPages();
		//System.out.println(pages);
		
		PDFTextStripper pdfdata=new PDFTextStripper();
		//String data=pdfdata.getText(doc);
		//System.out.println(data);
		
		pdfdata.setStartPage(4);
		//String pageData=pdfdata.getText(doc);
		//System.out.println(pageData);
		
		pdfdata.setStartPage(2);
		pdfdata.setEndPage(4);
		String pageDatas=pdfdata.getText(doc);
		System.out.println(pageDatas);
				
		

	}

}
