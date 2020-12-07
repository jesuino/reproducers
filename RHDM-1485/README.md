Reproduce for RHDM-1485
--

* Run on root dir: `mvn clean install`
* Import the project bc_RHDM1485 on BC (or at least import the rule and pom.xml); 
* Restart BC with flag `-Dkie.maven.offline.force=true`;
* Go to BC and try to build the project. It should fail with:

~~~
13:01:38,067 ERROR [org.drools.compiler.kie.builder.impl.KieProject] (default task-4) Unable to build KieBaseModel:defaultKieBase
Unable to resolve ObjectType 'org.rhdm1485.TransitiveDepCl' : [Rule name='test transitive']

Rule Compilation error : [Rule name='test transitive']
	org.drools.compiler.kie.builder.impl.CompilationProblemAdapter@65d25f15
~~~



