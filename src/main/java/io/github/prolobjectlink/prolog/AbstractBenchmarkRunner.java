/*-
 * #%L
 * prolobjectlink-pib
 * %%
 * Copyright (C) 2012 - 2020 Prolobjectlink Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package io.github.prolobjectlink.prolog;

import static java.util.logging.Level.SEVERE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.logging.Logger;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.RunResult;

public abstract class AbstractBenchmarkRunner implements BenchmarkRunner {

	public final String getCurrentPath() {
		Class<?> c = AbstractBenchmarkRunner.class;
		ProtectionDomain d = c.getProtectionDomain();
		CodeSource s = d.getCodeSource();
		return s.getLocation().getPath();
	}

	public final void output(Collection<RunResult> results) {

		File out = null;
		File outfile = null;
		PrintWriter writer = null;
		String name = getClass().getSimpleName();
		File jar = new File(getCurrentPath());
		File lib = jar.getParentFile();
		File dist = lib.getParentFile();

		try {

			out = new File(dist.getCanonicalPath() + File.separator + "out");
			out.mkdirs();
			outfile = new File(out.getCanonicalPath() + File.separator + name + ".txt");

			if (outfile.createNewFile()) {
				writer = new PrintWriter(outfile);

				for (RunResult result : results) {

					Mode mode = result.getParams().getMode();

					double score = result.getPrimaryResult().getScore();
					double scoerr = result.getPrimaryResult().getScoreError();
					double count = result.getPrimaryResult().getSampleCount();
					String label = result.getPrimaryResult().getLabel();
					String unit = result.getPrimaryResult().getScoreUnit();

					double min = result.getPrimaryResult().getStatistics().getMin();
					double max = result.getPrimaryResult().getStatistics().getMax();
					double stdev = result.getPrimaryResult().getStatistics().getStandardDeviation();

					writer.print(name + "." + label);
					writer.print("\t");
					writer.print(mode);
					writer.print("\t");
					writer.print(count);
					writer.print("\t");
					writer.print(min);
					writer.print("\t");
					writer.print(score);
					writer.print("\t");
					writer.print(max);
					writer.print("\t");
					writer.print(scoerr);
					writer.print("\t");
					writer.print(stdev);
					writer.print("\t");
					writer.println(unit);

				}

			}

		} catch (FileNotFoundException e) {
			Logger.getLogger(getClass().getName()).log(SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(getClass().getName()).log(SEVERE, null, e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

}
