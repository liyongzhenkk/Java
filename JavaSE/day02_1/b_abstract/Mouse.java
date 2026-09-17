package day02_1.b_abstract;



public class Mouse implements Usb {
    @Override
    public void open() {
        System.out.println("mouse open ");
    }

    @Override
    public void close() {
        System.out.println("mouse close");
    }
}
