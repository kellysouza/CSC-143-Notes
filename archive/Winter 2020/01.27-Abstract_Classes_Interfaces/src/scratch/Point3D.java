package scratch;

public class Point3D extends Point {
    public int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Point3D)) {
            return false;
        }

        return super.equals(o) && this.y == ((Point3D) o).y;
    }
}
