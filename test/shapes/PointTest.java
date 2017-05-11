package shapes;

import org.junit.*;

import static org.junit.Assert.*;

public class PointTest {
    private Point origin;
    private Point pointQ1;
    private Point pointQ2;
    private Point pointQ3;
    private Point pointQ4;

    private final double epsilon = 0.01;

    @Before
    public void setUp() {
        origin = new Point(0, 0);
        pointQ1 = new Point(1, 1);
        pointQ2 = new Point(-1, 1);
        pointQ3 = new Point(-1, -1);
        pointQ4 = new Point(1, -1);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("(0, 0)", origin.toString());
        assertEquals("(1, 1)", pointQ1.toString());
        assertEquals("(-1, 1)", pointQ2.toString());
        assertEquals("(-1, -1)", pointQ3.toString());
        assertEquals("(1, -1)", pointQ4.toString());
    }

    @Test
    public void testDistanceTo() throws Exception {
        assertEquals(Math.sqrt(2), origin.distanceTo(pointQ1), epsilon);
        assertEquals(Math.sqrt(2), pointQ1.distanceTo(origin), epsilon);

        assertEquals(Math.sqrt(2), origin.distanceTo(pointQ2), epsilon);
        assertEquals(Math.sqrt(2), pointQ2.distanceTo(origin), epsilon);

        assertEquals(Math.sqrt(2), origin.distanceTo(pointQ3), epsilon);
        assertEquals(Math.sqrt(2), pointQ3.distanceTo(origin), epsilon);

        assertEquals(Math.sqrt(2), origin.distanceTo(pointQ4), epsilon);
        assertEquals(Math.sqrt(2), pointQ4.distanceTo(origin), epsilon);

        assertEquals(2.0, pointQ1.distanceTo(pointQ2), epsilon);
        assertEquals(2.0, pointQ2.distanceTo(pointQ1), epsilon);

        assertEquals(2.0, pointQ2.distanceTo(pointQ3), epsilon);
        assertEquals(2.0, pointQ3.distanceTo(pointQ2), epsilon);

        assertEquals(2.0, pointQ3.distanceTo(pointQ4), epsilon);
        assertEquals(2.0, pointQ4.distanceTo(pointQ3), epsilon);

        assertEquals(2.0, pointQ4.distanceTo(pointQ1), epsilon);
        assertEquals(2.0, pointQ1.distanceTo(pointQ4), epsilon);

        assertEquals(Math.sqrt(8), pointQ1.distanceTo(pointQ3), epsilon);
        assertEquals(Math.sqrt(8), pointQ3.distanceTo(pointQ1), epsilon);

        assertEquals(Math.sqrt(8), pointQ2.distanceTo(pointQ4), epsilon);
        assertEquals(Math.sqrt(8), pointQ4.distanceTo(pointQ2), epsilon);
    }

    @Test
    public void testAngleTo() throws Exception {
        assertEquals(Math.PI * 1 / 4, origin.angleTo(pointQ1), epsilon);
        assertEquals(Math.PI * 5 / 4, pointQ1.angleTo(origin), epsilon);

        assertEquals(Math.PI * 3 / 4, origin.angleTo(pointQ2), epsilon);
        assertEquals(Math.PI * 7 / 4, pointQ2.angleTo(origin), epsilon);

        assertEquals(Math.PI * 5 / 4, origin.angleTo(pointQ3), epsilon);
        assertEquals(Math.PI * 1 / 4, pointQ3.angleTo(origin), epsilon);

        assertEquals(Math.PI * 7 / 4, origin.angleTo(pointQ4), epsilon);
        assertEquals(Math.PI * 3 / 4, pointQ4.angleTo(origin), epsilon);

        assertEquals(Math.PI, pointQ1.angleTo(pointQ2), epsilon);
        assertEquals(0, pointQ2.angleTo(pointQ1), epsilon);

        assertEquals(Math.PI * 3 / 2, pointQ2.angleTo(pointQ3), epsilon);
        assertEquals(Math.PI * 1 / 2, pointQ3.angleTo(pointQ2), epsilon);

        assertEquals(0, pointQ3.angleTo(pointQ4), epsilon);
        assertEquals(Math.PI, pointQ4.angleTo(pointQ3), epsilon);

        assertEquals(Math.PI * 1 / 2, pointQ4.angleTo(pointQ1), epsilon);
        assertEquals(Math.PI * 3 / 2, pointQ1.angleTo(pointQ4), epsilon);

        assertEquals(Math.PI * 5 / 4, pointQ1.angleTo(pointQ3), epsilon);
        assertEquals(Math.PI * 1 / 4, pointQ3.angleTo(pointQ1), epsilon);

        assertEquals(Math.PI * 7 / 4, pointQ2.angleTo(pointQ4), epsilon);
        assertEquals(Math.PI * 3 / 4, pointQ4.angleTo(pointQ2), epsilon);
    }

    private void assertPointAtAngle(
            Point start, Point expectedEnd) {
        Point actualEnd = start.pointAtAngle(
                start.angleTo(expectedEnd), start.distanceTo(expectedEnd));
        assertEquals(expectedEnd.x, actualEnd.x);
        assertEquals(expectedEnd.y, actualEnd.y);
    }

    @Test
    public void testPointAtAngle() throws Exception {
        assertPointAtAngle(origin, pointQ1);
        assertPointAtAngle(pointQ1, origin);

        assertPointAtAngle(origin, pointQ2);
        assertPointAtAngle(pointQ2, origin);

        assertPointAtAngle(origin, pointQ3);
        assertPointAtAngle(pointQ3, origin);

        assertPointAtAngle(origin, pointQ4);
        assertPointAtAngle(pointQ4, origin);

        assertPointAtAngle(pointQ1, pointQ2);
        assertPointAtAngle(pointQ2, pointQ1);

        assertPointAtAngle(pointQ2, pointQ3);
        assertPointAtAngle(pointQ3, pointQ2);

        assertPointAtAngle(pointQ3, pointQ4);
        assertPointAtAngle(pointQ4, pointQ3);

        assertPointAtAngle(pointQ4, pointQ1);
        assertPointAtAngle(pointQ1, pointQ4);
    }
}
