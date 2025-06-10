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

import java.io.*;
import java.util.*;

/**
 * Utility for converting a sequence of image frames into an MP4 video using FFmpeg.
 * <p>
 * This class executes a command-line FFmpeg process to compile a numbered series
 * of PNG frames into a video file. Frame filenames must follow the pattern
 * {@code frame_0001.png}, {@code frame_0002.png}, etc.
 * </p>
 * <p>
 * The method supports configurable frame rate, output filename, and frame count,
 * and provides real-time logging of FFmpeg's output. Requires a working FFmpeg
 * binary at {@code ffmpeg/ffmpeg.exe}.
 * </p>
 *
 * @author George Miller
 * @version 1.0, 2025-06-10
 */
public class VideoCreator {


    public static void createVideoFromFrames(String inputDir, String outputFile, int frameRate, int frameCount) {
        String ffmpegPath = "ffmpeg/ffmpeg.exe";

        String inputPattern = new File(inputDir, "frame_%04d.png").getPath().replace("\\", "/");
        String outputPath = outputFile.replace("\\", "/");

        List<String> command = Arrays.asList(
            ffmpegPath, "-y",
            "-framerate", String.valueOf(frameRate),
            "-i", inputPattern,
            "-frames:v", String.valueOf(frameCount),
            "-c:v", "libx264",
            "-pix_fmt", "yuv420p",
            outputPath
        );

        try {
            System.out.println("Running command:\n" + String.join(" ", command));
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectErrorStream(true); // Merge stderr with stdout

            Process process = builder.start();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[FFmpeg] " + line);
                }
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("✅ Video created: " + outputPath);
            } else {
                System.err.println("❌ FFmpeg exited with code: " + exitCode);
            }

            System.exit(exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
