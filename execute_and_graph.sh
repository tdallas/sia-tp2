#!/bin/bash

java -jar target/sia-tp2-1.0.jar > output.csv
tail -4 output.csv
python3 -W ignore visual/graphs.py output.csv