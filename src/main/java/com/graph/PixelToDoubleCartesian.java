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
 * Converts image-space coordinates to their equivalent positions in the Cartesian plane
 * using double-precision arithmetic.
 * <p>
 * This class enables the mapping of pixel locations (represented as {@code double}s)
 * to Cartesian coordinates for use in high-precision graphical applications, such as
 * fractal rendering. It supports various construction methods based on plane bounds,
 * center points, or magnification factors.
 * </p>
 * <p>
 * Instances of this class are immutable and tailored to specific image dimensions and
 * scaling ratios. The use of double precision allows sub-pixel accuracy, making it
 * suitable for applications requiring anti-aliasing or smooth zooming.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class PixelToDoubleCartesian implements ConvertCoordinate<Double, Double> {

    /**
     * The smallest value of the x-axis on the image.
     */
    private final double minX;
    /**
     * The smallest value of the y-axis on the image.
     */
    private final double minY;
    /**
     * The length of the x-axis that each pixel represents.
     */
    private final double xPlanePerPixel;
    /**
     * The length of the y-axis the that each pixel represents.
     */
    private final double yPlanePerPixel;
    /**
     * The height of the image.
     */
    private final double height;

    /**
     * Create new instance of PixelToDoubleCartesian.
     *
     * @param minX The smallest value of the x-axis on the image.
     * @param minY The smallest value of the y-axis on the image.
     * @param xPlanePerPixel The length of the x-axis that each pixel
     * represents.
     * @param yPlanePerPixel The length of the y-axis the that each pixel
     * represents.
     * @param height The height of the image.
     */
    private PixelToDoubleCartesian(double minX, double minY, double xPlanePerPixel,
            double yPlanePerPixel, double height) {
        this.minX = minX;
        this.minY = minY;
        this.xPlanePerPixel = xPlanePerPixel;
        this.yPlanePerPixel = yPlanePerPixel;
        this.height = height;
    }

    /**
     * Create a new instance of PixelToDoubleCartesian from the minimum and
     * maximum x and y coordinates of the plane that the fractal is being
     * rendered in and the dimensions of the image it is being rendered on.
     *
     * @param minX Minimum x-coordinate.
     * @param maxX Minimum x-coordinate.
     * @param minY Minimum y-coordinate.
     * @param maxY Maximum y-coordinate.
     * @param width Width of the image the fractal is being rendered in.
     * @param height Height of the image the fractal is being rendered in.
     * @return New instance of PixelToDoubleCartesian.
     */
    public static PixelToDoubleCartesian createFromMinMax(double minX, double maxX,
            double minY, double maxY,
            int width, int height) {
        //Image pixels are 1 less than the outside Cartesian axis.
        double widthDouble = width - 1;
        double heightDouble = height - 1;

        double planeWidth = maxX - minX;
        double xPlanePerPixel = planeWidth / widthDouble;

        double planeHeight = maxY - minY;
        double yPlanePerPixel = planeHeight / heightDouble;

        return new PixelToDoubleCartesian(minX, minY, xPlanePerPixel, yPlanePerPixel, heightDouble);
    }

    /**
     * Create a new instance of PixelToDoubleCartesian from the center
     * coordinate and the width of the graph shown on image (maxX - minX).
     *
     * @param xCenter The x-coordinate of the center of the plane.
     * @param yCenter The y-coordinate of the center of the plane.
     * @param planeWidth The width of the plane.
     * @param width Width of the image the fractal is being rendered in.
     * @param height Height of the image the fractal is being rendered in.
     * @return New instance of PixelToDoubleCartesian.
     */
    public static PixelToDoubleCartesian createFromCenterPlaneWidth(double xCenter,
            double yCenter, double planeWidth, int width, int height) {
        //Image pixels are 1 less than the outside Cartesian axis.
        double widthDouble = width - 1;
        double heightDouble = height - 1;
        double planeHeight = (heightDouble / widthDouble) * planeWidth;

        double minX = xCenter - (planeWidth / 2.0);
        double xPlanePerPixel = planeWidth / widthDouble;

        double minY = yCenter - (planeHeight / 2.0);
        double yPlanePerPixel = planeHeight / heightDouble;

        return new PixelToDoubleCartesian(minX, minY, xPlanePerPixel, yPlanePerPixel, heightDouble);
    }

    /**
     * Create a new instance of PixelToDoubleCartesian from the center
     * coordinate and a magnification factor. A magnification of 1 gives a plane
     * width of 4.
     *
     * @param xCenter The x-coordinate of the center of the plane.
     * @param yCenter The y-coordinate of the center of the plane.
     * @param magnification Magnification of the graph area relative to the
     * first frame, which has a width of 4.
     * @param width Width of the image the fractal is being rendered in.
     * @param height Height of the image the fractal is being rendered in.
     * @return New instance of PixelToDoubleCartesian.
     */
    public static PixelToDoubleCartesian createFromMagnification(double xCenter,
            double yCenter, double magnification, int width, int height) {
        double widthDouble = width - 1;
        double heightDouble = height - 1;

        //Maginification = 1, plan width = 4.
        double planeWidth = 4.0 / magnification;
        System.out.println(planeWidth);
        double planeHeight = (heightDouble / widthDouble) * planeWidth;

        double minX = xCenter - (planeWidth / 2.0);
        double xPlanePerPixel = planeWidth / widthDouble;

        double minY = yCenter - (planeHeight / 2.0);
        double yPlanePerPixel = planeHeight / heightDouble;

        return new PixelToDoubleCartesian(minX, minY, xPlanePerPixel, yPlanePerPixel, heightDouble);
    }
    
    @Override
    public Double convertX(Double x) {
        double xLength = x * xPlanePerPixel;
        return minX + xLength;
    }

    @Override
    public Double convertY(Double y) {
        double yLength = (height - y) * yPlanePerPixel;
        return minY + yLength;
    }
}
