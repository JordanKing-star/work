import concurrent.futures

from coinanalyse.requester import requester

address = '1AJbsFZ64EpEfS5UAjAfcUG8pH8Jn3rn1F'

response = requester(address)
print(response)