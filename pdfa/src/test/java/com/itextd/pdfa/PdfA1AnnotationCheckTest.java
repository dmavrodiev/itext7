package com.itextd.pdfa;

import com.itextpdf.basics.geom.Rectangle;
import com.itextpdf.basics.io.ByteArrayOutputStream;
import com.itextpdf.core.pdf.*;
import com.itextpdf.core.pdf.annot.*;
import com.itextpdf.pdfa.PdfAConformanceException;
import com.itextpdf.pdfa.PdfAConformanceLevel;
import com.itextpdf.pdfa.PdfADocument;
import com.itextpdf.pdfa.PdfOutputIntent;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PdfA1AnnotationCheckTest {
    static final public String sourceFolder = "./src/test/resources/com/itextpdf/pdfa/PdfAnnotationCheckTest/";
    static final public String destinationFolder = "./target/test/com/itextpdf/pdfa/PdfAnnotationCheckTest/";

    @BeforeClass
    static public void beforeClass() {
        new File(destinationFolder).mkdirs();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest01() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfAnnotation annot = new PdfFileAttachmentAnnotation(doc, rect);
        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest02() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfMarkupAnnotation annot = new PdfTextAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);
        annot.setOpacity(new PdfNumber(0.5));

        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest03() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfMarkupAnnotation annot = new PdfTextAnnotation(doc, rect);
        annot.setFlag(0);

        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest04() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfMarkupAnnotation annot = new PdfTextAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);
        annot.setFlag(PdfAnnotation.Invisible);

        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest05() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfAnnotation annot = new PdfWidgetAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);

        PdfStream s = new PdfStream("Hello World".getBytes());
        annot.setDownAppearance(new PdfDictionary());
        annot.setNormalAppearance(s);

        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest06() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfAnnotation annot = new PdfWidgetAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);

        annot.setNormalAppearance(new PdfDictionary());

        page.addAnnotation(annot);
        doc.close();
    }

    @Test
    public void annotationCheckTest07() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1B, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfMarkupAnnotation annot = new PdfTextAnnotation(doc, rect);
        annot.setFlags(PdfAnnotation.Print | PdfAnnotation.NoZoom | PdfAnnotation.NoRotate);

        page.addAnnotation(annot);
        doc.close();
    }

    @Test(expected = PdfAConformanceException.class)
    public void annotationCheckTest08() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1A, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfAnnotation annot = new PdfStampAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);

        page.addAnnotation(annot);
        doc.close();
    }

    @Test
    public void annotationCheckTest09() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(new ByteArrayOutputStream());
        InputStream is = new FileInputStream(sourceFolder + "sRGB Color Space Profile.icm");
        PdfADocument doc = new PdfADocument(writer, PdfAConformanceLevel.PDF_A_1A, new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", is));

        PdfPage page = doc.addNewPage();

        Rectangle rect = new Rectangle(100, 100, 100, 100);
        PdfAnnotation annot = new PdfStampAnnotation(doc, rect);
        annot.setFlag(PdfAnnotation.Print);
        annot.setContents("Hello world");

        page.addAnnotation(annot);
        doc.close();
    }
}