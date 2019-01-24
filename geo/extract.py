#!/usr/bin/python

import json
import os

#extracting Tunisia from the geojson file

print("writing to a javascript object (draw.js)...")

f = open("draw.js" , "w+")
f.write("let drawing = [ ")

with open('countries.geojson') as world:
    data = json.load(world)

a = 0
b = 0

for feature in data['features']:
    if(feature['properties']['ADMIN'] == 'Tunisia'):
        tun = feature['geometry']['coordinates'][3][0]
        for point in tun:
            a = max (a,point[0])
            b = max (b,point[1])
            f.write("\n   { x:" + str(point[0]) + ", y:" + str(point[1]) + " },")
    
f.seek(-1, os.SEEK_END)
f.truncate()
f.write("\n];")
print("done")
print ("max X = " + str(a))
print ("max Y = " + str(b))

world.close()
f.close()
