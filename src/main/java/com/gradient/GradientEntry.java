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

package com.gradient;

/**
 * Represents a single, immutable color node within a continuous color gradient.
 * <p>
 * Each {@code GradientEntry} instance stores a specific ARGB color value and its
 * associated normalized position in the gradient, ranging from 0.0 (start) to 1.0 (end).
 * Gradient entries are intended to act as fixed reference points from which interpolated
 * color values can be computed in {@link Gradient} implementations.
 * </p>
 * <p>
 * This class implements {@link Comparable}, allowing gradient entries to be sorted
 * by their index position. Factory methods are provided for convenience to create
 * start, end, or arbitrary-position entries.
 * </p>
 *
 * @author George Miller
 */

public class GradientEntry implements Comparable<GradientEntry> {

    /**
     * The color stored at this entry.
     */
    private final int color;
    /**
     * The index of this entry in the gradient.
     */
    private final double index;

    /**
     * Create a new instance of gradientEntry.
     *
     * @param color The color stored at this entry.
     * @param index The index of this entry.
     */
    private GradientEntry(int color, double index) {
        this.color = color;
        this.index = index;
    }

    /**
     * Create new instance of GradientEntry from the position of the entry in
     * the gradient and the color the entry holds.
     *
     * @param color The color of the entry.
     * @param index The index of the entry in the gradient.
     * @return New instance of GradientEntry.
     */
    public static GradientEntry createEntry(int color, double index) {
        return new GradientEntry(color, index);
    }

    /**
     * Create an entry at the start of the gradient.
     *
     * @param color The color of the entry.
     * @return New instance of GradientEntry.
     */
    public static GradientEntry createFirstEntry(int color) {
        return new GradientEntry(color, 0.0);
    }

    /**
     * Create an entry at the end of the gradient.
     *
     * @param color The color of the entry.
     * @return New instance of GradientEntry.
     */
    public static GradientEntry createFinalEntry(int color) {
        return new GradientEntry(color, 1.0);
    }

    /**
     * Get the color stored in this entry.
     *
     * @return The color stored in this entry.
     */
    public int getColor() {
        return color;
    }

    /**
     * Get the index of this entry.
     *
     * @return The index of this entry.
     */
    public double getIndex() {
        return index;
    }

    @Override
    public int compareTo(GradientEntry o) {
        if (this.index < o.index) {
            return -1;
        } //i

        if (this.index > o.index) {
            return 1;
        } //i

        return 0;
    }
}
