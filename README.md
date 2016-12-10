# jappend
Takes two overlapping files of temporal data and appends the first to the second, combining them to output one unified file. The delimiter doesn't matter, as long as the files use the same delimiter and formatting. Each observation should also be followed with a line break.

For instance, lets say you have two overlapping files of data from November and December: one with a date range from Nov. 19 - 29 and annother with a date range from Nov. 25 to Dec. 4, each in decending chronological order.

The files are then merged such that the output proceeds continuously from the first entry of the second file, Todd, to the last entry of the first file, Sarah, without repeating observations.

The <code> substring(int start, int end) </code> method is used to make large comparisons faster. In the code, choose an initial value "a" and a final value "b" as indexes that are small enough to be within the bounds of all strings in secondFile, but large enough to encompass a unique set of characters. For instance, 9 would be a suitable value for "a" and 24 would be a suitable value for "b" in the above case. 
