job("Concurrent_Job1") {
	description()
	keepDependencies(false)
	disabled(false)
	concurrentBuild(false)
	steps {
		shell("""#!/bin/bash
for a in 1 2 3 4 5 6 7 8 9 10
do
	if [\$a == 5];
    then sleep 30
    fi
    echo "Iteration no \$a"
done""")
	}
	configure {
		it / 'properties' / 'jenkins.model.BuildDiscarderProperty' {
			strategy {
				'daysToKeep'('-1')
				'numToKeep'('5')
				'artifactDaysToKeep'('-1')
				'artifactNumToKeep'('-1')
			}
		}
	}
}
