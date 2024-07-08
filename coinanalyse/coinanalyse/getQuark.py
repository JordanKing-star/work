import os
import shutil
from coinanalyse.colors import bad, run, info

def getQuark():
	if 'quark.html' not in os.listdir():
		cwd = os.getcwd()
		print ('%s Quark is neccessary to view graphs generated by Orbit.' % bad)
		print ('%s Downloading Quark [2.37 MB]' % run)
		os.system('git clone https://github.com/s0md3v/Quark %s/Quark -q' % cwd)
		os.system('mv ' + cwd + '/Quark/libs ' + cwd)
		os.system('mv ' + cwd + '/Quark/quark.html ' + cwd)
		os.remove(cwd + '/Quark/README.md')
		shutil.rmtree(cwd + '/Quark')
		print ('%s Quark was installed successfully' % info)