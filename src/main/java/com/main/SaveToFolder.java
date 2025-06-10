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
package com.main;

import com.gradient.Gradient;
import com.gradient.GradientEntry;
import com.gradient.GradientException;
import com.gradient.SmoothGradient;
import com.graph.PixelToDoubleCartesian;
import com.render.AntiAliasing;
import com.render.MandelbrotColoring;
import com.utils.ColorUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Generates and saves a sequence of Mandelbrot zoom images to a specified
 * folder.
 * <p>
 * This class creates a zoom animation by repeatedly rendering the Mandelbrot
 * set at increasingly higher magnification levels. Each frame is rendered using
 * anti-aliasing and a smooth gradient coloring scheme. Images are saved as PNG
 * files with sequential filenames.
 * </p>
 * <p>
 * Users can configure parameters such as zoom factor, image size, color
 * gradient, and maximum iterations. The process supports skipping
 * already-rendered frames to allow interrupted or resumed rendering.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class SaveToFolder {

    /**
     * Renders and saves a sequence of Mandelbrot set images to disk, creating a
     * zoom animation.
     * <p>
     * This method generates a series of high-resolution frames of the
     * Mandelbrot set, gradually zooming in on a specified center point. Each
     * frame is rendered using anti-aliasing for smooth visual output and
     * colored with a customizable gradient. Images are saved as PNG files to a
     * fixed output directory. Already existing frames are skipped, allowing
     * interrupted render jobs to resume without data loss.
     * </p>
     *
     * @throws IOException If an error occurs while writing image files to disk.
     * @throws GradientException If an invalid gradient configuration is
     * encountered.
     */
    public static void save() throws IOException, GradientException {
        System.out.println("Generating Mandelbrot zoom sequence...");

        int width = 800;
        int height = 600;

        double xCenter = -0.743643887037158704752191506114774;
        double yCenter = 0.131825904205311970493132056385139;
        double planeWidth = 4.0;

        int totalFrames = 1000;
        double zoomFactor = 0.95;
        int maxIteration = 50000;
        int aaFactor = 3;

        Gradient gradient = new SmoothGradient();
        gradient.addColor(GradientEntry.createFirstEntry(ColorUtils.toRGB(0, 8, 106)));
        gradient.addColor(GradientEntry.createEntry(ColorUtils.toRGB(55, 139, 218), 0.25));
        gradient.addColor(GradientEntry.createEntry(ColorUtils.toRGB(246, 251, 225), 0.5));
        gradient.addColor(GradientEntry.createEntry(ColorUtils.toRGB(253, 160, 0), 0.75));
        gradient.addColor(GradientEntry.createFinalEntry(ColorUtils.toRGB(0, 8, 106)));

        double bailout = 10.0;
        double multiplier = 5000.0;
        MandelbrotColoring coloring = new MandelbrotColoring(bailout, gradient, false, multiplier);

        File outputDir = new File("C:/Test/Mandelbrot/");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        for (int frame = 1; frame <= totalFrames; frame++) {
            String filename = String.format("C:/Test/Mandelbrot/frame_%04d.png", frame);
            File imageFile = new File(filename);

            if (imageFile.exists()) {
                System.out.printf("Skipping frame %d (already exists)\n", frame);
                planeWidth *= zoomFactor; // still zoom in even if skipping
                continue;
            }

            System.out.printf("Rendering frame %d/%d (width = %.10f)...\n", frame, totalFrames, planeWidth);

            PixelToDoubleCartesian convert = PixelToDoubleCartesian
                    .createFromCenterPlaneWidth(xCenter, yCenter, planeWidth, width, height);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int color = AntiAliasing.antiAliasedRenderingDouble(
                            x, y, coloring, maxIteration, bailout, aaFactor, convert);
                    image.setRGB(x, y, color);
                }
            }

            ImageIO.write(image, "png", imageFile);

            planeWidth *= zoomFactor;
        }

        System.out.println("Done!");
    }

}
