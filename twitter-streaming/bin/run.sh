#!/usr/bin/env bash

export SPARK_EXECUTOR_INSTANCES=8

spark-submit --master "local[8]" \
    --class ru.hse.modern.technologies.Twitter \
    assembly/twitter-streaming-assembly-0.0.1.jar \
    ### Consumer key ### \
    ### Consumer secret ### \
    ### Access token ### \
    ### Access token secret ###