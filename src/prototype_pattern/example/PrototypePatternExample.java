package prototype_pattern.example;

public class PrototypePatternExample {
    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();
        
        System.out.println("Prototype Pattern Example - Document Cloning");
        System.out.println("============================================");
        
        try {
            Document textDoc1 = manager.createDocument("text");
            textDoc1.setTitle("Meeting Notes");
            textDoc1.setContent("Discussion about quarterly goals and objectives.");
            System.out.println("\nOriginal: " + textDoc1.getInfo());
            
            Document textDoc2 = textDoc1.clone();
            textDoc2.setTitle("Meeting Notes - Copy");
            textDoc2.setContent("Discussion about quarterly goals and objectives. (Modified copy)");
            System.out.println("Cloned:   " + textDoc2.getInfo());
            
            Document pdfDoc1 = manager.createDocument("pdf");
            pdfDoc1.setTitle("Project Report");
            pdfDoc1.setContent("Comprehensive analysis of project milestones and deliverables.");
            if (pdfDoc1 instanceof PDFDocument) {
                ((PDFDocument) pdfDoc1).setPageCount(25);
                ((PDFDocument) pdfDoc1).setEncrypted(true);
            }
            System.out.println("\nOriginal: " + pdfDoc1.getInfo());
            
            Document pdfDoc2 = pdfDoc1.clone();
            pdfDoc2.setTitle("Project Report - Draft");
            if (pdfDoc2 instanceof PDFDocument) {
                ((PDFDocument) pdfDoc2).setEncrypted(false);
            }
            System.out.println("Cloned:   " + pdfDoc2.getInfo());
            
            System.out.println("\nDemonstrating independence of cloned objects:");
            System.out.println("Original PDF still encrypted: " + ((PDFDocument) pdfDoc1).isEncrypted());
            System.out.println("Cloned PDF not encrypted: " + ((PDFDocument) pdfDoc2).isEncrypted());
            
        } catch (CloneNotSupportedException e) {
            System.err.println("Error cloning document: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}