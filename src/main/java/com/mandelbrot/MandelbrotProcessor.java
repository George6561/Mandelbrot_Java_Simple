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
 * Defines the interface for Mandelbrot set evaluation algorithms.
 * <p>
 * Any implementing class provides a method for determining whether a point in
 * the complex plane belongs to the Mandelbrot set, based on a given input
 * configuration. The input and output objects support additional metadata for
 * advanced rendering tasks, such as coloring and escape detection analysis.
 * </p>
 * <p>
 * Implementations of this interface can vary in precision, optimization strategy,
 * or feature support (e.g., cardioid/bulb detection, periodicity checking).
 * </p>
 *
 * @param <T> The type used to represent coordinates in the complex plane (e.g., Double, BigDecimal).
 * 
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public interface MandelbrotProcessor<T> {


    /**
     * Process the Mandelbrot set for one coordinate in the complex plane.
     *
     * @param input The coordinate to process and additional information
     * required by the algorithm.
     * @return Whether or not the point is in the Mandelbrot set and additional
     * information needed for coloring.
     */
    public MandelbrotOutput<T> processCoordinate(MandelbrotInput<T> input);
}
