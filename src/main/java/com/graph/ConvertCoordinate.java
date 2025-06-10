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

package com.graph;

/**
 * Defines a bidirectional mapping between two coordinate systems.
 * <p>
 * This interface is intended for classes that convert coordinates from one
 * representation to another—for example, translating pixel-based coordinates
 * to Cartesian coordinates and back. It provides methods for transforming
 * values along both the x- and y-axes.
 * </p>
 *
 * @param <T> The original coordinate type.
 * @param <U> The target coordinate type.
 * 
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public interface ConvertCoordinate<T, U> {

    /**
     * Converts the x-axis component from the original to the target system.
     *
     * @param x The x-value in the original coordinate system.
     * @return The converted x-value.
     */
    T convertX(T x);

    /**
     * Converts the y-axis component from the original to the target system.
     *
     * @param y The y-value in the original coordinate system.
     * @return The converted y-value.
     */
    T convertY(T y);
}
