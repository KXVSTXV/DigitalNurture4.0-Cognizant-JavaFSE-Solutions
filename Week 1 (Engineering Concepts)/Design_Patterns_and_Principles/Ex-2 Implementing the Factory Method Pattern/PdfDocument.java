public class PdfDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Opening a PDF document");
    }

    @Override
    public void close()
    {
        System.out.println("Closing a PDF document");
    }
}