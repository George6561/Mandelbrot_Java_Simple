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
 * Container for all input parameters required to evaluate a point in the Mandelbrot set.
 * <p>
 * This class stores the starting complex coordinate, maximum iteration count, and
 * bailout threshold for escape detection. It is generic over the coordinate type {@code T},
 * allowing flexible representations such as doubles, high-precision decimals, or custom types.
 * </p>
 * <p>
 * Getter and setter methods provide full control over the parameters, supporting dynamic
 * adjustment for rendering and analysis workflows.
 * </p>
 *
 * @param <T> The type used to represent the real and imaginary parts of the coordinate.
 * 
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class MandelbrotInput<T> {


    /**
     * The x-coordinate of the point where the orbit starts.
     */
    private T startX;
    /**
     * The y-coordinate of the point where the orbit starts.
     */
    private T startY;
    /**
     * The maximum number of iterations to be carried out before the point is
     * considered inside the Mandelbrot set.
     */
    public int maxIteration;
    /**
     * The length from the origin the orbit must reach before a point is
     * considered "escaped" (not in the Mandelbrot set.)
     */
    public double bailout;

    /**
     * Create new instance of MandelbrotInput.
     *
     * @param startX The x-coordinate of the point where the orbit starts.
     * @param startY The y-coordinate of the point where the orbit starts.
     * @param maxIteration The maximum number of iterations to be carried out
     * before a point is considered inside the set.
     * @param bailout The length from the origin a point must reach before it is
     * considered outside the set.
     */
    public MandelbrotInput(T startX, T startY, int maxIteration, double bailout) {
        this.startX = startX;
        this.startY = startY;
        this.maxIteration = maxIteration;
        this.bailout = bailout;
    }

    /**
     * Get the x-coordinate of the point where the orbit starts.
     *
     * @return The x-coordinate of the point where the orbit starts.
     */
    public T getStartX() {
        return startX;
    }

    /**
     * Set the x-coordinate of the point where the orbit starts.
     *
     * @param startX The x-coordinate of the point where the orbit starts.
     */
    public void setStartX(T startX) {
        this.startX = startX;
    }

    /**
     * Get the y-coordinate of the point where the orbit starts.
     *
     * @return The y-coordinate of the point where the orbit starts.
     */
    public T getStartY() {
        return startY;
    }

    /**
     * Set the y-coordinate of the point where the orbit starts.
     *
     * @param startY The y-coordinate of the point where the orbit starts.
     */
    public void setStartY(T startY) {
        this.startY = startY;
    }

    /**
     * Get the maximum number of iterations allowed before the algorithm stops
     * iterating and assumes a point is in the Mandelbrot set.
     *
     * @return Get the max iteration.
     */
    public int getMaxIteration() {
        return maxIteration;
    }

    /**
     * Set the maximum number of iterations allowed before the algorithm stops
     * iterating and assumes a point is in the Mandelbrot set.
     *
     * @param maxIteration The max iteration.
     */
    public void setMaxIteration(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    /**
     * Get the length from the origin the orbit must exceed before it is has
     * considered to have escaped and is not in the Mandelbrot set.
     *
     * @return The escape bailout.
     */
    public double getBailout() {
        return bailout;
    }

    /**
     * Set the length from the origin the orbit must exceed before it is has
     * considered to have escaped and is not in the Mandelbrot set.
     *
     * @param bailout The escape bailout.
     */
    public void setBailout(double bailout) {
        this.bailout = bailout;
    }
}
