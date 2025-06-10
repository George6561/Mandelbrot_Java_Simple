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
 * Custom exception type thrown when an error occurs while processing
 * a color gradient.
 * <p>
 * Typically used to signal that a gradient is incomplete or improperly defined—
 * for example, when start and end color nodes are missing and interpolation is
 * not possible.
 * </p>
 *
 * @author George Miller
 */
public class GradientException extends Exception {

    /**
     * Creates a new instance of
     * <code>GradientException</code> without detail message.
     */
    public GradientException() {
    }

    /**
     * Constructs an instance of
     * <code>GradientException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public GradientException(String msg) {
        super(msg);
    }
}
