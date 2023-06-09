job("Environment_Variables_DSL") {
	description("This job is for understanding Jenkins environment variables.")
	keepDependencies(false)
	disabled(false)
	concurrentBuild(false)
	steps {
		shell("""echo "Current build no. - \$BUILD_ID"
echo "Current build is accessible at - \$BUILD_URL"
echo "Java library is available at - \$JAVA_HOME"
echo "Jenkins workspace is available at - \$WORKSPACE")
	}
}