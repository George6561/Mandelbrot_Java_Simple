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

import java.util.*;

/**
 * Abstract base class representing a sparse definition of a color gradient.
 * <p>
 * This class stores a set of discrete color nodes indexed between 0.0 and 1.0,
 * which serve as anchors in a conceptual continuous gradient. Concrete subclasses
 * of {@code Gradient} must implement the {@link #process(double)} method to define
 * how to interpolate between these nodes and compute the resulting color at any
 * intermediate point.
 * </p>
 * <p>
 * This design avoids storing an entire continuous gradient in memory. Instead,
 * it provides a flexible, on-demand way of generating colors using various interpolation
 * strategies. Color nodes can be dynamically added and removed, and optimized caching is
 * employed to avoid recomputation where possible.
 * </p>
 * <p>
 * To function correctly, the gradient must have defined colors at both ends
 * (0.0 and 1.0). Otherwise, interpolation is undefined and {@code GradientException}
 * will be thrown.
 * </p>
 *
 * @author George Miller
 */
public abstract class Gradient {

    /**
     * List representing nodes of gradient.
     */
    protected List<GradientEntry> gradientEntries = new ArrayList<GradientEntry>();
    /**
     * Buffer of colors already processed.
     */
    protected Map<Double, Integer> colorsProcessed = new HashMap<Double, Integer>();
    /**
     * The first entry.
     */
    protected GradientEntry firstEntry;
    /*8
     * The lastEntry.
     */
    protected GradientEntry finalEntry;
    /**
     * Whether or not there is a color at index 0.0.
     */
    private boolean start;
    /**
     * Whether or not there is a color at index 1.0.
     */
    private boolean end;
    /**
     * The number of nodes that have been added to the list.
     */
    protected int points;

    /**
     * Add a new color node to this
     * <code>Gradient</code>.
     *
     * @param entry Entry to be added to gradient entry list.
     */
    public void addColor(GradientEntry entry) {
        //Check if a color exists at this index, remove is it does.
        double newIndex = entry.getIndex();
        for (GradientEntry gradientEntry : gradientEntries) {
            if (gradientEntry.getIndex() == newIndex) {
                gradientEntries.remove(gradientEntry);
                break;
            } //i
        } //f

        //Determine if this is a start or end point.
        if (entry.getIndex() == 0.0) {
            start = true;
            firstEntry = entry;
        } //i
        if (entry.getIndex() == 1.0) {
            end = true;
            finalEntry = entry;
        } //i

        gradientEntries.add(entry);
        ++points;

        //Reform gradient.
        Collections.sort(gradientEntries);
    }

    /**
     * Removes a previously inserted color node from this
     * <code>Gradient</code>.
     *
     * @param color Color to be removed from gradient node list.
     */
    public void removeColor(GradientEntry color) {
        gradientEntries.remove(color);

        //Determine if this is a start or end point
        if (color.getIndex() == 0.0) {
            start = false;
            firstEntry = null;
        } //i
        if (color.getIndex() == 1.0) {
            end = false;
            finalEntry = null;
        } //i

        --points;

        //Reform gradient
        Collections.sort(gradientEntries);

        clearBuffer();
    }

    /**
     * Determines whether or not a continuous color gradient can be formed from
     * this
     * <code>Gradient</code> or not. This is the case if the Gradient has one
     * point at its beginning and at its end so any point can be indexed in
     * between.
     *
     * @return Returns true if a continuous color gradient can be created from
     * this Gradient, false if it can't.
     */
    public boolean gradientFormed() {
        return start && end;
    }

    /**
     * Clear all elements in the buffer.
     */
    private void clearBuffer() {
        colorsProcessed = new HashMap<Double, Integer>();
    }

    /**
     * Get the color at a certain point along a continuous color gradient that
     * this instance of
     * <code>Gradient</code> represents. Used to make a fixed gradient array.
     *
     * @param index The index of the point from 0 to length.
     * @param length The length of the fixed gradient array this method is
     * building, in elements.
     * @return The color at this element of the fixed gradient array.
     * @throws GradientException Gradient doesn't have start and end values yet,
     * so a continuous color gradient can't be computed.
     */
    public int getColor(int index, int length) throws GradientException {
        double gradientIndex = (double) index / (double) length;
        return process(gradientIndex);
    }

    /**
     * Get the color at a certain point along a continuous color gradient that
     * this instance of
     * <code>Gradient</code> represents.
     *
     * @param index A value between 0.0 and 1.0, which represent the start and
     * end of the gradient respectively, which represents the index of a
     * continuous color gradient.
     * @return The color at the point along the gradient specified by the index.
     * @throws GradientException Gradient doesn't have start and end values yet,
     * so a continuous color gradient can't be computed.
     */
    public int getColor(double index) throws GradientException {
        Integer color = colorsProcessed.get(index);

        //Flyweight
        if (color == null) {
            color = process(index);
            colorsProcessed.put(index, color);
        } //i

        return color;
    }

    /**
     * The unique implementation across concrete forms of Gradient that
     * determines the color between color entries.
     *
     * @param index A value between 0.0 and 1.0, which represent the start and
     * end of the gradient respectively, which represents the index of a
     * continuous color gradient.
     * @return The color at the point along the gradient specified by the index.
     * @throws GradientException Gradient doesn't have start and end values yet,
     * so a continuous color gradient can't be computed.
     */
    public abstract int process(double index) throws GradientException;
}
