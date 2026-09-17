package day03.test2;

public class test {
    public static void main(String[] args) {
//        Usb usb1 = createMouse();
//        Usb usb1 = new Usb(){
//            @Override
//            public void start(){
//                System.out.println("start usb1");
//            }
//            @Override
//            public void stop(){
//                System.out.println("stop usb1");
//            }
//        };
//
//        usb1.start();
        Usb usb2 = method(new Usb() {
            @Override
            public void start() {
                System.out.println("Usb start111");
            }

            @Override
            public void stop() {
                System.out.println("Usb stop111");
            }
        });
        usb2.start();
        usb2.stop();

    }
    public static Usb method(Usb usb) {
        usb.start();
        usb.stop();
        return new Usb() {
            @Override
            public void start() {
                System.out.println("Usb start222");

            }

            @Override
            public void stop() {
                System.out.println("Usb stop222");
            }
        };

    }
//    public static Usb createMouse() {
//        class Mouse implements Usb {
//            @Override
//            public void start() {
//                System.out.println("Mouse start");
//            }
//
//            @Override
//            public void stop() {
//                System.out.println("Mouse stop");
//            }
//        }
//        Mouse mouse1 = new Mouse();
//        return mouse1;
//    }
}
