#! /bin/sh

sbt -Dbrowser=chrome 'testOnly runner.TestRunner'
