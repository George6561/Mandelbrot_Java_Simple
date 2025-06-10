/*
 * Copyright © 2025 George Miller
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mandelbrot;

/**
 * Encapsulates the result of evaluating a point for membership in the Mandelbrot set.
 * <p>
 * This class records the number of iterations performed, the final orbit coordinates
 * in both generic and double precision formats, and whether the point is considered
 * to be inside the Mandelbrot set. It also provides detailed information on how
 * membership was determined, including checks for common features such as the main
 * cardioid and bulbs.
 * </p>
 * <p>
 * All instances are immutable and intended to provide accurate, structured output
 * for rendering, analysis, or debugging of Mandelbrot evaluations.
 * </p>
 *
 * @param <T> The type used to represent coordinates in the complex plane (e.g., Double, BigDecimal).
 * 
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class MandelbrotOutput<T> {

    /**
     * How the point was determine to be in the Mandelbrot set.
     */
    public static enum HowFound {

        /**
         * The algorithm iterated the maximum number of times set.
         */
        MAX_ITERATION,
        /**
         * The point was determined to be in the largest bulb of the set.
         */
        BULB,
        /**
         * The point was determined to be in the largest cardioid of the set.
         */
        CARDIOID,
        /**
         * The point was found by periodicity checking.
         */
        PERIOD,
        /**
         * The point is not in the set.
         */
        NOT
    }
    /**
     * The number of times the algorithm iterated before returning.
     */
    private final int iterations;
    /**
     * The x-coordinate of where the orbit ended in the generic class type.
     */
    private final T x;
    /**
     * The y-coordinate of where the orbit ended in the generic class type.
     */
    private final T y;
    /**
     * The x-coordinate of where the orbit ended in the double type.
     */
    private final double xDouble;
    /**
     * The y-coordinate of where the orbit ended in the double type.
     */
    private final double yDouble;
    /**
     * Whether or not this point is inside the Mandelbrot set. True if it is the
     * set, false if it is not.
     */
    private final boolean inSet;
    /**
     * How the algorithm determined this point was in the Mandelbrot set, if it
     * is, if it isn't the value will be NOT.
     */
    private final HowFound howFound;

    /**
     * Create a new instance of MandelbrotOutput.
     *
     * @param iterations The number of iterations the algorithm went through
     * before returning.
     * @param x The x-coordinate of where the orbit ended in the generic class
     * type.
     * @param y The y-coordinate of where the orbit ended in the generic class
     * type.
     * @param xDouble The x-coordinate of where the orbit ended in the double
     * type.
     * @param yDouble The y-coordinate of where the orbit ended in the double
     * type.
     * @param inSet Whether or not this point is on the set.
     * @param howFound How the point was determined to be in the set, if it was.
     */
    public MandelbrotOutput(int iterations,
            T x, T y, double xDouble, Double yDouble, boolean inSet, HowFound howFound) {
        this.iterations = iterations;
        this.x = x;
        this.y = y;
        this.xDouble = xDouble;
        this.yDouble = yDouble;
        this.inSet = inSet;
        this.howFound = howFound;
    }

    /**
     * Get the number of iterations the algorithm went through before returning.
     *
     * @return The number of iterations the algorithm went through before
     * returning.
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * Get the x-coordinate of where the orbit ended in the generic class type.
     *
     * @return The x-coordinate of where the orbit ended in the generic class
     * type.
     */
    public T getX() {
        return x;
    }

    /**
     * Get the y-coordinate of where the orbit ended in the generic class type.
     *
     * @return The y-coordinate of where the orbit ended in the generic class
     * type.
     */
    public T getY() {
        return y;
    }

    /**
     * Get the x-coordinate of where the orbit ended in double.
     *
     * @return The x-coordinate of where the orbit ended in double.
     */
    public double getDoubleX() {
        return xDouble;
    }

    /**
     * Get the y-coordinate of where the orbit ended in double.
     *
     * @return The y-coordinate of where the orbit ended in double.
     */
    public double getDoubleY() {
        return yDouble;
    }

    /**
     * Get if the point is in the Mandelbrot set. True if it is, false if it
     * isn't.
     *
     * @return If this point is in the Mandelbrot set.
     */
    public boolean isInSet() {
        return inSet;
    }

    /**
     * Get how the point was determined to be in the set, if it was.
     *
     * @return How the point was determined to be in the set, if it was.
     */
    public HowFound getHowFound() {
        return howFound;
    }
}
