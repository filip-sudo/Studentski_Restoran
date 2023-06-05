package com.example.demo.services.Impl;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Jelovnik;
import com.example.demo.models.Meni;
import com.example.demo.services.PDFService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;

@Service
@Transactional
public class PDFServiceImpl implements PDFService {
	
	public void export(HttpServletResponse response, List<Meni> popisMeni, List<Jelovnik> popisJelovnik ) {
		
		Document document = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.open();
		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle.setSize(18);
		
		Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
		fontParagraph.setSize(12);
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10);
		
		PdfPTable table2 = new PdfPTable(8);
		table2.setWidthPercentage(100);
		table2.setSpacingBefore(10);
		
		writeMeniHeader(table);
		writeMeniData(table, popisMeni);
		
		writeJelovnikHeader(table2);
		writeJelovnikData(table2, popisJelovnik);
		
		Paragraph paragraph = new Paragraph("Meniji", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		Paragraph paragraph2 = new Paragraph("Jelovnici", fontTitle);
		paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
		
		
		
		
		document.add(paragraph);
		document.add(table);
		document.add(paragraph2);
		document.add(table2);
		document.close();
		}

	private void writeMeniHeader(PdfPTable table) {
		// TODO Auto-generated method stub
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Naziv", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Juha", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("G. jelo", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Desert", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Vege", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Kalorije", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Cijena", font));
		table.addCell(cell);
	}
	
	private void writeMeniData(PdfPTable table, List<Meni> popisMeni) {
		for(Meni meni : popisMeni) {
			table.addCell(String.valueOf(meni.getId_meni()));
			table.addCell(meni.getNaziv());
			table.addCell(meni.getJuha());
			table.addCell(meni.getGlavno_jelo());
			table.addCell(meni.getDesert());
			table.addCell(String.valueOf(meni.getVege()));
			table.addCell(String.valueOf(meni.getKalorije()));
			table.addCell(String.valueOf(meni.getCijena()));
		}
	}
	
	private void writeJelovnikHeader(PdfPTable table) {
		// TODO Auto-generated method stub
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Naziv", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Restoran", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Adresa", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Datum", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Meni 1", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Meni 2", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Meni 3", font));
		table.addCell(cell);
	}
	
	private void writeJelovnikData(PdfPTable table, List<Jelovnik> popisJelovnik) {
		for(Jelovnik jelovnik : popisJelovnik) {
			table.addCell(String.valueOf(jelovnik.getId_jelovnik()));
			table.addCell(jelovnik.getNaziv());
			table.addCell(jelovnik.getRestoran());
			table.addCell(jelovnik.getAdresa());
			table.addCell(String.valueOf(jelovnik.getDatum()));
			table.addCell(jelovnik.getMeni1());
			table.addCell(jelovnik.getMeni2());
			table.addCell(jelovnik.getMeni3());
		}}

}
