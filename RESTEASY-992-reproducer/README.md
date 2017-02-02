RESTEASY-992-reproducer
--

### Before Build

- Replace the String LARGE_FILE in ReceiveLargeObjectResourceImpl and point to a file in your filesystem that is larger than 300mb (or some value bigger the client heap)

### Build

- Use: `mvn clean package`- Deploy the war from target directory to JBoss EAP 6.4.x
### Run the test

- Run the test and you can do it on an IDE because you must -Xmx according to the file size or run on command line using: `mvn test -DargLine="-Xmx200m"`  -- set Xmx according to the file size
