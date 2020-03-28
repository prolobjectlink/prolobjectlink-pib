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
package org.prolobjectlink.prolog;

public class BenchmarkResultEntry implements Comparable<BenchmarkResultEntry> {

	private String label;
	private String mode;
	private Number count;
	private Number min;
	private Number score;
	private Number max;
	private Number scoreerr;
	private Number stdev;
	private String unit;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Number getCount() {
		return count;
	}

	public void setCount(Number count) {
		this.count = count;
	}

	public Number getMin() {
		return min;
	}

	public void setMin(Number min) {
		this.min = min;
	}

	public Number getScore() {
		return score;
	}

	public void setScore(Number score) {
		this.score = score;
	}

	public Number getMax() {
		return max;
	}

	public void setMax(Number max) {
		this.max = max;
	}

	public Number getScoreerr() {
		return scoreerr;
	}

	public void setScoreerr(Number scoreerr) {
		this.scoreerr = scoreerr;
	}

	public Number getStdev() {
		return stdev;
	}

	public void setStdev(Number stdev) {
		this.stdev = stdev;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((scoreerr == null) ? 0 : scoreerr.hashCode());
		result = prime * result + ((stdev == null) ? 0 : stdev.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenchmarkResultEntry other = (BenchmarkResultEntry) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (scoreerr == null) {
			if (other.scoreerr != null)
				return false;
		} else if (!scoreerr.equals(other.scoreerr))
			return false;
		if (stdev == null) {
			if (other.stdev != null)
				return false;
		} else if (!stdev.equals(other.stdev))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "BenchmarkResultEntry [label=" + label + ", mode=" + mode + ", count=" + count + ", min=" + min
//				+ ", score=" + score + ", max=" + max + ", scoreerr=" + scoreerr + ", stdev=" + stdev + ", unit=" + unit
//				+ "]";
//	}

	public int compareTo(BenchmarkResultEntry o) {
		Double otherScore = o.score.doubleValue();
		Double thisScore = score.doubleValue();
		return thisScore.compareTo(otherScore);
	}

	@Override
	public String toString() {
		return "BenchmarkResultEntry [label=" + label + ", score=" + score + ", unit=" + unit + "]";
	}

}
