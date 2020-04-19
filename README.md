# Registry-Simulator
A student registry simulator that can add students, add different courses, add  a student to a course, etc 

Decriptions of commands 
a.	“L” : list all the students in the registry. This one has been done for you. 
b.	“Q” : quit out of the program. Also done for you.
c.	“REG” : register a student. Reads a student name and student id from the commandLine scanner (see code). Uses Registry method to register the new student. Just make up a 5 digit id. 
d.	“DEL”: deletes a student from the registry. 
e.	“ADDC”: adds a student to an active course
f.	“DROPC”: drops a student from an active course
g.	“PAC” : prints all active course
h.	“PCL” : prints class list for an active course
i.	“PGR” : prints student id and grade for all students in an active course
j.	“PSC” : prints all credit courses for a student
k.	“SFG” : Set final grade of a student in a course
l.	“SCN” : sort list of students in a course by student name
m.	“SCI” : sort list of students in a course by student id  
n.	“SCH courseCode day start duration”. See the video. For example: sch cps209 Mon 900 3. Schedules a course for a certain day, start time and duration. Don’t forget to catch any exceptions thrown. Print an appropriate message to the user if an exception is thrown.
o.	“CSCH courseCode”. Clears the schedule of the given course
p.	“PSCH” Prints the entire schedule.

