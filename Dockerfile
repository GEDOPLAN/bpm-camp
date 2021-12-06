FROM camunda/camunda-bpm-platform:wildfly-7.16.0

RUN rm /camunda/standalone/deployments/camunda-example-invoice-7.16.0.war

COPY target/bpm-camp.war /camunda/standalone/deployments