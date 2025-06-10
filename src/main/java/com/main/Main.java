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

import com.gradient.GradientException;
import java.io.IOException;
import com.render.VideoCreator;

/**
 * Entry point for generating a Mandelbrot zoom video.
 * <p>
 * This class invokes the video creation pipeline using a predefined directory
 * of image frames rendered from the Mandelbrot set. It leverages FFmpeg to
 * compile the frames into an MP4 video at a given frame rate and duration.
 * </p>
 * <p>
 * Before running this application, ensure the image frames have been generated
 * and that FFmpeg is installed and accessible at the expected path.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class Main {

    /**
     * Main method for launching Mandelbrot video creation.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an I/O error occurs during frame reading or FFmpeg execution.
     * @throws GradientException If a gradient-related error occurs (not expected in this step).
     */
    public static void main(String[] args) throws IOException, GradientException {
        VideoCreator.createVideoFromFrames("C:/Test/Mandelbrot", "C:/Test/Mandelbrot.mp4", 10, 612);
    }
}
