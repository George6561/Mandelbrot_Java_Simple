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

package com.render;

/**
 * Represents a square region in a 2D pixel layout grid.
 * <p>
 * This class defines a square area based on its top-left pixel coordinates and
 * side length. It is commonly used in layout management systems, tiling, or
 * adaptive rendering contexts where discrete regions are processed individually.
 * </p>
 * <p>
 * Instances of this class are value-based and override {@code equals} and
 * {@code hashCode} to support hashing and comparisons in spatial data structures.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class LayoutElement {

    /**
     * The x-coordinate of the pixel at the top left of the square.
     */
    private int x;
    /**
     * The y-coordinate of the pixel at the top left of the square.
     */
    private int y;
    /**
     * The size of this square.
     */
    private final int squareSize;

    /**
     * Create new instance of LayoutPoint.
     *
     * @param x The x-coordinate of the pixel at the top left of the square.
     * @param y The y-coordinate of the pixel at the top left of the square.
     * @param squareSize The size of the square in pixels.
     */
    public LayoutElement(int x, int y, int squareSize) {
        this.x = x;
        this.y = y;
        this.squareSize = squareSize;
    }

    /**
     * Get The x-coordinate of the pixel at the top left of the square.
     *
     * @return The x-coordinate of the pixel at the top left of the square.
     */
    public int getX() {
        return x;
    }

    /**
     * Get The y-coordinate of the pixel at the top left of the square.
     *
     * @return The y-coordinate of the pixel at the top left of the square.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the size of this square.
     *
     * @return The size of this square.
     */
    public int getSquareSize() {
        return squareSize;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        hash = 31 * hash + this.squareSize;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LayoutElement other = (LayoutElement) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.squareSize != other.squareSize) {
            return false;
        }
        return true;
    }
}