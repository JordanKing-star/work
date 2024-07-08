import concurrent.futures

from coinanalyse.colors import green, white, red, info, run, end
from coinanalyse.requester import requester

address = '1AJbsFZ64EpEfS5UAjAfcUG8pH8Jn3rn1F'

response = requester(address)
print('%s%s' % (green, response))