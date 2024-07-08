import argparse
from coinanalyse.utils import getNew
from coinanalyse.utils import ranker
from coinanalyse.colors import green, white, red, info, run, end

database = {}
parse = argparse.ArgumentParser()
parse.add_argument('-s', '--seeds', help='target blockchain address(es)', dest='seeds')
args = parse.parse_args()

seeds = args.seeds.split(',') if args.seeds else []
for seed in seeds:
    database[seed] = {}

database = ranker(database, 1)
toBeProcessed = getNew(database, set())
print(toBeProcessed)
print('%s %i addresses to crawl' % (info, len(toBeProcessed)))