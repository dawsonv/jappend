# jappend
Takes two overlapping files of temporal data and appends the first to the second, combining them to output one unified file. The delimiter doesn't matter, as long as the files use the same delimiter and formatting. Each observation should also be followed with a line break.

For instance, lets say you have two overlapping files of data from November and December: one with a date range from Nov. 19 - 29 and annother with a date range from Nov. 25 to Dec. 4 as follows. 

<p> </p>
<p> </p>
First File: Nov19-29.csv
<p> </p>
<p> Datetime, Duration, Name </p>
<p> November 29 5:12 pm, 159, Steve </p>
<p> November 29 4:58 pm, 298, Carol </p>
<p> November 29 4:38 pm, 238, Jim </p>
<p> ... </p>
<p> November 23 8:19 am, 348, John </p>
<p> ... </p>
<p> November 19 2:05 am, 83, Sarah </p>
<p> </p>
<p> </p>
<p> Second File: Nov25-Dec4.csv </p>
<p> </p>
<p> Datetime, Duration, Name </p>
<p> December 4 7:45 am, 349, Todd </p>
<p> December 4 7:18 am, 38, Joe </p>
<p> December 4 6:58 am, 289, Sean </p>
<p> ... </p>
<p> December 1 3:53 pm, 348, Fred </p>
<p> ... </p>
<p> November 25 11:10 am, 483, Bill </p>
<p> </p>

The files are then merged such that the output proceeds continuously from the first entry of the second file, Todd, to the last entry of the first file, Sarah, without repeating observations.

The <code> substring(int start, int end) </code> method is used to make large comparisons faster. In the code, choose an initial value "a" and a final value "b" as indexes that are small enough to be within the bounds of all strings in secondFile, but large enough to encompass a unique set of characters. For instance, 9 would be a suitable value for "a" and 24 would be a suitable value for "b" in the above case. 
