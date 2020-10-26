package objects;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance (MyPoint secondPoint){
        return Math.sqrt(Math.pow(this.x-secondPoint.x,2)+Math.pow(this.y-secondPoint.y,2));
    }


}
