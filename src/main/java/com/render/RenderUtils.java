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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility methods for rendering and layout generation in Mandelbrot
 * visualizations.
 * <p>
 * This class provides tools to:
 * </p>
 * <ul>
 *   <li>Convert between image data and 1D pixel arrays</li>
 *   <li>Generate hierarchical layout maps for progressive rendering</li>
 *   <li>Render partially or fully completed images based on layout mapping</li>
 * </ul>
 * <p>
 * It supports multi-resolution rendering by layering square regions from large
 * to small, allowing fast previews and gradual refinement of fractal images.
 * </p>
 * <p>
 * This utility is intended for rendering pipelines that rely on adaptive or
 * tiled Mandelbrot visualization strategies.
 * </p>
 */
public class RenderUtils {

    /**
     * The sizes (pixels x-y) that squares of the layout may be.
     */
    private static final Map<Integer, Integer> LEGAL_SQUARE_SIZES = new HashMap<>();

    /**
     * Create legal squares.
     */
    static {
        int size = 2;
        for (int i = 1; i < 30; i++) {
            LEGAL_SQUARE_SIZES.put(size, i);
            size *= 2;
        } //f
    }

    /**
     * Convert an image to a 1D array representing the image.
     *
     * @param image Image to be converted a 1D array.
     * @return The pixels of the image as a 1D array.
     */
    public static int[] imageToPixels(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int size = width * height;

        int[] pixels = new int[size];
        int index = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[index++] = image.getRGB(x, y);
            } //f
        } //f

        return pixels;
    }

    /**
     * Convert an 1D array to an image.
     *
     * @param pixels Pixels representing an image scanned in an x-first fashion.
     * @param width The width of the image.
     * @param height The height of the image.
     * @return The image that the pixel array represents.
     */
    public static BufferedImage pixelsToImage(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = x + (y * width);
                int rgb = pixels[index];
                image.setRGB(x, y, rgb);
            } //f
        } //f

        return image;
    }

    /**
     * Make a map of the order in which coordinates should be rendered and the
     * size of each pixel on screen. Draw the largest square first and then draw
     * the smaller squares on top of those right down to the single pixels. Once
     * all pixels are in this will create the image as is.
     *
     * @param width Width of the image.
     * @param height Height of the image.
     * @param maxSquareSize The largest square size during rendering. Must be an
     * integer multiple of 2 so it can be progressively halved until it reaches
     * 1.
     * @return The mapping of all coordinates and square sizes in the order the
     * points should be rendered (the color determined from the fractal
     * algorithm and the image drawn on the drawing panel.)
     */
    public static List<LayoutElement> makeLayoutMap(int width, int height, int maxSquareSize) {
        if (!LEGAL_SQUARE_SIZES.containsKey(maxSquareSize)) {
            throw new IllegalArgumentException("Max square size must be integer power of 2!");
        } //i

        int squareLayers = LEGAL_SQUARE_SIZES.get(maxSquareSize) + 1;
        int currentSquareSize = maxSquareSize;
        boolean[][] pixelsUsed = new boolean[width][height];

        List<LayoutElement> elements = new ArrayList<LayoutElement>();

        for (int i = 0; i < squareLayers; i++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    boolean validX = x % currentSquareSize == 0;
                    boolean validY = y % currentSquareSize == 0;

                    if (validX && validY && !pixelsUsed[x][y]) {
                        LayoutElement element = new LayoutElement(x, y, currentSquareSize);
                        elements.add(element);
                        pixelsUsed[x][y] = true;
                    } //i
                } //f
            } //f

            currentSquareSize /= 2;
        } //f

        return elements;
    }

    /**
     * Render an incomplete (or complete) image.
     *
     * @param pixels The pixels of he image to be rendered scanned in an x-first
     * manner.
     * @param width The width of the image.
     * @param height The height of the image.
     * @param renderTo The number of pixels in the array to read up +1 (if the
     * value of renderTo is width then the method read up to width - 1.)
     * @param map The layout map that gives the coordinates and square sizes for
     * the renderer.
     * @return The rendered image.
     */
    public static BufferedImage renderImage(int[] pixels, int width, int height,
            int renderTo, List<LayoutElement> map) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics g = null;
        try {
            g = image.createGraphics();
            for (int i = 0; i < renderTo; i++) {
                LayoutElement element = map.get(i);

                int x = element.getX();
                int y = element.getY();

                int index = x + (y * width);
                int rgb = pixels[index];
                Color color = new Color(rgb);
                g.setColor(color);

                int squareSize = element.getSquareSize();
                g.fillRect(x, y, squareSize, squareSize);
            } //f
        } finally {
            if (g != null) {
                g.dispose();
            } //i
        } //tf

        return image;
    }

}
