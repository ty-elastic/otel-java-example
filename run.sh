mvn package

java -javaagent:elastic-otel-javaagent-1.0.0.jar -Dotel.exporter.otlp.headers="Authorization=Bearer <replaceme>" -Dotel.exporter.otlp.endpoint="<replaceme>" -Dotel.resource.attributes="service.name=test,service.version=1.0.0,deployment.environment=QA" -jar target/otel-log-1.0-SNAPSHOT-jar-with-dependencies.jar