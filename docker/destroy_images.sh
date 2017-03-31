#!/usr/bin/env bash

if [ -z $IMAGE_NAME_PREFIX ]; then
    IMAGE_NAME_PREFIX="ruok"
fi

num=`docker images|grep $IMAGE_NAME_PREFIX|wc -l`
if [ $num -gt 0 ]; then
    echo "delete $IMAGE_NAME_PREFIX"
    docker images|grep $IMAGE_NAME_PREFIX|awk '{print $3}'|xargs docker rmi
else
    echo "no existing image"
fi
