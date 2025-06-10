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

import com.graph.PixelToDoubleCartesian;
import com.mandelbrot.MandelbrotInput;
import com.mandelbrot.MandelbrotOutput;
import com.mandelbrot.MandelbrotProcessor;
import com.mandelbrot.MandelbrotProcessorDouble;
import com.utils.ColorUtils;

/**
 * Provides anti-aliased rendering routines for Mandelbrot set visualization.
 * <p>
 * This class computes smooth pixel colors by oversampling a pixel region using
 * subpixel evaluation with a configurable anti-aliasing factor. Each sample is processed
 * through a double-precision Mandelbrot evaluator and blended to produce a final color.
 * </p>
 * <p>
 * Designed to be used in high-quality fractal image generation, it supports configurable
 * rendering parameters and integrates with coordinate conversion and coloring systems.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class AntiAliasing {


    /**
     * Mandelbrot processing algorithm.
     */
    private static final MandelbrotProcessor<Double> processor = new MandelbrotProcessorDouble();

    /**
     * Get the anti-aliased color for a pixel for a double precision mandelbrot
     * processor.
     *
     * @param x The x-coordinate of the pixel.
     * @param y The y-coordinate of the pixel.
     * @param coloring The coloring algorithm.
     * @param maxIteration The maximum iteration of the Mandelbrot processor.
     * @param bailout The bailout value of the Mandelbrot processor.
     * @param aaFactor The aa factor.
     * @param convert Pixel to Cartesian coordinate converter.
     * @return The anti-aliased color for a pixel.
     */
    public static int antiAliasedRenderingDouble(double x, double y,
            MandelbrotColoring coloring, int maxIteration,
            double bailout, int aaFactor, PixelToDoubleCartesian convert) {
        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        double aaJump = 1.0 / (double) aaFactor;
        int aaDivide = aaFactor * aaFactor;

        double aaX = -aaJump;
        double aaY = -aaJump;

        MandelbrotInput<Double> input = null;
        MandelbrotOutput<Double> output;

        for (int i = 0; i < aaFactor; i++) {
            for (int j = 0; j < aaFactor; j++) {
                double zx = x + aaX;
                double zy = y + aaY;

                double xAA = convert.convertX(zx);
                double yAA = convert.convertY(zy);

                //public MandelbrotInput(Coordinate<T> start, int maxIteration, double bailout) {
                if (input == null) {
                    input = new MandelbrotInput<>(xAA, yAA,
                            maxIteration, bailout);
                    output = processor.processCoordinate(input);
                } else {
                    input.setStartX(xAA);
                    input.setStartY(yAA);
                    output = processor.processCoordinate(input);
                } //ie

                int rgb = coloring.getColor(output);
                alpha += ColorUtils.getAlpha(rgb);
                red += ColorUtils.getRed(rgb);
                green += ColorUtils.getGreen(rgb);
                blue += ColorUtils.getBlue(rgb);

                aaY += aaJump;
            } //f

            aaY = -aaJump;
            aaX += aaJump;
        } //f

        alpha /= aaDivide;
        red /= aaDivide;
        green /= aaDivide;
        blue /= aaDivide;

        return ColorUtils.toARGB(alpha, red, green, blue);
    }
}
