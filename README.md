# BPM Camp

Example Process Application with Jakarta EE and the Camunda BPMN Platform.

## Building

    $ mvn verify

## Run

    $ docker run -p 8080:8080 --name bpm-camp gedoplan-showcase/bpm-camp:latest

## Welcome-Page (Dashboard)

Type `http://localhost:8080/bpm-camp` in your Browser to goto the Dashboard. Here you can find all deployed Processdefinitions. Follow the link to goto the start form of that Process.
