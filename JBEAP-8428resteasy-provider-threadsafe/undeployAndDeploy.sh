while [ 1 ]
do
	${JBOSS_HOME}/bin/jboss-cli.sh --connect command="deploy --name=resteasy-provider-threadsafe.war ./target/resteasy-provider-threadsafe-1.0.war --force"
	sleep 1
done
