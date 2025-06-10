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

import com.gradient.Gradient;
import com.gradient.GradientException;
import com.mandelbrot.MandelbrotOutput;
import com.utils.ColorUtils;

/**
 * Converts the results of Mandelbrot set evaluations into RGB color values.
 * <p>
 * This class maps the output of a {@link com.mandelbrot.MandelbrotProcessor}
 * to colors using a customizable gradient and optional highlight modes for
 * different set-detection methods (e.g., bulb, cardioid, periodicity).
 * </p>
 * <p>
 * For points outside the Mandelbrot set, it applies smooth coloring based on
 * the normalized iteration count (NIC) technique, allowing for visually
 * appealing gradients and zoom effects. This class supports anti-aliasing and
 * high-resolution rendering workflows.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class MandelbrotColoring {

    /**
     * Natural log of 2.
     */
    private static final double LN2 = Math.log(2.0);
    /**
     * Value that the gradient is assumed to be. The gradient index value is
     * always between 0.0 and 1.0, applying (n % 1000) / 1000, where n is the
     * output number, gives a value which matches the output of the processor.
     */
    private static final int FIXED_GRADIENT_LENGTH = 100000;
    /**
     * Natural log of the natural log of the bailout, ln(ln(bailout)).
     */
    private final double lnLnBailout;
    /**
     * Color gradient.
     */
    private final Gradient gradient;
    /**
     * Whether or not how the point was found should be highlighted with a set
     * color, or all points in the Mandelbrot set should be black no matter how
     * they where found.
     */
    private final boolean showType;
    /**
     * Value the output of the processor should be multiplied by before being
     * turned to a gradient index.
     */
    private final double multiplier;
    /**
     * The color code for finding by max iteration.
     */
    private static final int MAX_ITERATION_COLOR = ColorUtils.BLACK;
    /**
     * The color code for finding by main bulb check.
     */
    private static final int BULB_COLOR = ColorUtils.RED;
    /**
     * The color code for finding by cardioid check.
     */
    private static final int CARDIOID_COLOR = ColorUtils.YELLOW;
    /**
     * The color code for finding by periodicity check.
     */
    private static final int PERIOD_COLOR = ColorUtils.CORNFLOWER_BLUE;

    /**
     * Create new instance of MandelbrotColoring.
     *
     * @param bailout The length that the orbit has to be from the origin before
     * it is determined to not be in the set.
     * @param gradient The color gradient.
     * @param showType True if the image should show how the discovery method
     * for each point in the Mandelbrot set should be shown, false if each point
     * int the Mandelbrot set should be black.
     * @param multiplier Multiplier of gradient index.
     */
    public MandelbrotColoring(double bailout, Gradient gradient,
            boolean showType, double multiplier) {
        this.lnLnBailout = Math.log(Math.log(bailout));
        this.gradient = gradient;
        this.showType = showType;
        this.multiplier = multiplier;
    }

    /**
     * Get the color of a pixel based upon the output of the Mandelbrot
     * processor at that pixel.
     *
     * @param result The output of the Mandelbrot processor.
     * @return The color of the pixel.
     */
    public int getColor(MandelbrotOutput result) {
        boolean inSet = result.isInSet();
        if (inSet) {
            if (showType) {
                switch (result.getHowFound()) {
                    case MAX_ITERATION:
                        return MAX_ITERATION_COLOR;
                    case BULB:
                        return BULB_COLOR;
                    case CARDIOID:
                        return CARDIOID_COLOR;
                    case PERIOD:
                        return PERIOD_COLOR;
                } //s
            } else {
                return ColorUtils.BLACK;
            } //ie
        } //i

        double zx = result.getDoubleX();
        double zy = result.getDoubleY();
        int iteration = result.getIterations();

        //Apply nic to iteration.
        double position = normalizedIterationCount(zx, zy);
        position += iteration;

        //Smooth result by apply square root.
        position = Math.sqrt(position);
        position *= multiplier;

        //Push into range of gradient -> into range fixed gradient length.
        int index = (int) position;
        index %= FIXED_GRADIENT_LENGTH;

        //Into range -> 0 to 1.
        double doubleIndex = (double) index / (double) FIXED_GRADIENT_LENGTH;
        int color = 0;

        try {
            color = gradient.getColor(doubleIndex);
        } catch (GradientException ex) {
            System.out.println("Gradient index out of range: " + index);
        } //tc

        return color;
    }

    /**
     * Normalized iteration count addition value for a coordinate.
     *
     * @param x X coordinate of point to check for.
     * @param y Y coordinate of point to check for.
     * @return Normalized iteration count addition for that coordinate.
     */
    private double normalizedIterationCount(double x, double y) {
        double radius = Math.sqrt(x * x + y * y);
        double ln2R = Math.log(Math.log(radius));
        double nic = (lnLnBailout - ln2R) / LN2;
        return nic;
    }
}
