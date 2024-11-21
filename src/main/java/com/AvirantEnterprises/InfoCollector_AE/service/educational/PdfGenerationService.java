package com.AvirantEnterprises.InfoCollector_AE.service.educational;
import com.AvirantEnterprises.InfoCollector_AE.model.educational.Education;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class PdfGenerationService {

    public void generateEducationPdf(Education education, String filePath) {
        try {
            // Initialize PDF writer
            PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));

            // Create PDF document
            com.itextpdf.kernel.pdf.PdfDocument pdf = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdf);

            // Add content to PDF
            document.add(new Paragraph("Education Details"));
            document.add(new Paragraph("PUC: " + education.getPuc()));
            document.add(new Paragraph("Degree: " + education.getDegree()));
            document.add(new Paragraph("PG: " + education.getPg()));
            document.add(new Paragraph("Course: " + education.getCourse()));

            // Close document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
