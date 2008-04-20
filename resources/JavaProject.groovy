target = project["target"]

// TODO: if only Groovy had anonymous class...
class CompileTask extends groobuild.CustomTask {
    // compiler options. passed as attributes to <javac> task
    def options = [:]

    // classpath
    def classpath = []

    // list of source directories
    def sources;

    // where to produce the output?
    def target;

    void setVersion(v) {
        options.source=options.target=v.toString()
    }

    void execute() {
        javac( [source:"1.5",
                target:"1.5",
                srcdir:sources.join(':'),
                destdir:target]+options )
    }
}

compile = new CompileTask(
        sources:[project["src/main/java"]],
        target: target["classes"]);

testCompile = new CompileTask(
        sources:[project["src/test/jva"]],
        target: target["test-classes"]);

clean = task {
    delete(dir:target)
}