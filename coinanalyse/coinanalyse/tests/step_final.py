#!/usr/bin/env python3

import os
import json
import random
import argparse
import webbrowser
import concurrent.futures

from time import sleep

from coinanalyse.utils import getNew
from coinanalyse.utils import ranker
from coinanalyse.utils import genLocation
from coinanalyse.getQuark import getQuark
from coinanalyse.exporter import exporter
from coinanalyse.prepareGraph import prepareGraph
from coinanalyse.getTransactions import getTransactions
from coinanalyse.colors import green, white, red, info, run, end

parse = argparse.ArgumentParser()
parse.add_argument('-s', '--seeds', help='target blockchain address(es)', dest='seeds')
parse.add_argument('-o', '--output', help='output file to save raw JSON data', dest='output')
parse.add_argument('-d', '--depth', help='depth of crawling', dest='depth', type=int, default=1)
parse.add_argument('-t', '--top', help='number of addresses to crawl from results', dest='top', type=int, default=5)
parse.add_argument('-l', '--limit', help='maximum number of addresses to fetch from one address', dest='limit', type=int, default=100)
args = parse.parse_args()
print (args)

top = args.top
seeds = args.seeds
depth = args.depth
limit = args.limit
output = args.output

print ('''%s
  /\   _ _						 
 /--\  |  |  /_\   ||  \ /  ~  sss
/    \ |  | /   \  ||   /   &  e e   %sv1.0.4
%s''' % (green, white, end))

database = {}
processed = set()

seeds = args.seeds.split(',') if args.seeds else []

for seed in seeds:
    database[seed] = {}

#getQuark()

def crawl(addresses, processed, database, limit):
    threadpool = concurrent.futures.ThreadPoolExecutor(max_workers=10)
    futures = (threadpool.submit(getTransactions, address, processed, database, limit) for address in addresses)
    for i, _ in enumerate(concurrent.futures.as_completed(futures)):
        print('Progress: %i/%i        ' % (i + 1, len(addresses)), end='\r')

try:
    for i in range(depth):
        print ('Crawling level %i' % (i + 1))
        database = ranker(database, top + 1)
        toBeProcessed = getNew(database, processed)
        print('%i addresses to crawl' % (len(toBeProcessed)))
        crawl(toBeProcessed, processed, database, limit)
except KeyboardInterrupt:
    pass

database = ranker(database, top)

jsoned = {'edges':[],'nodes':[]}
num = 1

num = 0
doneNodes = []
doneEdges = []
for node in database:
    x, y = genLocation()
    size = len(database[node])
    if size > 20:
        size = 20
    if node not in doneNodes:
        doneNodes.append(node)
        jsoned['nodes'].append({'label': node, 'x': x, 'y': y, 'id':'id=' + node, 'size':size})
    for childNode in database[node]:
        uniqueSize = database[node][childNode]
        if uniqueSize > 20:
            uniqueSize = 20
        x, y = genLocation()
        if childNode not in doneNodes:
            doneNodes.append(childNode)
            jsoned['nodes'].append({'label': childNode, 'x': x, 'y': y, 'id':'id=' + childNode, 'size': uniqueSize})
        if (node + ':' + childNode or childNode + ':' + node) not in doneEdges:
            doneEdges.extend([(node + ':' + childNode), (childNode + ':' + node)])
            jsoned['edges'].append({'source':'id=' + childNode, 'target':'id=' + node, 'id':num, "size":uniqueSize/3 if uniqueSize > 3 else uniqueSize})
        num += 1

print('Total wallets:%i' % (len(jsoned['nodes'])))
print('Total connections:%i' % (len(jsoned['edges'])))

render = json.dumps(jsoned).replace(' ', '').replace('\'', '"')

prepareGraph('%s.json' % seeds[0], render)
#webbrowser.open('file://' + os.getcwd() + '/quark.html')
print(os.getcwd())
#webbrowser.open('file://C:/Python/Python39/Lib/site-packages/coinanalyse/quark.html')

if output:
    data = exporter(output, jsoned)
    new.write(data)
    new.close()

quit()
