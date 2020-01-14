package comple.t3h.learnspring;

public class Bikini implements Outfit {

    @Override
    public void wear() {
        System.out.println("Đang mặc bikini");
    }

    @Override
    public String toString() {
        return "Bikini{}";
    }
}
