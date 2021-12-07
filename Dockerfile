FROM camunda/camunda-bpm-platform:wildfly-7.16.0

RUN rm /camunda/standalone/deployments/camunda-example-invoice-7.16.0.war
RUN /camunda/bin/add-user.sh -a -u 'mike' -p 'password' -g 'stuff'
RUN /camunda/bin/add-user.sh -a -u 'george' -p 'password' -g 'stuff'
RUN /camunda/bin/add-user.sh -a -u 'eve' -p 'password' -g 'orga'

COPY target/bpm-camp.war /camunda/standalone/deployments