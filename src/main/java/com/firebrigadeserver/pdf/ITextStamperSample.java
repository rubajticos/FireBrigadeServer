package com.firebrigadeserver.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ITextStamperSample {

    public static void generatePdfForAnalysis(String filename, String fireBrigadeName, String analysisDesc, String dataInfo, String analysisResult) throws IOException, DocumentException {

        PdfReader pdfTemplate = new PdfReader("analysis_form.pdf");

        FileOutputStream fileOutputStream = new FileOutputStream(filename + ".pdf");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(pdfTemplate, out);
        stamper.setFormFlattening(true);

        AcroFields fields = stamper.getAcroFields();
        final BaseFont font = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);

        fields.setFieldProperty("firebrigade_name_field", "textfont", font, null);
        stamper.getAcroFields().setField("firebrigade_name_field", fireBrigadeName);

        fields.setFieldProperty("analysis_description_field", "textfont", font, null);
        stamper.getAcroFields().setField("analysis_description_field", analysisDesc);

        fields.setFieldProperty("analysis_data_info_field", "textfont", font, null);
        stamper.getAcroFields().setField("analysis_data_info_field", dataInfo);

        fields.setFieldProperty("analysis_result_field", "textfont", font, null);
        stamper.getAcroFields().setField("analysis_result_field", analysisResult);

        stamper.close();
        pdfTemplate.close();

        fileOutputStream.write(out.toByteArray());
        fileOutputStream.close();
    }

}
