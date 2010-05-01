#! /usr/bin/env python
# -*- mode:python; coding:utf-8; -*-

#  Calculation of Pi using quadrature.  Using the python-csp package by Sarah Mount.
#
#  Copyright © 2009-10 Russel Winder

import time
import multiprocessing

from csp.cspprocess import *

def execute ( processCount ) :
    n = 10#0000000 # 100 times fewer due to speed issues.
    delta = 1.0 / n
    startTime = time.time ( )
    slice = n / processCount
    channels = [ ]
    @process
    def accumulator ( ) :
        pi = 4.0 * sum ( [ channel.read ( ) for channel in channels ] ) * delta
        elapseTime = time.time ( ) - startTime
        print "==== Python CSP Multiple NestedDeep pi =" , pi
        print "==== Python CSP Multiple NestedDeep iteration count =", n
        print "==== Python CSP Multiple NestedDeep elapse =" , elapseTime
        print "==== Python CSP Multiple NestedDeep process count = ", processCount
        print "==== Python CSP Multiple NestedDeep processor count =" , multiprocessing.cpu_count ( )
    processes = [ ] 
    for i in range ( 0 , processCount ) :
        channel = Channel ( )
        channels.append ( channel )
        @process
        def calculator (channel ) :
            sum = 0.0
            for j in xrange ( 1 + i * slice , ( i + 1 ) * slice ) :
                x = ( j - 0.5 ) * delta
                sum += 1.0 / ( 1.0 + x * x )
            channel.write ( sum )
        processes.append ( calculator (channels[i] ) )
    processes.append ( accumulator ( ) )
    Par ( *processes ).start ( )

if __name__ == '__main__' :
    import gc
    gc.set_debug(True)
    execute ( 1 )
    print
    execute ( 2 )
    print
    execute ( 8 )
    print
    execute ( 32 )

