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

import com.utils.ColorUtils;

/**
 * Converts discrete color nodes into a continuous gradient using Catmull-Rom 
 * cubic interpolation.
 * <p>
 * This class extends {@link Gradient} and provides smooth transitions between 
 * color stops by evaluating each intermediate color based on four surrounding 
 * nodes. The resulting gradient is ideal for visual applications where 
 * smoothness and continuity are important.
 * </p>
 * 
 * @author George Miller
 */
public class SmoothGradient extends Gradient {

    @Override
    public int process(double index) throws GradientException {
        // Valid index?
        if (index < 0.0 || index > 1.0) {
            throw new IllegalArgumentException("Illegal gradient index!");
        }

        // Gradient formed?
        if (!gradientFormed()) {
            throw new GradientException("Gradient not formed!");
        }

        int listIndex = 0;
        for (int i = 0; i < points - 1; i++) {
            double index0 = gradientEntries.get(i).getIndex();
            double index1 = gradientEntries.get(i + 1).getIndex();

            if (index0 <= index && index <= index1) {
                listIndex = i;
                break;
            }
        }

        // Determine surrounding indices for cubic interpolation
        int i0 = Math.max(0, listIndex - 1);
        int i1 = listIndex;
        int i2 = Math.min(points - 1, listIndex + 1);
        int i3 = Math.min(points - 1, listIndex + 2);

        double x1 = gradientEntries.get(i1).getIndex();
        double x2 = gradientEntries.get(i2).getIndex();

        double t = (index - x1) / (x2 - x1); // normalized parameter between 0 and 1

        // Get colors
        int c0 = gradientEntries.get(i0).getColor();
        int c1 = gradientEntries.get(i1).getColor();
        int c2 = gradientEntries.get(i2).getColor();
        int c3 = gradientEntries.get(i3).getColor();

        int red = (int) cubicInterpolate(ColorUtils.getRed(c0), ColorUtils.getRed(c1),
                                         ColorUtils.getRed(c2), ColorUtils.getRed(c3), t);
        int green = (int) cubicInterpolate(ColorUtils.getGreen(c0), ColorUtils.getGreen(c1),
                                           ColorUtils.getGreen(c2), ColorUtils.getGreen(c3), t);
        int blue = (int) cubicInterpolate(ColorUtils.getBlue(c0), ColorUtils.getBlue(c1),
                                          ColorUtils.getBlue(c2), ColorUtils.getBlue(c3), t);
        int alpha = (int) cubicInterpolate(ColorUtils.getAlpha(c0), ColorUtils.getAlpha(c1),
                                           ColorUtils.getAlpha(c2), ColorUtils.getAlpha(c3), t);

        return ColorUtils.toARGB(alpha, red, green, blue);
    }

    /**
     * Cubic interpolation using Catmull-Rom spline.
     *
     * @param p0 Color component before the start point.
     * @param p1 Start color component.
     * @param p2 End color component.
     * @param p3 Color component after the end point.
     * @param t Normalized position between p1 and p2 (0 <= t <= 1).
     * @return Interpolated color component.
     */
    private double cubicInterpolate(double p0, double p1, double p2, double p3, double t) {
        double t2 = t * t;
        double t3 = t2 * t;

        return 0.5 * ((2 * p1)
                    + (-p0 + p2) * t
                    + (2*p0 - 5*p1 + 4*p2 - p3) * t2
                    + (-p0 + 3*p1 - 3*p2 + p3) * t3);
    }
}
