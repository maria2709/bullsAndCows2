// You can experiment here, it won’t be checked

 class Rectangle {
  private int length;
  private int width;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
  }

  public Rectangle(int size) {
    this(size, size);
  }

  public int square() {
      return length*width;
  }

}

public class Main {
    public static void main(String [] args) {
        Rectangle rec = new Rectangle(100);
        System.out.println(rec.square());

    }



}