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

import com.mandelbrot.MandelbrotOutput.HowFound;

/**
 * High-performance implementation of the Mandelbrot set evaluator using double
 * precision.
 * <p>
 * This processor performs optimized Mandelbrot set evaluation for a single
 * point in the complex plane. It includes fast checks for common interior
 * regions (cardioid and bulb), adaptive periodicity detection, and cycle
 * detection via the "hare and tortoise" method.
 * </p>
 * <p>
 * Designed for speed and precision, this implementation is suitable for
 * high-resolution rendering tasks where performance and accuracy are critical.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class MandelbrotProcessorDouble implements MandelbrotProcessor<Double> {

    private static final double PERIODICITY_THRESHOLD = 1e-17;

    /**
     * Process a single coordinate with all known optimizations.
     *
     * @param input standard Mandelbrot input with coordinates and params
     * @return MandelbrotOutput describing result
     */
    @Override
    public MandelbrotOutput<Double> processCoordinate(MandelbrotInput<Double> input) {
        final double px = input.getStartX();
        final double py = input.getStartY();
        final int maxIter = input.maxIteration;
        final double bailout = input.bailout;

        // Cardioid check
        double q = (px - 0.25) * (px - 0.25) + py * py;
        if (q * (q + (px - 0.25)) < 0.25 * py * py) {
            return new MandelbrotOutput<>(maxIter, px, py, px, py, true, HowFound.CARDIOID);
        }

        // Period-2 bulb check
        if ((px + 1) * (px + 1) + py * py < 1.0 / 16.0) {
            return new MandelbrotOutput<>(maxIter, px, py, px, py, true, HowFound.BULB);
        }

        // Standard Mandelbrot iteration
        double zx = 0.0, zy = 0.0;
        double zx2 = 0.0, zy2 = 0.0;

        // Periodicity memory
        double hx = 0.0, hy = 0.0;
        int checkInterval = 3;
        int checkCounter = 0;
        int updateCounter = 0;

        // Hare and tortoise for cycle detection
        double tx = 0.0, ty = 0.0; // tortoise
        int tortoiseLag = 10;

        for (int i = 0; i < maxIter; i++) {
            zy = 2.0 * zx * zy + py;
            zx = zx2 - zy2 + px;

            zx2 = zx * zx;
            zy2 = zy * zy;

            // Bailout
            if (zx2 + zy2 > bailout) {
                return new MandelbrotOutput<>(i, zx, zy, zx, zy, false, HowFound.NOT);
            }

            // Precision-based periodicity detection
            if (Math.abs(zx - hx) < PERIODICITY_THRESHOLD && Math.abs(zy - hy) < PERIODICITY_THRESHOLD) {
                return new MandelbrotOutput<>(i, zx, zy, zx, zy, true, HowFound.PERIOD);
            }

            // Cycle detection using spaced checkpoints (Hare & Tortoise)
            if (i == tortoiseLag) {
                tx = zx;
                ty = zy;
            } else if (i > tortoiseLag && i % tortoiseLag == 0) {
                if (Math.abs(zx - tx) < PERIODICITY_THRESHOLD && Math.abs(zy - ty) < PERIODICITY_THRESHOLD) {
                    return new MandelbrotOutput<>(i, zx, zy, zx, zy, true, HowFound.PERIOD);
                }
            }

            // Adaptive periodicity memory update
            if (checkCounter++ >= checkInterval) {
                checkCounter = 0;
                if (++updateCounter >= 10) {
                    checkInterval *= 2;
                    updateCounter = 0;
                }
                hx = zx;
                hy = zy;
            }
        }

        // No escape, max iterations
        return new MandelbrotOutput<>(maxIter, zx, zy, zx, zy, true, HowFound.MAX_ITERATION);
    }
}
