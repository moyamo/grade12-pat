#!/usr/bin/env python3

sql = open('tables.sql', 'r')
csv = open('tables.csv', 'w')

lines = sql.readlines()
table_name = ''
for l in lines:
    if l.startswith('--') or l.startswith('\tforeign key') or l.startswith('\tprimary key'):
        continue
    elif l.startswith('create table'):
        table_name = l.split()[2]
        csv.write(',,\n')
        csv.write(',,\n')
        csv.write(table_name + ',,\n')
        csv.write(',,\n')
        csv.write('Field,Data type, Justification\n')
    elif l.startswith('\t'):
        stuff = l.split()
        name = stuff[0]
        typ  = ' '.join(stuff[1:])
        csv.write(name + ',' + typ + ',\n')
csv.close()
sql.close()
